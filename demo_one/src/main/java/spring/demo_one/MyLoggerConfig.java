package spring.demo_one;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
 

@Configuration
@PropertySources({
	@PropertySource("classpath:mylogger.properties"),
	@PropertySource("classpath:sport.properties")
})
//@PropertySource("classpath:mylogger.properties")
@ComponentScan("spring.demo_one")
public class MyLoggerConfig {
 
	@Value("${root.logger.level}")
	private String rootLoggerLevel;
 
	@Value("${printed.logger.level}")
	private String printedLoggerLevel;
	
	public void setRootLoggerLevel(String rootLoggerLevel) {
		this.rootLoggerLevel = rootLoggerLevel;
	}
 
	public void setPrintedLoggerLevel(String printedLoggerLevel) {
		this.printedLoggerLevel = printedLoggerLevel;
	}
 
	@PostConstruct
	public void initLogger() {
        System.out.println( "inside initLogger ");
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printedLevel = Level.parse(printedLoggerLevel);
		
		// get logger for app context
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
 
		// get parent logger
		Logger loggerParent = applicationContextLogger.getParent();
 
		// set root logging level
		loggerParent.setLevel(rootLevel);
		
		// set up console handler
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		// add handler to the logger
		loggerParent.addHandler(consoleHandler);
	}
		
	@Bean		//bean id and no component search in swimCoach
	public Coach swim1Coach0() {
		SwimCoach swimCoach = new SwimCoach();
		return swimCoach;
	}
	
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
	
}