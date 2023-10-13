import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

    //初始化物件 mark
    People mark;

    //在所有測試方法執行之前執行
    //告知使用者開始測試
    @BeforeAll
    static void set(){
        System.out.println("Set up!");
    }

    //在每個測試方法執行之前執行
    //準備初始化
    @BeforeEach
    void init(){
        mark = new People("Mark" , 1999);
        System.out.println("Initialization!");
    }

    //測試方法
    //測試setAge()是否正常執行及輸出正確
    @Test
    void setAge() {
        System.out.println("Test age...");
        assertAll("age",
            () -> assertEquals( 24 , mark.setAge()) //24
        );
    }

    //測試方法
    //測試setHW()是否正常執行及輸出正確
    @Test
    void setHW() throws People.WrongException {
        System.out.println("Test height & weight...");
        mark.setHW(1.71 , 60);
        assertAll("hw",
            () -> assertEquals( 1.71 , mark.height),
            () -> assertEquals( 60 , mark.weight)
        );
    }

    //測試方法
    //測試getBmi()是否正常執行及輸出正確
    @Test
    void getBmi() throws People.WrongException {
        System.out.println("Test bmi...");
        mark.setHW(1.71 , 60);
        assertAll("bmi",
            () -> assertEquals( 20.52 , Math.round(mark.getBmi()*100.0) / 100.0)
        );
    }

    //在所有測試方法執行之後執行
    //告知使用者測試結束
    @AfterAll
    static void tearDownAll() {
        System.out.println("End of the program test.");
    }
}