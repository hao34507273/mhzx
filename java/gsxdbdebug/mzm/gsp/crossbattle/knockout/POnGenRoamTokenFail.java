/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnGenRoamTokenFail extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (!(this.arg instanceof KnockOutGenRoamTokenFailArg))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     KnockOutGenRoamTokenFailArg genRoamTokenFailArg = (KnockOutGenRoamTokenFailArg)this.arg;
/*    */     
/* 26 */     KnockOutTeamInfo selectionFinalTeamInfo = genRoamTokenFailArg.getSelectionFinalTeamInfo();
/*    */     
/* 28 */     List<Long> roleIdList = new ArrayList();
/* 29 */     Map<Long, String> roleId2UserId = new HashMap();
/* 30 */     for (KnockOutRoleInfo selectionFinalRoleInfo : selectionFinalTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 32 */       long roleId = selectionFinalRoleInfo.getRoleid();
/* 33 */       roleIdList.add(Long.valueOf(roleId));
/* 34 */       roleId2UserId.put(Long.valueOf(roleId), selectionFinalRoleInfo.getUserid());
/*    */     }
/*    */     
/* 37 */     lock(User.getTable(), roleId2UserId.values());
/* 38 */     lock(Role2properties.getTable(), roleIdList);
/*    */     
/* 40 */     CrossBattleKnockoutManager.goToCenterServerFail(roleId2UserId, 8);
/*    */     
/*    */ 
/* 43 */     StringBuilder sb = new StringBuilder();
/* 44 */     sb.append("[crossbattle_selection]POnGenRoamTokenFail.processImp@gen roam token fail");
/* 45 */     sb.append("|role_id=").append(roleIdList.toString());
/* 46 */     sb.append("|corps_id=").append(selectionFinalTeamInfo.getCorpsId());
/* 47 */     sb.append("|opponent_corps_id=").append(selectionFinalTeamInfo.getOpponentCorpsId());
/*    */     
/* 49 */     GameServer.logger().info(sb.toString());
/*    */     
/*    */ 
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */