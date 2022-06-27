package alexander.voronov.gitapp.ui.users

import alexander.voronov.gitapp.R
import alexander.voronov.gitapp.databinding.ItemUserBinding
import alexander.voronov.gitapp.domain.entities.UserEntity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

//меняем itemView: View на parent: ViewGroup
class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
) {
    private val binding = ItemUserBinding.bind(itemView)

    //наполнение ViewHolder
    fun bind(userEntity: UserEntity) {
        binding.avatarImageView.load(userEntity.avatarUrl)
        binding.loginTextView.text = userEntity.login
        binding.uidTextView.text = userEntity.id.toString()
    }
}