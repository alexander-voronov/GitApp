package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.data.LocalUsersRepoImpl
import alexander.voronov.gitapp.databinding.ActivityMainBinding
import alexander.voronov.gitapp.domain.UserEntity
import alexander.voronov.gitapp.domain.UsersRepo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UsersAdapter()
    private val usersRepo: UsersRepo = LocalUsersRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.activityMainRefreshButton.setOnClickListener {
            loadData()
        }
        initRecyclerView()
        showProgress(false)
    }

    private fun loadData() {
        showProgress(true)
        //асинхронный подход с callback. Активити знает только о UsersRepo, но не знает, что под капотом
        usersRepo.getUsers(
            //onSuccess = adapter::setData, //:: - ссылка на метод
            onSuccess = {
                showProgress(false)
                onDataLoaded(it)
            },
            onError = {
                showProgress(false)
                onError(it)
            }
        )
    }

    private fun onDataLoaded(data: List<UserEntity>) {
        adapter.setData(data)
    }

    private fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
    }

    private fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress

    }

}