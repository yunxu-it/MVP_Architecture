package cn.winxo.mvp.api;

import java.util.List;

import cn.winxo.mvp.api.entity.BaseModel;
import cn.winxo.mvp.api.entity.ResultsModel;
import rx.functions.Func1;

/**
 * Global: winxo
 * Date: 2016/10/19
 */
public class Apis {


    public static final String BaseUrl = "http://gank.io/api/";

    public static final int LIMIT_SIZE = 10;

    /**
     * 用来统一处理类似样的请求结果：
     * {"resultCode": 0,"resultMessage": "成功","data": {}}
     * 并将RetrofitResult中的Data分离出来交给subscriber处理
     */
    public class RetrofitResultFunc implements Func1<BaseModel, List<ResultsModel>> {

        @Override
        public List<ResultsModel> call(BaseModel baseModel) {
            if (baseModel.isError()) {
                // 暂时无用
            }
            return baseModel.getResults();
        }
    }
}
