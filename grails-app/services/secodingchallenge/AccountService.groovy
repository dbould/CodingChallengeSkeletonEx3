package secodingchallenge

import grails.transaction.Transactional

@Transactional
class AccountService {

    def updateBalances(int fromAccountId, int toAccountId, Double amount) {
        def fromBalance = getNewFromBalance(fromAccountId, amount)
        updateBalance(fromAccountId, fromBalance)

        def toBalance = getNewToBalance(toAccountId, amount)
        updateBalance(toAccountId, toBalance)
    }

    def getNewFromBalance(int accountId, Double amount) {
        return (Account.get(accountId).balance - amount)
    }

    def getNewToBalance(int accountId, Double amount) {
        return Account.get(accountId).balance + amount
    }

    def updateBalance(int accountId, amount) {
        def account = Account.get(accountId)
        account.balance = amount
        account.save(flush: true)
    }
}
