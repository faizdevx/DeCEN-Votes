package com.votechain.votechain_india;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlockchainController {

    @Autowired private BlockchainService svc;

    /* ---------- HTML PAGES ---------- */

    @GetMapping("/login")
    public String loginPage(){ return "login"; }

    @GetMapping({"/","/blockchain"})
    public String chain(Model m, Authentication auth){
        m.addAttribute("blocks", svc.getChain());
        m.addAttribute("isValid", svc.isValid());
        m.addAttribute("user", auth.getName());
        return "blockchain";
    }

    @GetMapping("/vote")
    public String votePage(Model m, Authentication auth){
        m.addAttribute("candidates", svc.getCandidates());
        m.addAttribute("already", svc.hasVoted(auth.getName()));
        return "vote";
    }

    @PostMapping("/vote")
    public String handleVote(@RequestParam String candidate,
                             Model m, Authentication auth){
        boolean ok = svc.addVote(auth.getName(), candidate);
        m.addAttribute("candidates", svc.getCandidates());
        m.addAttribute("already", true);
        m.addAttribute(ok ? "msg" : "err",
                       ok ? "Vote recorded!" : "You already voted");
        return "vote";
    }

    @GetMapping("/results")
    public String results(Model m){
        m.addAttribute("tally", svc.tally());
        m.addAttribute("total", svc.tally().values().stream().mapToInt(i->i).sum());
        m.addAttribute("valid", svc.isValid());
        return "results";
    }

    /* ---------- JSON API ---------- */

    @ResponseBody @GetMapping("/api/chain")          Object apiChain()   { return svc.getChain(); }
    @ResponseBody @GetMapping("/api/chain/tally")    Object apiTally()   { return svc.tally();    }
}
