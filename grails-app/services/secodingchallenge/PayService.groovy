package secodingchallenge

import grails.transaction.Transactional

@Transactional
class PayService {

    def approveTransaction(fromBalance, amount) {
        boolean approve = false

        if (fromBalance-amount >= 0) {
            approve = true
        }

        return approve
    }

    def getUserMessage(boolean transactionSuccess, fromName) {
        def message = ''

        if (transactionSuccess == true) {
            message = 'Transfer complete.'
        } else {
            message = 'Not enough funds in ' + fromName + '\'s account.  Transfer was unsuccessful.'
        }

        return message
    }
}
