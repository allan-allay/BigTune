package ke.co.tunes

class AlbumController {

     static scaffold = true

     def index() {
     	render Album.get(params.id)
     }

}
