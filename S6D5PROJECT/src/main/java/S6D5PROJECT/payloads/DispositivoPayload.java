package S6D5PROJECT.payloads;

import S6D5PROJECT.dispositivo.DisponibilitaDispositivo;
import S6D5PROJECT.dispositivo.TipoDispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DispositivoPayload {

	String modelloDispositivo;

	TipoDispositivo tipoDispositivo;

	DisponibilitaDispositivo disponibilitaDispositivo;

}