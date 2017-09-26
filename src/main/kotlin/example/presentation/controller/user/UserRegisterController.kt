package example.presentation.controller.user

import example.domain.fundamental.user.UserIdentifierName
import example.domain.fundamental.user.UserMailAddress
import example.domain.model.user.UserRepository
import example.presentation.view.user.UserRegisterForm
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

    @PostMapping("/confirm")
    fun validate(@Validated @ModelAttribute("userRegisterForm") userRegisterForm: UserRegisterForm,
                     result: BindingResult): String {
        if (result.hasErrors()) return "user/form";

        if(userRepository.isExists(UserIdentifierName(userRegisterForm.userIdentifierName)))
            return alreadyExistsByUserIdentifierName(userRegisterForm.userIdentifierName, result)
        
        if(userRepository.isExists(UserMailAddress(userRegisterForm.userMailAddress)))
            return alreadyExistsByUserMailAddress(userRegisterForm.userMailAddress, result)

        userRepository.register(userRegisterForm.toUser())

        return "user/complete"
    }



    private fun alreadyExistsByUserMailAddress(userMailAddress: String, result: BindingResult): String {
        val rejectedPath = "userMailAddress"
        val messageKey = "error.id.already.exists"
        val arguments = arrayOf<Any>(userMailAddress)
        val defaultMessage = "{0}は登録済みです"
        result.rejectValue(rejectedPath, messageKey, arguments, defaultMessage)
        return "user/form"
    }

    private fun alreadyExistsByUserIdentifierName(userIdentifierName: String, result: BindingResult): String {
        val rejectedPath = "userIdentifierName"
        val messageKey = "error.id.already.exists"
        val arguments = arrayOf<Any>(userIdentifierName)
        val defaultMessage = "{0}は登録済みです"
        result.rejectValue(rejectedPath, messageKey, arguments, defaultMessage)
        return "user/form"
    }


}