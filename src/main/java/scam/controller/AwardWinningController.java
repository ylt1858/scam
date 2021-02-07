package scam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import scam.dao.AwardWinningMapper;
import scam.pojo.AwardWinning;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author y'l'l
 */
@Controller
public class AwardWinningController {
    @Autowired
    AwardWinningMapper awardWinningMapper;

    @RequestMapping("/AWTable")
    public String awardWinningList(Model model){
        List<AwardWinning> awardWinnings = awardWinningMapper.awardWinningList();
        model.addAttribute("aws",awardWinnings);
        return "awardwinning";
    }

    @RequestMapping("/deleteAwardWinning")
    public String deleteAwardWinning(@PathParam("id") int id){
        awardWinningMapper.deleteModel(id);
        return "redirect:/AWTable";
    }

    @RequestMapping("/addAwardWinning")
    public String addAwardWinning(
            @PathParam("id") int id,
            @PathParam("teamNumber") int teamNumber,
            @PathParam("grade") int grade,
            @PathParam("total") int total
    ){
        awardWinningMapper.addModel(new AwardWinning(id,teamNumber,grade,total));
        return "redirect:/AWTable";
    }

    @RequestMapping("addawardwinning")
    public String toAddAwardWinning(){
        return "addawardwinning";
    }

    @RequestMapping("/update_awardwinning")
    public String updateTransit(
            @PathParam("id") int id,
            Model model
    ){
        AwardWinning model1 = awardWinningMapper.getModel(id);
        model.addAttribute("aw",model1);
        return "updateawardwinning";
    }

    @RequestMapping("/updateAwardWinning")
    public String updateAwardWinning(
            @PathParam("id") int id,
            @PathParam("teamNumber") int teamNumber,
            @PathParam("grade") int grade,
            @PathParam("total") int total
    ){
        awardWinningMapper.updateModel(new AwardWinning(id,teamNumber,grade,total));
        return "redirect:/AWTable";
    }
}
