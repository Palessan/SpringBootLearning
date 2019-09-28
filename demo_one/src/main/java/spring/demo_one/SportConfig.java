package spring.demo_one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring.demo_one")
@PropertySource("classpath:sport.properties")//This will be used in cricketCoach to utilize the annotation with @Value("${foo.teamName}") 
											 //above the value
public class SportConfig {

	
	@Bean		//bean id and no component search in swimCoach
	public Coach swim1Coach0() {
		SwimCoach swimCoach = new SwimCoach();
		return swimCoach;
	}
	
	//Because we have enabled the component scan, it already finds one happyFortuneService, and  if it is 
	//with a different name like happyFortuneService1, then there will be 2 available in spring config, and this will fail
	@Bean		//bean id and no component search in swimCoach
	public HappyFortuneService happyFortuneService() {
		return new HappyFortuneService();				
	}
	//AND
	@Bean		//bean id and no component search in swimCoach
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();				
	}
	//OR
	@Bean		//bean id and no component search in swimCoach
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach((happyFortuneService()));
		return swimCoach;
	}
	//OR
	@Bean		//bean id and no component search in swimCoach
	public Coach swim1Coach() {
		SwimCoach swimCoach = new SwimCoach();
		swimCoach.setFortuneService(sadFortuneService());
		return swimCoach;
	}
	@Bean		//bean id and no component search in swimCoach
	public Coach cricketCoach() {
		CricketCoach cricketCoach = new CricketCoach();
		cricketCoach.setFortuneService(happyFortuneService());
		return cricketCoach;
	}
//	//OR
//	@Bean		//bean id and no component search in swimCoach
//	public Coach swimCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
//		SwimCoach swimCoach = new SwimCoach((sadFortuneService()));
//		return swimCoach;
//	}
//	//OR
//	@Bean		//bean id and no component search in swimCoach
//	public Coach swim1Coach(HappyFortuneService fortuneService) {
//		SwimCoach swimCoach = new SwimCoach((happyFortuneService()));
//		return swimCoach;
//	}
	//OR
//	@Bean		//bean id and no component search in swimCoach
//	public Coach swim2Coach(SadFortuneService fortuneService) {
//		SwimCoach swimCoach = new SwimCoach();
//		swimCoach.setFortuneService(sadFortuneService());
//		return swimCoach;
//	}
//	//OR
//	@Bean		//bean id and no component search in swimCoach
//	public Coach swim3Coach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
//		SwimCoach swimCoach = new SwimCoach();
//		swimCoach.setFortuneService(sadFortuneService());
//		return swimCoach;
//	}
}
