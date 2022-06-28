package it.univaq.aggm;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

@WebService
public interface ServiceRepositoryInterface {
	@WebMethod
	public ArrayList<MatchWithBet> getMatchesWithBet() throws IOException, SAXException, ParserConfigurationException;
}
