package algorithm;

import algorithm.structure.ListNode;
import algorithm.structure.MyList;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LRUStrategy {

    private Integer size = 2;

    private Map<Integer, ListNode> map = new HashMap<>();

    private MyList myList = new MyList();

    public void put(int key, ListNode value) {
        if (map.get(key) != null) {
            ListNode node = map.get(key);
            node.setNextNode(myList.getHeadNode());
            myList.getHeadNode().setPreNode(node);
            node.getPreNode().setNextNode(null);
            myList.setHeadNode(node);
            return;
        }
        if (map.size() < size) {
            map.put(key, value);
            if (myList.getHeadNode() == null) {
                myList.setHeadNode(value);
            } else {
                value.setNextNode(myList.getHeadNode());
                myList.getHeadNode().setPreNode(value);
                myList.setHeadNode(value);
            }
        } else {
            //TODO 删除尾巴 并且map移除key
        }

    }

    public ListNode get(int key) {
        return map.get(key);
    }

    public void outOfSize() {

    }

    public static void main(String[] args) {
        LRUStrategy lru = new LRUStrategy();
        lru.put(1, new ListNode());
        lru.put(2, new ListNode());
        lru.put(1, new ListNode());
        lru.put(3, new ListNode());
        //size 是 2，预期为空
        lru.get(1);

    }


}
