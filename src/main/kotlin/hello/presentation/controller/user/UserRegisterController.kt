package hello.presentation.controller.user

import hello.domain.model.user.UserRepository
import hello.presentation.view.user.UserRegisterForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/user")
class UserRegisterController(@Autowired private val userRepository: UserRepository) {

    @GetMapping("/register")
    fun form(model: Model): String {
        model.addAttribute("userRegisterForm", UserRegisterForm())
        return "user/form"
    }

    @PostMapping("/register")
    fun Any.register(@Validated @ModelAttribute("userRegisterForm") userRegisterForm: UserRegisterForm,
                     result: BindingResult): String {
        userRepository.register(userRegisterForm.toUser())
        return "user/complete"
    }

    @GetMapping("/")
    fun list(model: Model): String {
        model.addAttribute("users", userRepository.list())
        return "user/list"
    }
}