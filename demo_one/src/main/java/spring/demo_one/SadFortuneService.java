package spring.demo_one;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {

//	@Override
	public String getFortune() {
		return "sad day";
	}

}
