package team.sesh.teamsesh.models


class News {
     var title: String = ""
     var link: String = ""
     var description: String = ""
     var image: String = ""

        constructor(title: String, /*link: String,*/ description: String, image: String) {
            this.title = title
            this.link =link
            this.description = description
            this.image = image
        }

        constructor() {

        }

}