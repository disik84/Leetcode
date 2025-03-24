package AddTwoNumbers;

public class MyLinkedList {
    public static void main(String[] args) {
        Util util = new Util();

        ListNode l1 = new ListNode();

        l1.addElementEnd(9);
        l1.addElementEnd(9);
        l1.addElementEnd(9);
        l1.addElementEnd(9);
        l1.addElementEnd(9);
        l1.addElementEnd(9);
        l1.addElementEnd(9);

        System.out.println(l1);

        ListNode l2 = new ListNode();
        l2.addElementEnd(9);
        l2.addElementEnd(9);
        l2.addElementEnd(9);
        l2.addElementEnd(9);

        System.out.println(l2);

        System.out.println("#############");

        util.addTwoNumbers(l1, l2);
    }
}

class Util {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//------V2
        ListNode listNode = null;
        int val;
        ListNode last = null;
        ListNode head = null;

        while (l1 != null && l2 != null) {
            val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            if (listNode == null) {
                listNode = new ListNode(val, null);
                last = listNode;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new ListNode(val, null);
            }
        }

        while (l1 != null && l2 == null) {
            val = l1.val + 0;
            l1 = l1.next;
            if (listNode == null) {
                listNode = new ListNode(val, null);
                last = listNode;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new ListNode(val, null);
            }
        }

        while (l1 == null && l2 != null) {
            val = l2.val + 0;
            l2 = l2.next;
            if (listNode == null) {
                listNode = new ListNode(val, null);
                last = listNode;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new ListNode(val, null);
            }
        }

        System.out.println(listNode);

        head = listNode;
        while (head != null) {

            if (head.val > 9 && head.next != null) {
                head.next.val = head.next.val + 1;
                head.val = head.val - 10;
            } else if (head.val > 9 && head.next == null) {
                while (head.val > 9) {
                    head.next = new ListNode(1, null);
                    head.val = head.val - 10;
                }
                head = head.next;
            }

            head = head.next;
        }
        System.out.println(listNode);
        return listNode;

// -------V1
//        ListNode listNode = null;
//        int val;
//        ListNode head = null;
//        int nextRazryad = 0;
//
//        while (l1 != null && l2 != null) {
//            val = l1.val + l2.val;
//            l1 = l1.next;
//            l2 = l2.next;
//            if (listNode == null) {
//                listNode = new ListNode(val, null);
//                head = listNode;
//            } else {
//                listNode = new ListNode(val, head);
//                head = listNode;
//            }
//        }
//
//        while (l1 != null && l2 == null) {
//            val = l1.val + 0;
//            l1 = l1.next;
//            if (listNode == null) {
//                listNode = new ListNode(val, null);
//                head = listNode;
//            } else {
//                listNode = new ListNode(val, head);
//                head = listNode;
//            }
//        }
//
//        while (l1 == null && l2 != null) {
//            val = l2.val + 0;
//            l2 = l2.next;
//            if (listNode == null) {
//                listNode = new ListNode(val, null);
//                head = listNode;
//            } else {
//                listNode = new ListNode(val, head);
//                head = listNode;
//            }
//        }
//
//        System.out.println(head);
//
//        while (head != null || nextRazryad != 0) {
//
//            if (head.val > 9 && head.next != null) {
//                head.next.val = head.next.val + 1;
//                head.val = head.val - 10;
//            } else if (head.val > 9 && head.next == null) {
//                while (head.val > 9) {
//                    head.next = new ListNode(1, null);
//                    head.val = head.val - 10;
//                }
//                head = head.next;
//            }
//
//            head = head.next;
//        }
//
//        return listNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode head;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.head = this;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void addElementEnd(int val) {
        ListNode listNode = new ListNode(val);
        if (head == null) {
            this.val = val;
            head = this;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = listNode;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

//----------
//class Node {
//    Integer val;
//    Node next;
//
//    public Node(Integer val) {
//        this.val = val;
//        this.next = null;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
//}

//class NodeList {
//    Node nodeList;
//    Node head;
//
//    public NodeList() {
//        this.nodeList = null;
//        this.head = null;
//    }
//
//    void addElementBegin(Integer val) {
//        Node newNode = new Node(val);
//        if (head == null) {
//            newNode.next = null;
//            head = newNode;
//            nodeList = newNode;
//        } else {
//            head = nodeList;
//            newNode.next = head;
//            head = newNode;
//            nodeList = newNode;
//        }
//    }
//
//    void addElementEnd(Integer val) {
//        Node newNode = new Node(val);
//        if (head == null) {
//            newNode.next = null;
//            head = newNode;
//            nodeList = head;
//        } else {
//            while (head.next != null) {
//                head = head.next;
//            }
//            head.next = newNode;
//        }
//    }
//
//    void print() {
//        while (nodeList.next != null) {
//            System.out.println(nodeList.val);
//            nodeList = nodeList.next;
//        }
//        System.out.println(nodeList.val);
//    }
//}