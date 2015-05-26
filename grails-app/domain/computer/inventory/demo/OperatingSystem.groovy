package computer.inventory.demo

class OperatingSystem {

    OperatingSystemType type
    String versionName

    static constraints = {
        versionName(nullable: false, blank: false)
    }
}
