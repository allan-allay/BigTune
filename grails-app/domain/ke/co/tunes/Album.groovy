package ke.co.tunes

class Album {

    String name
    Integer songs
    Song song

    static constraints = {
    }

    // static embedded = ['song']

    static hasMany = [songs:Song]
}