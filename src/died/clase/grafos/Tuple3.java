package died.clase.grafos;

public final class Tuple3 <T1, T2, T3>
{
	// https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
	
	public T1 first;
	public T2 second;
	public T3 third;
	
	public Tuple3()
	{
		first = null;
		second = null;
		third = null;
	}
	
	public Tuple3(T1 first, T2 second, T3 third)
	{
		this.first = first;
		this.second = second;
		this.third = third;
	}
}