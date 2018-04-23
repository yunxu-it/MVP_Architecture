package cn.winxo.toolbox.data;

import android.content.Context;
import android.support.v4.util.Preconditions;
import cn.winxo.toolbox.data.source.UserRepository;
import cn.winxo.toolbox.data.source.local.LocalUserDataSource;
import io.reactivex.annotations.NonNull;

public class Injection {

  public static UserRepository provideUserRepository(@NonNull Context context) {
    Preconditions.checkNotNull(context);
    return UserRepository.getInstance(LocalUserDataSource.getInstance(context));
  }
}