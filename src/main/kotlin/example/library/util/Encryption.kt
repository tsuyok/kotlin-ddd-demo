package example.library.util

import java.security.MessageDigest

class Encryption(private val md: MessageDigest) {

    /*
     * メッセージダイジェストアルゴリズムを指定する。
     *  MD2, MD5, SHA, SHA-256, SHA-384, SHA-512が利用可能。
     */
    constructor(algorithmName: String) : this(MessageDigest.getInstance(algorithmName))

    /*
     * メッセージダイジェストアルゴリズムを使い、文字列をハッシュ値へ変換する。
     */
    fun toHashValue(password: String): String {
        md.update(password.toByteArray())
        return toEncryptedString(md.digest())
    }

    /*
     * バイト配列を16進数の文字列に変換し、連結して返す。
     */
    fun toEncryptedString(bytes: ByteArray): String {
        val sb = StringBuilder()
        bytes
                .map { String.format("%02x", it) }
                .forEach { sb.append(it) }
        return sb.toString()
    }
}