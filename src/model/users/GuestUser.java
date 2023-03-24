package model.users;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GuestUser {
    int generatedId;

    public int getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(int generatedId) {
        this.generatedId = generatedId;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "generatedId=" + generatedId +
                '}';
    }
}
