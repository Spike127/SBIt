package com.epam.traning.buyit.service;

public interface CrudService<T> {
	
	void createElement(T elem);

	T getElementById(int id);

	void updateElement(T elem);

	void deleteElement(T elem);

}
