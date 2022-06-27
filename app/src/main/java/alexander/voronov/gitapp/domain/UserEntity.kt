package alexander.voronov.gitapp.domain

//базавая сущность всего приложения
data class UserEntity(
    val login: String,
    val id: Long,
    //avatar_url
    val avatarUrl: String,
    )



