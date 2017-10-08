package example.presentation.configration.security

import org.springframework.security.core.Authentication
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class SocialAuthenticationSuccessHandler : AuthenticationSuccessHandler {

    private val redirectStrategy = DefaultRedirectStrategy()

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(req: HttpServletRequest, res: HttpServletResponse, auth: Authentication) {
        redirectStrategy.sendRedirect(req, res, "/user/")
    }
}