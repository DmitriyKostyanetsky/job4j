package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test.
*
*@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
*@version 1
*@since 19.03.18
*/

public class CalculateTest {
	/**
	*Test echo.
	*/ @Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Dmitriy Kostyanetsky";
		String expect = "Echo, echo, echo : Dmitriy Kostyanetsky";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}