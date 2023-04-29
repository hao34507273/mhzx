/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedProcedure;
/*    */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*    */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class POnGenRoamTokenSucceed
/*    */   extends GenRoamTokenSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!(this.arg instanceof KnockOutGenTokenSuccessArg))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     KnockOutGenTokenSuccessArg argument = (KnockOutGenTokenSuccessArg)this.arg;
/*    */     
/* 26 */     KnockOutTeamInfo selectionFinalTeamInfo = argument.getSelectionFinalTeamInfo();
/*    */     
/* 28 */     KnockOutProcessContext selectionFinalPhaseContext = argument.getSelectionFinalPhaseContext();
/* 29 */     List<Long> allroles = new ArrayList();
/* 30 */     for (KnockOutRoleInfo selectionFinalRoleInfo : selectionFinalTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 32 */       long roleid = selectionFinalRoleInfo.getRoleid();
/* 33 */       selectionFinalPhaseContext.putRoleProcess(roleid, 1);
/* 34 */       allroles.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 37 */     GameServer.logger().info(String.format("[crossbattle_selection]POnGenRoamTokenSucceed.processImp@succeed|roleids=%s", new Object[] { allroles }));
/*    */     
/*    */ 
/* 40 */     CrossBattleKnockoutManager.sendUpdateCrossMatchProcessInfo(selectionFinalTeamInfo.getCrossBattleRoleInfoList(), argument.fightType, 1);
/*    */     
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */