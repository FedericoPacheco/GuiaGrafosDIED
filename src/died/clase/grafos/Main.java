package died.clase.grafos;

public class Main {
	
	public static void main(String[] args) 
	{
		Digraph<Integer> G1 = new Digraph<Integer>();
		
		// "Digraph" from exercise 2a is used, with another subdigraph not connected to the original
		G1.addVertex(1);
		G1.addVertex(2);
		G1.addVertex(3);
		G1.addVertex(4);
		G1.addVertex(5);
		G1.addVertex(6);
		G1.addVertex(7);
		G1.addVertex(8);
		G1.addVertex(9);
		
		G1.link(1, 2);
		G1.link(1, 4);
		G1.link(2, 5);
		G1.link(2, 7);
		G1.link(5, 4);
		G1.link(5, 6);
		G1.link(5, 7);
		G1.link(7, 3);
		G1.link(6, 3);
		G1.link(3, 4);
		G1.link(4, 1);
		G1.link(8, 9);
		
		System.out.println("[vertex: indegree, outdegree]");
		System.out.println("[1: " + G1.inDegree(G1.getVertex(1)) + ", " + G1.outDegree(G1.getVertex(1)) + "]");
		System.out.println("[2: " + G1.inDegree(G1.getVertex(2)) + ", " + G1.outDegree(G1.getVertex(2)) + "]");
		System.out.println("[3: " + G1.inDegree(G1.getVertex(3)) + ", " + G1.outDegree(G1.getVertex(3)) + "]");
		System.out.println("[4: " + G1.inDegree(G1.getVertex(4)) + ", " + G1.outDegree(G1.getVertex(4)) + "]");
		System.out.println("[5: " + G1.inDegree(G1.getVertex(5)) + ", " + G1.outDegree(G1.getVertex(5)) + "]");
		System.out.println("[6: " + G1.inDegree(G1.getVertex(6)) + ", " + G1.outDegree(G1.getVertex(6)) + "]");
		System.out.println("[7: " + G1.inDegree(G1.getVertex(7)) + ", " + G1.outDegree(G1.getVertex(7)) + "]");
		System.out.println("[8: " + G1.inDegree(G1.getVertex(8)) + ", " + G1.outDegree(G1.getVertex(8)) + "]");
		System.out.println("[9: " + G1.inDegree(G1.getVertex(9)) + ", " + G1.outDegree(G1.getVertex(9)) + "]");
		
		System.out.println();
		System.out.println("G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(7), 2): " + G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(7), 2));
		System.out.println("G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE): " + G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE));
		System.out.println("G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE): " + G1.pathExistsRecursive(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE));
		
		System.out.println();
		System.out.println("G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(7), 2).toString(): " + G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(7), 2).toString());
		System.out.println("G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE).toString(): " + G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE).toString());
		System.out.println("G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE).toString(): " + G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE).toString());
		System.out.println("G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(1), Integer.MAX_VALUE).toString(): " + G1.allPathsRecursive(G1.getVertex(1), G1.getVertex(1), Integer.MAX_VALUE).toString());
		
		
		System.out.println();
		System.out.println("G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(7), 2): " + G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(7), 2));
		System.out.println("G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE): " + G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE));
		System.out.println("G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE): " + G1.pathExistsIterative(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE));
		
		System.out.println();
		System.out.println("G1.allPathsIterative(G1.getVertex(1), G1.getVertex(7), 2): " + G1.allPathsIterative(G1.getVertex(1), G1.getVertex(7), 2));
		System.out.println("G1.allPathsIterative(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE): " + G1.allPathsIterative(G1.getVertex(1), G1.getVertex(7), Integer.MAX_VALUE));
		System.out.println("G1.allPathsIterative(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE): " + G1.allPathsIterative(G1.getVertex(1), G1.getVertex(9), Integer.MAX_VALUE));
		
		
		Digraph<String> G2 = new Digraph<String>();
		
		G2.addVertex("A");
		G2.addVertex("B");
		G2.addVertex("C");
		
		G2.link("A", "B");
		G2.link("A", "C");
		G2.link("B", "C");
		
		
		System.out.println();
		System.out.println("G1.isComplete():" + G1.isComplete());
		System.out.println("G2.isComplete():" + G2.isComplete());
		
		//https://gyazo.com/2e32b302918d6884e86406561e3503f6
		Digraph<String> G3 = new Digraph<String>();
		
		G3.addVertex("A");
		G3.addVertex("B");
		G3.addVertex("C");
		G3.addVertex("D");
		G3.addVertex("E");
		G3.addVertex("F");
		G3.addVertex("G");
		
		G3.link("E", "A");
		G3.link("E", "D");
		G3.link("E", "F");
		G3.link("A", "D");
		G3.link("A", "B");
		G3.link("B", "D");
		G3.link("B", "C");
		G3.link("D", "C");
		G3.link("D", "G");
		G3.link("D", "F");
		G3.link("G", "F");
		
		System.out.println();
		System.out.println("G3.topologicalOrder().toString(): " + G3.topologicalOrder().toString());
		
		Digraph<String> G4 = new Digraph<String>();
		
		G4.addVertex("t1");
		G4.addVertex("t2");
		G4.addVertex("t3");
		G4.addVertex("t4");
		G4.addVertex("t5");
		G4.addVertex("t6");
		G4.addVertex("t7");
		G4.addVertex("t8");
		
		G4.link("t1", "t2");
		G4.link("t1", "t3");
		G4.link("t2", "t3");
		G4.link("t2", "t8");
		G4.link("t3", "t6");
		G4.link("t4", "t5");
		G4.link("t5", "t6");
		G4.link("t5", "t7");
		G4.link("t7", "t8");
		
		System.out.println();
		System.out.println("G4.topologicalOrder().toString(): " + G4.topologicalOrder().toString());
		
		Digraph<String> G5 = new Digraph<String>();
		
		G5.addVertex("t1");
		G5.addVertex("t2");
		G5.addVertex("t3");
		G5.addVertex("t4");
		G5.addVertex("t5");
		G5.addVertex("t6");
		G5.addVertex("t7");
		G5.addVertex("t8");
		G5.addVertex("t9");
		G5.addVertex("t10");
		G5.addVertex("t11");
		
		G5.link("t1", "t4");
		G5.link("t2", "t6");
		G5.link("t3", "t7");
		G5.link("t6", "t4");
		G5.link("t6", "t7");
		G5.link("t4", "t8");
		G5.link("t6", "t8");
		G5.link("t7", "t9");
		G5.link("t8", "t9");
		G5.link("t3", "t10");
		G5.link("t9", "t11");
		G5.link("t10", "t11");
		
		System.out.println();
		System.out.println("G5.topologicalOrder().toString(): " + G5.topologicalOrder().toString());
		
		Digraph<String> G6 = new Digraph<String>();
		
		G6.addVertex("A");
		G6.addVertex("B");
		G6.addVertex("C");
		G6.addVertex("D");
		
		G6.link("A", "B");
		G6.link("B", "A");
		G6.link("A", "C");
		G6.link("C", "A");
		G6.link("A", "D");
		G6.link("D", "A");
		
		System.out.println();
		System.out.println("G6.eccentricity(G6.getVertex(\"A\")): " + G6.eccentricity(G6.getVertex("A")));
		System.out.println("G6.eccentricity(G6.getVertex(\"B\")): " + G6.eccentricity(G6.getVertex("B")));
		System.out.println("G6.eccentricity(G6.getVertex(\"C\")): " + G6.eccentricity(G6.getVertex("C")));
		System.out.println("G6.eccentricity(G6.getVertex(\"D\")): " + G6.eccentricity(G6.getVertex("D")));
	}
}
