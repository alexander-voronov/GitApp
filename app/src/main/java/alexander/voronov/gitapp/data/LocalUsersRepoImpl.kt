package alexander.voronov.gitapp.data

import alexander.voronov.gitapp.domain.entities.UserEntity
import alexander.voronov.gitapp.domain.repos.UsersRepo
import android.os.Handler
import android.os.Looper

private const val DATA_LOADING_FICTIONAL_DELAY = 3_000L

class LocalUsersRepoImpl : UsersRepo {
    private val data: List<UserEntity> = listOf(
        UserEntity("mojombo", 1, "https://avatars.githubusercontent.com/u/1?v=4"),
        UserEntity("defunkt", 2, "https://avatars.githubusercontent.com/u/2?v=4"),
        UserEntity("pjhyett", 3, "https://avatars.githubusercontent.com/u/3?v=4"),
    )

    //имитируем многопоточность
    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed({
            onSuccess(data)
        }, DATA_LOADING_FICTIONAL_DELAY)
    }
}