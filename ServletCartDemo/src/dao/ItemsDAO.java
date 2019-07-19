package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//商品的业务逻辑类
public class ItemsDAO {
    public List<Items> getAllItems() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet results = null;

        List<Items> allItems = new ArrayList<>();//所有商品的集合
        try {
            String sqlStmt = "select * from items";//要执行的SQL语句
            conn = DBHelper.getConnection();
            stmt = conn.createStatement();
            results = stmt.executeQuery(sqlStmt);

            while (results.next()) {
                //获取查询到的数据，封装到Items对象中
                Items item = new Items();
                assignItemAttrs(item, results);

                //将Items对象加入List
                allItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseRS_Stmt(results, stmt);
        }
        return allItems;
    }

    //根据商品编号获得详细资料
    public Items getItemDetailsById(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet results = null;

        Items item = null;
        try {
            String sqlStmt = "select * from items where id=" + id;//要执行的SQL语句
            conn = DBHelper.getConnection();
            stmt = conn.createStatement();
            results = stmt.executeQuery(sqlStmt);

            if (results.next()) {
                item = new Items();
                assignItemAttrs(item, results);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            releaseRS_Stmt(results, stmt);
        }
        return item;
    }

    //获取最近浏览的前五条商品信息
    public ArrayList<Items> getViewList(String list) {
        System.out.println("list:" + list);
        ArrayList<Items> itemList = new ArrayList<Items>();
        int iCount = 5; //每次返回前五条记录
        if (list != null && list.length() > 0) {
            //如果商品记录大于等于5条
            if (list.length() >= 5) {
                for (int i = list.length() - 1; i >= list.length() - iCount; i--) {
                    itemList.add(getItemDetailsById(Integer.parseInt(list.charAt(i) + "")));
                }
            } else {
                for (int i = list.length() - 1; i >= 0; i--) {
                    itemList.add(getItemDetailsById(Integer.parseInt(list.charAt(i) + "")));
                }
            }
            return itemList;
        } else {
            return null;
        }

    }

    private void releaseRS_Stmt(ResultSet results, Statement stmt) {
        //由小到大释放资源
        //释放ResultSet
        if (null != results) {
            try {
                results.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //释放Statement
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void assignItemAttrs(Items item, ResultSet results) throws SQLException {
        item.setId(results.getInt("id"));
        item.setName(results.getString("name"));
        item.setPrice(results.getDouble("price"));
        item.setCity(results.getString("city"));
        item.setStock_quantity(results.getInt("stock_quantity"));
        item.setPicture(results.getString("picture"));
    }
}
