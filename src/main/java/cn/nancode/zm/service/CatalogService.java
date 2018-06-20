package cn.nancode.zm.service;

import cn.nancode.zm.dao.Catalog;
import cn.nancode.zm.dao.User;

import java.util.List;

public interface CatalogService {

    Catalog saveCatalog(Catalog catalog);

    void removeCatalog(Long id);

    Catalog getCatalogById(Long id);

    List<Catalog> listCatalogs(User user);
}
