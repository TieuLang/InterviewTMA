public class Bai1 {

    //Nhận thấy muốn 1 số chia hết cho 3 thì tổng các số của số đó phải bằng 3
    //Vì vậy, đầu tiên ta tính tổng các chứ số của xâu S,
    //sau đó, ta chỉ cần duyệt từ đầu đến cuối xâu S,
    //với mỗi phần tử xâu S thì ta sẽ xét xem nếu xóa số đó đi thì tổng thành bao nhiêu,
    //sau đó tính xem tổng đó cần phần tử bao nhiêu để chia hết cho 3,
    //sau đó xét sô lượng phần tử tương ứng và cộng vào kết quả.

    //Hàm này sẽ tính tổng các chữ số trong xâu S
    private static int getSumString(String S) {
        int sum=0;
        for (int i=0;i<S.length();++i)
            sum=sum+(S.charAt(i)-'0');
        return sum;
    }


    //kiểm tra xem ta có thêm nhầm số ban đầu đã được thêm vào không
    private static boolean checkRepeat(int sum,char ch){
        return ((ch - '0') - (3 - (sum - (ch - '0')) % 3)) % 3 == 0;
    }

    //Công thức tính số lượng số chia hết cho 3 khi thay kí tự i thành kí tự khác
    private static int getValueDivOf3(int sum, char ch) {
        if ((sum- (ch-'0'))%3==0) return 4;
            else return 3;
    }

    public static int solve(String S)
    {
        int sum=getSumString(S);
        int ans=0;
        int numRepeat=0;
        //Với mỗi kí tự, ta xét xem nếu xóa kí tự đó đi thì sẽ thay thành những số nào để chia hết cho 3
        for (int i=0;i<S.length();++i) {
            if (checkRepeat(sum,S.charAt(i)) ) ++numRepeat;
            ans += getValueDivOf3(sum, S.charAt(i));
        }
        if (numRepeat==0) return ans;
        return ans-numRepeat+1;
    }


    public static void main(String[] args)
    {
        String s="0081";
        System.out.println(solve(s));
    }
}
