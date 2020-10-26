package com.grupoTres.doacommerce.service;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupoTres.doacommerce.model.UserLogin;
import com.grupoTres.doacommerce.model.Usuario;
import com.grupoTres.doacommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		
		Optional<Usuario> userExiste = repository.findByEmail(usuario.getEmail());
		
		if (userExiste.isPresent())
			return userExiste.get();
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
		
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//findAll??
		Optional<Usuario> email = repository.findByEmail(user.get().getEmail());
		
		if(email.isPresent()) {
			if(encoder.matches(user.get().getSenha(), email.get().getSenha())) {
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
	
				user.get().setToken(authHeader);
				user.get().setNome(email.get().getNomeRazao());
				user.get().setTipoPessoa(email.get().getTipoPessoa());
				return user;
				
			}
		}
		return null;
	}
}
