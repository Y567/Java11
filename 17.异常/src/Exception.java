public class Exception extends Throwable {
    public static void main(String[] args){
        int[] a = new int[5];
        try{
            throw new Exception();
        }catch(Exception e){
//            throw new ArrayIndexOutOfBoundsException("越界异常");
        } finally{
            System.out.println("资源释放");
        }
        /*try(InputStream is = new FileInputStream("D:\\f.txt")){
           try第二种使用方法
        }*/
    }
}
