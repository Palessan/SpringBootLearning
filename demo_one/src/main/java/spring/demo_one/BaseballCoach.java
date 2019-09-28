package spring.demo_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	private FortuneService fortuneService ;
	
	//Used by Spring
//	@Qualifier("notHappyFortuneService")//Not allowed here for constructor
	@Autowired
	public BaseballCoach( @Qualifier("sadFortuneService") FortuneService fortuneService ) {
		this.fortuneService=fortuneService;
	}
	
//	@Override
	public String getDailyWorkout() {
		return "30 mins batting";
	}
	
//	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
