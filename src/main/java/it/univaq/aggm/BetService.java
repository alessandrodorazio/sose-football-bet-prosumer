package it.univaq.aggm;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class BetService {
	public static Bet getBetForMatch(Match m) throws IOException, SAXException, ParserConfigurationException {
		Document doc = getDocument(m);
		NodeList list = doc.getElementsByTagName("Bet"); // get Bet element from XML document
		Node node = list.item(0);
		return generateBetFromElement((Element) node);
	}
	
	// get the XML document from Bet Service Provider
	private static Document getDocument(Match m) throws IOException, SAXException, ParserConfigurationException {
		OkHttpClient client = new OkHttpClient();
		String url = "http://localhost:8082/bets/calculate?localTeam=" + m.getLocalTeam().getId() + "&visitorTeam=" + m.getVisitorTeam().getId();
		Request request = new Request.Builder().url(url).get().build();
		Response response = client.newCall(request).execute();
		String data = response.body().string();
		InputSource inputSource = new InputSource(new StringReader(data));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
		doc.getDocumentElement().normalize();
		return doc;
	}
	
	// create bet object from Bet XML Element
	private static Bet generateBetFromElement(Element element) {
		double localTeamQuote = Double.parseDouble(element.getElementsByTagName("localTeamQuote").item(0).getTextContent());
		double visitorTeamQuote = Double.parseDouble(element.getElementsByTagName("visitorTeamQuote").item(0).getTextContent());
		double tieQuote = Double.parseDouble(element.getElementsByTagName("tieQuote").item(0).getTextContent());
		Bet bet = new Bet(localTeamQuote, visitorTeamQuote);
		bet.setTieQuote(tieQuote);
		return bet;
	}
}
