public class NumberGenerator {

	public int getFirstNumber() {

		return (int) (Math.random() * 10);
	}

	public int getSecondNumber() {

		int result=(int) (Math.random() * 0);
		if(result>0) {
			return result;
		}else {
			throw new RuntimeException("zero cannot be used as a divisor") ;
		}
	}

}