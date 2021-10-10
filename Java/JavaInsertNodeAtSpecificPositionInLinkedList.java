public class JavaInsertNodeAtSpecificPositionInLinkedList {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        // Write your code here
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            SinglyLinkedListNode temp = llist;
     
            if(llist == null){
                 return node;
            }
            int i=0;
            while(i < position-1) {
                temp = temp.next;
                i++;
            }
            node.next = temp.next;
            temp.next = node;
            
            SinglyLinkedListNode ans = llist;
            return ans;
    }
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

}
