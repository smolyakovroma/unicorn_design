package android.test.web3j;

import com.google.gson.annotations.SerializedName;

public class Clan {

    private int id;
    private String name;
    private String creator;
    @SerializedName("referral_link")
    private String referralLink;
}
