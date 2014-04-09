import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;


public class BINGTranslate {
	
	public static String french(String input) throws Exception{
		Translate.setClientId("pgunawan");
	    Translate.setClientSecret("kUSV3q03RRS52z4E54tvyJZ3rq7AjEd4mhcZB3NVvi4=");
	 
	    // Translate an english string to french
	    String frenchTranslation = Translate.execute(input,Language.FRENCH);
	    
	    return frenchTranslation;
	}
	public static String spanish(String input) throws Exception{
		Translate.setClientId("pgunawan");
	    Translate.setClientSecret("kUSV3q03RRS52z4E54tvyJZ3rq7AjEd4mhcZB3NVvi4=");
	 
	    String spanishTranslation = Translate.execute(input,Language.SPANISH);
	    
	    return spanishTranslation;		
	}
	public static String dutch(String input) throws Exception{
		Translate.setClientId("pgunawan");
	    Translate.setClientSecret("kUSV3q03RRS52z4E54tvyJZ3rq7AjEd4mhcZB3NVvi4=");
	 
	    String spanishTranslation = Translate.execute(input,Language.DUTCH);
	    
	    return spanishTranslation;
	}
	public static String indonesian(String input) throws Exception{
		Translate.setClientId("pgunawan");
	    Translate.setClientSecret("kUSV3q03RRS52z4E54tvyJZ3rq7AjEd4mhcZB3NVvi4=");
	 
	    String spanishTranslation = Translate.execute(input,Language.INDONESIAN);
	    
	    return spanishTranslation;
	}
	public static String russian(String input) throws Exception{
		Translate.setClientId("pgunawan");
	    Translate.setClientSecret("kUSV3q03RRS52z4E54tvyJZ3rq7AjEd4mhcZB3NVvi4=");
	 
	    String spanishTranslation = Translate.execute(input,Language.RUSSIAN);
	    
	    return spanishTranslation;
	}


}
