package team.sesh.teamsesh.presentation.global


interface MvpView {

    fun showProgress(show: Boolean)

    fun showMessage(message: String)

    fun onBackPressed(): Boolean

}