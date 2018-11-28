package beans;

import java.util.List;

/**
 * 分页处理
 */
public class PageCompute<T> {
    private int currentPage;         //当前页数，从前端获取
    private int total;    //总记录条数
    private int totalPage;          //总页数
    private int pageSize;           //每页记录条数

    private List<T> data;      //每页记录

    private String msg;        //查询结果
    private int code;        //查询结果

    public PageCompute(){}
    //构造器传入参数，分页导航栏显示页码计算
    public PageCompute(int currentPage,int total,int pageSize){
        this.currentPage=currentPage;
        this.total=total;
        this.pageSize=pageSize;
        //获取总页数
        if(total%pageSize==0){
            this.totalPage=total/pageSize;
        }else{
            //有余数，那么总页数要+1
            this.totalPage=total/pageSize+1;
        }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPage() {

        return totalPage;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    
    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {

        return total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    
    public void setCode(int code) {
		this.code = code;
	}
    public int getCode() {
		return code;
	}
}