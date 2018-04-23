package cn.winxo.toolbox.data.source.interfaces;

import cn.winxo.toolbox.data.entity.local.UserEntity;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public interface UserDataSource {

  void getUser();

  void insertUser(UserEntity userEntity);
}
