package cn.winxo.mvp.module.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
@RunWith(MockitoJUnitRunner.class) public class MainPresenterTest {

  MainPresenter presenter;
  private MainActivity context;

  @Before public void setUp() throws Exception {
    context = mock(MainActivity.class);
    presenter = new MainPresenter(context);
    presenter.attachView(context);
  }

  @Test public void changeText() throws Exception {

    presenter.changeText(1);

    Mockito.verify(context).changeButton("2");
  }
}