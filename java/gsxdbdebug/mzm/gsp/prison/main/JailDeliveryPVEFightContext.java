/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailDeliveryPVEFightContext
/*    */   implements FightContext
/*    */ {
/*    */   final long savedId;
/*    */   final int fightId;
/*    */   
/*    */   public JailDeliveryPVEFightContext(long savedId, int fightId)
/*    */   {
/* 15 */     this.savedId = savedId;
/* 16 */     this.fightId = fightId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailDeliveryPVEFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */