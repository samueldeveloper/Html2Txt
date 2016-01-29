import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadPage {

    public void getPage(URL url, File file) throws IOException {
        BufferedReader in =
        		new BufferedReader(new InputStreamReader(url.openStream()));

        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
		
            // Imprime no console
            System.out.println(inputLine);
			
            // Grava pagina no arquivo
            out.write(inputLine);
            out.newLine();
        }

        in.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        URL url = null;
        //arquivo que sera gravado
        File file = new File("C:\\Users\\Samuel\\Desktop\\index.txt");
        try {
            url = new URL("http://201.20.73.8:8888/IS4/logon.jsp?sys=SIH&msgKey=");
            new LoadPage().getPage(url, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}