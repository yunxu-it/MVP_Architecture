package cn.winxo.toolbox.data.source.interfaces;

import cn.winxo.toolbox.data.entity.local.UserEntity;
import io.reactivex.Flowable;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public interface UserDataSource {

  Flowable<List<UserEntity>> getUser();

  void insertUser(UserEntity userEntity);
}
