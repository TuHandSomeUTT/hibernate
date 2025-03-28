package dao;

import java.util.List;

import model.Cat;

public interface DAOInterface <T>{
	public List<Cat> selectAll();
	
	public T selectById(T t);
	
	public boolean insert(T t);
	
	public boolean update(T t);

	public boolean delete(T t);
}
