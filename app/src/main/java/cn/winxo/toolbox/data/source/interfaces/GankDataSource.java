package cn.winxo.toolbox.data.source.interfaces;

import cn.winxo.toolbox.data.entity.remote.Gank;
import io.reactivex.Observable;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public interface GankDataSource {
  Observable<List<Gank>> getGankData(int page);
}
