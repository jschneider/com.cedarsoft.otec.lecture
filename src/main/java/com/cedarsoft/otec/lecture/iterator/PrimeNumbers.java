package com.cedarsoft.otec.lecture.iterator;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PrimeNumbers {
  final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};


  @Nonnull
  public List<Integer> asList() {
    List<Integer> list = new ArrayList<Integer>();

    for ( int prime : primes ) {
      list.add( prime );
    }

    return list;
  }
}
