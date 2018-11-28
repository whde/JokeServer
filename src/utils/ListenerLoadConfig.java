package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 监听上下文加载配置
  */
public class ListenerLoadConfig implements ServletContextListener {

    public static final long TOKEN_CHECKED_TIME=24*60*60*1000;

    public void contextDestroyed(ServletContextEvent sce) {
    }
    public void contextInitialized(ServletContextEvent event) {
        String path=event.getServletContext().getRealPath("/WEB-INF/config/dbconfig.properties");
        System.out.println(path);
        LoadDBconfig.load(path);
        System.out.println(DBUtil.getConn());
    }
}
