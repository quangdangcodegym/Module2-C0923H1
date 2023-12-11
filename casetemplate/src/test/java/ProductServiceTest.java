import com.cg.model.ECategory;
import com.cg.model.ERole;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.service.txt.ProductService;
import com.cg.utils.DateUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductServiceTest {

    @Test
    public void testFindByExistingId() {
        // Tạo một đối tượng YourService
        ProductService yourService = new ProductService();


        // Gọi phương thức findBy với một ID tồn tại
        Product result = yourService.findBy(1L);

        //Userr

        User user = new User(1, "quocanh", "123123", ERole.USER, DateUtils.parse("2023-08-08"));

        // Đối tượng mong đợi
        Product product = new Product(1L, "Iphone 11", "Iphone 11 64GB RED",
                1000000, user, ECategory.APPLE, DateUtils.parse("2023-10-09"));


        // Kiểm tra kết quả
        assertEquals(product, result);
    }
}

