package com.planetas.Services;

import java.util.List;

public interface ObjectServices <T> {
	public List<T> findAll() throws Exception;
	public T findById(int id) throws Exception;
	public T save(T t) throws Exception;
	public T update(T t, int i) throws Exception;
	public boolean delete(int id) throws Exception;
}
