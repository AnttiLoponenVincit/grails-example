import computer.inventory.demo.Computer
import computer.inventory.demo.ComputerManufacturer
import computer.inventory.demo.ComputerModel
import computer.inventory.demo.ComputerType
import computer.inventory.demo.Department
import computer.inventory.demo.OperatingSystem
import computer.inventory.demo.OperatingSystemType
import computer.inventory.demo.User
import computer.inventory.demo.UserHasComputer

class BootStrap {

    def init = { servletContext ->

        ComputerManufacturer apple = new ComputerManufacturer(name: "Apple")
        apple.save()
        ComputerModel mbp = new ComputerModel(name: "MBP", manufacturer: apple, clockRate: 3.5, ram: 512)
        mbp.save()
        OperatingSystem mavericks = new OperatingSystem(versionName: "Mavericks", type: OperatingSystemType.OSX)
        mavericks.save()
        Computer testComputer = new Computer(model: mbp, serial: "1234567", operatingSystem: mavericks, type: ComputerType.LAPTOP)
        testComputer.save()
        ComputerManufacturer ibm = new ComputerManufacturer(name: "IBM")
        ibm.save()
        ComputerModel lenovo = new ComputerModel(name: "Lenovo", manufacturer: ibm, clockRate: 2.5, ram: 256)
        lenovo.save()
        OperatingSystem win7 = new OperatingSystem(versionName: "7", type: OperatingSystemType.WINDOWS)
        win7.save()
        Computer testComputer2 = new Computer(model: lenovo, serial: "1234568", operatingSystem: win7, type: ComputerType.LAPTOP)
        testComputer2.save()
        User testUser = new User(firstName: "Antti", lastName: "Loponen", ssn: "123456-789A", department: Department.RESEARCH)
        testUser.save()
        testUser.startUsingComputer(testComputer)
        for (int it = 0; it < 100; it++) {
            Computer cloneComputer = new Computer(model: mbp, serial: "000000" + it.toString(), operatingSystem: mavericks, type: ComputerType.LAPTOP)
            cloneComputer.save()
        }
    }
    def destroy = {
    }
}
