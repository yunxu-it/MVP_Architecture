package cn.winxo.toolbox.data.source;

import android.support.annotation.NonNull;
import cn.winxo.toolbox.data.entity.local.UserDao;
import cn.winxo.toolbox.data.entity.local.UserEntity;
import cn.winxo.toolbox.data.source.interfaces.UserDataSource;
import io.reactivex.Flowable;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class UserRepository implements UserDataSource {
  private static UserRepository INSTANCE = null;
  private UserDao mUserDao;

  private UserRepository(@NonNull UserDao userDao) {
    mUserDao = userDao;
  }

  public static UserRepository getInstance(UserDao userDao) {
    if (INSTANCE == null) {
      INSTANCE = new UserRepository(userDao);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override public Flowable<List<UserEntity>> getUser() {
    return mUserDao.getAllUsers();
  }

  @Override public void insertUser(UserEntity userEntity) {
    mUserDao.insert(userEntity);
  }
}
