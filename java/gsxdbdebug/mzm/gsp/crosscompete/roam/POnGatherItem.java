/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.map.event.PlayerGatherItemSuccessProcedure;
/*    */ import mzm.gsp.map.main.GatherItemEventArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnGatherItem
/*    */   extends PlayerGatherItemSuccessProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!GameServerInfoManager.isRoamServer()) {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     if (((GatherItemEventArg)this.arg).mapId != SCrossCompeteConsts.getInstance().FightMap) {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     String userid = RoleInterface.getUserId(((GatherItemEventArg)this.arg).roleId);
/*    */     
/* 35 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/*    */ 
/* 38 */     RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(((GatherItemEventArg)this.arg).roleId, true);
/*    */     
/*    */ 
/* 41 */     if (xRoamRole == null) {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(xRoamRole.getFactionid(), true);
/*    */     
/*    */ 
/* 49 */     if ((xFactionTmp == null) || (xFactionTmp.getWorld() != ((GatherItemEventArg)this.arg).worldId)) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     int treasureAward = CrossCompeteConfigManager.getTreasureAwardByMapItemid(((GatherItemEventArg)this.arg).gatherItemCfgId);
/* 54 */     xRoamRole.setFinal_award(treasureAward);
/*    */     
/*    */ 
/* 57 */     if (TeamInterface.isRoleInTeam(((GatherItemEventArg)this.arg).roleId, true))
/*    */     {
/* 59 */       TeamInterface.leaveTeamNoneRealTime(((GatherItemEventArg)this.arg).roleId);
/*    */     }
/*    */     else
/*    */     {
/* 63 */       CrossCompeteRoamManager.leave(userid, ((GatherItemEventArg)this.arg).roleId, xRoamRole, 4);
/*    */     }
/*    */     
/*    */ 
/* 67 */     CrossCompeteManager.logInfo("POnGatherItem.process@get treasure|roleid=%d|worldid=%d|mapid=%d|map_itemid=%d|treasure_awardid=%d", new Object[] { Long.valueOf(((GatherItemEventArg)this.arg).roleId), Long.valueOf(((GatherItemEventArg)this.arg).worldId), Integer.valueOf(((GatherItemEventArg)this.arg).mapId), Integer.valueOf(((GatherItemEventArg)this.arg).gatherItemCfgId), Integer.valueOf(treasureAward) });
/*    */     
/*    */ 
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnGatherItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */