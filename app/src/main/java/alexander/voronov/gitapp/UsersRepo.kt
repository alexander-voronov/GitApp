package alexander.voronov.gitapp

interface UsersRepo {
    //CRUD в данном случае только Read
    //асинхронный подход. метод ожидаеь на вход 2 callback 'a
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
}