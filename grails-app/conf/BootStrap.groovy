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
        User testUser = new User(firstName: "Antti", lastName: "Loponen", SSN: "123456-789A", department: Department.RESEARCH)
        testUser.save()
        testUser.startUsingComputer(testComputer)

        List ibmComputers = Computer.createCriteria().list {
            model {
                manufacturer {
                    eq("name", "IBM")
                }
            }
        }
        println("IBM: " + ibmComputers)

        List osxComputers = Computer.createCriteria().list {
            operatingSystem {
                eq("type", OperatingSystemType.OSX)
            }
        }

        println("OSX: " + osxComputers)

        List researchComputerSerials = UserHasComputer.createCriteria().listDistinct {
            user {
                eq("department", Department.RESEARCH)
            }
            computer {
                projections {
                    property("serial")
                }
            }
        }

        println("Research computer serials: " + researchComputerSerials)

        Computer lastInUse = UserHasComputer.createCriteria().get {

            maxResults(1)
            order("usageStarted", "desc")
            projections {
                property("computer")
            }
        }

        println("Computer last taken into usage: " + lastInUse.properties)

        List computersInUse = UserHasComputer.createCriteria().list {
            projections {
                property("computer")
            }
        }
        List computersNotInUse = Computer.list() - computersInUse
        println("Computers not in use: " + computersNotInUse)
    }
    def destroy = {
    }
}
