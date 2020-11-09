package ex0;
import java.util.*;

public class Graph_Algo implements graph_algorithms {
    private Graph_DS gr;//

    public Graph_Algo(graph grap) {
        this.init(grap);
    }


    public Graph_Algo() {
        Graph_DS gr = new Graph_DS();
        this.init(gr);
    }

    public void init(graph g) {
        if (g instanceof Graph_DS) {
            this.gr = (Graph_DS) g;
        }

    }

    public graph copy() {//deep copy of graph

        graph gk = new Graph_DS();


        for (node_data n : gr.getV()) {
           //System.out.println(n);
            node_data no = new NodeData(n);

              gk.addNode(no);


           

        }

        for (node_data na : gr.getV()) {
           // System.out.println(na);
             for(node_data na2:na.getNi()){
                //System.out.println(na2);
                  gk.connect(na.getKey(),na2.getKey());
             }
        }





        return gk;
    }


    public boolean isConnected() {   //cheaking using afinction BFS if graph connected
      int m=0;
      int m2=1;
      int m3=0;
       int m4=0;
        //System.out.println(gr.nodeSize());
        for (node_data n : gr.getV()) {

            m4++;



        }

       if(gr.nodeSize()==0){

            return true;
        }



       if(gr.nodeSize()==1){
          // System.out.println(gr.nodeSize());
           return true;
   }



        //System.out.println(gr.nodeSize());
      for (node_data n : gr.getV()) {

          m3=n.getKey();


          break;
      }
       if(gr.getNode(m3)==null){
           return true;
}
         if(BFS2(m3,gr)==m4){

            //
             return true;
         }
         else
           return  false;



    }


    public int shortestPathDist(int src, int dest) {
          if(src==dest){
              return 0;
          }

            BFS(src,gr);
        node_data  n=gr.getNode(dest);
       int s=n.getTag();
       if(s==0){
           return -1;
       }

            return s;
    }

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */

    public List<node_data> shortestPath(int src, int dest) {
      if(src==dest){
          return null;
      }
       if(gr.getNode(src)==null ||gr.getNode(dest)==null){
           return null;
       }

           LinkedList<node_data> list = new LinkedList<node_data>();
        BFS(src,gr);
        //System.out.println(gr.getNode(dest).getKey()+" "+gr.getNode(dest).getTag());
        node_data k=gr.getNode(dest);

        list.addFirst(k);
        while(k.getTag()!=0){
            for (node_data n : k.getNi()){
                if((k.getTag()-n.getTag())==1){
                   // System.out.println(n.getKey()+" "+n.getTag());
                    list.addFirst(n);
                       k=n;
                   // System.out.println( n.getTag());
                }
            }



    }
        //System.out.println(list.size());
               return (List<node_data>)list;
    }
    /**
     * algoritm BFS for funtion "isconnected"
     *
     * @param src - start node
     * @param g - end (target) node
     * @return
     */

    public int BFS2(int src,graph g){

        for (node_data n : g.getV()) {
           // System.out.println(n);
            n.setInfo("white");
            n.setTag(0);

        }
        int numNode = 0;

        //System.out.println(gr.getNode(src));
        gr.getNode(src).setInfo("gray");
        Queue<node_data> q = new LinkedList<node_data>();
        q.offer(gr.getNode(src));

        while (!q.isEmpty()) {
            node_data qq = q.remove();
            for(node_data a:qq.getNi()){
                if(a.getInfo()=="white"){
                    int scrr=qq.getTag();
                    a.setTag(scrr+1);

                    node_data k=g.getNode(a.getKey());
                    k.setInfo("grey");
                    q.offer(k);
                }
            }
            qq.setInfo("black");
            numNode++;
        }

        for (node_data n : g.getV()) {
            n.setInfo("");
            n.setTag(0);

        }
        return numNode;

    }

    /**
     * algoritm BFS for funtion "shortestPath" and "shortestpathdist"
     *
     * @param src - start node
     * @param g - end (target) node
     * @return
     */


    public void BFS(int src,graph g){
        for (node_data n : g.getV()) {
            n.setInfo("white");
            n.setTag(0);

        }
       // int numNode = 0;

        gr.getNode(src).setInfo("gray");
        Queue<node_data> q = new LinkedList<node_data>();
        q.offer(gr.getNode(src));

        while (!q.isEmpty()) {
            node_data qq = q.remove();
            for(node_data a:qq.getNi()){
                if(a.getInfo()=="white"){
                    int scrr=qq.getTag();
                    a.setTag(scrr+1);

                    node_data k=g.getNode(a.getKey());
                    k.setInfo("grey");
                    q.offer(k);

                }
            }
            qq.setInfo("black");
            //numNode++;
        }




    }
}


