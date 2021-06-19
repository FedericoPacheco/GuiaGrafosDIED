package died.clase.grafos;

public final class Tuple4 <T1, T2, T3, T4> // Not used
{
	// https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
	
	public T1 first;
	public T2 second;
	public T3 third;
	public T4 fourth;
	
	public Tuple4()
	{
		first = null;
		second = null;
		third = null;
		fourth = null;
	}
	
	public Tuple4(T1 first, T2 second, T3 third, T4 fourth)
	{
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}
}
