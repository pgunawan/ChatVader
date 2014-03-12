import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bot {
	
    private static BufferedReader reader;

	static String Bot(String input) throws IOException{
        //Checks for which method to call first
		if(input.startsWith("hey")||
           input.startsWith("hi")||
           input.startsWith("sup")||
           input.startsWith("yo ")||
           input.matches("yo")||
           input.matches("yo,")||
           input.contains("hello")||
           input.contains("greetings")||
           input.contains("good morning")||
           input.contains("good evening")||
           input.contains("good day"))
			return Hi(input);
		else if(input.contains("where"))
			return	Where(input);
		else if(input.contains("how"))
			return How(input);
		else if(input.contains("what"))
			return What(input);
		else if(input.contains("why"))
			return Why(input);
		else if(input.contains("when"))
			return When(input);
		else if(input.contains("?"))
			return Question(input);
		else if(input.contains("!") &&
				input.contains("/VB")||
				input.contains("/VBD")||
				input.contains("/VBG")||
				input.contains("/VBN")||
				input.contains("/VBP")||
				input.contains("/VBZ"))
			return POSTagger(input);
		else if(input.contains("bye"))
			return Bye();
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
        
        if(input.contains("where"))
            part2=Where(input);
        else if(input.contains("how"))
            part2=How(input);
        else if(input.contains("what"))
            part2=What(input);
        else if(input.contains("why"))
            part2=Why(input);
        else if(input.contains("when"))
            part2=When(input);
        else if(input.contains("?"))
            part2=Question(input);
        else  part2="what brings you here?";
        String a= part1+part2;
        return a;
	}
	
	private static String Where(String input){
		String a="";
		if(input.contains("you")&&input.contains("live"))
            a="Coruscant, it's the first planet on the right after Xpiter.";
		else if(input.contains("you")&&input.contains("from"))
			a="Tataouine, it's beautiful during the winter.";
		else if(input.contains("dark"))
			a="The dark side is in all of us.";
		else a="The emplacement cannot be revealed to the weak links like yourself.";
		
		return a;	
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
		System.out.println(randString);
		
		if(input.contains("you")&&(input.contains("washroom")||input.contains("pee")||input.contains("bathroom")))
			randString="Man diapers... this stays between us right?";
		else if(input.contains("you")&&input.contains("eat"))
			randString="Power is the only resource I need.";
		else if(input.contains("power"))
			randString="You need to channel your anger to reach greater power.";

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
		System.out.println(randString);
		
		if(input.contains("you")&&((input.contains("living"))||input.contains("want")))
			randString="Rule the world";
		else if(input.contains("depends"))
			randString="Are you ready to join the darkside?";
		
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
		System.out.println(randString);
		
		if(input.contains("cape"))
			randString="It looks cool.";
		else if(input.contains("dark")||input.contains("evil"))
			randString="I need to get my revenge.";
		else if(input.contains("mask"))
			randString="Trust me, you do not want to see the real me.";
		
		return randString;
	}
	
	private static String When(String input){
		String a="";
		if(input.contains("born"))
            a="The day I put on this mask.";
		else if(input.contains("die"))
			a="Never.";
		else a="Time is relative.";
		return a;
	}
	
	private static String Question(String input) throws IOException{
		reader = new BufferedReader(new FileReader("dontunderstand.txt"));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while( line != null ){
		    lines.add(line);
		    line = reader.readLine();
		}
		//Choose a random one from the list
		Random r = new Random();
		String randString= lines.get(r.nextInt(lines.size()));
		System.out.println(randString);
		
		if(input.contains("who"))
			randString="This information cannot be revealed to the weaklinks like yourself..";
		else if(input.contains("depends"))
			randString="Are you ready to join the darkside?";
		else if(input.contains("joke"))
			randString="Alright...Let me catch me catch my breath first.";
		else if(input.contains("other"))
			randString="I'm not good at it... can you give me a hand?";
		else if(input.contains("regret"))
			randString="Do you regret being born?";
		
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
		System.out.println(randString);
		
		if(input.contains("yes"))
			randString="Good.";
		else if(input.contains("no"))
			randString="You will regret this.";
		else if(input.contains("haha"))
			randString="Do you think that's funny??";
		else if((input.contains("i'm")|input.contains("i am")|input.contains("my name"))&input.contains("luke"))
			randString="I am your father.";
		else if(input.contains("you")&input.contains("heard"))
			randString="It depends...";
		
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
		System.out.println(randString);
		
		return randString;
	}
	
	private static String Bye(){
		String end="Good day sir.";
		return end;
	}
	
}
