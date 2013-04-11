package com.cedarsoft.otec.lecture.iterator;

import org.junit.*;

import java.util.Iterator;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PrimeNumbersTest {
  @Test
  public void testFor() throws Exception {
    PrimeNumbers primeNumbers = new PrimeNumbers();

    System.out.println( "Foreach" );
    for ( int prime : primeNumbers.primes ) {
      System.out.println( "--> " + prime );
    }

    System.out.println( "For" );
    int[] primes = primeNumbers.primes;
    for ( int i = 0; i < primes.length; i++ ) {
      int prime = primes[i];
      System.out.println( "--> " + prime );
    }
  }

  @Test
  public void testIterator() throws Exception {

    PrimeNumbers primeNumbers = new PrimeNumbers();
    PrimeIterator iterator = new PrimeIterator( primeNumbers );


    while ( iterator.hasNext() ) {
      System.out.println( "--> " + iterator.next() );
    }
  }

  @Test
  public void testList() throws Exception {
    List<Integer> primes = new PrimeNumbers().asList();

    for ( Iterator<Integer> iterator = primes.iterator(); iterator.hasNext(); ) {
      Integer prime = iterator.next();
      System.out.println( "--> " + prime );
    }
  }

  @Test
  public void testRemove() throws Exception {
    List<Integer> primes = new PrimeNumbers().asList();

    for ( Iterator<Integer> iterator = primes.iterator(); iterator.hasNext(); ) {
      Integer prime = iterator.next();
      System.out.println( "--> " + prime );

      if ( prime == 2 ) {
        iterator.remove();
      }
    }

    System.out.println( "-------------------" );
    for ( Iterator<Integer> iterator = primes.iterator(); iterator.hasNext(); ) {
      Integer prime = iterator.next();
      System.out.println( "--> " + prime );
    }
  }
}
