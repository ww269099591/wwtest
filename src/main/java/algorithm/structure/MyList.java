package algorithm.structure;

import lombok.Data;

@Data
public class MyList {
    private ListNode headNode;


    public MyList() {
    }


    public MyList(int length) {
        long random = Math.round(Math.random() * 100);
        headNode = new ListNode();
        ListNode presentNode = headNode;
        for (int i = 0; i < length - 1; i++) {
            random = Math.round(Math.random() * 100);
            presentNode.setNextNode(new ListNode());
            presentNode.getNextNode().setPreNode(presentNode);
            presentNode = presentNode.getNextNode();
        }
        System.out.println(this.toString());
    }

    public void deleteIndexOf(int n) {
        ListNode preNode = headNode;
        ListNode presentNode = headNode;
        for (int i = 0; i < n; i++) {
            preNode = presentNode;
            presentNode = headNode.getNextNode();
        }
        if (presentNode.getNextNode() == null) {
            return;
        }
        preNode.setNextNode(presentNode.getNextNode());
    }


    /**
     * 删除倒数第n个节点
     */
    public void deleteDescIndexOf(int n) {

    }

    @Override
    public String toString() {
        if (headNode == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ListNode presidentNode = headNode;
        while (presidentNode.getNextNode() != null) {
            sb.append(presidentNode.getValue() + "=>");
            presidentNode = presidentNode.getNextNode();
        }
        sb.append(presidentNode);
        return sb.toString();
    }


}
