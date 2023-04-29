/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCRoleKeepAliveNotice
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCRoleKeepAliveNotice(long roleId)
/*    */   {
/* 17 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/* 24 */     if (leaderId != this.roleId) {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(leaderId));
/* 30 */     return ChangeLeaderManager.startChangeLeaderSession(leaderId, xLeaderChangeBean);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\PCRoleKeepAliveNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */