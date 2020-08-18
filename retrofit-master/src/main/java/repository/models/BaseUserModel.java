package repository.models;

import com.google.gson.annotations.SerializedName;

public class BaseUserModel<T> {
    int page, total;

    @SerializedName("per_page")
    int perPage;

    @SerializedName("total_pages")
    int total_pages;

    T data;

    AddressModel ad;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AddressModel getAd() {
        return ad;
    }

    public void setAd(AddressModel ad) {
        this.ad = ad;
    }
}
