/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public abstract interface AddBuffHandle
/*    */ {
/*    */   public abstract void onAddBuff(Fighter paramFighter, FighterBuff paramFighterBuff);
/*    */   
/*    */   public abstract void isCanAddBuff(Fighter paramFighter, FighterBuff paramFighterBuff, OutPutObj paramOutPutObj);
/*    */   
/*    */   public static class OutPutObj
/*    */   {
/* 15 */     public boolean canAddBuff = true;
/* 16 */     public Set<Integer> targetTiggerPassiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\AddBuffHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */