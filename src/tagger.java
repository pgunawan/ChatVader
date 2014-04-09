import java.io.IOException;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class tagger{

	public static String tag(String input) throws Exception{

		MaxentTagger tagger = null;
		try {
			tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		String tagged = tagger.tagString(input);
		String output = null;
		try {
			output = Bot.Bot(tagged);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return tagged;
	}
}
