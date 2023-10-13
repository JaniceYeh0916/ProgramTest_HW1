import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    //初始化物件 t
    Triangle t;

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
        t = new Triangle();
        System.out.println("Initialization!");
    }

    //測試方法
    //測試checkTriangle()是否正常執行及輸出正確
    @Test
    void TestCase(){
        System.out.println("Test edge...");
        assertAll("edge",
            () -> assertEquals( "正三角形" , t.checkTriangle(3 , 3 , 3)),
            () -> assertEquals( "等腰三角形" , t.checkTriangle(7 , 7 , 13)), //Actual:等腰三角形
            () -> assertEquals( "三角形" , t.checkTriangle(3 , 7 , 9))
        );
    }

    //在所有測試方法執行之後執行
    //告知使用者測試結束
    @AfterAll
    static void tearDownAll() {
        System.out.println("End of the program test.");
    }

}