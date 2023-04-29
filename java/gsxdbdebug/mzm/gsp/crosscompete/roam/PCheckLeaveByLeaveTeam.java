/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PCheckLeaveByLeaveTeam
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PCheckLeaveByLeaveTeam(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     if (!GameServerInfoManager.isRoamServer()) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     String userid = RoleInterface.getUserId(this.roleid);
/* 35 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/*    */ 
/* 38 */     RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(this.roleid, true);
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
/* 49 */     if (xFactionTmp == null) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 54 */     if (world != xFactionTmp.getWorld()) {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     if (xRoamRole.getAction_point() <= 0)
/*    */     {
/* 60 */       CrossCompeteRoamManager.leave(userid, this.roleid, xRoamRole, 1);
/*    */       
/* 62 */       CrossCompeteManager.sendNormalResult(this.roleid, 41, new Object[0]);
/*    */ 
/*    */     }
/* 65 */     else if (xRoamRole.getFinal_award() > 0)
/*    */     {
/* 67 */       CrossCompeteRoamManager.leave(userid, this.roleid, xRoamRole, 4);
/*    */     }
/*    */     
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PCheckLeaveByLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */