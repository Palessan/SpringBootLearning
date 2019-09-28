package spring.demo_one;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

//	@Override
	public String getFortune() {
		return "lucky day!!!";
	}

}
