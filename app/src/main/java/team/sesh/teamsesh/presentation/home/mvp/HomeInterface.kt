package team.sesh.teamsesh.presentation.home.mvp

import team.sesh.teamsesh.models.Banner
import team.sesh.teamsesh.models.News
import team.sesh.teamsesh.presentation.global.MvpView

interface HomeInterface : MvpView {
    fun showBannersOnFragment(showBanners: List<Banner>)

    fun startInfoActivity(NotifyFr: Banner)

    fun showNewsOnFragment(showNews: List<News>)

    fun startInfoActivity(homeFr: News)


}