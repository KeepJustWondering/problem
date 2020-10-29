
public class BookOwnership {

    //예외 상황인지 아닌지 판단하는 메소드
    private boolean ExceptionCheck(int[] pobi, int[] crong){

            return pobi[1]-pobi[0]!=1 || crong[1]-crong[0]!=1;

    }

    //왼쪽 오른쪽 페이지의 합중 큰것을 반환
    private int Sum(int[] pages){
        int[] page=pages.clone();
        int[] LOrR= {0,0};

        for(int i=0;i<2;i++) {
            for (int j = 2; j >= 0; j--) {
                LOrR[i] += (page[i]/(int)Math.pow(10,j));
                page[i]=page[i] % (int)Math.pow(10,j);

            }
        }

        if(LOrR[0]>=LOrR[1])
            return LOrR[0];
        else
            return LOrR[1];
    }

    //왼쪽 오른쪽 페이지의 곱중 큰것을 반환
    private int Mul(int[] page){
        int[] LOrR= {1,1};

        for(int i=0;i<2;i++) {
            for (int j = 2; j >= 0; j--) {
                LOrR[i] *= (page[i]/(int)Math.pow(10,j));
                page[i]=page[i] % (int)Math.pow(10,j);
                if(LOrR[i]==0)
                    LOrR[i]++;
            }
        }

        if(LOrR[0]>=LOrR[1])
            return LOrR[0];
        else
            return LOrR[1];
    }

    //곱과 합중 큰것을 반환
    private int Max(int Sum, int Mul){

        if(Sum>=Mul)
            return Sum;
        else
            return Mul;
    }

    //결과 반환
    private int Owner(int[] pobi, int[] crong){


        if(!ExceptionCheck(pobi,crong)){
            int pobiNum = Max(Sum(pobi), Mul(pobi));
            int crongNum = Max(Sum(crong), Mul(crong));


            if (pobiNum > crongNum)
                return 1;
            else if(pobiNum < crongNum)
                return 2;
            else
                return 0;
        }

        else
            return -1;
    }

    public static void main(String[] args){
        BookOwnership Book = new BookOwnership();

        int[] pobi={97,98};
        int[] crong={197,198};

        System.out.print(Book.Owner(pobi,crong));


    }
}
