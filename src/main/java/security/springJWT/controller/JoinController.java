package security.springJWT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import security.springJWT.dto.JoinDto;
import security.springJWT.service.JoinService;

@Controller
@ResponseBody
public class JoinController {

	JoinService joinService;

	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}

	@PostMapping("/join")
	public String joinProc(JoinDto joinDto) {

		System.out.println("joinDto = " + joinDto);
		joinService.joinProc(joinDto);

		return "join successed";
	}
}
