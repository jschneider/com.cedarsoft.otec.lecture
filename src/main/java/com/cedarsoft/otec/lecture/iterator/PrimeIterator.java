package com.cedarsoft.otec.lecture.iterator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PrimeIterator {
  private final int[] primes;

  private int currentIndex;

  public PrimeIterator( PrimeNumbers primeNumbers ) {
    primes = primeNumbers.primes;
  }

  public boolean hasNext() {
    return primes.length > currentIndex;
  }

  public int next() {
    int current = primes[currentIndex];
    currentIndex++;
    return current;
  }
}
