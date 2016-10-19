package cn.winxo.library.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.winxo.library.base.BaseFragment;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class ViewUtils {
    private static Map<String, BaseFragment> fragmentMap = new HashMap<>();

    public static BaseFragment createFragment(Class<?> clazz, boolean isObtain) {
        BaseFragment fragment = null;
        String className = clazz.getName();
        if (fragmentMap.containsKey(className)) {
            fragment = fragmentMap.get(className);
        } else {
            try {
                fragment = (BaseFragment) Class.forName(className).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (isObtain) {
                fragmentMap.put(className, fragment);
            }
        }
        return fragment;
    }

    public static BaseFragment createFragment(Class<?> clazz) {
        return createFragment(clazz, true);
    }


    public static List<BaseFragment> getFragments() {
        Iterator<BaseFragment> ita = fragmentMap.values().iterator();
        List<BaseFragment> list = new ArrayList<>();
        while (ita.hasNext()) {
            list.add(ita.next());
        }
        return list;
    }
}
