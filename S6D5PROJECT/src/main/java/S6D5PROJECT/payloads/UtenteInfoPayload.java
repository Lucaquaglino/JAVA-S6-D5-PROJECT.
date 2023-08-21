package S6D5PROJECT.payloads;

import java.util.List;

import S6D5PROJECT.dispositivo.Dispositivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter

public class UtenteInfoPayload {

	String username;
	String nome;
	String cognome;
	String email;
	List<Dispositivo> dispositiviAssegnati;

}