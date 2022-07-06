package com.dh.dentalClinic.user.dao;

import com.dh.dentalClinic.user.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
