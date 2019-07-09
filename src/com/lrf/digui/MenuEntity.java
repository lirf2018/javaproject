package com.lrf.digui;

import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/23 15:57
 * 功能介绍:
 */
public class MenuEntity {

    // 菜单id
    private Integer menuId;
    // 菜单名称
    private String name;
    // 父菜单id
    private Integer parentId;

    public MenuEntity() {
    }

    public MenuEntity(Integer menuId, String name, Integer parentId) {
        this.menuId = menuId;
        this.name = name;
        this.parentId = parentId;
    }

    // 子菜单
    private List<MenuEntity> childList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<MenuEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuEntity> childList) {
        this.childList = childList;
    }
}
