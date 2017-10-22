package secodingchallenge

import grails.transaction.Transactional

@Transactional
class AccountService {

    def updateAccountBalances(int fromAccountId, int toAccountId, Double amount) {
        updateFromBalance(fromAccountId, amount)
        updateToBalance(toAccountId, amount)
    }

    def updateFromBalance(int accountId, amount) {
        def account = Account.get(accountId)
        account.balance = account.balance - amount
        account.save(flush: true)
    }

    def updateToBalance(int accountId, amount) {
        def account = Account.get(accountId)
        account.balance = account.balance + amount
        account.save(flush: true)
    }
}
