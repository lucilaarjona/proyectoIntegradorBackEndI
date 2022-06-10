package com.example.proyectoFinal.dao.impl;

import com.example.proyectoFinal.dao.IDao;
import com.example.proyectoFinal.dao.config.ConfiguracionJDBC;
import com.example.proyectoFinal.models.Domicilio;
import com.example.proyectoFinal.models.Paciente;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    private ConfiguracionJDBC configuracionJDBC;
    private DomicilioDaoH2 domicilioDaoH2;

    public PacienteDaoH2(DomicilioDaoH2 domicilioDaoH2) {
        this.configuracionJDBC = new ConfiguracionJDBC();
        this.domicilioDaoH2 = domicilioDaoH2;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement pstmt = null;
        String query = String.format("INSERT INTO pacientes(nombre,apellido,dni,fecha_ingreso,domicilio_id) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        try {
            Domicilio dom = domicilioDaoH2.guardar(paciente.getDomicilio());
            paciente.getDomicilio().setId(dom.getId());

            pstmt = connection.prepareStatement(query);

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido());
            pstmt.setString(3, paciente.getDni());

            pstmt.setString(4, paciente.getFechaIngreso());

            pstmt.setInt(5, paciente.getDomicilio().getId());

            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getLong(0));

            pstmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Long id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement pstmt = null;
        String query = String.format("SELECT id,nombre,apellido,dni,fecha_ingreso, domicilio_id  FROM pacientes where id = ?");
        Paciente paciente = null;
        try {
            pstmt = connection.prepareStatement("SELECT id,nombre,apellido,dni,fecha_ingreso, domicilio_id  FROM pacientes where id = ?");
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                paciente = crearObjetoPaciente(result);
            }
            pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM pacientes where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM pacientes";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                pacientes.add(crearObjetoPaciente(result));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }

    private Paciente crearObjetoPaciente(ResultSet result) throws SQLException {

        Long idPaciente = result.getLong("id");
        String nombre = result.getString("nombre");
        String apellido = result.getString("apellido");
        String dni = result.getString("dni");
        String fechaIngreso = result.getString("fecha_ingreso");
        Domicilio domicilio = domicilioDaoH2.buscar(result.getLong("domicilio_id"));
        return new Paciente(idPaciente, nombre, apellido, dni, fechaIngreso, domicilio);

    }
}