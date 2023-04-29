/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*    */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSelectionOrFinalMatchFailed extends mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     KnockOutTeamInfo ownCrossBattleTeamInfo = ((SelectionOrFinalMatchFailedArg)this.arg).getOwnCrossBattleTeamInfo();
/* 19 */     Map<Long, String> roleid2Userid = new HashMap();
/* 20 */     List<Long> roleids = new ArrayList();
/* 21 */     for (KnockOutRoleInfo roleCrossBattleInfo : ownCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 23 */       long roleid = roleCrossBattleInfo.getRoleid();
/* 24 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 25 */       roleid2Userid.put(Long.valueOf(roleid), userid);
/* 26 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 29 */     GameServer.logger().info(String.format("[crossbattle_knockout]POnSelectionOrFinalMatchFailed.processImp@match fails|roleids=%s", new Object[] { roleids }));
/*    */     
/*    */ 
/*    */ 
/* 33 */     lock(User.getTable(), roleid2Userid.values());
/* 34 */     lock(xtable.Role2properties.getTable(), roleids);
/*    */     
/* 36 */     CrossBattleKnockoutManager.doUnMatch(roleids);
/*    */     
/* 38 */     CrossBattleKnockoutManager.removeCancelMatchId(roleids);
/*    */     
/*    */ 
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnSelectionOrFinalMatchFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */