import java.util.Arrays;
/**
 * @author Group 10
 * @author Joshua Graeber, Ayden Hocking, Dev Amin, Quanfei Li, Andre Bautista, Karin Kato
 */
public class MyArrayList_int{

    final static int INIT_CAPACITY = 10;
    int items[];
    int size;
    public MyArrayList_int(){
        this.items = new int[INIT_CAPACITY];
        this.size = 0;
    }
    
    public MyArrayList_int(int size){
        this.items = new int[size];
        this.size = 0;
    }
    
    public int get(int index){
        if (index < 0 || index >= size) {
            System.out.println("error, please try again!");
        }
        return items[index];
    }
    
    public void set(int index, int newitem){
        if (index < 0 || index >= size) {
            System.out.println("error, please try again!");
        }
        items[index] = newitem;
    }

    public void add(int value) {
        if (size == items.length) {
            resize();
        }
        items[size++] = value;
    }
    
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("error, please try again!");
        }
        if (size == items.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        
        items[index] = value;
        size++;
    }
    
    public void resize() {
        this.items = Arrays.copyOf(this.items, 2 * this.items.length);
    }
    
    public int[] expandAndCopyArray(){
        if (items == null) return null;
        int size = (int)(items.length * (3.0/2));
        int [] list = new int[size];
        for (int index = 0; index < size; index++)
            if (index < items.length)
                    list[index] = items[index];
            else
                list[index] = 0;
         return list;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("error, please try again!");
        }

        int removedValue = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removedValue;
    }
    
    public int size(){
        return size;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList_int list = new MyArrayList_int(10);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(1, 10);
        list.remove(0);
        
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}