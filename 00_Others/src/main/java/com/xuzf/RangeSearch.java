package com.xuzf;


import java.util.*;

/****
 * 位图广度搜索
 */
public class RangeSearch {
    public static void main(String[] args){
        //初始化先建立起各个节点信息，以及对应的直接子节点列表
        HashMap<String,String[]> map = new HashMap<String,String[]>();
        map.put("A", new String[] {"B","C"});
        map.put("B", new String[] {"E"});
        map.put("C", new String[] {"D","F"});
        map.put("D", new String[] {"E"});
        map.put("E", new String[] {"H"});
        map.put("F", new String[] {"E","G"});
        map.put("G", new String[] {"H"});
        map.put("H", new String[] {});
        //获取从A到H的最短路径节点链表
        GraphNode target = findTarget("A","H",map);
        //打印出最短路径的各个节点信息
        printSearPath(target);

    }

    /**
     * 打印出到达节点target所经过的各个节点信息
     * @param target
     */
    static void printSearPath(GraphNode target) {
        if (target != null) {
            System.out.print("找到了目标节点:" + target.id + "\n");
            List<GraphNode> searchPath = new ArrayList<GraphNode>();
            searchPath.add(target);
            GraphNode node = target.parent;
            while(node!=null) {
                searchPath.add(node);
                node = node.parent;
            }
            String path = "";
            for(int i=searchPath.size()-1;i>=0;i--) {
                path += searchPath.get(i).id;
                if(i!=0) {
                    path += "-->";
                }
            }
            System.out.print("步数最短："+path);
        } else {
            System.out.print("未找到了目标节点");
        }
    }

    /**
     * 从指定的开始节点 startId ，查询到目标节点targetId 的最短路径
     * @param startId 开始节点
     * @param targetId 目标节点
     * @param map
     * @return
     */
    static GraphNode findTarget(String startId,String targetId,HashMap<String,String[]> map) {
        //用来存放已搜索的队列
        List<String> hasSearchList = new ArrayList<String>();
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        //首先把头节点存放到一个队列里
        queue.offer(new GraphNode(startId,null));
        while(!queue.isEmpty()) {//如果队列不为空，表示还没遍历完
            GraphNode node = queue.poll();//弹出队列节点
            if(hasSearchList.contains(node.id)) {//跳过已经搜索过的，避免互相引用或者重复或者死循环
                continue;
            }
            System.out.print("判断节点:" + node.id +"\n");
            if (targetId.equals(node.id)) {//如果找到目标节点
                //直接return,可以避免查找长度更长的路径
                return node;
            }
            hasSearchList.add(node.id);//记录已遍历的节点ID
            //如果当前遍历的节点还有下一级的节点，则把下一级的节点放入队列
            if (map.get(node.id) != null && map.get(node.id).length > 0) {
                for (String childId : map.get(node.id)) {
                    queue.offer(new GraphNode(childId,node));
                }
            }
        }

        return null;
    }

    /**
     * 节点对象
     *
     */
    static class GraphNode{
        //节点唯一id
        public String id;
        //该节点的直接父节点
        public GraphNode parent;
        //该节点的直接子节点
        public List<GraphNode> childs = new ArrayList<GraphNode>();
        public GraphNode(String id,GraphNode parent) {
            this.id = id;
            this.parent = parent;
        }
    }

}
