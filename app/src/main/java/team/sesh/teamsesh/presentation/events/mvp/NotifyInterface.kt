package team.sesh.teamsesh.presentation.events.mvp

import team.sesh.teamsesh.models.Banner
import team.sesh.teamsesh.presentation.global.MvpView

interface NotifyInterface : MvpView {


    fun showBannersOnFragment(showBanners: List<Banner>) {

    }
    fun startInfoActivity(NotifyFr: Banner)

}