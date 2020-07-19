package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/29 22:05
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    //链式编程+流式计算
    private int id;
    private String bookName;
    private double price;

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1).setBookName("wgl").setPrice(20);
    }
}
