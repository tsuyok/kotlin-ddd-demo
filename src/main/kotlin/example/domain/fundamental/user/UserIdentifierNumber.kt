package example.domain.fundamental.user


/**
 * 利用者情報のサロゲートキー
 * （付与は外部リソース（DB）に任せるため、Nullable Type とする）
 */
data class UserIdentifierNumber(val value: Int?)