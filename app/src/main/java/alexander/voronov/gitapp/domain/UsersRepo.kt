package alexander.voronov.gitapp.domain

import alexander.voronov.gitapp.domain.UserEntity

interface UsersRepo {
    //CRUD в данном случае только Read
    //асинхронный подход. метод ожидает на вход 2 callback 'a
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
}