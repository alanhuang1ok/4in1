package demo.comp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harvey on 14/12/1.
 */
public class CompDemo {
    public int total=0;
    public int n=4;
    public int m =4;
//    public void comb(String str){
//        for(int i=1;i<n+1;i++){
//            if(str.length()==m-1){
//                System.out.println(str+i);
//                total++;
//            }else
//                comb(str+i);
//        }
//    }
public void printAnyThree(){
    int[] num = new int[]{1,2,3,4,5,6};
    print(combine(num,4));
}
    public List combine(int[] a,int m){
        int n = a.length;
        if(m>n){
            try {
                throw new OurException("错误！数组a中只有"+n+"个元素。"+m+"大于"+2+"!!!");
            } catch (OurException e) {
                e.printStackTrace();
            }
        }

        List result = new ArrayList();

        int[] bs = new int[n];
        for(int i=0;i<n;i++){
            bs[i]=0;
        }
        //初始化
        for(int i=0;i<m;i++){
            bs[i]=1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        //首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
        do{
            sum = 0;
            pos = 0;
            tempFlag = true;
            result.add(print(bs,a,m));

            for(int i=0;i<n-1;i++){
                if(bs[i]==1 && bs[i+1]==0 ){
                    bs[i]=0;
                    bs[i+1]=1;
                    pos = i;
                    break;
                }
            }
            //将左边的1全部移动到数组的最左边

            for(int i=0;i<pos;i++){
                if(bs[i]==1){
                    sum++;
                }
            }
            for(int i=0;i<pos;i++){
                if(i<sum){
                    bs[i]=1;
                }else{
                    bs[i]=0;
                }
            }

            //检查是否所有的1都移动到了最右边
            for(int i= n-m;i<n;i++){
                if(bs[i]==0){
                    tempFlag = false;
                    break;
                }
            }
            if(tempFlag==false){
                flag = true;
            }else{
                flag = false;
            }

        }while(flag);
        result.add(print(bs,a,m));

        return result;
    }

    private int[] print(int[] bs,int[] a,int m){
        int[] result = new int[m];
        int pos= 0;
        for(int i=0;i<bs.length;i++){
            if(bs[i]==1){
                result[pos]=a[i];
                pos++;
            }
        }
        return result ;
    }

    private void print(List l){
        for(int i=0;i<l.size();i++){
            int[] a = (int[])l.get(i);
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        CompDemo mCompDemo = new CompDemo();
        mCompDemo.printAnyThree();
    }

}
