package S6D5PROJECT.dispositivo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S6D5PROJECT.exceptions.NotFoundException;
import S6D5PROJECT.payloads.DispositivoPayload;

@Service
public class DispositivoService {

	@Autowired
	private DispositivoRepository dispositivoRepo;

	public Dispositivo create(DispositivoPayload body) {

		Dispositivo nuovoDispositivo = new Dispositivo(body.getModelloDispositivo(), body.getTipoDispositivo(),
				body.getDisponibilitaDispositivo());

		return dispositivoRepo.save(nuovoDispositivo);
	}

	public List<Dispositivo> find() {
		return dispositivoRepo.findAll();
	}

	public Dispositivo findById(UUID id) throws NotFoundException {
		return dispositivoRepo.findById(id).orElseThrow(() -> new NotFoundException("Dispositivo non trovato!"));
	}

	public Dispositivo findByIdAndUpdate(UUID id, Dispositivo d) throws NotFoundException {
		Dispositivo found = this.findById(id);

		found.setId(id);//
		found.setTipoDispositivo(d.getTipoDispositivo());
		found.setDisponibilitaDispositivo(d.getDisponibilitaDispositivo());

		return dispositivoRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Dispositivo found = this.findById(id);
		dispositivoRepo.delete(found);
	}

//
	public Dispositivo findByIdAndDisponibilitaDispositivo(UUID idDispositivo,
			DisponibilitaDispositivo disponibilitaDispositivo) {
		return dispositivoRepo.findByIdAndDisponibilitaDispositivo(idDispositivo, disponibilitaDispositivo).orElseThrow(
				() -> new NotFoundException("Il dispositivo con " + idDispositivo + " non è disponibile!"));
	}

}