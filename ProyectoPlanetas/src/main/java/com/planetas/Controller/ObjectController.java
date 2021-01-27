package com.planetas.Controller;

import org.springframework.http.ResponseEntity;

public interface ObjectController <T> {
	public ResponseEntity <T> getAll();
	public ResponseEntity <T> getOne(int id);
	public ResponseEntity <T> post(T t);
	public ResponseEntity <T> put(T t, int id);
	public ResponseEntity <T> delete(int id);
}
