package team.sesh.teamsesh.presentation.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import team.sesh.teamsesh.R
import team.sesh.teamsesh.presentation.global.BaseFragment

class RadioFragment : Fragment(), RadioInterface {

    val layoutRes = R.layout.fragment_radio
    lateinit var navController: NavController
    private lateinit var presenter: RadioPresenter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = layoutInflater.inflate(R.layout.fragment_radio, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        presenter = RadioPresenter()
        presenter.attachView(this)

    }

    override fun showProgress(show: Boolean) {}

    override fun showMessage(message: String) {}

    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }
}