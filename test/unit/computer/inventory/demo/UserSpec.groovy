package computer.inventory.demo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
@Mock(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "should validate"() {

        setup:
            User user = new User(ssn: "123456-1234", firstName: "Antti", lastName: "Loponen", department: Department.PRODUCTION)

        expect:
            user.validate()

    }

    void "should not validate"() {

        setup:
            User user = new User(ssn: "12345678", firstName: "Antti", lastName: "", department: Department.PRODUCTION)

        expect:
            !user.validate()

    }
}
