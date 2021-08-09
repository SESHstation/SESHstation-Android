package team.sesh.teamsesh.presentation.home.mvp

import team.sesh.teamsesh.models.News
import team.sesh.teamsesh.presentation.global.MvpView

interface HomeInterface : MvpView {

    fun showNewsOnFragment(showNews: List<News>)

    fun startInfoActivity(homeFr: News)


}