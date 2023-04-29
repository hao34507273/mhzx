/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ public abstract interface AddAngerHandle {
/*    */   public abstract void onAddAnger(OutputObj paramOutputObj);
/*    */   
/*    */   public static class OutputObj {
/*    */     public double finalAddAnger;
/* 10 */     public Set<Integer> passiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\AddAngerHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */