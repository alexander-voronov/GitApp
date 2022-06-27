package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.domain.UserEntity
import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {
    private val data = mutableListOf<UserEntity>()

    //для работы notifyDataSetChanged()
    init {
        setHasStableIds(true)
    }

    //для работы notifyDataSetChanged()
    override fun getItemId(position: Int) = getItem(position).id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent)
    //: UserViewHolder {
    //классический подход для отображения 1 типа данных
    //LayoutInflater.from(parent.context).inflate()
    //}

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = data.size

    //по позиции возвращает элемент.
    private fun getItem(pos: Int) = data[pos]

    //метод, который сообщит в адаптер об имеющихся данных
    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<UserEntity>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }
}