package secodingchallenge

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PayService)
class PayServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test approveTransaction passes"() {
        when: "Current balance is more than amount to pay"
        def approveTransaction = service.approveTransaction(200, 10)

        then: "transaction is approved"
        approveTransaction == true
    }

    void "test approveTransaction fails"() {
        when: "Current balance is less than amount to pay"
        def approveTransaction = service.approveTransaction(200, 300)

        then: "transaction is approved"
        approveTransaction == false
    }

    void "test transfer approved message" () {
        when: "Transaction is approved"
        def message = service.getUserMessage(true, 'Sam')

        then: "User gets an approval message"
        message == 'Transfer complete.'
    }

    void "test transfer failed message" () {
        when: "Transaction failed"
        def message = service.getUserMessage(false, 'Sam')

        then: "User gets feedback message"
        message == 'Not enough funds in Sam\'s account.  Transfer was unsuccessful.'
    }
}
