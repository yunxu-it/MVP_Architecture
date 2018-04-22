package cn.winxo.toolbox.api.retrofit;

import cn.winxo.toolbox.api.Apis;
import cn.winxo.toolbox.data.entity.remote.GankBase;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yunxu
 * Date: 2016/8/28.
 * Time：1:47
 */
public interface GankService {

  @GET("/data/福利" + Apis.LIMIT_SIZE + "/{page}") Observable<GankBase> getMeiziData(
      @Path("page") int page);
}
