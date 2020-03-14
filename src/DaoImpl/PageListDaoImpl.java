package DaoImpl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import beans.JokeBean;
import utils.DBUtil;
import beans.PageCompute;

public class PageListDaoImpl {
	public static PageCompute<JokeBean> getRecords(int currentPage, int pageSize) {
		int total = getTotal();
        PageCompute<JokeBean> pageCompute=new PageCompute<>(currentPage,total,pageSize);
		List<JokeBean> list = new ArrayList<JokeBean>();
		int start = 0;
		if (currentPage > 0) {
			start = (currentPage - 1) * pageSize;
		}
		if (total>0) {
    		try {
    			Connection con = DBUtil.getConn();
    			String sql = "select date,herf,title from joke ORDER BY date LIMIT " + start + "," + pageSize;
    			QueryRunner qr=new QueryRunner();
    			list=(List<JokeBean>)qr.query(con,sql,new BeanListHandler<>(JokeBean.class));
    			con.close();
                pageCompute.setData(list);
                pageCompute.setMsg("请求成功");
                pageCompute.setCode(0);
    		} catch (Exception e) {
    			e.printStackTrace();
    			pageCompute.setData(new ArrayList<JokeBean>());
                pageCompute.setMsg("获取数据失败，出现错误");
                pageCompute.setCode(-1);
    		}
		} else {
			pageCompute.setData(new ArrayList<JokeBean>());
            pageCompute.setMsg("暂无数据");
            pageCompute.setCode(-2);
		}
		return pageCompute;
	}
 
	private static int getTotal() {
		try {
			Connection con = DBUtil.getConn();
			String sql = "SELECT COUNT(1) AS total FROM joke";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
