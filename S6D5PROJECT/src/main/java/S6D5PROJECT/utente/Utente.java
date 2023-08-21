package S6D5PROJECT.utente;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import S6D5PROJECT.dispositivo.Dispositivo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "utenti")
@Data
@NoArgsConstructor

public class Utente implements UserDetails {

	private static final long serialVersionUID = 306567421269812142L;
	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String password;

	private boolean isEnabled;
	private boolean isCredentialsNonExpired;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	@Enumerated(EnumType.STRING)
	@OneToMany
	@JoinColumn(name = "dispositivo_id", referencedColumnName = "id", nullable = true)
	@JsonManagedReference
	private List<Dispositivo> dipositiviAssegnati;

	public Utente(String username, String nome, String cognome, String email, String password) {
		setUsername(username);
		setNome(nome);
		setCognome(cognome);
		setEmail(email);
		setPassword(password);
		setEnabled(true);
		setAccountNonExpired(true);
		setCredentialsNonExpired(true);
		setAccountNonLocked(true);

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}