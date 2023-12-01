package review;

public class MyLinkedList<E> {

    private Node<E> head;
    private int numNode;

    // class lồng class
    private class Node<E> {
        public Object data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;

        }
    }

    public MyLinkedList(E data){
        this.head = new Node<>(data);
        numNode++;
    }

    public void addFirst(E data){
        Node<E> temp = head;
        head=new Node<>(data);
        head.next=temp;
    }

    public Node getElementById(int index) {
        Node temp = head;
        int i = 0;
        while (temp.next != null){
            if(i == index){
//                System.out.println(head.data);
//                break;
                return temp;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }
    public void addNode(int index,E data) {
//        Node temp = (Node) getElementById(index - 1);
//        Node node = new Node<>(data);
//        node.next= (Node) getElementById(index);
//        temp.next = node;

          Node node = new Node(data);
          Node temp = getElementById(index - 1);
          Node temp2 = temp.next;

          temp.next = node;
          node.next = temp2;
          numNode++;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(1);
        linkedList.addFirst(6);
        linkedList.addFirst(8);
        linkedList.addFirst(5);
        linkedList.addFirst(2);

        System.out.println(linkedList.getElementById(3).data);
        linkedList.addNode(4, 10);
        System.out.println(linkedList.getElementById(3).data);
    }
}
