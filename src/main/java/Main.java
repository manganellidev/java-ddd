import com.manga.ddd.logic.product.Code;
import com.manga.ddd.logic.product.Period;
import com.manga.ddd.logic.product.Product;
import com.manga.ddd.logic.product.ProductTypes;
import com.manga.ddd.logic.product.TypeCode;
import java.time.Instant;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started....");

        run();

        System.out.println("Finalizing....");
    }

    public static void run() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-ddd");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Code code = Code.create("CODE1", "DESC 1");
        TypeCode typeCode = TypeCode.create(ProductTypes.MATERIAL.toString());
        Period period = Period.create(Instant.parse("1999-01-01T00:00:00Z"), Instant.parse("9999-12-31T23:59:59Z"));
        Product product = new Product(code, typeCode, period);

        tx.begin();
        em.persist(product);
        tx.commit();

        Product foundProduct = em.find(Product.class, product.getId());
        System.out.println(foundProduct);
    }
}
