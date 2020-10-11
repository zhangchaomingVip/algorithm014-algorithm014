class LRUCache {
    /**
     * 维护一个双向链表，map里面存节点的key，淘汰根据Key在链表中的位置进行淘汰
     */
    class DLinkedNode {
        private int key;
        private int value;
        private DLinkedNode next;
        private DLinkedNode prev;
        public DLinkedNode(){};
        public DLinkedNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        };
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;
    private int capacity;
    private Map<Integer,DLinkedNode> map = new HashMap<>();
    
    //map+双向链表
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    

    public int get(int key) {
      DLinkedNode node =  map.get(key);
      if(node == null) {
          return -1;
      }
      moveToHead(node);
      return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node =  map.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key,value);
            addHead(newNode);
            map.put(key,newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail =  removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    //1-2-3-4-5
    public void addHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //1-2-3-4-5
    public void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addHead(node);
    }


    public DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }


}