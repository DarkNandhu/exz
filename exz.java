import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
public class exz {
    public static void main(String args[]) throws Exception {
String[] a=new String[100];
String ini,pat;
Scanner na=new Scanner(System.in);
Scanner nz=new Scanner(System.in);
int x=0;
int y=0;
System.out.println("Enter the Image to be Downloaded");
ini=na.nextLine();
System.out.println("Enter the Index of Image to be Downloaded");
y=nz.nextInt();
System.out.println("Enter the path (use double slash instead of single slash)");
pat=na.nextLine();
        String webUrl = "http://images.search.yahoo.com/search/images;_ylt=AwrTcXZ4YxFVCtQAl8KLuLkF;_ylc=X1MDOTYwNTc0ODMEX3IDMgRiY2sDZG92OWVtdGE4ZDIwaCUyNmIlM0Q0JTI2ZCUzRDU2WTNka1JwWUY2OGFONGxDa0tKNnJEdjZCUS0lMjZzJTNEOXQlMjZpJTNENnl2ZW1sNWc2emRxSUw3SzRsOVgEZnIDBGdwcmlkAwRtdGVzdGlkA251bGwEbl9zdWdnAzAEb3JpZ2luA2ltYWdlcy5zZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDBHFzdHJsAzMEcXVlcnkDZG9nBHRfc3RtcAMxNDI3MjAyOTUwBHZ0ZXN0aWQDSU1HMDM-?pvid=gIFr2jIwNi7cfS63VIaIEQ48MTE3LgAAAACUE.gl&fr2=sb-top-images.search.yahoo.com&p="+ ini +"&ei=UTF-8&iscqry=&fr=sfp";
        URL url = new URL(webUrl);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        parser.parse(br, callback, true);

        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) {
            AttributeSet attributes = iterator.getAttributes();
            String imgSrc = (String) attributes.getAttribute(HTML.Attribute.SRC);
        a[x]=imgSrc; 
         x++;
        }
      
      URL url1 = new URL(a[y]);
InputStream in = new BufferedInputStream(url1.openStream());
ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buf = new byte[9216];
int n = 0;
while (-1!=(n=in.read(buf)))
{
   out.write(buf, 0, n);
}
out.close();
in.close();
byte[] response = out.toByteArray();
FileOutputStream fos = new FileOutputStream(pat+ini+".jpg");
fos.write(response);
fos.close();
  System.out.println("Downloaded on: "+pat+":");
    }
}
