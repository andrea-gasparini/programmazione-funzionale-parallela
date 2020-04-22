def minMax(l : List[Int]) : (Int, Int) =
{
	(l.min, l.max)
}

def minMax2(l : List[Int]) : (Int, Int) =
{
	(l.reduce((a,b) => a min b), l.reduce((a,b) => a max b))
}

/*
def minMax3(l : List[Int]) : (Int, Int) =
{
	if (l.size == 1) (l.head, l.head)
	else
	{

	}
}
*/