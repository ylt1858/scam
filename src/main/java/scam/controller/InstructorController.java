package scam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import scam.dao.InstructorMapper;
import scam.pojo.instructor;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class InstructorController {
    @Autowired
    InstructorMapper instructorMapper;

    @RequestMapping("/InstructorTable")
    public String teacherList (Model model){
        List<instructor> instructors = instructorMapper.instructorList();
        model.addAttribute("instructors", instructors);
        return "instructor";
    }

    @RequestMapping("/deleteInstructor")
    public String deleteInstructor (@PathParam("tno") String tno, @PathParam("id") int id){
        instructorMapper.deleteInstructor(tno, id);
        return "redirect:/InstructorTable";
    }

    @RequestMapping("/addInstructor")
    public String addInstructor (
            @PathParam("tno") String tno,
            @PathParam("teamNumber") int teamNumber,
            @PathParam("grade") int grade
    ){
        instructorMapper.addInstructor(new instructor(tno,teamNumber,grade));
        return "redirect:/InstructorTable";
    }

    @RequestMapping("/toAddInstructor")
    public String toAddInstructor (){
        return "addinstructor";
    }

    @RequestMapping("/toUpdateInstructor")
    public String toUpdateInstructor (
            Model model,
            @PathParam("tno") String tno,
            @PathParam("teamNumber") int teamNumber
    ){
        instructor instructor = instructorMapper.getInstructor(tno,teamNumber);
        model.addAttribute("instructor", instructor);
        return "updateinstructor";
    }

    @RequestMapping("/updateInstructor")
    public String updateInstructor(
            @PathParam("tno")String tno,
            @PathParam("teamNumber")int teamNumber,
            @PathParam("grade") int grade
    ){
        instructorMapper.updateInstructor(new instructor(tno, teamNumber, grade));
        return "redirect:/InstructorTable";
    }
}
