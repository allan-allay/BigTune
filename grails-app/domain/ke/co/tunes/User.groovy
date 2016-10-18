package ke.co.tunes

class User {

	String username
	String password
	String firstName
	String lastName
	int age

    static  hasMany = [purchasedSongs: Song]

    static constraints = {
    	username blank : false, unique: true
    	password blank: false, size : 6..20
    	firstName blank : false
    	lastName blank: false
    }
}
