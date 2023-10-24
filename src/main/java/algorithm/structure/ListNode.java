package algorithm.structure;


import lombok.Data;


public class ListNode {

    private Long value;

    private ListNode preNode;
    private ListNode nextNode;

    public ListNode(Long value) {
        this.value =value;
    }


    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public ListNode getPreNode() {
        return preNode;
    }

    public void setPreNode(ListNode preNode) {
        this.preNode = preNode;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
