/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.gsp.crossbattle.knockout.FightStageEndCorpsInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetFinalChampionMapStatueArg
/*    */ {
/*    */   public final boolean isSuccess;
/*    */   public final boolean nowIsHasStatue;
/*    */   public final int session;
/*    */   public final FightStageEndCorpsInfo fightStageEndCorpsInfo;
/*    */   
/*    */   public GetFinalChampionMapStatueArg(boolean isSuccess, boolean nowIsHasStatue, int session, FightStageEndCorpsInfo fightStageEndCorpsInfo)
/*    */   {
/* 30 */     this.isSuccess = isSuccess;
/* 31 */     this.nowIsHasStatue = nowIsHasStatue;
/* 32 */     this.session = session;
/* 33 */     this.fightStageEndCorpsInfo = fightStageEndCorpsInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFinalChampionMapStatueArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */