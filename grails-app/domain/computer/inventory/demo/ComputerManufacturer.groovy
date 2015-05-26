package computer.inventory.demo

class ComputerManufacturer {

    String name

    static constraints = {
        name (nullable: false, blank: false)
    }
}
