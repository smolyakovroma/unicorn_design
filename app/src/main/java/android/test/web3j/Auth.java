package android.test.web3j;

import com.google.gson.annotations.SerializedName;

public class Auth {

    private String token;
    @SerializedName("expires_at")
    private String expiresAt;
    private User user;

    public Auth() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
