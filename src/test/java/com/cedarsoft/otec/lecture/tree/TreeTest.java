package com.cedarsoft.otec.lecture.tree;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import org.junit.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class TreeTest {

  private ParentNode root;

  @Before
  public void setUp() throws Exception {
    root = new ParentNode( "root" );

    root.add( new Leaf( "a" ) );

    ParentNode p1 = new ParentNode( "p1" );
    root.add( p1 );
    root.add( new Leaf( "b" ) );
    root.add( new Leaf( "c" ) );

    p1.add( new Leaf( "1" ) );
    p1.add( new Leaf( "2" ) );
    ParentNode p13 = new ParentNode( "p13" );
    p13.add( new Leaf( "I" ) );
    p13.add( new Leaf( "II" ) );
    p13.add( new Leaf( "III" ) );
    p1.add( p13 );
    p1.add( new Leaf( "3" ) );
    p1.add( new Leaf( "4" ) );
  }

  @Test
  public void testDFS() throws Exception {
    System.out.println( "Tiefensuche Rekursiv" );
    dfs( root, 0 );
  }

  private void dfs( Node node, int depth ) {
    System.out.println( formatNode( node, depth ) );

    for ( Node childNode : node.getChildren() ) {
      dfs( childNode, depth + 1 );
    }
  }

  @Test
  public void testBFS() throws Exception {
    System.out.println( "Breiten-Suche" );
    Queue<Node> stack = new ArrayDeque<Node>(  );
    stack.add( root );

    while ( !stack.isEmpty() ) {
      Node currentNode = stack.poll();
      System.out.println( "--> " + currentNode.getId() );

      stack.addAll( currentNode.getChildren() );
    }
  }

  private static String formatNode( Node node, int depth ) {
    return Strings.repeat( "  ", depth ) + "+ " + node.getId();
  }
  
  
}
