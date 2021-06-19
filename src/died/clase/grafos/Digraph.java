package died.clase.grafos;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Digraph <T> {
	private List<Edge<T>> edges;
	private List<Vertex<T>> vertices;

	public Digraph(){
		this.edges = new ArrayList<Edge<T>>();
		this.vertices = new ArrayList<Vertex<T>>();
	}

	public Digraph<T> addVertex(T nodo){
		 this.addVertex(new Vertex<T>(nodo));
		 return this;
	}

	private void addVertex(Vertex<T> nodo){
		this.vertices.add(nodo);
	}
	
	public Digraph<T> link(T n1,T n2){
		this.link(getVertex(n1), getVertex(n2), 1.0);
		return this;
	}

	public Digraph<T> link(T n1,T n2,Number valor){
		this.link(getVertex(n1), getVertex(n2), valor);
		return this;
	}

	private void link(Vertex<T> nodo1,Vertex<T> nodo2,Number valor){
		this.edges.add(new Edge<T>(nodo1,nodo2,valor));
	}
	
	public Vertex<T> getVertex(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertex<T>(valor)));
	}

	public List<T> getNeighbourhood(T valor){ 
		Vertex<T> unNodo = this.getVertex(valor);
		List<T> salida = new ArrayList<T>();
		for(Edge<T> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd().getValue());
			}
		}
		return salida;
	}
	

	private List<Vertex<T>> getNeighbourhood(Vertex<T> unNodo){ 
		List<Vertex<T>> salida = new ArrayList<Vertex<T>>();
		for(Edge<T> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd());
			}
		}
		return salida;
	}
	
	public void printEdges(){
		System.out.println(this.edges.toString());
	}

    protected Edge<T> findEdge(T v1, T v2){
    	return this.findEdge(new Vertex<T>(v1), new Vertex<T>(v2));
    }

    private boolean isAdjacent(Vertex<T> v1,Vertex<T> v2){
    	List<Vertex<T>> ady = this.getNeighbourhood(v1);
        for(Vertex<T> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
   
    protected Edge<T> findEdge(Vertex<T> v1, Vertex<T> v2){
    	for(Edge<T> unaArista : this.edges) {
    		
    		if(unaArista.getOrigin().equals(v1) && unaArista.getEnd().equals(v2)) return unaArista;
    	}
    	return null;
    }

	public List<T> bfs(Vertex<T> inicio){ // Busqueda a lo ancho
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Queue<Vertex<T>> pendientes = new LinkedList<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertex<T> actual = pendientes.poll();
			List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for(Vertex<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<T> dfs(Vertex<T> inicio){ // Busqueda en profundidad
		List<T> resultado = new ArrayList<T>();
		Stack<Vertex<T>> pendientes = new Stack<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertex<T> actual = pendientes.pop();
			List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for(Vertex<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
    public List<List<Vertex<T>>> paths(T v1,T v2){
    	return this.paths(new Vertex<T>(v1), new Vertex<T>(v2));
    }
    
    public List<List<Vertex<T>>> paths(Vertex<T> v1,Vertex<T> v2){
    	List<List<Vertex<T>>>salida = new ArrayList<List<Vertex<T>>>();
    	
    	return salida;
    }

    private void findPathAux(Vertex<T> v1,Vertex<T> v2, List<Vertex<T>> marcados, List<List<Vertex<T>>> todos) {
    	
    }
    
    public void floydWarshall() {
    	int cantVertexs= this.vertices.size();
    	int[][] matrizDistancias = new int[cantVertexs][cantVertexs];
    	
    	for(int i=0; i<cantVertexs;i++) {
        	for(int j=0; j<cantVertexs;j++) {
        		if(i== j) {
            		matrizDistancias[i][j] = 0;        			
        		}else {
	        		Edge<T> arista = this.findEdge(this.vertices.get(i), this.vertices.get(j));
	        		if(arista!=null) {
	            		matrizDistancias[i][j] = arista.getValue().intValue();        			
	        		} else {
	            		matrizDistancias[i][j] = 9999;        			
	        		}
        		}
        	}    		
    	}
    	printMatrix(matrizDistancias);
    	
    	for (int k = 0; k < cantVertexs; k++) 
        { 
            // Pick all vertices as source one by one 
            for (int i = 0; i < cantVertexs; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (int j = 0; j < cantVertexs; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (matrizDistancias[i][k] + matrizDistancias[k][j] < matrizDistancias[i][j]) 
                    	matrizDistancias[i][j] = matrizDistancias[i][k] + matrizDistancias[k][j]; 
                } 
            } 
            System.out.println("MATRIZ "+k);
            printMatrix(matrizDistancias);
        } 
    	
    }
    
    public void printMatrix(int[][] m) {
    	for(int i=0; i<m.length;i++) {
    		System.out.print("[ ");
        	for(int j=0; j<m[i].length;j++) {
        		System.out.print(i+":"+j+" = "+m[i][j]+ ",   ");
        	}
        	System.out.println(" ]");
    	}
    }
    
    // ----------------------------------------------------------------------------------------------------------------
    
    public Integer eccentricity(Vertex<T> v) // Use it preferably with connected digraphs
    {
    	// https://en.wikipedia.org/wiki/Distance_(graph_theory)
        // https://www.youtube.com/watch?v=YbCn8d4Enos
    	
    	ArrayList<Integer> potencialEccentricities;
    	
    	potencialEccentricities = new ArrayList<Integer>(vertices.size());
    	for (Vertex<T> u : vertices)
    		potencialEccentricities.add(this.distance(v, u));
    	
    	return Collections.max(potencialEccentricities);
    }
    
    public Integer distance(Vertex<T> v, Vertex<T> u)
    {
    	Integer d;
    	LinkedList<Vertex<T>> shortestPath;
    	
    	shortestPath = Collections.min   // Not too efficient. Dijktra's algorithm should be better a approach
    	(
    			this.allPathsRecursive(v, u, Integer.MAX_VALUE),
    			(p1, p2) -> ((Integer) p1.size()).compareTo((Integer) p2.size())
    	);
    	
    	d = shortestPath.size() - 1;
    	
    	if (d == -1) // i.e. No path
    		d = Integer.MAX_VALUE; // "Infinity"
    	
    	return d;
    }
    
    
    @SuppressWarnings("unchecked")
	public LinkedList<LinkedList<Vertex<T>>> allPathsIterative(Vertex<T> v1, Vertex<T> v2, Integer n)
    {
    	ArrayDeque<Tuple3<Vertex<T>, Integer, LinkedList<Vertex<T>>>> callStack;
    	LinkedList<Vertex<T>> visitedVerticesCopy;
		LinkedList<LinkedList<Vertex<T>>> result;
		Tuple3<Vertex<T>, Integer, LinkedList<Vertex<T>>> t;
    	
		result = new LinkedList<LinkedList<Vertex<T>>>();
		visitedVerticesCopy = new LinkedList<Vertex<T>>();
		callStack = new ArrayDeque<Tuple3<Vertex<T>, Integer, LinkedList<Vertex<T>>>>();
    	
		visitedVerticesCopy.add(v1);
		t = new Tuple3<Vertex<T>, Integer, LinkedList<Vertex<T>>>(v1, n, visitedVerticesCopy);
    	callStack.push(t);
    	
    	/*
    	 * Recursive       | Iterative 
    	 * ----------------|--------------
    	 * v1			   | t.first
    	 * n			   | t.second
    	 * visitedVertices | t.third 
    	 */
    	
    	while(!callStack.isEmpty())
    	{
    		t = callStack.pop();
    		
    		if ((Integer) t.second > 0) // lengthOfPath < n
    			if (t.first.equals(v2))
    			{
    				visitedVerticesCopy = (LinkedList<Vertex<T>>) t.third.clone();
    				result.add(visitedVerticesCopy);
    			}
    	    	else
    	    		for (Vertex<T> w : this.getNeighbourhood(t.first))
    	    			if (!t.third.contains(w))
    	    			{
    	    				visitedVerticesCopy = (LinkedList<Vertex<T>>) t.third.clone();
    	    				visitedVerticesCopy.add(w);
    	    				callStack.push(new Tuple3<Vertex<T>, Integer, LinkedList<Vertex<T>>>(w, t.second - 1, visitedVerticesCopy));
    	    			}
    	}	
    		
    	return result;
    }
    
	@SuppressWarnings("unchecked")
	public Boolean pathExistsIterative(Vertex<T> v1, Vertex<T> v2, Integer n) 
    {
    	ArrayDeque<Tuple3<Vertex<T>, Integer, HashSet<Vertex<T>>>> callStack;
    	HashSet<Vertex<T>> visitedVerticesCopy;
    	Tuple3<Vertex<T>, Integer, HashSet<Vertex<T>>> t;
    	Boolean found;
    	Integer i;
    	List<Vertex<T>> adjacentNodes;
    	Vertex<T> w;
    	
    	callStack = new ArrayDeque<Tuple3<Vertex<T>, Integer, HashSet<Vertex<T>>>>();
    	visitedVerticesCopy = new HashSet<Vertex<T>>();
    	
    	visitedVerticesCopy.add(v1);
    	t = new Tuple3<Vertex<T>, Integer, HashSet<Vertex<T>>>(v1, n, visitedVerticesCopy);
    	callStack.push(t);
    	found = false;
    	
    	/*
    	 * Recursive       | Iterative 
    	 * ----------------|--------------
    	 * v1			   | t.first
    	 * n			   | t.second
    	 * visitedVertices | t.third 
    	 */
    	
    	while(!callStack.isEmpty() && !found) // Emulate recursiveness
    	{
    		t = callStack.pop();
    		
    		if ((Integer) t.second == 0) // lengthOfPath < n
        		found = false;
        	else
    	    	if (t.first.equals(v2))
    	    		found = true;
    	    	else
    	    	{
    	    		found = false;
    	    		i = 0;
    	    		adjacentNodes = this.getNeighbourhood(t.first);
    	    		
    	    		while (!found && i < adjacentNodes.size())
    	    		{
    	    			w = adjacentNodes.get(i);
    	    			i++;
    	    			
    	    			if (!t.third.contains(w)) // O(1)
    	    			{
    	    				visitedVerticesCopy = (HashSet<Vertex<T>>) t.third.clone();
    	    				visitedVerticesCopy.add(w);
    	    				callStack.push(new Tuple3<Vertex<T>, Integer, HashSet<Vertex<T>>>(w, t.second - 1, visitedVerticesCopy));
    	    			
    	    			}
    	    		}			
    	    	}
    	}
    	
    	return found;
    }
    
	 public LinkedList<LinkedList<Vertex<T>>> allPathsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n)
	 {
		LinkedList<Vertex<T>> visitedVertices = new LinkedList<Vertex<T>>();
		LinkedList<LinkedList<Vertex<T>>> result = new LinkedList<LinkedList<Vertex<T>>>();
		
		visitedVertices.add(v1);
		this.allPathsRecursive(v1, v2, n, visitedVertices, result);	
		
	    return result; 
	 }
	 
	@SuppressWarnings("unchecked")
	private void allPathsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n, LinkedList<Vertex<T>> visitedVertices, LinkedList<LinkedList<Vertex<T>>> result) 
	{
    	LinkedList<Vertex<T>> visitedVerticesCopy;
    	
		if (n > 0) // lengthOfPath < n
			if (v1.equals(v2))
			{
				visitedVerticesCopy = (LinkedList<Vertex<T>>) visitedVertices.clone();
				result.add(visitedVerticesCopy);
			}
	    	else
	    		for (Vertex<T> w : this.getNeighbourhood(v1))
	    			if (!visitedVertices.contains(w))
	    			{
	    				visitedVerticesCopy = (LinkedList<Vertex<T>>) visitedVertices.clone();
	    				visitedVerticesCopy.add(w);
	    				this.allPathsRecursive(w, v2, n - 1, visitedVerticesCopy, result); 
	    			}
	}
	
    public Boolean pathExistsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n) 
    {	
    	HashSet<Vertex<T>> visitedVertices = new HashSet<Vertex<T>>();
    	visitedVertices.add(v1);
    	
    	return this.pathExistsRecursive(v1, v2, n, visitedVertices);
    }
    
    // More efficient than checking if the list returned by allPathsRecursive(...) is empty or not
	@SuppressWarnings("unchecked")
	private Boolean pathExistsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n, HashSet<Vertex<T>> visitedVertices) 
	{
		Boolean found;
		Integer i;
		Vertex<T> w;
    	List<Vertex<T>> v1AdjacentNodes;
    	HashSet<Vertex<T>> visitedVerticesCopy;
    	
		if (n == 0) // lengthOfPath < n
    		found = false;
    	else
	    	if (v1.equals(v2))
	    		found = true;
	    	else
	    	{
	    		found = false;
	    		i = 0;
	    		v1AdjacentNodes = this.getNeighbourhood(v1);
	    		
	    		while (!found && i < v1AdjacentNodes.size())
	    		{
	    			w = v1AdjacentNodes.get(i);
	    			i++;
	    			
	    			if (!visitedVertices.contains(w))
	    			{
	    				visitedVerticesCopy = (HashSet<Vertex<T>>) visitedVertices.clone();
	    	    		visitedVerticesCopy.add(w);
	    				found = this.pathExistsRecursive(w, v2, n - 1, visitedVerticesCopy); 
	    			}
	    		}			
	    	}
	
		return found;
	}
	
	public Boolean isComplete()
	{
		Boolean isComplete = true;
		Integer i, j;
		Vertex<T> vi, vj;
		
		i = 0;
		while (i < vertices.size() && isComplete)
		{
			vi = vertices.get(i);
			j = 0;
			while (j < vertices.size() && isComplete)
			{
				vj = vertices.get(j);
			
				if (!vi.equals(vj))  // Links of a vertex with itself aren't considered.
					if (!this.areLinked(vertices.get(i), vertices.get(j)))
						isComplete = false;
				
				j++;
			}
			
			i++;
		}
			
		return isComplete;
	}
	
	private Boolean areLinked(Vertex<T> v1, Vertex<T> v2)
	{
		Boolean areLinked = false;
		Integer i = 0;
		Edge<T> e;
		
		while (i < edges.size() && !areLinked)
		{
			e = edges.get(i);
			i++;
			if (
					(e.getOrigin().equals(v1) && e.getEnd().equals(v2)) || // Linked in either of both "directions".
					(e.getOrigin().equals(v2) && e.getEnd().equals(v1))
			   )
				areLinked = true;
		}
		
		return areLinked;
	}
	
	public Integer inDegree(Vertex<T> vertex){
		Integer result = 0;
		for(Edge<T> e : this.edges){
			if(e.getEnd().equals(vertex)) result++;
		}
		return result;
	}

	public Integer outDegree(Vertex<T> vertex){
		Integer result = 0;
		for(Edge<T> e : this.edges){
			if(e.getOrigin().equals(vertex)) result--;
		}
		return result;
	}
	
	public List<Vertex<T>> topologicalOrder()
	{
		ArrayDeque<Vertex<T>> verticesWithoutEdges = new ArrayDeque<Vertex<T>>();
		HashMap<Vertex<T>, Integer> verticesWithIndegree = new HashMap<Vertex<T>, Integer>(); // Avoid using a copy of the digraph.
		List<Vertex<T>> result = new ArrayList<Vertex<T>>();
		Integer vertexIndegree;
		Vertex<T> v;
		
		for (Vertex<T> u: vertices)
		{
			vertexIndegree = this.inDegree(u);
			verticesWithIndegree.put(u, vertexIndegree);
			
			if (vertexIndegree == 0)
				verticesWithoutEdges.add(u);
		}
		
		while (!verticesWithoutEdges.isEmpty())
		{
			v = verticesWithoutEdges.remove();
			result.add(v);
			
			for (Vertex<T> w: this.getNeighbourhood(v))
			{
				vertexIndegree = verticesWithIndegree.get(w) - 1;
				verticesWithIndegree.put(w, vertexIndegree);
				
				if (vertexIndegree == 0)
					verticesWithoutEdges.add(w);
			}
		}
		
		return result;
 	}
}

