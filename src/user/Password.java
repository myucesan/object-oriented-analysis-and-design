package user;

public class Password {

    public String hash;

    public Password(String hash) {
        this.hash = hash;
    }

    //TODO: implement
    public boolean checkPassword(String password) {
        return password == hash;
    }
}
