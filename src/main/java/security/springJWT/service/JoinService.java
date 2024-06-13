package security.springJWT.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import security.springJWT.dto.JoinDto;
import security.springJWT.entity.UserEntity;
import security.springJWT.repository.UserRepository;

@Service
public class JoinService {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserRepository userRepository;

	public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void joinProc(JoinDto joinDto) {
		boolean exist = userRepository.existsByUsername(joinDto.getUsername());

		// 이미 존재하는 username 인 경우 예외처리
		if (exist)
			return ;

		UserEntity userEntity = new UserEntity();

		userEntity.setUsername(joinDto.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
		userEntity.setRole("ROLE_ADMIN");

		userRepository.save(userEntity);
	}
}
