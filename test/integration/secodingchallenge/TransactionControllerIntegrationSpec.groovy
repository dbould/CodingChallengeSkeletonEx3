package secodingchallenge

import grails.test.spock.IntegrationSpec

class TransactionsControllerIntegrationSpec extends IntegrationSpec {

    def setup() {
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Alex", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Frankie", email: "dbould@gmail.com", balance: 200).save()
    }

    def cleanup() {
    }

    void "test something"() {
        def controller = new TransactionsController()

        when: "The message action is invoked"
        controller.index()

        def model = controller.getModelAndView().model
        then: "account is returned"
        model.accounts[0].name == "Sam"
        model.accounts[1].name == "Alex"
        model.accounts[2].name == "Frankie"
    }
}
