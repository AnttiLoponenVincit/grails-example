package computer.inventory.demo

import grails.transaction.Transactional

class UserService {

    User getUser(Long id) {
        return User.get(id)
    }

    List<User> findAllUsers() {
        return User.list()
    }

    @Transactional
    User save(Map params) {
        User user = new User(
                firstName: params.firstName,
                lastName: params.lastName,
                ssn: params.ssn,
                department: Department.valueOf(params.department)
        )
        user.save(flush: true)
        return user

    }

    @Transactional
    UserHasComputer addComputerToUser(Map params) {
        User user = User.get(params.userId)
        Computer computer = Computer.get(params.computerId)
        return user.startUsingComputer(computer)
    }

}
