package S6D5PROJECT.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UtenteRegistrationPayload {

	String username;
	String nome;
	String cognome;
	String email;
	String password;
}
