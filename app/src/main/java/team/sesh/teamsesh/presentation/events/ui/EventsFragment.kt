package team.sesh.teamsesh.presentation.events.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.fragment_notifications.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.Banner
import team.sesh.teamsesh.presentation.events.mvp.NotifyInterface
import team.sesh.teamsesh.presentation.events.mvp.NotifyPresenter

class EventsFragment() : Fragment(), NotifyInterface {

    lateinit var navController: NavController
    private lateinit var presenter: NotifyPresenter
    private lateinit var snapHelper: SnapHelper
    private lateinit var recViewBanner: RecyclerView
    private val bannersAdapter: BannersAdapter by lazy {
        BannersAdapter(
            bannerClickListener = {
                val bundle = Bundle()
                bundle.putString("BANNERdescription", it.description)
                bundle.putString("BANNERtitle", it.title)
                bundle.putString("BANNERimage",it.imageBanners)
                navController.navigate(R.id.nav_details_banners, bundle)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = layoutInflater.inflate(R.layout.fragment_notifications, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        recViewBanner = view.findViewById(R.id.recViewBanners)
        presenter = NotifyPresenter()
        presenter.attachView(this)
        presenter.getBannersOnView()
        recViewBanners.adapter = bannersAdapter
        navController = Navigation.findNavController(view)
        initViews()

    }

    private fun initViews() {

        recViewBanners.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            isNestedScrollingEnabled = false
            bannersIndicator.attachToRecyclerView(this)
        }
    }

    override fun showBannersOnFragment(showBanners: List<Banner>) {
        bannersAdapter.setData(showBanners as ArrayList<Banner>)
    }

    override fun startInfoActivity(NotifyFr: Banner) {
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showMessage(message: String) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }


}