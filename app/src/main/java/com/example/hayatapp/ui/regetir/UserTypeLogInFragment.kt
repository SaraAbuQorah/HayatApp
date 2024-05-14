    package com.example.hayatapp.ui.regetir

    import android.annotation.SuppressLint
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.lifecycle.ViewModelProvider
    import androidx.navigation.fragment.findNavController
    import com.example.hayatapp.R
    import com.example.hayatapp.data.UserTypeData
    import com.example.hayatapp.databinding.FragmentUserTypeLogInBinding

    class UserTypeLogInFragment : Fragment(), UserTypeAdapter.ItemsClickEvents {
        private lateinit var binding: FragmentUserTypeLogInBinding
        private lateinit var adapter: UserTypeAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentUserTypeLogInBinding.inflate(inflater, container, false)

            // Initialize adapter with the click listener
            adapter = UserTypeAdapter(this)
            binding.type.adapter = adapter

            // Set up the list of static data directly in the adapter
            val userTypeList = listOf(
                UserTypeData(R.drawable.group845, R.drawable.ellipse37, "A Delivery Driver"),
                UserTypeData(R.drawable.group844, R.drawable.ellipse37, "Looking for a Driver")
            )
            adapter.submitList(userTypeList)

            binding.next.setOnClickListener {
                    findNavController().navigate(UserTypeLogInFragmentDirections.actionUserTypeLogInFragmentToCreateDriverAccountFragment())
            }
            return binding.root
        }
        @SuppressLint("NotifyDataSetChanged")
        override fun selected(data: UserTypeData) {
            if(data.isSelected){
            data.isSelected = false
            adapter.notifyDataSetChanged()

            }else {
                data.isSelected = true
                adapter.notifyDataSetChanged()
                deselectOthers(data)
            }
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun deselectOthers(data: UserTypeData) {
            for (item in adapter.currentList) {
                if (item != data && item.isSelected) {
                    item.isSelected = false
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
