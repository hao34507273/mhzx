/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatueArg;
/*    */ 
/*    */ public class POnGetFinalChampionMapStatue extends mzm.gsp.crossbattle.event.GetFinalChampionMapStatueProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     if (((GetFinalChampionMapStatueArg)this.arg).isSuccess)
/*    */     {
/* 10 */       GoldStatueManager.getInstance().onInitGoldStatueDone(((GetFinalChampionMapStatueArg)this.arg).nowIsHasStatue, ((GetFinalChampionMapStatueArg)this.arg).session, ((GetFinalChampionMapStatueArg)this.arg).fightStageEndCorpsInfo);
/*    */     }
/*    */     else
/*    */     {
/* 14 */       GoldStatueManager.getInstance().onInitGoldStatueFailed();
/*    */     }
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnGetFinalChampionMapStatue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */