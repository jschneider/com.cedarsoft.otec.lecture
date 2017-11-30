package com.cedarsoft.otec.lecture.reactive;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HelloWorldReactive {

  private static Flowable<String> getHelloWorld() {
    return Flowable.just("Hello world");
  }

  @Test
  public void testHelloWorld() {
    Flowable<String> flowable = getHelloWorld();
    Disposable disposable = flowable.subscribe(System.out::println);
    disposable.dispose();
  }

  @Test
  public void testThreading() throws InterruptedException {
    Flowable<String> flowable = getHelloWorld();
    Disposable disposable = flowable
      .subscribeOn(Schedulers.io())
      .subscribe(x -> {
        System.out.println("Got x on thread " + Thread.currentThread().getName());
      });

    Thread.sleep(1000L);
    disposable.dispose();
  }

  private static Flowable<Integer> getNumbers() {
    return Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  }

  @Test
  public void testEvenNumbers() {
    Flowable<Integer> numbers = getNumbers();

    Disposable disposable = numbers
      .filter(integer -> integer % 2 == 0)
      .subscribe(integer -> System.out.println("Got <" + integer + ">"));

    disposable.dispose();
  }

  @Test
  public void testSkip2EvenNumbers() {
    System.out.println("Skipping first two numbers");

    Flowable<Integer> numbers = getNumbers();

    Disposable disposable = numbers
      .skip(2)
      .filter(integer -> integer % 2 == 0)
      .subscribe(integer -> System.out.println("Got <" + integer + ">"));

    disposable.dispose();
  }

  @Test
  public void testEvenNumbersSkip2() {
    System.out.println("Skipping first two numbers");

    Flowable<Integer> numbers = getNumbers();

    Disposable disposable = numbers
      .filter(integer -> integer % 2 == 0)
      .skip(2)
      .subscribe(integer -> System.out.println("Got <" + integer + ">"));

    disposable.dispose();
  }

  //Possible operators: https://github.com/ReactiveX/RxJava/wiki/Alphabetical-List-of-Observable-Operators
}
