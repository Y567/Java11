package test9_5;

public class List {
    public int[] a = new int[10];
    public int size = 0;
    public void insert(int index,int e){
        //空
    }

}

class ArrayList extends List{
    @Override
    public void insert(int index, int e) {
        for (int i = index; i < size - 1; i++) {
            a[i+1] = a[i];
        }
        a[index] = e;
        size++;
    }
}
