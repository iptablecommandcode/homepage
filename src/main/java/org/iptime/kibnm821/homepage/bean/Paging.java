package org.iptime.kibnm821.homepage.bean;

public class Paging {

    /** 현재 페이지 번호 */
    private int currentPageNo;

    /** 페이지당 출력할 데이터 개수 */
    private int PerPage;

    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageSize;

    /** 검색 키워드 */
    private String searchKeyword;

    /** 검색 유형 */
    private String searchType;

    private String BIGHEADTITLE;

    public Paging(String BIGHEADTITLE) {
        this.currentPageNo = 1;
        this.PerPage = 10;
        this.pageSize = 10;
        this.BIGHEADTITLE = BIGHEADTITLE;
    }

    public int getStartPage() {
        return (currentPageNo - 1) * PerPage;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getRecordsPerPage() {
        return PerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.PerPage = recordsPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getBIGHEADTITLE() {
        return BIGHEADTITLE;
    }

    public void setBIGHEADTITLE(String BIGHEADTITLE) {
        this.BIGHEADTITLE = BIGHEADTITLE;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "currentPageNo=" + currentPageNo +
                ", recordsPerPage=" + PerPage +
                ", pageSize=" + pageSize +
                ", searchKeyword='" + searchKeyword + '\'' +
                ", searchType='" + searchType + '\'' +
                ", BIGHEADTITLE='" + BIGHEADTITLE + '\'' +
                '}';
    }
}
