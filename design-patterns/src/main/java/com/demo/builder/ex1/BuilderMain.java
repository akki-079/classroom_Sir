package com.demo.builder.ex1;

public class BuilderMain {

	public static void main(String[] args) {
		User user = new User.UserBuilder(123, "name").build();

		User user1 = new User.UserBuilder(120, "John").email("john@gmail.com").city("London").build();
		User user2 = new User.UserBuilder(120, "Peter").email("peter@gmail.com").city("Sydney").mobile("67678789")
				.build();
		
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("Shantanu").append("Banerjee").append(93913297);
		
		System.out.println(stringBuilder);

	}

}
