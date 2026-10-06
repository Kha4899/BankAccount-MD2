import java.util.ArrayList;

/* Generic: tương tự tự tham số nhưng dành cho KIỂU DỮ LIỆU,
nó sẽ đại diện cho những kiểu dữ liệu được thêm vào khi sử dụng.
 */
public interface IManager<T>{
    void add(T t);
    void remove(int index);
    void update(int index, T t);
    ArrayList<T> findAll();
}