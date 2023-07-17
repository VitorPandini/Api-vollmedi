package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuarios.DadosAuth;
import med.voll.api.domain.usuarios.Usuario;
import med.voll.api.infra.security.TokenDadosJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosAuth dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var auth = manager.authenticate(token);

        var tokenJWT=tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }
}
