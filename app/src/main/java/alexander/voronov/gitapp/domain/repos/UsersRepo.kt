package alexander.voronov.gitapp.domain.repos

import alexander.voronov.gitapp.domain.entities.UserEntity

interface UsersRepo {
    //CRUD в данном случае только Read
    //асинхронный подход. метод ожидает на вход 2 callback 'a
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
}