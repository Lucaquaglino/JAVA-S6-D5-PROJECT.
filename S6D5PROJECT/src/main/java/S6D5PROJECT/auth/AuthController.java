package S6D5PROJECT.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import S6D5PROJECT.exceptions.UnauthorizedException;
import S6D5PROJECT.payloads.AuthenticationSuccessfullPayload;
import S6D5PROJECT.payloads.UtenteLoginPayload;
import S6D5PROJECT.payloads.UtenteRegistrationPayload;
import S6D5PROJECT.utente.Utente;
import S6D5PROJECT.utente.UtenteService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UtenteService utenteService;

	@Autowired
	private PasswordEncoder bcrypt;

	@PostMapping("/register")
	public ResponseEntity<Utente> register(@RequestBody @Validated UtenteRegistrationPayload body) {
		body.setPassword(bcrypt.encode(body.getPassword()));
		Utente utenteCreato = utenteService.create(body);
		return new ResponseEntity<>(utenteCreato, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationSuccessfullPayload> login(@RequestBody UtenteLoginPayload body) {

		// VERIFICO CHE L'EMAIL DELL'UTENTE SIA PRESENTE SUL DB
		Utente u = utenteService.findByEmail(body.getEmail());

		String insertPW = body.getPassword();
		String hashedPW = u.getPassword();

		if (!bcrypt.matches(insertPW, hashedPW))
			throw new UnauthorizedException("Credenziali non valide");

		// GENERO IL TOKEN
		String token = JWTTools.createToken(u);

		return new ResponseEntity<>(new AuthenticationSuccessfullPayload(token), HttpStatus.OK);
	}

}