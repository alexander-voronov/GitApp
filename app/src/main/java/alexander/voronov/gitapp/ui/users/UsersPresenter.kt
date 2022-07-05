package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.domain.repos.UsersRepo

class UsersPresenter(private val usersRepo: UsersRepo) : UsersContract.Presenter {
    // var потому что Presenter'у можно многократно присоединять и отсоединять View
    // view пока нет, появляется в attach
    private var view: UsersContract.View? = null

    override fun attach(view: UsersContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgress(true)
        //асинхронный подход с callback. Активити знает только о UsersRepo, но не знает, что под капотом
        usersRepo.getUsers(
            //onSuccess = adapter::setData, //:: - ссылка на метод
            onSuccess = {
                view?.showProgress(false)
                view?.showUsers(it)
            },
            onError = {
                view?.showProgress(false)
                view?.showError(it)
            }
        )
    }
}