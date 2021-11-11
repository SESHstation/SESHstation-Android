package team.sesh.teamsesh.presentation.home.mvp

import team.sesh.teamsesh.data.DataManager
import team.sesh.teamsesh.presentation.global.MvpPresenter
import team.sesh.teamsesh.presentation.global.MvpView

open class HomePresenter() : MvpPresenter<HomeInterface>() {

    private val dataManager: DataManager by lazy(LazyThreadSafetyMode.NONE) {
        DataManager()
    }

    fun getNewsOnView() {

        dataManager.getNewsManager(
            onSuccess = { news ->
                getView().showNewsOnFragment(showNews = news)
            },
            onFailure = {

            }
        )
    }

    fun getBannersOnView() {

        dataManager.getBannersManager(
            onSuccess = {banner ->
                getView().showBannersOnFragment(showBanners = banner)
            },
            onFailure = {

            }
        )
    }
}