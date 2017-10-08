package example.domain.fundamental.user

import example.library.util.Encryption

data class UserPassword(val value: String){
    fun hashValue(): String {
        return Encryption("SHA-512").toHashValue(value)
    }
}