package CodingTest;

public class MyTree {
    Node head = null;

    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insertNode(int data) {
        // Case1 : Node가 하나도 없을 떄
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // Case2 : Node 가 하나 이상 있을 경우
            Node findNode = this.head;
            while (true) {
                // case2-1 : 현재 Node의 왼쪽에 Node 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    // case2-2 : 현재 Node의 오른쪽에 Node 가 들어가야 할 때
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
    }

    public Node searchNode(int data) {
        Node findNode = this.head;

        // Case 1 : Node가 하나도 없을 경우
        if (findNode == null) {
            return null;
        } else {
            // Case 2 : Node가 하나 이상일 경우
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public Node findParentNode(int data){
        Node parentNode = this.head;
        Node childNode;

        // Case 1 : Node가 없을 경우
        if(parentNode == null){
            return null;
        } else {
            // Case 2 : Node가 하나 이상 있는 경우
            // data와 parentNode.value 값 비교 후 childNode 설정
            childNode = ((data < parentNode.value) ? parentNode.left : parentNode.right);

            while(childNode != null){
                // Case 2-1 : childNode value가 찾는 data 인 경우
                if(childNode.value == data){
                    return parentNode;
                } else {
                    // Case 2-2 :  childNode value가 아닌 경우
                    parentNode = childNode;
                    childNode = ((data < parentNode.value) ? parentNode.left : parentNode.right);
                }
            }
        }

        return parentNode;
    }


    public boolean deleteNode(int data) {
        Node searchNode = searchNode(data);
        Node parentNode = findParentNode(data);

        // Case 1 : Node가 없을 경우
        if (searchNode == null) {
            return true;
        } else {

            // Case 2 : Node가 하나 이상 있는 경우
            if(searchNode.value == data && searchNode.left == null && searchNode.right == null){
                // Case 2-1 : Node가 childNode가 하나도 없는 leafNode 인경우
                if(data < parentNode.value){
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }


            else if (searchNode.left == null || searchNode.right == null){
                // Case 3 : Node의 childNode가 하나인  인경우
                if(data < parentNode.value){
                    parentNode.left = (searchNode.left == null ? searchNode.right : searchNode.left);
                } else {
                    parentNode.right = (searchNode.left == null ? searchNode.right : searchNode.left);
                }
            }


            else {
                // Case 4 : Node의 childNode가 두개인  인경우
                Node changeNode = searchNode.right;
                Node changeParentNode = searchNode.right;

                while(changeNode.left != null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if(changeNode.right != null){
                    // Case 4-1 : 삭제할 Node가 부모 Node의 왼쪽에 있을 경우.
                    changeParentNode.left= changeNode.right;
                } else {
                    // Case 4-2 : 삭제할 Node가 부모 Node의 오른쪽에 있을 경우.
                    changeParentNode.left = null;
                }

                if(data < parentNode.value){
                    parentNode.left = changeNode;
                } else {
                    parentNode.right = changeNode;
                }

                changeNode.right = searchNode.right;
                changeNode.left = searchNode.left;

            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println("\n(1) 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 왼쪽에 있을 때)");
        MyTree tree = new MyTree();

        tree.insertNode(10);
        tree.insertNode(15);
        tree.insertNode(13);
        tree.insertNode(11);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(16);
        tree.insertNode(19);
        tree.insertNode(17);
        tree.insertNode(7);
        tree.insertNode(8);
        tree.insertNode(6);

        System.out.println(tree.deleteNode(15));
        System.out.println("HEAD: " + tree.head.value);
        System.out.println("HEAD LEFT: " + tree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + tree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + tree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + tree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + tree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + tree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + tree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + tree.head.right.right.right.value);

        System.out.println("\n------------------------- ");
        System.out.println("\n(2) 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 오른쪽에 있을 때)");
        tree = new MyTree();

        tree.insertNode(31);
        tree.insertNode(15);
        tree.insertNode(13);
        tree.insertNode(11);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(16);
        tree.insertNode(19);
        tree.insertNode(17);
        tree.insertNode(41);
        tree.insertNode(40);
        tree.insertNode(51);

        System.out.println(tree.deleteNode(15));
        System.out.println("HEAD: " + tree.head.value);
        System.out.println("HEAD LEFT: " + tree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + tree.head.left.left.value);
        System.out.println("HEAD LEFT LEFT LEFT: " + tree.head.left.left.left.value);

        System.out.println("HEAD LEFT RIGHT: " + tree.head.left.right.value);
        System.out.println("HEAD LEFT RIGHT LEFT: " + tree.head.left.right.left.value);
        System.out.println("HEAD LEFT RIGHT RIGHT: " + tree.head.left.right.right.value);

        System.out.println("HEAD RIGHT: " + tree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + tree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + tree.head.right.right.value);


    }
}
