package com.mmxin.vo;

/**
 * 响应，值对象
 * @author : mmxin
 * @className : Response
 * @date : 2018/8/17 18:21
 */
public class Response {

    /*
    * 处理是否成功
    * */
    private boolean success;
    /*
    * 处理消息提示
    * */
    private String message;
    /*
    * 返回的数据
    * */
    private Object body;

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
