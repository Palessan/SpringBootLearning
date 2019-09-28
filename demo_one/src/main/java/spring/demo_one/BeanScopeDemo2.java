package spring.demo_one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class BeanScopeDemo2 
{
    public static void main( String[] args )
    {
    	//Load spring app context file
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

    	//Get bean
    	Coach theCoach = context.getBean("myCoach", Coach.class);//Interface 	

    	Coach alphaCoach = context.getBean("myCoach", Coach.class);//Interface 	
    	
    	TrackCoach trackCoach = context.getBean("trackCoach", TrackCoach.class);//Interface 	
    	
    	boolean result = theCoach==alphaCoach;//Actually looks the mem location of the object to make sure it is the same in memory
    	
        System.out.println();
        System.out.println( theCoach.getDailyWorkout() );
        System.out.println( theCoach.getDailyFortune() );
        System.out.println();
        System.out.println( "result="+result );
        System.out.println( "mem location for theCoach="+theCoach );
        System.out.println( "mem location for alphaCoach="+alphaCoach );
        System.out.println();
        System.out.println( "trackCoach workout= " + trackCoach.getDailyWorkout() );
        System.out.println( "trackCoach fortune= " + trackCoach.getDailyFortune() );
        System.out.println();
        //close the context
        context.close();
        
    }
}
