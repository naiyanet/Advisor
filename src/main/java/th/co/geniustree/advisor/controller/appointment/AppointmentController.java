package th.co.geniustree.advisor.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import th.co.geniustree.advisor.domain.Appointment;
import th.co.geniustree.advisor.repository.AppointmentRepository;

/**
 * @author pramoth
 */
@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        Page<Appointment> findAll = appointmentRepository.findAll(pageable);
        model.addAttribute("appointments", findAll);
        return "appointments/list";
    }

    @RequestMapping(value = "/appointments/search", method = RequestMethod.GET)
    public String list(@RequestParam("student") String student, @RequestParam("teacher") String teacher, Model model, Pageable pageable) {
        Page<Appointment> findAll = appointmentRepository.findByTeacherAndStudent(student, teacher, pageable);
        model.addAttribute("appointments", findAll);
        return "appointments/list";
    }

    @RequestMapping(value = "/appointments/new", method = RequestMethod.GET, params = "!save")
    public String list(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointments/new";
    }

    @RequestMapping(value = "/appointments/new", method = RequestMethod.POST, params = "save")
    public String list(@Validated Appointment appointment, BindingResult error, Model model) {
        if (!error.hasErrors()) {
            appointmentRepository.save(appointment);
            return "redirect:/appointments";
        } else {
            return "/appointments/new";
        }
    }

}
