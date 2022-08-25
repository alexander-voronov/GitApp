package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.domain.entities.UserEntity
import alexander.voronov.gitapp.domain.repos.UsersRepo

class UsersPresenter(private val usersRepo: UsersRepo) : UsersContract.Presenter {
    // var потому что Presenter'у можно многократно присоединять и отсоединять View
    // view пока нет, появляется в attach
    private var view: UsersContract.View? = null

    private var usersList: List<UserEntity>? = null
    //private var loadingError: Throwable? = null  - single event!
    private var inProgress: Boolean = false

    //прикрепляемся к новой вьюшке
    override fun attach(view: UsersContract.View) {
        this.view = view
        view.showProgress(inProgress)
        usersList?.let { view.showUsers(it) }
        //loadingError?.let { view.showError(it) } - single event!
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgress(true)
        inProgress = true
        //асинхронный подход с callback. Активити знает только о UsersRepo, но не знает, что под капотом
        usersRepo.getUsers(
            //onSuccess = adapter::setData, //:: - ссылка на метод
            onSuccess = {
                view?.showProgress(false)
                view?.showUsers(it)
                usersList = it
                //loadingError = null  - single event!
                inProgress = false
            },
            onError = {
                view?.showProgress(false)
                view?.showError(it)
                //loadingError = it  - single event!
                inProgress = false
            }
        )
    }
}