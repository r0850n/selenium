import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;


public class WejsciaWyjscia {

	@Test
	public void test() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("podaj imie: ");
		
		String imie=s.next();
		
		System.out.println("witaj: "+ imie);
	}
	@Test
	public void testName() throws Exception {
		Scanner in = new Scanner(Paths.get("F:\\DATA\\snapshots\\private\\wk\\Goldyn\\Vaadinjpa\\src\\test\\java\\aaa.txt"));
		//Scanner in = new Scanner(System.in);
		//System.out.println("Podaj imie:");
		while(in.hasNext()){
		String imie= in.next();
	//	PrintWriter out=new PrintWriter("F:\\DATA\\snapshots\\private\\wk\\Goldyn\\Vaadinjpa\\src\\test\\java\\aaa.txt");
		//out.println(imie); 
		
		System.out.println(imie);
		}
	}
	@Test
	public void testName2() throws Exception {
		 
		Scanner in = new Scanner(System.in);
		System.out.println("podaj Imie:");
		String imie = in.next();
		
		PrintWriter out = new PrintWriter("aaa.txt");
		out.write(imie);
		
		out.flush();
		out.close();
		
		Scanner  odczyt= new Scanner(Paths.get("aaa.txt"));
		
		System.out.println(odczyt.next());
	}

}
