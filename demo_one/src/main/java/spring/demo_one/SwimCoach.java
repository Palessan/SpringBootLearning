package spring.demo_one;

//pojo
public class SwimCoach implements Coach {

	private FortuneService fortuneService ;
	
	public SwimCoach( FortuneService fortuneService ) {
		this.fortuneService=fortuneService;
	}
	
	public SwimCoach() {}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

//	@Override
	public String getDailyWorkout() {
		return "30 min shark attack";
	}
	
//	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
