package com.adso.pollos.service;

import com.adso.pollos.dto.UsuarioRequestDTO;
import com.adso.pollos.dto.UsuarioResponseDTO;
import com.adso.pollos.entity.Usuario;
import com.adso.pollos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service //Crea un bean
@RequiredArgsConstructor // Crea un constructor
public class UsuarioService {

    // Se define variable constante (final), de repository con tipo de dato UsuariosRepository
    private final UsuarioRepository usuarioRepository;

    // Metodo de nuestro servicio para crear usuario, respondiendo con UsuariosResponseDTO y recibiendo UsuariosRequestDTO
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuariosRequestDTO) {
        // Se instancia la entidad, ya que @Entity no crea un bean, asi que siempre la instanciamos
        Usuario usuario = new Usuario();
        // Se setean por medio de Getters y setters (@Data, de lombok) a nuestra entidad a partir de nuestro dto de peticion
        usuario.setNombre(usuariosRequestDTO.getNombre());
        usuario.setEdad(usuariosRequestDTO.getEdad());
        usuario.setCorreo(usuariosRequestDTO.getCorreo());

        // Se usa metodo de JpaRepository para guardar nuestra entidad
        // .save = insert into usuarios (nombre, edad, correo) values (?, ?, ?)
        usuarioRepository.save(usuario);

        // Se llena nuestro DTO de respuesta para responder con los datos del usuario que se acabo de insertar a
        // partir de nuestra entidad
        UsuarioResponseDTO response = new UsuarioResponseDTO(); // se instancia el DTO de respuesta
        response.setId(usuario.getId());
        response.setNombre(usuariosRequestDTO.getNombre());
        response.setEdad(usuariosRequestDTO.getEdad());
        response.setCorreo(usuariosRequestDTO.getCorreo());

        // Se retorna la respuesta (UsuariosResponseDTO)
        return response;
    }

    public List <UsuarioResponseDTO> listarUsuarios () {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> lista = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
            responseDTO.setId(usuario.getId());
            responseDTO.setNombre(usuario.getNombre());
            responseDTO.setEdad(usuario.getEdad());
            responseDTO.setCorreo(usuario.getCorreo());
            lista.add(responseDTO);
        }
        return lista;

    }

    public Optional<UsuarioResponseDTO> obtenerUsuario(Long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
            responseDTO.setId(usuario.getId());
            responseDTO.setNombre(usuario.getNombre());
            responseDTO.setEdad(usuario.getEdad());
            responseDTO.setCorreo(usuario.getCorreo());
            return Optional.of(responseDTO);
        }else{
            return Optional.empty();
        }
    }

    public Optional<UsuarioResponseDTO> actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNombre(usuarioRequestDTO.getNombre());
            usuario.setEdad(usuarioRequestDTO.getEdad());
            usuario.setCorreo(usuarioRequestDTO.getCorreo());

            usuarioRepository.save(usuario);

            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
            responseDTO.setId(usuario.getId());
            responseDTO.setNombre(usuario.getNombre());
            responseDTO.setEdad(usuario.getEdad());
            responseDTO.setCorreo(usuario.getCorreo());
            return Optional.of(responseDTO);
        } else {
            return Optional.empty();
        }
    }
}
