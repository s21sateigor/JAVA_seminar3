package model.users;


public class GuestUser {
    private long generatedId;
    private static long idCounter = 0;

    public long getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId() {
        this.generatedId = idCounter++;
    }

    public GuestUser(){
        setGeneratedId();
    }

    @Override
    public String toString() {
        return "Guest User Nr." + generatedId;
    }

    //TODO add find functions


}
