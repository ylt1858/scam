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
}
