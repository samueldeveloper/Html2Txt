import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class Html2Text extends HTMLEditorKit.ParserCallback {
	    
	    public Html2Text(){
	    	
	    }
	    StringBuffer s;
	    
	    public void parse(Reader in) throws IOException {
	        s = new StringBuffer();
	        ParserDelegator delegator = new ParserDelegator();
	        // the third parameter is TRUE to ignore charset directive
	        delegator.parse(in, this, Boolean.TRUE);
	    }
	    public void handleText(char[] text, int pos) {
	        s.append(text);
	        s.append("\n");
	    }
	    public String getText() {
	        return s.toString();
	    }
	    
	    public static void main (String[] args) throws FileNotFoundException, IOException {
	            // the HTML to convert
	            FileReader in = new FileReader("C:\\index.html");
	            Html2Text parser = new Html2Text();
	            parser.parse(in);
	            in.close();
	            System.out.println(parser.getText());
	    }
}
