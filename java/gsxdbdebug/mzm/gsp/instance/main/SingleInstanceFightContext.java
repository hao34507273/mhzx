/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class SingleInstanceFightContext implements FightContext
/*    */ {
/*    */   public final int monsterInstanceid;
/*    */   public final int instanceCfgid;
/*    */   public final int instanceProcessid;
/*    */   
/*    */   public SingleInstanceFightContext(int monsterInstanceid, int instanceCfgid, int instanceProcessid) {
/* 12 */     this.monsterInstanceid = monsterInstanceid;
/* 13 */     this.instanceCfgid = instanceCfgid;
/* 14 */     this.instanceProcessid = instanceProcessid;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 19 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */