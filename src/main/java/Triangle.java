//開啟assert
//package org.example.u2debug;

public class Triangle {

    //測試測資
    public static void main(String[] args) throws TriangleException {
        // 正確測資
        Triangle t1 = new Triangle();
        String r1 = t1.checkTriangle(2 , 3 , 4);
        System.out.println(r1);

        //錯誤測資:邊長為0
        Triangle t2 = new Triangle();
        String r2 = t2.checkTriangle(0 , 5 , 11);
        System.out.println(r2);

        //錯誤測資:任兩邊之合小於第三邊
        Triangle t3 = new Triangle();
        String r3 = t3.checkTriangle(7 , 5 , 13);
        System.out.println(r3);
    }

    //確認三角形類型
    public String checkTriangle(int a, int b, int c) throws TriangleException {

        //判斷是否有邊長 = 0
        boolean zero = (a <= 0 || b <= 0 || c <= 0);
        //若是，則拋出例外處理
        if (zero) {
            throw new TriangleException();
        }

        //判斷是否任兩邊之合都大於第三邊
        boolean ok = (a + b > c && b + c > a && c + a > b);
        //若否，則拋出例外處理，並打包三邊長
        if (!ok) {
            throw new TriangleException(a, b, c);
        }

        //將triangleType初始化
        String triangleType = "normal";
        //若有兩邊相等，則有可能為正三角形或等腰三角形，否則為一般三角形
        if (a == b){    //a = b
            if (b == c){
                triangleType = "正三角形";
            }else{
                triangleType = "等腰三角形";
            }
        }else if (a == c){    //a = c
            assert a == b : "a 不等於 b";    //告知使用者a不等於b
            triangleType = "等腰三角形";
        }else if (a * a + b * b == c * c) {
            triangleType = "直角三角形";
        }else {
           assert (a == b || a == c || b == c) : "三邊皆不相等";    //告知使用者三邊邊長皆不相等
            triangleType = "三角形";
        }

        return triangleType;
    }
}

//例外處理 : 任一邊長≤0 或 任兩邊之合沒有大於第三邊
class TriangleException extends Exception {
    int[] edge = new int[3];

    //發生錯誤，告知使用者輸入的邊長無法組成一個三角形
    public TriangleException(int a, int b, int c) {
        super("Not allowed triangle length");
        this.edge = new int[]{a, b, c};
    }

    //發生錯誤，告知使用者輸入的邊長中有<=0的數值
    public TriangleException() {
        super("Zero edge");
    }

    //封裝三邊邊長
    public int[] getEdge(){
        return edge;
    }
}

