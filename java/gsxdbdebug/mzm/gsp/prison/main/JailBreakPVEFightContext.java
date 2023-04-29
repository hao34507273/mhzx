/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailBreakPVEFightContext
/*    */   implements FightContext
/*    */ {
/*    */   final int fightId;
/*    */   
/*    */   public JailBreakPVEFightContext(int fightId)
/*    */   {
/* 14 */     this.fightId = fightId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailBreakPVEFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */