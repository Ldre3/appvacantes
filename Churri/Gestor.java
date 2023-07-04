import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gestor {
	
	private BufferedReader Archivo(String ruta) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(ruta);
		BufferedReader br = new BufferedReader(
		           new InputStreamReader(new FileInputStream(file), "Cp1252"));
		return br;
		
	}
	
	public int Contar(String ruta) throws IOException {
		int retorno = 0;
		BufferedReader br = Archivo(ruta);
		String linea = br.readLine();
		while (linea!=null) {
			String [] c = linea.split(";");
			List<String> b = Arrays.asList(c);
			if (b.contains("J")&&b.contains("PEDAGOGÍA TERAPÉUTICA")) {
				retorno++;
			}
			linea = br.readLine();
		}
		return retorno;
	}
}
