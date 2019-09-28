package spring.demo_one;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	//Coach aCoach = new BaseBallCoach();
    	Coach aCoach = new TrackCoach();

        System.out.println( aCoach.getDailyWorkout() );
    }
}
