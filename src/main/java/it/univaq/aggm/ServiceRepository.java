package it.univaq.aggm;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

@Path("matches-with-bets")
@Produces("text/xml")
@WebService(endpointInterface="it.univaq.aggm.ServiceRepositoryInterface")
public class ServiceRepository implements ServiceRepositoryInterface {
	@GET @Path("/")
	public ArrayList<MatchWithBet> getMatchesWithBet() throws IOException, SAXException, ParserConfigurationException {
		ArrayList<MatchWithBet> result = new ArrayList<MatchWithBet>();
		
		ArrayList<Match> matches = MatchService.getTodayMatches(); // get all matches
		for(int i=0; i<matches.size(); i++) { // iterate through them
			Bet bet = BetService.getBetForMatch(matches.get(i)); // get bet
			result.add(new MatchWithBet(matches.get(i), bet)); // generate MatchWithBet object
		} 
		return result;
	}
}
