import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;
import com.wolfram.alpha.net.HttpProviderFactory;

public class WolframAPI {

	private static String appid = "6LYGA3-A38P5VHTH8";

	@SuppressWarnings("static-access")

	public static String Wolfram(String input) throws WAException {
		HttpProviderFactory h = new HttpProviderFactory();

		input = "George Lucas";

		WAEngine engine = new WAEngine();
		h.getDefaultHttpProvider();

		// These properties will be set in all the WAQuery objects created from this WAEngine.
		engine.setAppID(appid);
		engine.addFormat("plaintext");

		// Create the query.
		WAQuery query = engine.createQuery();
		query.setInput(input);

		String out = "";

			WAQueryResult queryResult = engine.performQuery(query);

			if (queryResult.isError()) {
				System.out.println("Query error");
				System.out.println("  error code: " + queryResult.getErrorCode());
				System.out.println("  error message: " + queryResult.getErrorMessage());
			} else if (!queryResult.isSuccess()) {
				System.out.println("Query was not understood; no results available.");
			} else {
				// Got a result.
				System.out.println("Successful query. Pods follow:\n");

				for (WAPod pod : queryResult.getPods()) {
					if (!pod.isError()) {
						out = pod.getTitle();
						out = "------------";
						for (WASubpod subpod : pod.getSubpods()) {
							for (Object element : subpod.getContents()) {
								return out = ((WAPlainText) element).getText() + "\n";
							}
						}
					}
				}
			}
			return out;
		} 	
}