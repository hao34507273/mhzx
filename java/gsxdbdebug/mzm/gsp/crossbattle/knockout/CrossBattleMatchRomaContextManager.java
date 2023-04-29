/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*    */ 
/*    */ public class CrossBattleMatchRomaContextManager extends CrossBattleKnockOutContextManager<Long, RoamedKnockOutContext>
/*    */ {
/*  7 */   private static final CrossBattleMatchRomaContextManager instance = new CrossBattleMatchRomaContextManager();
/*    */   
/*    */   static CrossBattleMatchRomaContextManager getInstance()
/*    */   {
/* 11 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleMatchRomaContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */