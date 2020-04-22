def longestString(l : List[String]) : String =
{
	l.reduce((a,b) => if (a.length < b.length) b else a)
}