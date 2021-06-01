package com.store.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //Aqui creamos un objeto que setea los datos de usuario que usaremos más adelante, lo ideal es hacelo contra una base de datos
        //Pero al ser una prueba se entiende, {noop} sirve para encriptar la contraseña y el arraylist contendrá los roles que justo ahora no se usarán
        return new User("Miguel", "{noop}12345", new ArrayList<>());
    }
}
