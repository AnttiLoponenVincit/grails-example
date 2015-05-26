package computer.inventory.demo

class Computer {

    ComputerModel model
    String serial
    OperatingSystem operatingSystem
    ComputerType type

    String getInformation() {

        return model.manufacturer.name + " " +
                model.name + ", " +
                operatingSystem.type + " " +
                operatingSystem.versionName
    }

    static transients = ["information"]

    static constraints = {
        model (nullable: false)
        serial (nullable: false, blank: false)
        operatingSystem (nullable: true)
        type (nullable: true)
    }
}
