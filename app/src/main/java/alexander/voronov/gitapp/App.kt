package alexander.voronov.gitapp

import alexander.voronov.gitapp.data.LocalUsersRepoImpl
import alexander.voronov.gitapp.domain.UsersRepo
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment

//абстаркция на всё приложение (процесс). общая точка доступа, singleton
//наследуется от context

class App : Application() {

    //скрывает логику создания
    val usersRepo: UsersRepo by lazy { LocalUsersRepoImpl() }

    override fun onCreate() {
        super.onCreate()
        // пример
    }
}

//синтаксический сахар
val Context.app: App get() = applicationContext as App

//пример для фрагмента
val Fragment.app: App get() = requireContext().applicationContext as App