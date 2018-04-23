package cn.winxo.toolbox.data.source;

import android.support.annotation.NonNull;
import cn.winxo.toolbox.data.entity.local.UserEntity;
import cn.winxo.toolbox.data.source.interfaces.UserDataSource;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class UserRepository implements UserDataSource {
  private static UserRepository INSTANCE = null;
  private UserDataSource mLocalUserDataSource;

  private UserRepository(@NonNull UserDataSource localUserDataSource) {
    mLocalUserDataSource = localUserDataSource;
  }

  public static UserRepository getInstance(UserDataSource localUserDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new UserRepository(localUserDataSource);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override public void getUser() {
  }

  @Override public void insertUser(UserEntity userEntity) {

  }
}
