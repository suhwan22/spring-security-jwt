package security.springJWT.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.springJWT.dto.CustomUserDetails;
import security.springJWT.entity.UserEntity;
import security.springJWT.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);

		if (user != null) {
			return new CustomUserDetails(user);
		}

		return null;
	}
}
