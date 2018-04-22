package cn.winxo.mvp.data.source;

import cn.winxo.mvp.data.source.interfaces.UserDataSource;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class UserRepository implements UserDataSource {
  private static UserRepository INSTANCE = null;

  private UserRepository() {
  }

  public static UserRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new UserRepository();
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override public void getUser() {

  }
}
