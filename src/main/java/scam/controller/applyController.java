package scam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import scam.dao.MatchMapper;
import scam.dao.applyMapper;
import scam.pojo.apply;
import scam.pojo.match;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

/**
 * @author y'l'l
 */
@Controller
public class applyController {
    @Autowired
    applyMapper applyMapper;

    @RequestMapping("/applyTable")
    public String applyList(Model model){
        List<apply> applies = applyMapper.applyList();
        model.addAttribute("applies",applies);
        return "apply";
    }

    @RequestMapping("/deleteApply")
    public String deleteApply(
            @PathParam("eventName") String eventName,
            @PathParam("sno") String sno,
            @PathParam("tno") String tno
    ){
        applyMapper.deleteApply(1);
        return "redirect:/applyTable";
    }

    @RequestMapping("/update_apply")
    public String updateApplyTransit(
            @PathParam("eventName") String eventName,
            @PathParam("sno") String sno,
            @PathParam("tno") String tno,
            Model model
    ){
        apply apply = applyMapper.getApply(1);
        model.addAttribute("apply",apply);
        return "updateapply";
    }

    @RequestMapping("/updateApply")
    public String updateApply(
            @PathParam("eventName") String eventName,
            @PathParam("sno") String sno,
            @PathParam("id") Integer id,
            @PathParam("teamName") String teamName,
            @PathParam("teamNumber") Integer teamNumber
    ){
        applyMapper.updateApply(new apply(eventName, teamNumber, teamName, sno, id));
        return "redirect:/applyTable";
    }

    @RequestMapping("/addApply")
    public String addApply(
            @PathParam("eventName") String eventName,
            @PathParam("sno") String sno,
            @PathParam("tno") Integer id,
            @PathParam("teamName") String teamName,
            @PathParam("teamNumber") Integer teamNumber
    ){
        applyMapper.addApply(new apply(eventName, teamNumber, teamName, sno, id));
        return "redirect:/applyTable";
    }
}
