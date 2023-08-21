package S6D5PROJECT;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import S6D5PROJECT.auth.AuthController;
import S6D5PROJECT.payloads.UtenteRegistrationPayload;
import S6D5PROJECT.utente.Utente;
import S6D5PROJECT.utente.UtenteRepository;
import S6D5PROJECT.utente.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner {

	@Autowired
	UtenteService utenteService;

	@Autowired
	UtenteRepository utenteRepo;

	@Autowired
	AuthController authController;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		List<Utente> utentiDb = utenteRepo.findAll();
		if (utentiDb.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				String username = faker.name().username();
				String nome = faker.name().firstName();
				String cognome = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = "1234";
				UtenteRegistrationPayload utente = new UtenteRegistrationPayload(username, nome, cognome, email,
						password);
				authController.register(utente);

			}
		}
	}

}