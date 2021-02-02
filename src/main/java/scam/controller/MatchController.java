package scam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import scam.dao.MatchMapper;
import scam.pojo.match;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@Controller
public class MatchController {
    @Autowired
    MatchMapper matchMapper;

    @RequestMapping("/matchTable")
    public String matchTable(Model model){
        List<match> matches = matchMapper.matchList();
        model.addAttribute("matches",matches);
        return "match";
    }

    @RequestMapping("/deleteMatch")
    public String deleteMatch(@PathParam("name") String name){
        matchMapper.deleteMatch(name);
        return "redirect:/matchTable";
    }

    @RequestMapping("/addMatch")
    public String addMatch(
            @PathParam("times") Date times,
            @PathParam("raceName") String raceName,
            @PathParam("organizer") String organizer,
            @PathParam("profession") String profession,
            @PathParam("rank") int rank,
            @PathParam("category") int category
    ){
        match match = new match(times, raceName, organizer, profession, rank, category);
        matchMapper.addMatch(match);
        return "redirect:/matchTable";
    }

    @RequestMapping("/update_match")
    public String updateMatchTransit(
            @PathParam("times") Date times,
            @PathParam("raceName") String raceName,
            @PathParam("organizer") String organizer,
            @PathParam("profession") String profession,
            @PathParam("rank") int rank,
            @PathParam("category") int category,
            Model model
    ){
        match match = new match(times, raceName, organizer, profession, rank, category);
        model.addAttribute("match",match);
        return "updatematch";
    }

    @RequestMapping("/updateMatch")
    public String updateMatch(
            @PathParam("times") Date times,
            @PathParam("raceName") String raceName,
            @PathParam("organizer") String organizer,
            @PathParam("profession") String profession,
            @PathParam("rank") int rank,
            @PathParam("category") int category
    ){
        match match = new match(times, raceName, organizer, profession, rank, category);
        matchMapper.updateMatch(match);
        return "redirect:/matchTable";
    }
}
