package android.test.web3j;

import java.io.Serializable;
import java.util.List;

public class Unicorn implements Serializable{


    private static final long serialVersionUID = 594401L;

    private int id;
    private String created_at;
    private String updated_at;
    private String unicorn_blockchain_id;
    private int owner_id;
    private String name;
    private String purchase_count;
    private String creation_type;
    private String swift;
    private int views;
    private int likes;
    private int comment_count;
    private String comment_price;
    private int generation;
    private String blockchain_id;
    private int rate;
    private String chain;
    private String image;
    private byte[] imageSrc;
    private String tags;
    private int target_ids;
    private String cost;
    private String candy_cost;
    private String candy_breed_cost;
    private String calced_cost;
    private Unicorns.Location location;
    private int energy;
    private int reproduction;
    private int strength;
    private int agility;
    private int speed;
    private int intelligence;
    private int charisma;
    private String operation_id;
    private String operation_status_id;
    private String recovered_to;
    private String last_activity_at;
    private String owned_at;
    private boolean liked_by_current_user;
    private boolean by_current_user;
    private Genom BDYFRM = new Genom();
    private Genom WNGFRM = new Genom();
    private Genom HOOFRM = new Genom();
    private Genom HRNFRM = new Genom();
    private Genom EYEFRM = new Genom();
    private Genom HAIFRM = new Genom();
    private Genom TAIFRM = new Genom();
    private Genom STNFRM = new Genom();
    private Genom EARFRM = new Genom();
    private Genom HEDFRM = new Genom();
    private List<Unicorn> parents;

    public Unicorn() {
    }

    public List<Unicorn> getParents() {
        return parents;
    }

    public void setParents(List<Unicorn> parents) {
        this.parents = parents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUnicorn_blockchain_id() {
        return unicorn_blockchain_id;
    }

    public void setUnicorn_blockchain_id(String unicorn_blockchain_id) {
        this.unicorn_blockchain_id = unicorn_blockchain_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(String purchase_count) {
        this.purchase_count = purchase_count;
    }

    public String getCreation_type() {
        return creation_type;
    }

    public void setCreation_type(String creation_type) {
        this.creation_type = creation_type;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getComment_price() {
        return comment_price;
    }

    public void setComment_price(String comment_price) {
        this.comment_price = comment_price;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getBlockchain_id() {
        return blockchain_id;
    }

    public void setBlockchain_id(String blockchain_id) {
        this.blockchain_id = blockchain_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTarget_ids() {
        return target_ids;
    }

    public void setTarget_ids(int target_ids) {
        this.target_ids = target_ids;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCandy_cost() {
        return candy_cost;
    }

    public void setCandy_cost(String candy_cost) {
        this.candy_cost = candy_cost;
    }

    public String getCandy_breed_cost() {
        return candy_breed_cost;
    }

    public void setCandy_breed_cost(String candy_breed_cost) {
        this.candy_breed_cost = candy_breed_cost;
    }

    public String getCalced_cost() {
        return calced_cost;
    }

    public void setCalced_cost(String calced_cost) {
        this.calced_cost = calced_cost;
    }

    public Unicorns.Location getLocation() {
        return location;
    }

    public void setLocation(Unicorns.Location location) {
        this.location = location;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getReproduction() {
        return reproduction;
    }

    public void setReproduction(int reproduction) {
        this.reproduction = reproduction;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(String operation_id) {
        this.operation_id = operation_id;
    }

    public String getOperation_status_id() {
        return operation_status_id;
    }

    public void setOperation_status_id(String operation_status_id) {
        this.operation_status_id = operation_status_id;
    }

    public String getRecovered_to() {
        return recovered_to;
    }

    public void setRecovered_to(String recovered_to) {
        this.recovered_to = recovered_to;
    }

    public String getLast_activity_at() {
        return last_activity_at;
    }

    public void setLast_activity_at(String last_activity_at) {
        this.last_activity_at = last_activity_at;
    }

    public String getOwned_at() {
        return owned_at;
    }

    public void setOwned_at(String owned_at) {
        this.owned_at = owned_at;
    }

    public boolean isLiked_by_current_user() {
        return liked_by_current_user;
    }

    public void setLiked_by_current_user(boolean liked_by_current_user) {
        this.liked_by_current_user = liked_by_current_user;
    }

    public boolean isBy_current_user() {
        return by_current_user;
    }

    public void setBy_current_user(boolean by_current_user) {
        this.by_current_user = by_current_user;
    }

    public Genom getBDYFRM() {
        return BDYFRM;
    }

    public void setBDYFRM(Genom BDYFRM) {
        this.BDYFRM = BDYFRM;
    }

    public Genom getWNGFRM() {
        return WNGFRM;
    }

    public void setWNGFRM(Genom WNGFRM) {
        this.WNGFRM = WNGFRM;
    }

    public Genom getHOOFRM() {
        return HOOFRM;
    }

    public void setHOOFRM(Genom HOOFRM) {
        this.HOOFRM = HOOFRM;
    }

    public Genom getHRNFRM() {
        return HRNFRM;
    }

    public void setHRNFRM(Genom HRNFRM) {
        this.HRNFRM = HRNFRM;
    }

    public Genom getEYEFRM() {
        return EYEFRM;
    }

    public void setEYEFRM(Genom EYEFRM) {
        this.EYEFRM = EYEFRM;
    }

    public Genom getHAIFRM() {
        return HAIFRM;
    }

    public void setHAIFRM(Genom HAIFRM) {
        this.HAIFRM = HAIFRM;
    }

    public Genom getTAIFRM() {
        return TAIFRM;
    }

    public void setTAIFRM(Genom TAIFRM) {
        this.TAIFRM = TAIFRM;
    }

    public Genom getSTNFRM() {
        return STNFRM;
    }

    public void setSTNFRM(Genom STNFRM) {
        this.STNFRM = STNFRM;
    }

    public Genom getEARFRM() {
        return EARFRM;
    }

    public void setEARFRM(Genom EARFRM) {
        this.EARFRM = EARFRM;
    }

    public Genom getHEDFRM() {
        return HEDFRM;
    }

    public void setHEDFRM(Genom HEDFRM) {
        this.HEDFRM = HEDFRM;
    }

    public byte[] getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(byte[] imageSrc) {
        this.imageSrc = imageSrc;
    }
}