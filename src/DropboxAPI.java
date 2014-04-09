import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class DropboxAPI {

	public static String note(String input) throws DbxException, IOException{
		DbxRequestConfig config = new DbxRequestConfig(
				"JavaTutorial/1.0", Locale.getDefault().toString());

		String accessToken = "dUnJnQUuIOQAAAAAAAAACs8WjfReysYtm6guSHNUi-DZWTgt9oLOsQeypu9sx0Rd";
		DbxClient client = new DbxClient(config, accessToken);

		PrintWriter writer = new PrintWriter("noteVader.txt", "UTF-8");
		writer.println(input);
		writer.close();
		File inputFile = new File("noteVader.txt");

		FileInputStream inputStream = new FileInputStream(inputFile);
		try {
			DbxEntry.File uploadedFile = client.uploadFile("/ChatVader2.0/noteVader.txt",
					DbxWriteMode.add(), inputFile.length(), inputStream);
		} finally {
			inputStream.close();
		}
		return input;
	}
}