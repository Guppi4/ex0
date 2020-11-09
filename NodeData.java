package ex0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public  class NodeData implements node_data {
    private int id,tag;
    private String info;
    private static int c=0;
    private HashSet<node_data> neighbors;
   public NodeData(int key){
   this.id=key;
}
   
    public NodeData(node_data n){
        this.id=n.getKey();
        this.info=n.getInfo();
        this.tag=n.getTag();
        this.neighbors=new HashSet<>();

    }

  public NodeData(int key, Collection<node_data> ni) {
        this.id=key;
        this.neighbors= (HashSet<node_data>) ni;
    }

    public Collection<node_data> getNi(){

        return this.neighbors;
    }
    public int getKey() {
        return this.id;
    }
    public String getInfo(){
        return this.info;
    }
    public void setInfo(String s){
        this.info=s;
    }
    public int getTag(){
        return this.tag;
    }
    public void setTag(int t){
        this.tag=t;
    }
    /**
     * return true iff this<==>key are adjacent</==>
     * @param key
     * @return
     */

    public boolean hasNi(int key) {
        boolean ar = false;
        for (node_data num : this.neighbors) {

            if (num.getKey() == key) {

                ar = true;
                return ar;
            }
        }
        return ar;
    }


    public void addNi(node_data t){
        if(t!=null) {
            this.neighbors.add(t);
        }
    }


    public void removeNode(node_data node) {
        this.neighbors.remove(node);
    }


    public NodeData(){
        this.id=c;
        this.c++;
        this.info="";
        this.tag=0;
        HashSet<node_data> neighbors=new HashSet<node_data>();
        this.neighbors=neighbors;
    }

}
