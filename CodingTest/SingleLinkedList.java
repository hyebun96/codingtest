package CodingTest;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public static class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<>(data);
        } else {
            Node<T> lastNode = this.head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = new Node<>(data);
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> searchData(T data){
        Node<T> node = head;

        if(node == null){
            return null;
        }

        while(node != null){
            if(node.data.equals(data)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void addNodeInside(T data, T insideData){
        Node<T> previousNode = searchData(data);

        if(previousNode == null) {
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            Node<T> backNode = previousNode.next;
            Node<T> insideNode = new Node<>(insideData);

            previousNode.next  = insideNode;
            insideNode.next = backNode;

        }
    }

    public void deleteNode(T data){
        Node<T> deleteNode = searchData(data);

        if(deleteNode == null){
            System.out.println(data + " => 삭제할 노드를 찾지 못했습니다.");
        } else {
            Node<T> node = this.head;
            while(node.next != null){
                if(node.next == deleteNode){
                    node.next = deleteNode.next;
                    break;
                } else{
                    node = node.next;
                }
            }
        }

    }

    public static void main(String[] args) {

       SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
       myLinkedList.addNode(1);
       myLinkedList.addNode(2);
       myLinkedList.addNode(3);

       myLinkedList.addNodeInside(1, 5);
       myLinkedList.addNodeInside(1, 9);
       myLinkedList.addNodeInside(4, 8);
       // 195238

        myLinkedList.deleteNode(5);
        myLinkedList.deleteNode(8);
        myLinkedList.deleteNode(4);

       myLinkedList.printAll();

    }
}
