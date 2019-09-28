package spring.demo_one;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	private FortuneService fortuneService ;
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	@Qualifier("happyFortuneService")
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService= fortuneService;
	}
	
//	@Override
	public String getDailyWorkout() {
		return "15 minute run";
	}
	
//	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@PostConstruct
	public void doMyStartupStuff() {
        System.out.println( "Inside doMyStartupStuff()" );

	}
	@PreDestroy
	public void doMyCleanupStuff() {
        System.out.println( "Inside doMyCleanupStuff()");

	}
}
