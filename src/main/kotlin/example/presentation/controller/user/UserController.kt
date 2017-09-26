package example.presentation.controller.user

import example.domain.model.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/user")
class UserController(@Autowired private val userRepository: UserRepository) {
    @GetMapping("/")
    fun list(model: Model): String {
        model.addAttribute("users", userRepository.list())
        return "user/list"
    }
}