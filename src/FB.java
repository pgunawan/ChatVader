import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;


public class FB {
	
	public static String about(String input){
		FacebookClient fbClient = new DefaultFacebookClient();
		Page me = fbClient.fetchObject("Coruscant.thePlanet",com.restfb.types.Page.class);
		String about = me.getDescription();		
		return about;
	}
	
	public static String GLquote(String input){
		FacebookClient fbClient = new DefaultFacebookClient();
		Page me = fbClient.fetchObject("georgelucas.ds",com.restfb.types.Page.class);
		String quote = me.getAbout();		
		return quote;
	}
}
