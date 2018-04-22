package cn.winxo.mvp.util;

/**
 * @author lxlong
 * @date 2018/3/26
 * @desc 此类是所有请求返回数据的包裹类，用来统一处理错误逻辑真正的返回数据在泛型T中
 */
public class CommonResult<T> {

  private String status;
  private String message;
  private T data;

  public String getStatus() {
    return status;
  }

  public CommonResult<T> setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}