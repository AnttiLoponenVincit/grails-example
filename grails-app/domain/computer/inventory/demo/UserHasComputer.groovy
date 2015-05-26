package computer.inventory.demo

class UserHasComputer {

    User user
    Computer computer
    GregorianCalendar usageStarted
    GregorianCalendar usageEnded

    static constraints = {
        user (nullable: false)
        computer (nullable: false, unique:"user")
        usageStarted (nullable: false)
        usageEnded (nullable: true)
    }
}
