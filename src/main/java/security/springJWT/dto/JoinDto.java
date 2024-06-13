package security.springJWT.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDto {

	private String username;
	private String password;

	@Override
	public String toString() {
		return "[username: " + username + ", password: " + password + "]";
	}
}
