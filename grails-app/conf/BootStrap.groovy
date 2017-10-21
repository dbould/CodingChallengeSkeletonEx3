import secodingchallenge.Account

class BootStrap {

    def init = { servletContext ->
        new Account(name: "Sam", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Alex", email: "dbould@gmail.com", balance: 200).save()
        new Account(name: "Frankie", email: "dbould@gmail.com", balance: 200).save()
    }
    def destroy = {
    }
}
