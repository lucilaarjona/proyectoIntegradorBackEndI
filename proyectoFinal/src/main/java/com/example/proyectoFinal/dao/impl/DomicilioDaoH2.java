package com.example.proyectoFinal.dao.impl;

import com.example.proyectoFinal.dao.IDao;
import com.example.proyectoFinal.dao.config.ConfiguracionJDBC;
import com.example.proyectoFinal.models.Domicilio;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private ConfiguracionJDBC configuracionJDBC;

    public DomicilioDaoH2() {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, domicilio.getCalle());
            pstmt.setString(2, domicilio.getNumero());
            pstmt.setString(3, domicilio.getLocalidad());
            pstmt.setString(4, domicilio.getProvincia());

            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next())
                domicilio.setId(keys.getInt(1));
            pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilio;
    }


    @Override
    public Domicilio buscar(Long id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement stmt = null;
        String query = String.format("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
        Domicilio domicilio = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setLong(1,id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                domicilio = crearObjetoDomicilio(result);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM domicilios where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM domicilios";
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                domicilios.add(crearObjetoDomicilio(result));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilios;
    }

    private Domicilio crearObjetoDomicilio(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String calle = result.getString("calle");
        String numero = result.getString("numero");
        String localidad = result.getString("localidad");
        String provincia = result.getString("provincia");
        return new Domicilio(id, calle, numero, localidad, provincia);

    }
}