package S6D5PROJECT.payloads;

import java.util.UUID;

import S6D5PROJECT.dispositivo.DisponibilitaDispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AssegnaDispositivoPayload {

	String emailUtente;

	UUID dispositivoId;
	DisponibilitaDispositivo disponibilita;

}