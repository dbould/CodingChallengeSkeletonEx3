package secodingchallenge

import grails.test.spock.IntegrationSpec

class AccountControllerIntegrationSpec extends IntegrationSpec {

    def setup() {
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save(flush: true)
        new Transaction(fromAccount: 1, toAccount: 2, amount: 30).save(flush: true)
    }

    def cleanup() {
    }

    void "test account is returned"() {
        def controller = new AccountController()

        when: "The message action is invoked"
        controller.params.id = 1
        controller.index()

        then: "account is returned"
        controller.getModelAndView().model.account.id == 1
    }

    void "test transactions are returned"() {
        def controller = new AccountController()

        when: "The message action is invoked"
        controller.params.id = 1
        controller.index()

        def model = controller.getModelAndView().model
        then: "transactions are returned"
        model.transactions[0].fromAccount == 1
        model.transactions[0].toAccount == 2
        model.transactions[0].amount == 30.0
    }
}