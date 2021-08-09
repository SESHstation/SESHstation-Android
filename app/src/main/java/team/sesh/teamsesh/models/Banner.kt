package team.sesh.teamsesh.models


class Banner {
    var title: String = ""
    var imageBanners: String = ""
    var id: Int = 0
    var description: String = ""

    constructor(imageBanner: String, id:Int, description: String, title: String) {
        this.imageBanners = imageBanner
        this.id = id
        this.description = description
        this.title = title

    }

    constructor() {

    }
}