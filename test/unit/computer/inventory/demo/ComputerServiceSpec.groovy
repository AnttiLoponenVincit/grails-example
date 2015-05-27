package computer.inventory.demo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ComputerService)
@Mock(UserHasComputer)
class ComputerServiceSpec extends Specification {

    def "should return computer not in use"() {

        given:
            Computer computerNotInUse = new Computer()
            Computer computerInUse = new Computer()
            UserHasComputer.createCriteria().list(_) << {
                return [new UserHasComputer(user: new User(), computer: computerInUse)]
            }
            Computer.list() << {
                return [computerInUse, computerNotInUse]
            }

        expect:
            service.findAllComputersNotInUse().first() == computerNotInUse





    }


}
