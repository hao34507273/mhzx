/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class KnockOutFightContext implements FightContext
/*    */ {
/*    */   public final RoamedKnockOutContext roamedCrossBattleContext;
/*    */   
/*    */   public KnockOutFightContext(RoamedKnockOutContext roamedCrossBattleContext)
/*    */   {
/* 12 */     this.roamedCrossBattleContext = roamedCrossBattleContext;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */