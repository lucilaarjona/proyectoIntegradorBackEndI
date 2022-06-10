package com.example.proyectoFinal.dao.impl;

import com.example.proyectoFinal.dao.IDao;
import com.example.proyectoFinal.dao.config.ConfiguracionJDBC;
import com.example.proyectoFinal.models.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
   private ConfiguracionJDBC configuracionJDBC;

    @Override

    public Odontologo guardar(Odontologo odontologo){
        Connection connection= configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement=null;

        try{

            preparedStatement=connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
            preparedStatement.setLong(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getMatricula());
            preparedStatement.setString(3,odontologo.getNombre());
            preparedStatement.setString(4,odontologo.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return odontologo;
    }

    @Override
    public Odontologo buscar(Long id){
        Connection connection= configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement=null;
        Odontologo odontologo=null;

        try{

            preparedStatement=connection.prepareStatement("SELECT * FROM odontologos where id=?");
            preparedStatement.setLong(1,id);

            ResultSet result=preparedStatement.executeQuery();
            while(result.next()){
                Long idOdontologos=result.getLong("id");
                String numeroMatricula=result.getString("numeroMatricula");
                String nombre=result.getString("nombre");
                String apellido=result.getString("apellido");


                odontologo=new Odontologo(idOdontologos, numeroMatricula, nombre,apellido);

            }

            preparedStatement.close();


        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return odontologo;
    }
    @Override
    public void eliminar(Long id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM odontologos where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {


            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Long idOdontologos = result.getLong("id");
                String numeroMatricula = result.getString("numeroMatricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Odontologo odontologo = new Odontologo(idOdontologos, numeroMatricula, nombre, apellido);
                odontologos.add(odontologo);
            }

            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return odontologos;
    }
}