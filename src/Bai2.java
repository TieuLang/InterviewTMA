

import java.util.*;

public class Bai2 {

    // Bài này vì giới hạn nhỏ, N chỉ có 100 và mỗi sđt có kích thước là 9
    // nên đầu tiên ta chuyển xâu P thành số nguyên P,
    // sau đó với mỗi số điện thoại t chuyển dần thành số nguyên
    // bằng cách thêm kí tự đang duyệt trong số điện thoại đó vào cuối biến số nguyên tạm ta đang dùng,
    // mỗi lần thêm số nguyên vào cuối biến tạm xong, ta xét xem biến tạm đó trừ đi P có chia hết cho 10^(P.length) không,
    // nếu chia hết thì P tồn tại trong số điện thoại đó, ta tiến hành cập nhật kết quả tương ứng.
    // ĐPT thuật toán là O(n)

    //(Bài này nếu kích thước số điện thoại lớn hơn khiến cho số nguyên không lưu được thì ta có thể dùng thuật toán Rabin-karp hoặc Z-function để xử lý)
    //(Nếu số lượng truy vấn lớn hơn thay vì 1 thì em nghĩ có thể dùng thuật toán Rabin-karp kết hợp với cấu trúc dữ liệu segment tree để tăng tốc độ truy vấn)

    //Tính a^b đpt(log(b))
    public static int getPow(int a,int b)
    {
        if (b==0) return 1;
        if (b==1) return a;
        int temp=getPow(a,b/2);
        if (b%2==0) return temp*temp; else return temp*temp*a;
    }

    // Hàm chuyển xâu thành số nguyên
    private static int ConvertStringToInt(String P) {
        int pInt=0;
        for (int i=0;i<P.length();++i)
            pInt=pInt*10+(P.charAt(i)-'0');
        return pInt;
    }

    public static String solve(String[] A, String[] B, String P)
    {
        String ans="";
        int pInt=ConvertStringToInt(P);
        int Pow=getPow(10,P.length());
        // Duyệt từng số điện thoại
        for (int i=0;i<B.length;++i) {
            int temp=0; //Biến temp để biến số điện thoại đang duyệt từ xâu thành số
            //Với mỗi số điện thoại, ta duyệt từng kí tự trong số điện thoại đó và thêm vào cuối biến temp
            for (int j = 0; j < B[i].length(); ++j)
            {
                temp=temp*10+(B[i].charAt(j)-'0');
                // nếu biến (temp-pInt)%Pow=0 thì nghĩa là P tồn tại trong số điện thoại đó
                if ((temp-pInt)%Pow==0)
                {
                    //Nếu thứ tự từ điển của ans nhỏ hơn A[i] thì cập nhật ans
                    if (ans.equals("") || ans.compareTo(A[i])>0) ans=A[i];
                    break;
                }
            }
        }
        // Nếu ans vẫn bằng rỗng thì nghĩa là P không tồn tại trong bất kì số điện thoại nào.
        if (ans=="") return "NO CONTACT";
        return ans;
    }

    public static void main(String[] args)
    {
        String[] A={"sander", "amy", "ann", "michael"};
        String[] B={"21345678", "234567890", "789213456","213213213"};
        String P= "12";
        System.out.println(solve(A,B,P));
    }
}
