package beans;

public class ResponseBean <T> {
    private Object data;      //每页记录
    private String msg;        //查询结果
    private int code;        //查询结果

    
    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
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
