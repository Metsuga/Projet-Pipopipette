import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graphe {
    HashMap<Integer, Configuration> m;
    HashMap<Integer,LinkedList<Integer>> adj;

    public Graphe(int l,int L){
        m=new HashMap<Integer, Configuration>();
        Configuration p =new Plateau(l,L);
        m.put(new Integer(p.hashCode()),p);
        adj=new HashMap<Integer,LinkedList<Integer>>();
        Generateur.generate(new Integer(p.hashCode()),this);
    }

    public boolean toDot(String fichier)
            throws IOException {
        Configuration c;
        Integer i=new Integer(0);
        File fic = new File(fichier);
        PrintWriter b = new PrintWriter(new FileWriter(fic), true);
        b.println("digraph default {");
        b.println("graph[labelloc=\"t\"  fontsize=16 fontcolor=\"blue\"");
        b.println("label=\"Graphe des configurations d'un jeu de pipopipette\\n et calcul d'une stratégie gagnante\\n\\n\"]");
        b.println();
        b.println("node [shape=box fontname = \"Courier New\" color=\"sienna\"]");
        b.println("edge [fontname = \"Times\" fontcolor=\"sienna\"]");
        Iterator<Integer> it=m.keySet().iterator();
        while(it.hasNext()) {
            i = (Integer) it.next();
            b.println(m.get(i).toDot(i, 0));
        }
        b.println();
        b.println();
        it=adj.keySet().iterator();
        Iterator<Integer> it2;
        while(it.hasNext()) {
            i = (Integer) it.next();
            it2=adj.get(i).iterator();
            while(it2.hasNext())
                b.println("N"+i+"->N"+(Integer)it2.next());
        }
        b.println("}");
        b.close();
        return true;
    }

    public Configuration getConf(Integer i){
        return m.get(i);
    }

    public void ajouteConf(Configuration c){
        if(!m.containsKey(c.hashCode()))
            m.put(c.hashCode(),c);
    }
    public void ajoutListe(Integer i,LinkedList<Integer> list){
        if(!adj.containsKey(i))
            adj.put(i,list);
    }

    public String toString(){
        return "les config:\n"+m.toString()+"\n liste de adj"+adj.toString();
    }

    public LinkedList<Integer> jeuPossible(Configuration c){
            return adj.get(c.hashCode());
    }
}

