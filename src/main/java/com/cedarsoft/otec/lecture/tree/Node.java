package com.cedarsoft.otec.lecture.tree;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface Node {
  String getId();

  List<Node> getChildren();
}
