package computer.inventory.demo

class ComputerController {

    def computerService
    def grailsApplication

    def list() {
        if (!params.max) {
            params.max = grailsApplication.config.pagination.max
        }
        if (!params.offset) {
            params.offset = grailsApplication.config.pagination.offset
        }

        List computers = computerService.findAllComputers(params)
        render(view: "list", model: [computers: computers, computerCount: computerService.getComputerCount()])
    }

    def create() {
        render(view: "create")
    }

    def show() {
        Computer computer = computerService.getComputer(params.id as Long)
        showComputer(computer)
    }

    def save() {
        Computer computer = computerService.save(params)
        showComputer(computer)
    }

    void showComputer(Computer computer) {
        render(view: "show", model: [computer: computer])
    }
}
