package computer.inventory.demo

import grails.transaction.Transactional


class ComputerService {

    Computer getComputer(Long id) {
        return Computer.get(id)
    }

    List<Computer> findAllComputers() {
        return Computer.list()
    }

    @Transactional
    Computer save(Map params) {
        ComputerManufacturer computerManufacturer = ComputerManufacturer.findByName(params.computerManufacturerName)
        if (!computerManufacturer) {
            computerManufacturer = new ComputerManufacturer(name: params.computerManufacturerName)
            computerManufacturer.save()
        }
        ComputerModel model = ComputerModel.findByName(params.computerModelName)
        if (!model) {
            model = new ComputerModel(name: params.computerModelName)
            model.save()
        }
        OperatingSystem operatingSystem = OperatingSystem.findByTypeAndVersionName(OperatingSystemType.valueOf(params.OperatingSystemType), params.operatingSystemVersionName)

        Computer computer = Computer.findBySerial(params.serial)
        if (computer) {
            println("Computer exists already!")
        } else {
            computer = new Computer(
                    serial: params.serial,
                    model: model,
                    operatingSystem: operatingSystem,
                    type: ComputerType.valueOf(params.computerType)

            )
            computer.save()
        }
        return computer
    }

    List<Computer> findAllComputersNotInUse() {
        List computersInUse = UserHasComputer.createCriteria().list {
            projections {
                property("computer")
            }
        }
        List computersNotInUse = Computer.list() - computersInUse
        return computersNotInUse
    }

    List<UserHasComputer> findComputerUsagesByUser(User user) {
        return UserHasComputer.findAllByUser(user)
    }


}
