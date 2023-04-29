/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public abstract interface SkillCostHandle
/*    */ {
/*    */   public abstract void handle(CostResult paramCostResult);
/*    */   
/*    */   public static class CostResult
/*    */   {
/*    */     public int magicreducerate;
/*    */     public int exangerRate;
/* 14 */     public Set<Integer> passiveSkillids = new HashSet();
/*    */     public int extraRate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\SkillCostHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */