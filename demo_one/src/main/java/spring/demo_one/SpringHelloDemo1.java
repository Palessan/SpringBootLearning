package spring.demo_one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class SpringHelloDemo1 
{
    public static void main( String[] args )
    {
    	//Load spring app context file
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    	//Get bean
    	Coach theCoach = context.getBean("myCoach", Coach.class);//Interface
    	
    	CricketCoach myCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);//Implementation
    	//Coach aCoach = new TrackCoach();//Deprecated
    	

        System.out.println();
        System.out.println( theCoach.getDailyWorkout() );
        System.out.println( theCoach.getDailyFortune() );
        System.out.println();
        System.out.println( myCricketCoach.getDailyWorkout() );
        System.out.println( myCricketCoach.getDailyFortune() );
        System.out.println( myCricketCoach.getEmail());
        System.out.println( myCricketCoach.getTeamName() );
        System.out.println();
        
        //close the context
        context.close();
        
    }
}
