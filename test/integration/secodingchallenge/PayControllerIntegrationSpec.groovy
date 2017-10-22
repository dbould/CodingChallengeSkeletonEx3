package secodingchallenge

import grails.test.spock.IntegrationSpec

class PayControllerIntegrationSpec extends IntegrationSpec {

    def setup() {
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Alex", email: "dbould@gmail.com", balance: 200).save()
    }

    def cleanup() {

    }

    void "test account balances have correctly updated"() {
        def controller = new PayController()

        when: "The message action is invoked"
        controller.params.fromAccount = 1
        controller.params.toAccount = 2
        controller.params.amount = 30
        controller.transfer()

        then: "account is returned"
        Account.get(1).balance == 170
        Account.get(2).balance == 230
    }

    void "test transfer larger than balance fails"() {
        def controller = new PayController()

        when: "The message action is invoked"
        controller.params.fromAccount = 1
        controller.params.toAccount = 2
        controller.params.amount = 300
        controller.transfer()

        then: "account is returned"
        Account.get(1).balance == 200
        Account.get(2).balance == 200
    }

    void "test correct balance transfer pass message"() {
        def controller = new PayController()

        when: "The message action is invoked"
        controller.params.fromAccount = 1
        controller.params.toAccount = 2
        controller.params.amount = 30
        controller.transfer()

        def model = controller.getModelAndView().model
        then: "account is returned"
        model.message == 'Transfer complete.'
    }

    void "test correct balance transfer fail message"() {
        def controller = new PayController()

        when: "The message action is invoked"
        controller.params.fromAccount = 1
        controller.params.toAccount = 2
        controller.params.amount = 300
        controller.transfer()

        def model = controller.getModelAndView().model
        then: "account is returned"
        model.message == 'Not enough funds in Sam\'s account.  Transfer was unsuccessful.'
    }
}
