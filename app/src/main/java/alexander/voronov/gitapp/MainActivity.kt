package alexander.voronov.gitapp

import alexander.voronov.gitapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UsersAdapter()
    private val usersRepo: UsersRepo = LocalUsersRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainRefreshButton.setOnClickListener {
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
        //асинхронный подход с callback. Активити знает только о UsersRepo, но не знает, что под капотом
        usersRepo.getUsers(
            onSuccess = adapter::setData, //:: - ссылка на метод
            onError = {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        )
    }
}