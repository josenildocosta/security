package br.com.security.securityapi.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.security.securityapi.model.Usuario;
import br.com.security.securityapi.repository.UsuarioRepository;

@Service
@Profile("springdatajpa")
public class UsuarioService implements GenericService<Usuario, Long> {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Set<Usuario> findAll() {
		Set<Usuario> usuarios = new HashSet<>();

		usuarioRepository.findAll().forEach(usuarios::add);

		return usuarios;
	}

	public Usuario findById(Long aLong) {
		return usuarioRepository.findById(aLong).orElse(null);
	}

	public Usuario save(Usuario object) {
		return usuarioRepository.save(object);
	}

	public void delete(Usuario object) {
		usuarioRepository.delete(object);
	}

	public void deleteById(Long aLong) {
		usuarioRepository.deleteById(aLong);
	}
}
