package ke.co.tunes

class UserController {

    def register() { 

    	if (request.method == 'POST') {
    		def newUser = new User()
    		user.properties['login', 'password', 'firstName', 'lastName'] = params

    		if (newUser.password != params.confirm) {
    			newUser.errors.rejectValue("password", "user.password.dontmatch")
    			return [user: newUser]
    		}else if(newUser.save()){
    			sesson.user = newUser
    			redirect controller : "store"
    		}else {
    			return [user: newUser]
    		}
    		
    	}
    }

    def login(LoginCommand cmd) {

    	if (request.method == 'POST') {
    		if (!cmd.hasErrors()) {
    			session.user = cmd.getUser()
    			redirect controller : "store"

    		}else {
    			render view: '/store/index', model: [loginCmd:cmd]
    		} 
    	}else{
    			render view: 'store/index'
    	}

    }
}

class LoginCommand {
	String login
	String password
	private u

	User getUser() {
		if (!u && login) {
			u = User.findByLogin(login, [fetch:[purchasedSongs: 'join']])
		}

		return u
	}

	static constraints = {

		login blank:false, validator:{ val, obj ->
			if (!obj.user) {
				return "user.not.found"
			}
		}

		password blank:false , validator: { val, obj->
			if (obj.user && obj.user.password != val) {
				return "user.password.invalid"
			}

		}
	}
}
