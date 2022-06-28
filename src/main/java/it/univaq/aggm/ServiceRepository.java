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
	@GET
	@Path("/get")
	public ArrayList<MatchWithBet> getMatchesWithBet() throws IOException, SAXException, ParserConfigurationException {
		ArrayList<MatchWithBet> result = new ArrayList<MatchWithBet>();
		
		ArrayList<Match> matches = MatchService.getTodayMatches();
		for(int i=0; i<matches.size(); i++) {
			MatchWithBet mw = new MatchWithBet();
			mw.setMatch(matches.get(i));
			Bet bet = BetService.getBetForMatch(matches.get(i));
			mw.setBet(bet);
			result.add(mw);
		} 
		return result;
	}
}
