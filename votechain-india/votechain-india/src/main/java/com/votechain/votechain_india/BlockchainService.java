package com.votechain.votechain_india;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BlockchainService {

    private final List<Block> chain  = new ArrayList<>();
    private final Set<String> voted  = new HashSet<>();
    private final List<String> candidates = List.of("Alice","Bob","Charlie");

    public BlockchainService() {
        chain.add(new Block(0,"Genesis Block","0"));
    }

    public List<Block> getChain()          { return chain; }
    public List<String> getCandidates()    { return candidates; }
    public boolean hasVoted(String user)   { return voted.contains(user); }

    public synchronized boolean addVote(String user,String candidate) {
        if (voted.contains(user)) return false;
        Block last = chain.get(chain.size()-1);
        chain.add(new Block(last.getIndex()+1, user+": "+candidate, last.getHash()));
        voted.add(user);
        return true;
    }

    public boolean isValid() {
        for (int i=1;i<chain.size();i++){
            Block c = chain.get(i);
            Block p = chain.get(i-1);
            if (!c.getHash().equals(c.calculateHash())) return false;
            if (!c.getPreviousHash().equals(p.getHash())) return false;
        }
        return true;
    }

    public Map<String,Integer> tally() {
        Map<String,Integer> m = new LinkedHashMap<>();
        for (String c : candidates) m.put(c,0);
        for (Block b: chain){
            if (b.getIndex()==0) continue;
            String[] arr = b.getData().split(": ");
            if (arr.length==2){
                String cand = arr[1].trim();
                m.computeIfPresent(cand, (k,v)->v+1);
            }
        }
        return m;
    }
}
