/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*    */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoamRoleDataSucceed
/*    */   extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!(this.arg instanceof KnockOutRoamRoleDataSuccessArg))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     KnockOutRoamRoleDataSuccessArg arguement = (KnockOutRoamRoleDataSuccessArg)this.arg;
/* 31 */     KnockOutTeamInfo selectionFinalTeamInfo = arguement.getSelectionFinalTeamInfo();
/*    */     
/* 33 */     List<Long> roleIdList = new ArrayList();
/* 34 */     Map<Long, String> roleId2UserId = new HashMap();
/* 35 */     KnockOutProcessContext selectionFinalPhaseContext = arguement.getSelectionFinalPhaseContext();
/* 36 */     for (KnockOutRoleInfo selectionFinalRoleInfo : selectionFinalTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 38 */       long roleId = selectionFinalRoleInfo.getRoleid();
/* 39 */       roleIdList.add(Long.valueOf(roleId));
/* 40 */       roleId2UserId.put(Long.valueOf(roleId), selectionFinalRoleInfo.getUserid());
/*    */       
/* 42 */       selectionFinalPhaseContext.putRoleProcess(roleId, 2);
/*    */     }
/*    */     
/* 45 */     lock(User.getTable(), roleId2UserId.values());
/* 46 */     lock(Role2properties.getTable(), roleIdList);
/*    */     
/* 48 */     CrossBattleKnockoutManager.sendUpdateCrossMatchProcessInfo(selectionFinalTeamInfo.getCrossBattleRoleInfoList(), arguement.fightType, 2);
/*    */     
/*    */ 
/* 51 */     CrossBattleKnockoutManager.removeCancelMatchId(roleIdList);
/*    */     
/*    */ 
/* 54 */     long endTimeMills = DateTimeUtils.getCurrTimeInMillis() + SLadderConsts.getInstance().protectSec * 1000;
/* 55 */     for (String userid : roleId2UserId.values())
/*    */     {
/* 57 */       LoginAssistManager.getInstance().addProtectUser(userid, endTimeMills);
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */