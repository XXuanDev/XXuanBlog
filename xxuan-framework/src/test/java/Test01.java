import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: test
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-26 22:22
 * @Version: V1.0
 */
public class Test01{
final private String password = "1234";

@Test
public void TestCrypt01()
{
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    String encode = bCryptPasswordEncoder.encode(password);
    System.out.println("encode:" + encode);

    boolean matches = bCryptPasswordEncoder.matches(password, encode);
    System.out.println("matches:" + matches);


}


@Test
public void TestCrypt02()
{
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    String encode = bCryptPasswordEncoder.encode(password);
    System.out.println(encode);


}


@Test
public void TestCrypt03()
{
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    boolean matches = bCryptPasswordEncoder.matches(password,"$2a$10$hXk1tk4rry.dCTXUQ27oOOHh92hvfeoMF0drMKg.VkmSX.iMYYV/S");
    System.out.println("matches:" + matches);


}
}