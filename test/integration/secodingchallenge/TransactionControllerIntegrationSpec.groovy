package secodingchallenge

import grails.test.spock.IntegrationSpec

class TransactionControllerIntegrationSpec extends IntegrationSpec {

    def setup() {
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Alex", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Frankie", email: "dbould@gmail.com", balance: 200).save()
        new Transaction(fromAccount: 1, toAccount: 2, amount: 30)
    }

    def cleanup() {
    }

    void "test something"() {
        def controller = new TransactionController()

        when: "The message action is invoked"
        controller.index()

        def model = controller.getModelAndView().model
        then: "account is returned"
        model.accounts[0].name == "Sam"
        model.accounts[1].name == "Alex"
        model.accounts[2].name == "Frankie"
    }

    void "test account is returned"() {
        def controller = new TransactionController()

        when: "The message action is invoked"
        controller.params.accountId = 1
        controller.accountTransactions()

        then: "account is returned"
        controller.getModelAndView().model.account.id == 1
    }

    void "test transactions are returned"() {
        def controller = new TransactionController()

        when: "The message action is invoked"
        controller.params.accountId = 1
        controller.accountTransactions()

        def model = controller.getModelAndView().model
        then: "transactions are returned"
        model.transactions[0].fromAccount == 1
        model.transactions[0].toAccount == 2
        model.transactions[0].amount == 30.0
    }
}
