package computer.inventory.demo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ComputerController)
class ComputerControllerSpec extends Specification {

    ComputerService computerService = Stub(ComputerService)

    void "expect model to have correct object"() {

        Computer computer = new Computer()

        setup:
            controller.computerService = computerService
            computerService.getComputer(_) >> {
                return computer
            }
        when:
            controller.show()
        then:
            model.computer == computer

    }
}
