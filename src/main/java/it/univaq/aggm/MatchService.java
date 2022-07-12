package it.univaq.aggm;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MatchService {
	public static ArrayList<Match> getTodayMatches() throws IOException, SAXException, ParserConfigurationException {
		ArrayList<Match> result = new ArrayList<Match>();
		Document doc = getDocument();
		NodeList list = doc.getElementsByTagName("Match");
		for (int temp = 0; temp < list.getLength(); temp++) { // loop over football service provider matches
			Node node = list.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				Element localTeam = (Element) element.getElementsByTagName("localTeam").item(0);
				Team local = getTeamFromElement(localTeam);
				Element visitorTeam = (Element) element.getElementsByTagName("visitorTeam").item(0);
				Team visitor = getTeamFromElement(visitorTeam);
				String localScore = element.getElementsByTagName("localScore").item(0).getTextContent();
				String visitorScore = element.getElementsByTagName("visitorScore").item(0).getTextContent();
				String coordinates = element.getElementsByTagName("coordinates").item(0).getTextContent();
				result.add(new Match(local, Integer.parseInt(localScore), visitor, Integer.parseInt(visitorScore), coordinates));
			}
		}
		return result;
	}
	
	private static Document getDocument() throws IOException, SAXException, ParserConfigurationException {
		String url = "http://localhost:8083/matches";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).get().build();
		Response response = client.newCall(request).execute();
		String data = response.body().string();
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(data)));
		doc.getDocumentElement().normalize();
		return doc;
	}
	
	// generate team object from a Match XML element
	private static Team getTeamFromElement(Element element) {
		int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
		String name = element.getElementsByTagName("name").item(0).getTextContent();
		return new Team(id, name);
	}
}
