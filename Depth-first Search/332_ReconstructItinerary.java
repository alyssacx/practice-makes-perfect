/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

public List<String> findItinerary(String[][] tickets) {

    List<String> list = new ArrayList<String>();
    if(tickets == null || tickets.length == 0 || tickets[0].length == 0)
        return list;

    //build graph
    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    for(int i = 0; i < tickets.length; i++) {
        if(!map.containsKey(tickets[i][0])) {
            map.put(tickets[i][0], new PriorityQueue<String>());
        }
        map.get(tickets[i][0]).offer(tickets[i][1]);
    }

    helper("JFK", map, list, tickets.length+1);
    return list;
}

private void helper(String label, HashMap<String, PriorityQueue<String>> map, List<String> list, int count) {


    // if(list.size() == count)
    //     return;

    System.out.println(label);
    PriorityQueue<String> q = map.get(label);
    while(q != null && !q.isEmpty()) {
        helper(q.poll(), map, list, count);
    }

    list.add(0, label);

}
