package listasencadeadas;

public class ListaDuplamenteEncadeadaCircular <Type> {
    
    private ListNode head;
    private ListNode tail;
    private ListNode node;
    private int size;
    
    private class ListNode{
        private Type element;
        private ListNode next;
        private ListNode previous;
        
        private ListNode(Type element, ListNode previous, ListNode next){
            this.element = element;
            this.previous = previous;
            this.next = next;
        }        
    }
    
    public ListaDuplamenteEncadeadaCircular(){
        head = tail = null;
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        tail = head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public void add(Type elem){
        ListNode newElement = new ListNode(elem, null, null);
        if(head == null){
            head = newElement;
            head.next = head.next = head;
            newElement = head;
        } else {
            newElement.previous = tail;
            newElement.next = head;
            tail.next = newElement;
        }
        tail = newElement;
        size++;
    }
    
    public int indexOf(Type elem){
        ListNode search = head;
        for(int i = 0; i < size; i++){
            if(search.element.equals(elem)){
                return i;
            }
            search = search.next;
        }
        return -1;
    }
    
    public Type get(int index){
        if(index < 0 || index >= size){
            return null;
        } else {
            ListNode search = head;
            for (int i = 0; i < index; i++) {
                search = search.next;
            }
            return search.element;
        }
    }
    
    public void set(Type elem, int index){
        if (index < 0 || index >= size) {
            return;
        } else {
            findNode(index);
            node.element = elem;
        }
    }
    
    public boolean remove(int index){
        if(index < 0 || index >= size){
            return false;
        } else {
            if(index == 0){
                if(head.equals(tail)){
                    head = tail = null;
                } else {
                    head = head.next;
                    head.previous = tail;
                }
            } else {
                if(index == size - 1){
                    tail = tail.previous;
                    tail.next = head;
                    head.previous = tail;
                } else {
                    findNode(index);
                    System.out.println("\n asdas "+node.element);
                    node.previous.next = node.next.next;
                    node.next.previous = node.previous;
                    
                }
            }
            size--;
            return true;
        }
    }
    
    public void add(Type elem, int index){
        if(index < 0 || index > size){
            return;
        } else {
            if(index == 0){
                ListNode newElement = new ListNode(elem, tail, null);
                if(head == null){
                    head = newElement;
                    head.previous = head.next = head;
                    newElement = head;
                    tail = newElement;
                } else {
                    newElement.next = head;
                    head.previous = newElement;
                    head = newElement;
                }
            } else {
                if(index == size){
                    ListNode newElement = new ListNode(elem, tail, head);
                    tail.next = newElement;
                    tail = newElement;
                } else {
                    findNode(index);
//                    System.out.println("\n"+index+" "+node.previous.element);
                    ListNode newElement = new ListNode(elem, node.previous, node);
                    node.previous.next = newElement;
                }
            }
            size++;
        }
    }
    
    private void findNode(int index){
        ListNode search = head;
//        System.out.println("\n asfas"+head.element);
        for (int i = 0; i < index; i++) {
            search = search.next;
//            System.out.println("\n  "+search.element+"\n");
        }
        node = search;
    }
    
    public void printList(){
        ListNode print = head;
        System.out.println("\nLISTA DUPLAMENTE ENCADEADA CIRCULAR");
        for (int i = 0; i < size; i++) {
            System.out.println("Índice "+i+": "+print.element);
            print = print.next;
        }
    }
    
}
