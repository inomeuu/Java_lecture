/**
 * 
 */
package opendata0;

//import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author b1021008 井上芽依
 *
 */
public class ReadFromURL {
	private String url;
	private String code;
	private ArrayList<String> data;
	
	public ReadFromURL(String url,String code) {
		this.url=url;
		this.code=code;
		data=new ArrayList<String>();
	}
	
	public ArrayList<String> getData() { return this.data; }
	
	public boolean readData(){
		try {
			URL url = new URL(this.url);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, this.code);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine()) != null) {
				data.add(line);
			}
		    	br.close();
		    	return true;
		    }catch(IOException e) {
		    	return false;
		    }
	}
	
	public boolean writeToFile(String a) {
		try {
		FileWriter fw = new FileWriter(a);
		BufferedWriter out = new BufferedWriter(fw);
		for(String str: data) {
			out.write(str);
			out.newLine();
		}
		out.flush();
		out.close();
		return true;
		}catch(IOException e) {
			return false;
		}
	}
//		out.write("ABCDEFG");
//		out.newLine();
//		out.write("日本語");
//		out.newLine();
//		out.write("한국"); // hangul
//		out.flush();
//		out.close();
		public static void main(String[] args){
			final String URL = "https://www.city.hakodate.hokkaido.jp/docs/2014061200017/files/h18_koutuuryou_hyou.csv";
			final String CODE = "SJIS";
			final String OUTFILE = "data.txt";
			ArrayList<String> data;

			ReadFromURL rcsv = new ReadFromURL(URL, CODE);
	                rcsv.readData();
			data = rcsv.getData();
			for(String s: data) 
				System.out.println(s);
	    
			rcsv.writeToFile(OUTFILE);
	}
}

