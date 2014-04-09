import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterAPI {
	
	public static String joke(String input) throws TwitterException{
		String consumerKey ="B4P6FQfqKUHBx2U8twAwRycYq";
		String consumerSecret="PSsD1dfUBYh9wzNjvijRcPAgMfxOJw8AmZCq8SCMIwLjoifreH";
		String accessToken="99162621-a2x7HLwP39WzlkZzaogiugvCXFlgpvWlTwGVW9zfe";
		String accessTokenSecret="VSPAkjCIlsZMf4DimAJ9Q9cJ0UJqpVZgLQpT4jWVQzwfi";

		Twitter twitter = new TwitterFactory().getInstance();
	    //Twitter twitter = TwitterFactory.getSingleton();

		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		AccessToken AccessToken = new AccessToken(accessToken, accessTokenSecret);

		twitter.setOAuthAccessToken(AccessToken);
		ResponseList<Status> statusList = twitter.getUserTimeline("depresseddarth");
		
		String joke="";
		for (Status status : statusList) {
			joke = status.getText();
			return joke;
		}

		return joke;	
	}
}
