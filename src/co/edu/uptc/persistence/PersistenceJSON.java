package co.edu.uptc.persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import co.edu.uptc.model.Agency;

public class PersistenceJSON {
	private String route;
	
	public PersistenceJSON(String route){
		this.route = route;
	}
	
	public Agency readDates() throws IOException {
		JsonReader reader = new JsonReader(new FileReader(route));
		Gson gson = new Gson();
		Agency agency = gson.fromJson(reader, Agency.class);
		reader.close();
		return agency;
	}
		
	public void writeDates(Agency agency) throws FileNotFoundException {
		Gson gson = new Gson();
		String text = gson.toJson(agency);
		PrintWriter writer = new PrintWriter(route);
		writer.write(text);
		writer.close();
	}
}
