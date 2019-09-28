package spring.demo_one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class CodeConfigDemo3 
{
    public static void main( String[] args )
    {
    	//Load spring app context file
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class);

    	//Get bean
//    	Coach theCoach = context.getBean("myCoach", Coach.class);//Interface
//    	
//    	BaseballCoach myBaseballCoach = context.getBean("myBaseballCoach", BaseballCoach.class);//Implementation
    	//Coach aCoach = new TrackCoach();//Deprecated
    	
//    	BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);//Implementation
//
//    	
    	CricketCoach myCricketCoach = context.getBean("cricketCoach", CricketCoach.class);//Implementation
//    	//Coach aCoach = new TrackCoach();//Deprecated
//    	
//    	TennisCoach tennisCoach=context.getBean("thatSillyCoach", TennisCoach.class);
//    	//TennisCoach tennisCoach=context.getBean("tennisCoach", TennisCoach.class);
//    	
//    	TrackCoach trackCoach = context.getBean("trackCoach", TrackCoach.class);//Interface 	

    	SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);//Interface 	
    	SwimCoach swimCoach1 = context.getBean("swim1Coach", SwimCoach.class);//Interface 	


    	
//        System.out.println();
//        System.out.println( theCoach.getDailyWorkout() );
//        System.out.println( theCoach.getDailyFortune() );
        System.out.println();
        System.out.println( myCricketCoach.getDailyWorkout() );
        System.out.println( myCricketCoach.getDailyFortune() );
        System.out.println( myCricketCoach.getEmail());
        System.out.println( myCricketCoach.getTeamName() );
        System.out.println();
//        System.out.println( baseballCoach.getDailyWorkout() );
//        System.out.println( baseballCoach.getDailyFortune() );
//        System.out.println();
//        System.out.println( "tennisCoach wo="+tennisCoach.getDailyWorkout() );
//        System.out.println( "tennisCoach f="+tennisCoach.getDailyFortune() );
//        System.out.println();
//        System.out.println( "trackCoach workout= " + trackCoach.getDailyWorkout() );
//        System.out.println( "trackCoach fortune= " + trackCoach.getDailyFortune() );
        System.out.println();
        System.out.println( "swimCoach workout= " + swimCoach.getDailyWorkout() );
        System.out.println( "swimCoach fortune= " + swimCoach.getDailyFortune() );
        System.out.println();
        System.out.println( "swimCoach1 workout= " + swimCoach1.getDailyWorkout() );
        System.out.println( "swimCoach1 fortune= " + swimCoach1.getDailyFortune() );
        System.out.println();
        //close the context
        context.close();
        
    }
}
