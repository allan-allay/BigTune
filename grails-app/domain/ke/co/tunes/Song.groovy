package ke.co.tunes

class Song {

    String title
    String artist
 	Integer rating 
 	Integer duration

    static constraints = {

        title blank: false
        artist blank: false
        rating min : 0
        duration min : 1
    }

    static transients = ['rating']

    static  belongsTo = Album
}
