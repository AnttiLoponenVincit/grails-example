package computer.inventory.demo

class ComputerController {

    def computerService

    def list() {
        List computers = computerService.findAllComputers()
        render(view: "list", model: [computers: computers])
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
