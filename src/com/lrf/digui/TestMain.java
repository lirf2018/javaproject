package com.lrf.digui;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/23 15:58
 * 功能介绍:
 */
public class TestMain {

    public static void main(String[] args) {
        //获取该角色下所有菜单
        List<MenuEntity> menuList = new ArrayList<>();
        MenuEntity m1 = new MenuEntity(1, "管理员", 0);
        MenuEntity m2 = new MenuEntity(2, "开发人员", 0);
        MenuEntity m3 = new MenuEntity(3, "客服", 0);
        MenuEntity m4 = new MenuEntity(4, "客服1", 3);
        MenuEntity m5 = new MenuEntity(5, "客服2", 3);
        MenuEntity m6 = new MenuEntity(6, "客服4", 5);
        MenuEntity m7 = new MenuEntity(7, "客服5", 5);
        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        menuList.add(m4);
        menuList.add(m5);
        menuList.add(m6);
        menuList.add(m7);


        //找到所有的1级菜单
        List<MenuEntity> mList = new ArrayList<>();
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getParentId() == 0) {
                mList.add(menuList.get(i));
            }
        }
        //为一级菜单设置子菜单准备递归
        for (MenuEntity menu : mList) {
            //获取父菜单下所有子菜单调用getChildList
            menu.setChildList(getChildList(menu.getMenuId(), menuList));
        }

        System.out.println(JSONObject.toJSONString(mList));
    }

    public static List<MenuEntity> getChildList(int id, List<MenuEntity> menuList) {
        //构建子菜单
        List<MenuEntity> childList = new ArrayList<>();
        //遍历传入的list
        for (MenuEntity menu : menuList) {
            //所有菜单的父id与传入的根节点id比较，若相等则为该级菜单的子菜单
            if (menu.getParentId() == id) {
                childList.add(menu);
            }
        }
        //递归
        for (MenuEntity m : childList) {
            m.setChildList(getChildList(m.getMenuId(), menuList));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
