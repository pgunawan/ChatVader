import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.dropbox.core.DbxException;
import com.wolfram.alpha.WAException;

import twitter4j.TwitterException;

public class Bot {

	private static BufferedReader reader;

	static String Bot(final String input) throws Exception{
		//Checks for which method to call first
		if(synonyms.syn(input,"greetings")||
				input.contains("greetings")||
				input.contains("hey")||
				input.contains("sup")||
				input.contains("yo")){
			return Hi(input);}
		else if(input.contains("where")){
			return	Where(input);}
		else if(input.contains("how")){
			return How(input);}
		else if(input.contains("what")){
			return What(input);}
		else if(input.contains("why")){
			return Why(input);}
		else if(input.contains("when")){
			return When(input);}
		else if(input.contains("cosc")&&!input.contains("note")){
			return stressVader(input);}
		if(synonyms.syn(input,"creator")||input.contains("creator")||synonyms.syn(input,"creator")){
			return stressVader2(input);}
		if(input.contains("?")||
				(input.contains("speak") && (input.contains("indonesian")||
						input.contains("spanish")||input.contains("french")||
						input.contains("dutch")||input.contains("russian")))){
			return multiLang(input);
		}
		else if (input.contains("about")||input.contains("coruscant")){
			return FBabout(input);
		}
		else if (input.contains("george lucas")){
			return GL(input);
		}
		else if (input.contains("joke")){
			return Twitter(input);
		}
		else if (input.contains("note")){
			return Dropbox(input);
		}
		else if(input.contains("bye")){
			return Bye();}
		else return generic(input);
	}

	private static String Hi(String input) throws IOException{
		//Randoms between 2 type of greetings, if the person a person ask a question
		//It calls the adequate method else returns a generic answer
		Random generator = new Random();
		int i=generator.nextInt(2)+1;
		String part1="";
		String part2="";
		switch (i) {
		case 1:  part1 = "Hello, ";
		break;
		case 2:  part1 = "Greetings, ";
		break;}

		if(input.contains("where")){
			part2=Where(input);}
		else if(input.contains("how")){
			part2=How(input);}
		else if(input.contains("what")){
			part2=What(input);}
		else if(input.contains("why")){
			part2=Why(input);}
		else if(input.contains("when")){
			part2=When(input);}
		else  part2="what brings you here?";
		String a= part1+part2;
		return a;
	}

