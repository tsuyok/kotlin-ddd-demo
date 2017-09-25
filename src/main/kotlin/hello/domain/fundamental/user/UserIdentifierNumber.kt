package hello.domain.fundamental.user

import lombok.ToString

/**
 * 利用者情報のサロゲートキー
 * （付与は外部リソース（DB）に任せるため、Nullable Type とする）
 */
@ToString
class UserIdentifierNumber(val value: Int?) {
}