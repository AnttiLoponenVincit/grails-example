package computer.inventory.demo

class User {

    String firstName
    String lastName
    String ssn
    Department department

    static hasMany = [computerUsages: UserHasComputer]



    static constraints = {
        firstName (nullable: false, blank: false)
        lastName (nullable: false, blank: false)
        ssn (nullable: false, blank: false, unique: true, validator: {val ->
            val ==~ /\d{6}[+-A]\d{3}[A-Z0-9]/
        })
        department (nullable: false)
    }

    UserHasComputer startUsingComputer(Computer computer) {

        UserHasComputer userHasComputer = new UserHasComputer(computer: computer, user: this, usageStarted: new GregorianCalendar())
        userHasComputer.save()
        this.addToComputerUsages(userHasComputer)
        return userHasComputer

    }

}
