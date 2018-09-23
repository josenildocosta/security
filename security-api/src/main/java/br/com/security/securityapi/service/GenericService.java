package br.com.security.securityapi.service;

import java.util.Set;

public interface GenericService<T, ID> {
	public Set<T> findAll();

	public T findById(ID id);

	public T save(T object);

	public void delete(T object);

	public void deleteById(ID id);
}