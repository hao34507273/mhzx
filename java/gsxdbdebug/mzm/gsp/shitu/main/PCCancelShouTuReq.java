/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.SCancelShouTuSuccess;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCCancelShouTuReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long masterRoleId;
/*    */   private final long sessionId;
/*    */   
/*    */   public PCCancelShouTuReq(long masterRoleId, long sessionId)
/*    */   {
/* 25 */     this.masterRoleId = masterRoleId;
/* 26 */     this.sessionId = sessionId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!ShiTuManager.isShiTuSwitchOpen(this.masterRoleId, "PCancelShouTuReq.processImp"))
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     Session session = ShouTuSession.getSession(this.sessionId);
/* 38 */     ShouTuSession shouTuSession = null;
/* 39 */     if ((session instanceof ShouTuSession))
/*    */     {
/* 41 */       shouTuSession = (ShouTuSession)session;
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 46 */       GameServer.logger().error(String.format("[shitu]PCancelShouTuReq.processImp@session is not exist|role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.sessionId) }));
/*    */       
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     long apprenticeRoleId = shouTuSession.getApprenticeRoleId();
/*    */     
/* 54 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/* 55 */     String apprenticeUserId = RoleInterface.getUserId(apprenticeRoleId);
/* 56 */     lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*    */     
/*    */ 
/* 59 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*    */     
/*    */ 
/* 62 */     if (!RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1713, true, true))
/*    */     {
/* 64 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 68 */     if (this.masterRoleId != shouTuSession.getRoleid())
/*    */     {
/* 70 */       GameServer.logger().error(String.format("[shitu]PCancelShouTuReq.processImp@session context not match|master_role_id=%d|session_master_role_id=%d|session_apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(shouTuSession.getRoleid()), Long.valueOf(shouTuSession.getApprenticeRoleId()), Long.valueOf(this.sessionId) }));
/*    */       
/*    */ 
/*    */ 
/* 74 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 78 */     if (ShouTuSession.getSession(this.sessionId) == null)
/*    */     {
/* 80 */       GameServer.logger().error(String.format("[shitu]PCancelShouTuReq.processImp@time out or session has removed|master_role_id=%d|session_apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(this.sessionId) }));
/*    */       
/*    */ 
/*    */ 
/* 84 */       return false;
/*    */     }
/* 86 */     ShouTuSession.removeSession(this.sessionId);
/*    */     
/* 88 */     SCancelShouTuSuccess sCancelShouTuSuccess = new SCancelShouTuSuccess();
/* 89 */     sCancelShouTuSuccess.masterroleid = this.masterRoleId;
/* 90 */     sCancelShouTuSuccess.masterrolename = RoleInterface.getName(this.masterRoleId);
/*    */     
/* 92 */     OnlineManager.getInstance().sendMulti(sCancelShouTuSuccess, Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*    */     
/* 94 */     GameServer.logger().info(String.format("[shitu]PCancelShouTuReq.processImp@handle cancel shou tu req success|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(shouTuSession.getApprenticeRoleId()), Long.valueOf(this.sessionId) }));
/*    */     
/*    */ 
/*    */ 
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCCancelShouTuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */