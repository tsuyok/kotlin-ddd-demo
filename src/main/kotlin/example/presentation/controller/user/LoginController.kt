package example.presentation.controller.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/login")
class LoginController {
    @GetMapping("")
    fun form(model: Model): String {
        model.addAttribute("mailaddress", "")
        model.addAttribute("password", "")
        return "user/login"
    }
}