package example.presentation.configration.security

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import org.springframework.stereotype.Component

@Component
class GooglePrincipalExtractor : PrincipalExtractor {
    override fun extractPrincipal(map: Map<String, Any>): Any {
        println(map)
        return map
    }

}