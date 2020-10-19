class Hello
{
    public static void main(String[] args)
	{
	Hello h = new Hello();
	int n= h.factorial(4);
	System.out.println(n);
		
	}
	int factorial(int n)
	{
		int fn=1;
		while(n>1)
		
			fn*=n--;
		return fn;
		
	}
	}