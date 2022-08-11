package DataStructure;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) { this.data = data;}
    }

    public void addNode(T data){
       Node<T> node = this.head;
       Node<T> lastNode = this.tail;
       Node<T> addNode = new Node<>(data);

        if(node == null){
            this.head = addNode;
        } else {
            lastNode.next = addNode;
            addNode.prev = lastNode;
        }
        this.tail = addNode;
    }

    public void printAll(){
        if(head == null) {
            System.out.println("출력할 노드가 없습니다.");
        } else {
            Node<T> node = this.head;
            while(node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public Node<T> searchFromHead(T data){
        if(this.head == null){
            System.out.println("노드가 비어있습니다.");
            return null;
        } else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data.equals(data)){
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public Node<T> searchFromTail(T data){
        if(this.tail == null){
            System.out.println("노드가 비어있습니다.");
            return null;
        } else{
            Node<T> node = this.tail;
            while(node != null){
                if (node.data.equals(data)) {
                    return node;
                }
                node = node.prev;
            }
        }
        return null;
    }

    // 임의 노드 앞에 노드 추가하기
    public void insertToFront(T backData , T insertData){
        Node<T> backNode = searchFromHead(backData);
        Node<T> insertNode = new Node<>(insertData);

        if(backNode == null){
            if(this.head == null){
                System.out.println("리스트가 비어있어 새로 추가함.");
                addNode(insertData);
            } else {
                System.out.println("리스트 내에 찾는 노드가 없음.");
            }
        } else if(this.head.equals(this.tail)){
            this.tail.prev = insertNode;
            insertNode.next = tail;
            this.head = insertNode;
        } else {
            Node<T> previousNode = backNode.prev;
            if(backNode.prev == null){
                backNode.prev = insertNode;
                insertNode.next = backNode;
                this.head = insertNode;
            } else {
                previousNode.next = insertNode;
                insertNode.prev = previousNode;
                insertNode.next = backNode;
                backNode.prev = insertNode;
            }
        }

    }


    public static void main(String[] args){

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(5);
        doubleLinkedList.addNode(8);
        doubleLinkedList.addNode(3);

        doubleLinkedList.printAll();
        // 24583

        System.out.println("-----------------------");
        doubleLinkedList.insertToFront(3, 10);
        doubleLinkedList.insertToFront(2, 10);
        doubleLinkedList.insertToFront(0, 10);

        doubleLinkedList.printAll();

        System.out.println("\n\n----------------------->   test2");
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }
}
