package team.sesh.teamsesh.presentation.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.Banner
import team.sesh.teamsesh.models.News
import team.sesh.teamsesh.presentation.events.ui.BannersAdapter
import team.sesh.teamsesh.presentation.global.BaseFragment
import team.sesh.teamsesh.presentation.home.mvp.HomeInterface
import team.sesh.teamsesh.presentation.home.mvp.HomePresenter

class HomeFragment : BaseFragment(), HomeInterface {

    override val layoutRes = R.layout.fragment_home
    lateinit var navController: NavController
    private lateinit var recViewNews: RecyclerView
    private lateinit var recViewBanner: RecyclerView
    private lateinit var presenter: HomePresenter
    private lateinit var snapHelper: SnapHelper

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
    private val newsAdapter:NewsAdapter by lazy {
        NewsAdapter(
            newsClickListener  = {
                val bundle = Bundle()
                bundle.putString("newsDescription", it.description)
                bundle.putString("newsTitle", it.title)
                bundle.putString("newsImage",it.image)
                navController.navigate(R.id.nav_details_news, bundle)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = layoutInflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        recViewNews = view.findViewById(R.id.recViewNewss)
        recViewBanner = view.findViewById(R.id.recViewBanners)
        presenter = HomePresenter()
        presenter.attachView(this)
        presenter.getNewsOnView()
        recViewNewss.adapter = newsAdapter
        presenter.getBannersOnView()
        recViewBanners.adapter = bannersAdapter
        navController = Navigation.findNavController(view)
        initViews()

    }

    private fun initViews () {
      recViewNews.run {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
      }
        recViewBanners.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            isNestedScrollingEnabled = false
            bannersIndicator.attachToRecyclerView(this)
              }
          }




    override fun showNewsOnFragment(showNews: List<News>) {
        newsAdapter.setData(showNews as ArrayList<News>)

    }

    override fun showBannersOnFragment(showBanners: List<Banner>) {
        bannersAdapter.setData(showBanners as ArrayList<Banner>)
    }

    override fun startInfoActivity(NotifyFr: Banner) {

    }

    override fun startInfoActivity(homeFr: News) {
    }

    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }
    override fun showProgress(show: Boolean) {
        //  progressBar.setVisibility(if (show) View.VISIBLE else View.GONE)
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*  fun getNews(view1: View) {

          val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("News")
          reference.addValueEventListener(object : ValueEventListener {
              override fun onCancelled(p0: DatabaseError) {
                  Log.e("DATA", "error")

              }

              override fun onDataChange(p0: DataSnapshot) {

                  for (snapshot in p0.children) {
                      val news = snapshot.getValue(News::class.java)
                      newsList.add(news ?: News())
                      Log.e("DATA", "${snapshot.value}")
                  }

                  view1.recViewNews.adapter =
                      NewsAdapter(newsList)
              }
          })
      }*/
}