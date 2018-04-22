package cn.winxo.toolbox.util;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 用来统一处理类似样的请求结果：
 * {"resultCode": 0,"resultMessage": "成功","data": {}}
 * 并将RetrofitResult中的Data分离出来交给subscriber处理
 *
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class CommonResultFunc<T> implements Function<CommonResult<T>, T> {

  @Override public T apply(@NonNull CommonResult<T> result) throws Exception {
    if (result.getStatus() != null && "200".equals(result.getStatus())) {
      return result.getData();
    }
    throw new RuntimeException(result.getMessage());
  }
}

