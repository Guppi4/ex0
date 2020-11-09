package ex0;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Graph_DS implements graph {


    private int eS=0;//number of eages in graph
    private int ms=0;//number of all actyvity in graph
    private HashMap< Integer,node_data> nodeMap = new HashMap<Integer, node_data>();// data struct for nodes in graph
public Graph_DS
        (HashMap< Integer,node_data> no){
    this.nodeMap=no;
}

    public Graph_DS() {

    }


    public node_data getNode(int key){
       if(this.nodeMap.get(key)!=null) {
           return this.nodeMap.get(key);
       }
        return null;
    }
    






    public boolean hasEdge(int node1, int node2) {
      node_data a=getNode(node1);
      node_data b=getNode(node2);
      if(a!=null && b!=null && a.getNi().contains(b)) {
          return true;
      }
      return false;
    }


    public void addNode(node_data n) {
           if(nodeMap.get(n)!=null){
               return;
           }
           this.ms++;

       this.nodeMap.put(n.getKey(),n);

    }


    public void connect(int node1, int node2) { //connect node1 with node 2
        node_data a=getNode(node1);
        node_data b=getNode(node2);

    if(node1==node2){

            return;
        }


        if( a!=null && b!=null  && !a.getNi().contains(b)){

         a.addNi(b);
            b.addNi(a);
         this.eS++;
         this.ms++;
     }
   else
       return;

}


    public Collection<node_data> getV() {
        Collection<node_data> co = this.nodeMap.values();
        return co;
    }


    public Collection<node_data> getV(int node_id) {
       node_data c=getNode(node_id);
       Collection<node_data>c2= c.getNi();
       return c2;
    }

    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(n), |V|=n, as all the edges should be removed.
     * @return the data of the removed node (null if none).
     * @param key
     */
    public node_data removeNode(int key) {
       if(nodeMap.containsKey(key)==false){
           return null;
       }


        node_data a=getNode(key);

          for (node_data b : a.getNi()) {
              //System.out.println(this.eS);
              //System.out.println(b.getKey());
              b.removeNode(a);
              this.eS--;

          }



          this.nodeMap.remove(key);
         this.ms++;
          return a;



    }


    public void removeEdge(int node1, int node2) {
        node_data c=getNode(node1);
        node_data c2=getNode(node2);
        if(c.getNi().contains(c2)){
           c.removeNode(c2);
           c2.removeNode(c);
            this.eS--;
            this.ms++;
        }


    }


    public int nodeSize() {
        return this.nodeMap.size();
    }


    public int edgeSize() {
        return this.eS;
    }


    public int getMC() {
        return this.ms;
    }





}
