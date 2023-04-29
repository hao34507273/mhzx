/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ class PLeave
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int reason;
/*    */   
/*    */   PLeave(long roleid, int reason)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 28 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 30 */     RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(this.roleid, true);
/*    */     
/* 32 */     if (xRoamRole == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     RoamCrossCompeteFaction xFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(xRoamRole.getFactionid(), true);
/*    */     
/* 38 */     if (xFaction == null) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     CrossCompeteRoamManager.leave(userid, this.roleid, xRoamRole, this.reason);
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */