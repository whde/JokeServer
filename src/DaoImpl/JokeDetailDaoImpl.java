package DaoImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import beans.JokeBean;
import beans.ResponseBean;
import utils.DBUtil;

public class JokeDetailDaoImpl {
	public static ResponseBean<JokeBean> getJokeDetail(String herf) {
		ResponseBean<JokeBean> responseBean = new ResponseBean<JokeBean>();
		try {
			Connection con = DBUtil.getConn();
			String sql = "select * from joke where herf='" + herf+"'";
			QueryRunner qr=new QueryRunner();
			List<JokeBean> list=(List<JokeBean>)qr.query(con,sql,new BeanListHandler<>(JokeBean.class));
			con.close();
			if (list.size()>0) {
				responseBean.setData(list.get(0));
				responseBean.setMsg("请求成功");
				responseBean.setCode(0);
			} else {
				responseBean.setData(new ArrayList<>());
				responseBean.setMsg("请求成功");
				responseBean.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setData(new ArrayList<JokeBean>());
			responseBean.setMsg("获取数据失败，出现错误");
			responseBean.setCode(-1);
		}
		return responseBean;
	}
}
