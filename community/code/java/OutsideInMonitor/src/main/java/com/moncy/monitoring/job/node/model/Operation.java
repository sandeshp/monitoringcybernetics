package com.moncy.monitoring.job.node.model;

public class Operation {
   private int recur_mins;
   private int total_nodes;

   public Operation() {
   }

   public int getRecurMins() {
       return recur_mins;
   }

   public void setRecurMins(int recurMins) {
       this.recur_mins = recurMins;
   }
    public int getTotalNodes() {
         return total_nodes;
    }
    public void setTotalNodes(int total_nodes) {
         this.total_nodes = total_nodes;
    }
}
