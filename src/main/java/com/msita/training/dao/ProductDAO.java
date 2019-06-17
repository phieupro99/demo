package com.msita.training.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.msita.training.vo.Product;
import com.msita.training.vo.User;

@Repository
public class ProductDAO extends BaseDAO {
	@SuppressWarnings("unchecked")
	public List<Product> getData(String type) {
		return (List<Product>) getJdbcTemplateObject().query("select * from  spring.product where type='" + type + "'",
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product product = new Product();
						product.setDescription(rs.getString("description"));
						product.setId(rs.getString("id"));
						product.setTitle(rs.getString("title"));
						product.setImage(rs.getString("image"));
						product.setPrice(rs.getString("price"));
						product.setImages(getImages(product.getId()));
						return product;
					}
				});

	}

	@SuppressWarnings("unchecked")
	public Product getProduct(String id) {
		return getJdbcTemplateObject().query("select * from spring.product where id=?", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, id);
			}

		}, new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				Product product = null;
				if (rs.next()) {
					product = new Product();
					product.setDescription(rs.getString("description"));
					product.setId(rs.getString("id"));
					product.setTitle(rs.getString("title"));
					product.setImage(rs.getString("image"));
					product.setPrice(rs.getString("price"));
					product.setImages(getImages(product.getId()));
				}
				return product;
			}
		});
	}

	public List<String> getImages(String id){
		return getJdbcTemplateObject().query(
				"select * from spring.images where productId=?",
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						ps.setString(1, id);
					}
	},
				new RowMapper() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						return rs.getString("url");
					};
				}
				);
		}
}
