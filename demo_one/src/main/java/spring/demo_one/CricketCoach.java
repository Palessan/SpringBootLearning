package spring.demo_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	
	private FortuneService fortuneService ;
	
	@Value("hawks1@gmail.com")
	private String email="";
	@Value("${foo.teamName}")
	private String teamName="";
	
	//Used by Spring
	
//	@Autowired
//	public CricketCoach(FortuneService fortuneService) {
//		this.fortuneService=fortuneService;
//	}
	
	//used by Spring
	public void setEmail(String email) {
		this.email = email;
	}

	//used by Spring
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	//used by Spring

	@Qualifier("happyFortuneService")
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Qualifier("happyFortuneService")
	@Autowired
	public void blaFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	public String getEmail() {
		return email;
	}
	

//	@Override
	public String getDailyWorkout() {
		return "15 hour listening to crickets";
	}
	
//	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
