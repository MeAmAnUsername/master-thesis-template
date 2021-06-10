/*
 * Copyright (C) 2013 - 2021 Oracle and/or its affiliates. All rights reserved.
 */
package oracle.pgx.algorithms;

import oracle.pgx.algorithm.EdgeProperty;
import oracle.pgx.algorithm.annotations.GraphAlgorithm;
import oracle.pgx.algorithm.PgxGraph;
import oracle.pgx.algorithm.PgxVertex;
import oracle.pgx.algorithm.annotations.Out;

import static java.lang.Math.log;

@GraphAlgorithm
public class AdamicAdar {
  public void adamicAdar(PgxGraph g, @Out EdgeProperty<Double> aa) {
    g.getEdges().forEach(e -> {
      PgxVertex src = e.sourceVertex();
      PgxVertex dst = e.destinationVertex();

      double value = src.getNeighbors()
          .filter(n -> n.hasEdgeFrom(dst))
          .sum(n -> 1 / log(n.getDegree()));

      aa.set(e, value);
    });
  }
}