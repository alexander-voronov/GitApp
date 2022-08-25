package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.domain.entities.UserEntity

//файл, описывающий суть (экрана). декомпозиция UI слоя
interface UsersContract {
    //логика отображения изображения
    interface View {
        //метод, которым будет пользоваться Presenter во View
        fun showUsers(users: List<UserEntity>)
        fun showError(throwable: Throwable)
        fun showProgress(inProgress: Boolean)
    }

    //View создаёт Presenter. Тут бизнес логика.
    interface Presenter {
        fun attach(view: View)
        fun detach()

        //клик кнопки
        fun onRefresh()
    }
}