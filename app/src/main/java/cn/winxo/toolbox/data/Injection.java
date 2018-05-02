package cn.winxo.toolbox.data;

import android.content.Context;
import android.support.v4.util.Preconditions;
import cn.winxo.toolbox.data.entity.local.AppDatabase;
import cn.winxo.toolbox.data.entity.local.UserDao;
import cn.winxo.toolbox.data.source.UserRepository;
import io.reactivex.annotations.NonNull;

public class Injection {

  public static UserRepository provideUserRepository(@NonNull Context context) {
    Preconditions.checkNotNull(context);
    UserDao userDao = AppDatabase.getInstance(context).userDao();
    return UserRepository.getInstance(userDao);
  }
}