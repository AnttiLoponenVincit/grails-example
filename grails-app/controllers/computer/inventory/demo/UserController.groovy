package computer.inventory.demo

class UserController {

    def userService
    def computerService

    def index() { }

    def list() {
        List users = userService.findAllUsers()
        render(view: "list", model: [users: users])
    }

    def show() {
        User user = userService.getUser(params.id as Long)
        showUser(user)
    }

    def save() {
        User user = userService.save(params)
        showUser(user)
    }

    def addComputerToUser() {
        UserHasComputer userHasComputer = userService.addComputerToUser(params)
        showUser(userHasComputer.user)
    }

    void showUser(User user) {
        List<UserHasComputer> computerUsages = computerService.findComputerUsagesByUser(user)
        render(view: "show", model: [user: user, computerUsages: computerUsages])
    }
}
