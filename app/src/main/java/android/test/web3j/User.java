package android.test.web3j;

import com.google.gson.annotations.SerializedName;

public class User {

    private int id;
    @SerializedName("blockchain_id")
    private String blockchainId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String wallet;
    private String name;
    private String email;
    private boolean email_confirmed;
    @SerializedName("unicorn_count")
    private int unicornCount;
    private String avatar;
    @SerializedName("use_geo_location")
    private boolean useGeoLocation;
    @SerializedName("use_shared_stats")
    private boolean useSharedStats;
    private Location location;
    @SerializedName("social_links")
    private SocialLinks socialLinks;
    //          private String site_links;
    private String about;
    private Clan clan;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(String blockchainId) {
        this.blockchainId = blockchainId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmail_confirmed() {
        return email_confirmed;
    }

    public void setEmail_confirmed(boolean email_confirmed) {
        this.email_confirmed = email_confirmed;
    }

    public int getUnicornCount() {
        return unicornCount;
    }

    public void setUnicornCount(int unicornCount) {
        this.unicornCount = unicornCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isUseGeoLocation() {
        return useGeoLocation;
    }

    public void setUseGeoLocation(boolean useGeoLocation) {
        this.useGeoLocation = useGeoLocation;
    }

    public boolean isUseSharedStats() {
        return useSharedStats;
    }

    public void setUseSharedStats(boolean useSharedStats) {
        this.useSharedStats = useSharedStats;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}

//  "id": 99,
//