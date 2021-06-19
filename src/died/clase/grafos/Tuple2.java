package died.clase.grafos;

public final class Tuple2 <T1, T2> // Not used
{
	// https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
	
	public T1 first;
	public T2 second;
	
	public Tuple2()
	{
		first = null;
		second = null;
	}
	
	public Tuple2(T1 first, T2 second)
	{
		this.first = first;
		this.second = second;
	}
}
