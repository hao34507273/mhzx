/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetFinalTeamSize extends LogicProcedure
/*    */ {
/*    */   private final int teamNum;
/*    */   private final long gmRoleId;
/*    */   
/*    */   public PGM_SetFinalTeamSize(int teamNum, long gmRoleId)
/*    */   {
/* 16 */     this.teamNum = teamNum;
/* 17 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if ((this.teamNum > 5) || (this.teamNum < 1))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "队伍人数需要在1个到5个之间");
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     for (SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg : SCrossBattleKnockOutCfg.getAll().values())
/*    */     {
/* 31 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 32 */       if (knockOutCfg != null)
/*    */       {
/* 34 */         knockOutCfg.need_team_member_num = this.teamNum;
/*    */       }
/*    */     }
/*    */     
/* 38 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "当前参加总决赛只需要大于" + this.teamNum + "人队伍");
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetFinalTeamSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */