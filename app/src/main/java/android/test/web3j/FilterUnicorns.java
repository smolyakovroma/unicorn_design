package android.test.web3j;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FilterUnicorns implements Serializable {

    private static final long serialVersionUID = 592101L;

    @SerializedName("user_id")
    private String userId = "";
    private String target = "All";
    @SerializedName("count_on_page")
    private int countOnPage = 999;
    private String sort = "newest";
    private int page = 1;
    private String query = "";
    private Filters filters = new Filters();

    public FilterUnicorns() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public int getCountOnPage() {
        return countOnPage;
    }

    public void setCountOnPage(int countOnPage) {
        this.countOnPage = countOnPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
