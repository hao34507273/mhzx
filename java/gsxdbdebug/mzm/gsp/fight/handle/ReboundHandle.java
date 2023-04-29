/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ public abstract interface ReboundHandle
/*    */ {
/*    */   public abstract void onRebound(Fighter paramFighter, int paramInt1, int paramInt2, OutPutObj paramOutPutObj);
/*    */   
/*    */   public static class OutPutObj
/*    */   {
/* 14 */     public Set<Integer> targetPassiveSkillids = new HashSet();
/*    */     public int reboundDamage;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\ReboundHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */