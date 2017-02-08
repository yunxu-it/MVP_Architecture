package cn.winxo.mvp.api.retrofit;


import cn.winxo.mvp.api.Apis;
import cn.winxo.mvp.api.entity.BaseModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yunxu
 * Date: 2016/8/28.
 * Time：1:47
 */
public interface GankService {

    @GET("/data/福利" + Apis.LIMIT_SIZE + "/{page}")
    Observable<BaseModel> getMeiziData(@Path("page") int page);

}
