package secodingchallenge

import grails.test.mixin.integration.Integration
import grails.test.spock.IntegrationSpec

@Integration
class AccountServiceIntegrationSpec extends IntegrationSpec {

    def accountService

    def setup() {
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Alex", email: "dbould@gmail.com", balance: 200).save()
    }

    def cleanup() {
    }

    void "test get from balance"() {
        when: "User sends money"
        def balance = accountService.getNewFromBalance(1, 30)

        then: "Check their new balance has been reduced by the send amount"
        balance == 170
    }

    void "test update to balance"() {
        when: "User receives money"
        def balance = accountService.getNewToBalance(2, 30)

        then: "Check their new balance has been increased by the send amount"
        balance == 230
    }

    void "test update balance"() {
        when: "From account balance gets updated"
        accountService.updateBalance(1, 5)
        then: "That account's balance has increased"
        Account.get(1).balance == 5
    }

    void "test update balances"() {
        when: "A transfer is taking place"
        accountService.updateBalances(1, 2, 40)
        then: "Both accounts will contain an updated balance"
        Account.get(1).balance == 160
        Account.get(2).balance == 240
    }
}
