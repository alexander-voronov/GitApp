package alexander.voronov.gitapp.domain.entities

import com.google.gson.annotations.SerializedName

//базавая сущность всего приложения
data class UserEntity(
    val login: String,
    val id: Long,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)



