package kontroleri;

import model.Korisnik;
import model.Usluge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @RequestMapping("/")
    public String prazna() {
        return "index";
    }
    
     @RequestMapping(value="/register")
    public String getRegister(Model model) {
        model.addAttribute("newUser", new Korisnik());
        return "register";
    }

    /**
     *
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister( @ModelAttribute("newUser")
            Korisnik user, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        if(user.getUsername().equals("moket")) return "register";
        Usluge.unesi(user);
        return "prikaz";
    }
}
