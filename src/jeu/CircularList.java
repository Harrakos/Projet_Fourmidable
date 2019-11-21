package jeu;

public class CircularList<Type> {
    private Node node;
    private Node last;
    private int size;
    public CircularList()
    {
        node=null;//Création d'une chaine vide
        last=null;
        size=0;
    }

    public void add(Type s)
    {
        if (size==0)//Si la chaine est vide
        {
            this.node= new Node(s);
            this.node.next=this.node;
            last=node;
            size=1;
        }
        else
        {
            Node addNode= new Node(s);
            addNode.next=last.next;
            last.next=addNode;
            last=addNode;
            size++;
        }
    }

    private class Node
    {
        private Type data;
        private Node next;
        public Node(Type data)
        {
            this.data=data;
            this.next=null;
        }
    }

}
