package computer.inventory.demo

import grails.transaction.Transactional


class ComputerService {

    Computer getComputer(Long id) {
        return Computer.get(id)
    }

    List<Computer> findAllComputers(Map params) {
        return Computer.list([max: params.max, offset: params.offset])
    }

    int getComputerCount() {
        return Computer.count()
    }

    List<Computer> findAllComputerUsages() {
        return UserHasComputer.list()
    }

    private ComputerManufacturer findOrCreateManufacturerByName(String name) {
        ComputerManufacturer computerManufacturer = ComputerManufacturer.findByName(name)
        if (!computerManufacturer) {
            computerManufacturer = new ComputerManufacturer(name: name)
            computerManufacturer.save()
        }
        return computerManufacturer
    }

    private ComputerModel findByNameOrCreateModel(String name, ComputerManufacturer computerManufacturer) {
        ComputerModel model = ComputerModel.findByNameAndManufacturer(name, computerManufacturer)
        if (!model) {
            model = new ComputerModel(name: name, manufacturer: computerManufacturer)
            model.save()
        }
        return model
    }

    @Transactional
    Computer save(Map params) {
        ComputerManufacturer computerManufacturer = findOrCreateManufacturerByName(params.computerManufacturerName)
        ComputerModel model = findByNameOrCreateModel(params.computerModelName, computerManufacturer)
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
