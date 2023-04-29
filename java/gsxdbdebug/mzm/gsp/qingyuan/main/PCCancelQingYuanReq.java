/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingyuan.SCancelQingYuanSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCCancelQingYuanReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamLeaderRoleId;
/*    */   private final long sessionId;
/*    */   private long teamMemberRoleId;
/*    */   
/*    */   public PCCancelQingYuanReq(long teamLeaderRoleId, long sessionId)
/*    */   {
/* 24 */     this.teamLeaderRoleId = teamLeaderRoleId;
/* 25 */     this.sessionId = sessionId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!QingYuanManager.isQingYuanSwitchOpen(this.teamLeaderRoleId, "PCCancelQingYuanReq.processImp"))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     Session session = QingYuanConfirmSession.getSession(this.sessionId);
/* 37 */     if (!(session instanceof QingYuanConfirmSession))
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[qingyuan]PCCancelQingYuanReq.processImp@session may be expired|team_leader_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.sessionId) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     QingYuanConfirmSession qingYuanConfirmSession = (QingYuanConfirmSession)session;
/*    */     
/* 48 */     this.teamMemberRoleId = qingYuanConfirmSession.getTeamMemberRoleId();
/* 49 */     if (this.teamLeaderRoleId != qingYuanConfirmSession.getOwerId())
/*    */     {
/* 51 */       GameServer.logger().error(String.format("[qingyuan]PCCancelQingYuanReq.processImp@session context not match|team_leader_role_id=%d|session_id=%d|session_team_leader_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.sessionId), Long.valueOf(qingYuanConfirmSession.getOwerId()) }));
/*    */       
/*    */ 
/*    */ 
/* 55 */       return false;
/*    */     }
/* 57 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/* 58 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*    */     
/* 60 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/* 61 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*    */     
/* 63 */     if (!RoleStatusInterface.checkCanSetStatus(this.teamLeaderRoleId, 1702, true, true))
/*    */     {
/* 65 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 69 */     if (QingYuanConfirmSession.getSession(this.sessionId) == null)
/*    */     {
/* 71 */       GameServer.logger().error(String.format("[qingyuan]PCCancelQingYuanReq.processImp@session expired or has operator|team_leader_role_id=%d|session_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.sessionId), Long.valueOf(this.teamMemberRoleId) }));
/*    */       
/*    */ 
/*    */ 
/* 75 */       return false;
/*    */     }
/* 77 */     QingYuanConfirmSession.removeSession(this.sessionId);
/*    */     
/* 79 */     SCancelQingYuanSuccess sCancelQingYuanSuccess = new SCancelQingYuanSuccess();
/* 80 */     sCancelQingYuanSuccess.team_leader_role_id = this.teamLeaderRoleId;
/* 81 */     sCancelQingYuanSuccess.team_leader_role_name = RoleInterface.getName(this.teamLeaderRoleId);
/*    */     
/* 83 */     OnlineManager.getInstance().sendMulti(sCancelQingYuanSuccess, Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*    */     
/*    */ 
/* 86 */     GameServer.logger().info(String.format("[qingyuan]PCCancelQingYuanReq.processImp@handle cancel qing yuan req success|team_leader_role_id=%d|session_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.sessionId), Long.valueOf(this.teamMemberRoleId) }));
/*    */     
/*    */ 
/*    */ 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\PCCancelQingYuanReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */