package org.francis.dd.controller;

import org.francis.dd.datasource.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote
 */
@RestController
public class DataSourceController {

    private static final Logger log = LoggerFactory.getLogger(DataSourceController.class);

    /**
     * 修改数据源接口
     *
     * @param dsType
     */
    @PostMapping("/dytype")
    public void setDsType(String dsType, HttpSession session) {
        session.setAttribute(DataSourceType.DS_SESSION_KEY, dsType);
        log.info("数据源切换为:{}", dsType);
    }
}
