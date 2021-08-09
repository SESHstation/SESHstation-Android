package team.sesh.teamsesh.models

class Merch {

    var name: String = ""
    var image: String = ""
    var price: String = ""
    var click: String = ""
   // var description: String = ""
    constructor (name: String, image: String, price: String, click: String //description:String
        )
    {
        this.name = name
        this.image = image
        this.price = price
        this.click = click
//        this.description = description
    }

    constructor() {

    }
}