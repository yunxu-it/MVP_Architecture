package cn.winxo.mvp.di;

import cn.winxo.mvp.module.main.MainActivity;
import dagger.Component;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
@Component(modules = { AppModule.class }) public interface AppComponent {
  void inject(MainActivity mainActivity);
}
