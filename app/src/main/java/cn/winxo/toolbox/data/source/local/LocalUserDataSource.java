package cn.winxo.toolbox.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;
import cn.winxo.toolbox.data.entity.local.AppDatabase;
import cn.winxo.toolbox.data.entity.local.UserDao;
import cn.winxo.toolbox.data.entity.local.UserEntity;
import cn.winxo.toolbox.data.source.interfaces.UserDataSource;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class LocalUserDataSource implements UserDataSource {

  private static LocalUserDataSource INSTANCE;
  private Context mContext;

  public static LocalUserDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new LocalUserDataSource(context);
    }
    return INSTANCE;
  }

  // Prevent direct instantiation.
  private LocalUserDataSource(@NonNull Context context) {
    mContext = context;
  }

  @Override public void getUser() {
    UserDao userDao = AppDatabase.getInstance(mContext).userDao();
  }

  @Override public void insertUser(UserEntity userEntity) {
    UserDao userDao = AppDatabase.getInstance(mContext).userDao();
    userDao.insert(userEntity);
  }
}
