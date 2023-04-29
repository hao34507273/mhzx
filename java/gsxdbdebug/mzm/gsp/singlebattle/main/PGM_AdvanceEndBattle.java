/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AdvanceEndBattle
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_AdvanceEndBattle(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/* 20 */     if (battleId <= 0L)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.roleId, "没在战场里呀~老铁~");
/* 23 */       return false;
/*    */     }
/* 25 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleId, false);
/* 26 */     if (globalInfo == null)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.roleId, "战场已经销毁了~老铁~");
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 36 */     SingleBattleManager.advanceEndMatch(battleId, globalInfo.getBattleCfg(), 4);
/* 37 */     GmManager.getInstance().sendResultToGM(this.roleId, "战场即将结束~~");
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PGM_AdvanceEndBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */