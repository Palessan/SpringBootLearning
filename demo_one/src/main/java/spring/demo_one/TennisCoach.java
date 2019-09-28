package spring.demo_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
//@Component
@Component("thatSillyCoach")//Bean id //Implementation like we would have given in the xml config file. The interface is what it extends simply.
public class TennisCoach implements Coach {

	@Qualifier("happyFortuneService")
	@Autowired //No Need for setter and getter methods.
	private FortuneService fortuneService ;
	

//	@Override
	public String getDailyWorkout() {
		return "30 mins wall practice";
	}
	
//	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
