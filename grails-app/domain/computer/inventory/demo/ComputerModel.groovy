package computer.inventory.demo

class ComputerModel {

    ComputerManufacturer manufacturer
    String name
    BigDecimal clockRate
    int ram

    static constraints = {
        name (nullable: false, blank: false)
        manufacturer (nullable: false)
        clockRate(min: BigDecimal.ZERO)
        ram(min: 0)
    }
}
