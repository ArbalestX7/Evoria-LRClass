package com.macro4evoria.listenersreaders_class.view.fragment.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.macro4evoria.listenersreaders_class.R
import com.macro4evoria.listenersreaders_class.databinding.FragmentHomeBinding
import com.macro4evoria.listenersreaders_class.model.User
import com.macro4evoria.listenersreaders_class.view.activity.LoginActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var tv_username: TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide)
        exitTransition = inflater.inflateTransition(R.transition.fade)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUsername()

        val btnLogout: Button = binding.btnExit
        btnLogout.setOnClickListener { logout() }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUsername()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUsername() {
        val intent = Intent()
        tv_username = binding.tvMainUsername
        val username = intent.getParcelableExtra<User>("User")?.username
        tv_username.text = username
        Log.d("setUsername: ", username.toString())
    }

    private fun logout() {
        val logoutDialog = AlertDialog.Builder(requireActivity())
        with(logoutDialog) {
            setTitle(resources.getString(R.string.btn_exit))
            setMessage(resources.getString(R.string.log_desc))
            setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                val i = Intent(requireActivity(), LoginActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
                onDestroy()
            }
            setNegativeButton(resources.getString(R.string.no)) { dialog, _ -> dialog.cancel() }
        }
        val alertDialog = logoutDialog.create()
        alertDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}