	private static String Where(String input) throws IOException{
		reader = new BufferedReader(new FileReader("where.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString=lines.get(r.nextInt(lines.size()));
		
		if(input.contains("live")){
			randString="Coruscant, it's the first planet on the right after Xpiter.";}
		else if(input.contains("you")&&input.contains("from")){
			randString="Tataouine, it's beautiful during the winter.";}
		else if(input.contains("dark")){
			randString="The dark side is in all of us.";}

		return randString;	
	}

	private static String How(String input) throws IOException{
		reader = new BufferedReader(new FileReader("how.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString=lines.get(r.nextInt(lines.size()));

		if(input.contains("washroom")||input.contains("pee")||input.contains("bathroom")){
			randString="Man diapers... this stays between us right?";}
		else if(input.contains("you")&&input.contains("eat")||synonyms.syn(input,"eat")){
			randString="Power is the only resource I need.";}
		else if(input.contains("power")){
			randString="You need to channel your anger to reach greater power.";}

		return randString;
	}

	private static String What(String input) throws IOException{
		reader = new BufferedReader(new FileReader("what.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));

		if(input.contains("you")&&input.contains("want")){
			randString="Rule the world";}
		else if(input.contains("depends")){
			randString="Are you ready to join the darkside?";}

		return randString;	
	}

	private static String Why(String input) throws IOException{
		reader = new BufferedReader(new FileReader("why.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString=lines.get(r.nextInt(lines.size()));

		if(synonyms.syn(input, "cloak") || input.contains("cloak")){
			randString="It looks cool.";}
		else if(input.contains("dark")||input.contains("evil")){
			randString="I need to get my revenge.";}
		else if(input.contains("mask")){
			randString="Trust me, you do not want to see the real me.";}

		return randString;
	}


	private static String When(String input) throws IOException{
		String randString = null;
		reader = new BufferedReader(new FileReader("when.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		randString= lines.get(r.nextInt(lines.size()));
		return randString;
	}

	private static String generic(String input) throws IOException{
		reader = new BufferedReader(new FileReader("generic.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));

		if(input.contains("yes")){
			reader = new BufferedReader(new FileReader("affirmation.txt"));
		lines = new ArrayList<String>();
		line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		r = new Random();
		randString= lines.get(r.nextInt(lines.size()));
		}
		else if(input.contains("no")){
			reader = new BufferedReader(new FileReader("negation.txt"));
		lines = new ArrayList<String>();
		line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		r = new Random();
		randString= lines.get(r.nextInt(lines.size()));
		}
		reader = new BufferedReader(new FileReader("dontunderstand.txt"));
		lines = new ArrayList<String>();
		line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		r = new Random();
		randString= lines.get(r.nextInt(lines.size()));

		if(input.contains("who")){
			randString="This information cannot be revealed to the weaklinks like yourself..";}
		else if(input.contains("depends")){
			randString="Are you ready to join the darkside?";}
		else if(input.contains("other")){
			randString="I'm not good at it... can you give me a hand?";}
		else if(input.contains("regret")){
			randString="Do you regret being born?";}
		
		else if(input.contains("haha")){
			randString="Do you think that's funny??";}
		else if((input.contains("i'm")|input.contains("i am")|input.contains("my name"))&input.contains("luke")){
			randString="I am your father.";}
		else if(input.contains("you")&input.contains("heard")){
			randString="It depends...";}

		return randString;    
	}

	private static String POSTagger(String input) throws IOException{
		reader = new BufferedReader(new FileReader("postaggerverb.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));
		
		return randString;
	}

	//additional topics
	private static String stressVader(String input) throws IOException{
		reader = new BufferedReader(new FileReader("stressvader2.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));

		return randString;
	}
	
	private static String stressVader2(String input) throws IOException, WAException{
		reader = new BufferedReader(new FileReader("stressvader.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String out = lines.get(r.nextInt(lines.size()));
		
		if(input.contains("real") && 
				(input.contains("creator")||synonyms.syn(input,"creator"))){
			out = WolframAPI.Wolfram(input);
		}
		return out;
	}
	
	// Bing Translate API
	private static String multiLang(String input) throws Exception{
		reader = new BufferedReader(new FileReader("multilang.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
			lines.add(line);
			line = reader.readLine();
		}
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));
		
	    String translate = null;
		if(input.contains("french")){
			translate = BINGTranslate.french(randString);
		}
		if(input.contains("spanish")){
			translate = BINGTranslate.spanish(randString);
		}
		if(input.contains("dutch")){
			translate = BINGTranslate.dutch(randString);
		}
		if(input.contains("russian")){
			translate = BINGTranslate.russian(randString);
		}
		if(input.contains("indonesian")){
			translate = BINGTranslate.indonesian(randString);
		}

		return translate;
	}

	// Facebook graph API
	private static String FBabout(String input){
		String about = FB.about(input);
		return about;
	}
	private static String GL(String input){
		String GLquote = FB.GLquote(input);
		return "Wll, here is a quote from him: " + GLquote;
	}

	//Twitter API
	private static String  Twitter(String input) throws TwitterException{
		String funny = TwitterAPI.joke(input);
		return "You should follow my Twitter account (@DepressedDarth). "
				+ "I can be very funny sometimes. This is my latest tweet: \n\n" + funny;
	}

	//Dropbox API
	private static String Dropbox(String input) throws DbxException, IOException{
		DropboxAPI.note(input);
		return "NOTED! You can find your file here: https://www.dropbox.com/sh/dh3bviiegm4ha1g/qyAndjBW3G";
	}

	private static String Bye(){
		String end="Good day sir.";
		return end;
	}
}
