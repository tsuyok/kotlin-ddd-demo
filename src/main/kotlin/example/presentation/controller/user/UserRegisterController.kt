package example.presentation.controller.user

import example.domain.model.user.UserRepository
import example.presentation.view.user.UserRegisterForm
import example.presentation.view.user.UserRegisterValidation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/user")
class UserRegisterController(@Autowired private val userRepository: UserRepository,
                             @Autowired private val userRegisterValidation: UserRegisterValidation) {

    @GetMapping("/register")
    fun form(model: Model): String {
        model.addAttribute("userRegisterForm", UserRegisterForm())
        return "user/form"
    }

    @PostMapping("/confirm")
    fun validate(@Validated @ModelAttribute("userRegisterForm") userRegisterForm: UserRegisterForm,
                     result: BindingResult): String {

        if(!userRegisterValidation.validate(userRegisterForm, result)) return "user/form"

        userRepository.register(userRegisterForm.toUser())

        return "user/complete"
    }

}