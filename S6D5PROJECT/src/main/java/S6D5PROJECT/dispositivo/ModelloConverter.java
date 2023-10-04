package S6D5PROJECT.dispositivo;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;

@Component
@Converter
public class ModelloConverter implements AttributeConverter<String, String> {

	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
	@Value("PLL9KDLP467QJYCH8X8MYZLP1HK1J3Z6")
	private String secret;

	@Override
	public String convertToDatabaseColumn(String modelloDipositivo) {
		try {
			Key key = new SecretKeySpec(secret.getBytes(), "AES");
			Cipher c = Cipher.getInstance(ALGORITHM);

			c.init(Cipher.ENCRYPT_MODE, key);

			return Base64.getEncoder().encodeToString(c.doFinal(modelloDipositivo.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public String convertToEntityAttribute(String encryptedmodelloDipositivo) {
		try {
			Key key = new SecretKeySpec(secret.getBytes(), "AES");

			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			return new String(c.doFinal(Base64.getDecoder().decode(encryptedmodelloDipositivo)));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
