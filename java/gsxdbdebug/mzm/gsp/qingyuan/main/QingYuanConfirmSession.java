/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingyuan.SAgreeOrRefuseQingYuan;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xtable.User;
/*    */ 
/*    */ public class QingYuanConfirmSession extends Session
/*    */ {
/*    */   private final long teamMemberRoleId;
/*    */   
/*    */   public QingYuanConfirmSession(long interval, long teamLeaderRoleId, long teamMemberRoleId)
/*    */   {
/* 19 */     super(interval, teamLeaderRoleId);
/* 20 */     this.teamMemberRoleId = teamMemberRoleId;
/*    */   }
/*    */   
/*    */   public long getTeamMemberRoleId()
/*    */   {
/* 25 */     return this.teamMemberRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     PQingYuanConfirmTimeOut pQingYuanConfirmTimeOut = new PQingYuanConfirmTimeOut(super.getOwerId(), this.teamMemberRoleId, super.getSessionId());
/*    */     
/*    */ 
/* 34 */     pQingYuanConfirmTimeOut.execute();
/*    */   }
/*    */   
/*    */   private static class PQingYuanConfirmTimeOut extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long teamLeaderRoleId;
/*    */     private final long teamMemberRoleId;
/*    */     private final long sessionId;
/*    */     
/*    */     public PQingYuanConfirmTimeOut(long teamLeaderRoleId, long teamMemberRoleId, long sessionId)
/*    */     {
/* 45 */       this.teamLeaderRoleId = teamLeaderRoleId;
/* 46 */       this.teamMemberRoleId = teamMemberRoleId;
/* 47 */       this.sessionId = sessionId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 53 */       String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/* 54 */       String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*    */       
/* 56 */       lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/* 57 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*    */       
/* 59 */       Role2QingYuanInfo xLeaderRole2QingYuanInfo = xtable.Role2qingyuan.get(Long.valueOf(this.teamLeaderRoleId));
/*    */       
/* 61 */       if (xLeaderRole2QingYuanInfo == null)
/*    */       {
/* 63 */         GameServer.logger().error(String.format("[qingyuan]PQingYuanConfirmTimeOut.processImp@leader role qing yuan info is null|team_leader_rold_id=%d|team_member_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId) }));
/*    */         
/*    */ 
/*    */ 
/* 67 */         return false;
/*    */       }
/* 69 */       SAgreeOrRefuseQingYuan sAgreeOrRefuseQingYuan = new SAgreeOrRefuseQingYuan();
/* 70 */       sAgreeOrRefuseQingYuan.operator = 0;
/* 71 */       sAgreeOrRefuseQingYuan.team_leader_role_id = this.teamLeaderRoleId;
/* 72 */       sAgreeOrRefuseQingYuan.team_member_role_id = this.teamMemberRoleId;
/*    */       
/* 74 */       OnlineManager.getInstance().send(this.teamLeaderRoleId, sAgreeOrRefuseQingYuan);
/* 75 */       GameServer.logger().info(String.format("[qingyuan]PQingYuanConfirmTimeOut.processImp@time out|team_leader_rold_id=%d|team_member_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId) }));
/*    */       
/*    */ 
/*    */ 
/* 79 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\QingYuanConfirmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */