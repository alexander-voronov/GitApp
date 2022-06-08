package alexander.voronov.gitapp

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//меняем itemView: View на parent: ViewGroup
class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {

    //наполнение ViewHolder
    fun bind(userEntity: UserEntity) {

    }
}