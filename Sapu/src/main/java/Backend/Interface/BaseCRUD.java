package Backend.Interface;

public interface BaseCRUD<T> {
	boolean create(T model);
	T read(String id);
	boolean update(T model);
	boolean delete(String id);
}
