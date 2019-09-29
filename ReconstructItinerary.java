package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from,
 * to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a
 * smaller lexical order than ["JFK", "LGB"]. All airports are represented by three capital letters
 * (IATA code). You may assume all tickets form at least one valid itinerary.
 * 
 * Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] Output: ["JFK", "MUC",
 * "LHR", "SFO", "SJC"]
 * 
 * Example 2:
 * 
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] Output:
 * ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 */
public class ReconstructItinerary {
	
	public List<String> findItinerary(List<List<String>> tickets) {
		
		Map<String, Queue<String>> map = new HashMap<>();
		List<String> reconstructedItineary = new ArrayList<>();
		
      if(tickets == null || tickets.size() == 0)
      		return reconstructedItineary;
      
      for(List<String> ticket : tickets) {
      		map.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
      		map.get(ticket.get(0)).add(ticket.get(1));
      }
      
      backTrack("JFK", map, reconstructedItineary);
		return reconstructedItineary;
   }
	
	private void backTrack(String src, Map<String, Queue<String>> map, List<String> reconstructedItineary) {
		Queue<String> destinations = map.get(src);
		
		while(destinations != null && !destinations.isEmpty()) {
				backTrack(destinations.poll(), map, reconstructedItineary);
		}
		reconstructedItineary.add(0, src);
	}

	public static void main(String[] args) {
		List<List<String>> itinerary = new ArrayList<>();
		itinerary.add(Arrays.asList("MUC", "LHR"));
		itinerary.add(Arrays.asList("JFK", "MUC"));
		itinerary.add(Arrays.asList("SFO", "SJC"));
		itinerary.add(Arrays.asList("LHR", "SFO"));
		ReconstructItinerary obj = new ReconstructItinerary();
		System.out.println(obj.findItinerary(itinerary));
	}
}
