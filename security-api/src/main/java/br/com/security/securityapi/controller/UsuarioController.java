package br.com.security.securityapi.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.security.securityapi.model.Usuario;
import br.com.security.securityapi.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public List<Usuario> getUsuarios() {
		return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@PostMapping("/usuario")
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/usuario")
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/usuario/{usuarioId}")
	public Usuario findByIdUsuario(@PathVariable Long usuarioId) {
		return usuarioRepository.findById(usuarioId).get();
	}

	@DeleteMapping("/usuario}")
	public void deleteUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
