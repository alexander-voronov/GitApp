package alexander.voronov.gitapp.data.retrofit

import alexander.voronov.gitapp.domain.entities.UserEntity
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    fun getUsers(): Call<List<UserEntity>>
}