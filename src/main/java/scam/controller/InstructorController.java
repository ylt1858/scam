package scam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import scam.dao.InstructorMapper;
import scam.pojo.instructor;
import scam.pojo.teacher;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
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
    public String deleteInstructor (@PathParam("tno") String tno){
        instructorMapper.deleteInstructor(tno);
        return "redirect:/InstructorTable";
    }
}
