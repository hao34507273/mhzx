/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.SReplyPayRespect;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2PayRespectInfo;
/*    */ import xtable.Role2payrespect;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PayRespectSession extends Session
/*    */ {
/*    */   private final long apprenticeRoleId;
/*    */   
/*    */   public PayRespectSession(long interval, long masterRoleId, long apprenticeRoleId)
/*    */   {
/* 22 */     super(interval, masterRoleId);
/* 23 */     this.apprenticeRoleId = apprenticeRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     PPayRespectOnTimeOut payRespectOnTimeOut = new PPayRespectOnTimeOut(super.getOwerId(), this.apprenticeRoleId);
/* 30 */     payRespectOnTimeOut.execute();
/*    */   }
/*    */   
/*    */   public long getApprenticeRoleId()
/*    */   {
/* 35 */     return this.apprenticeRoleId;
/*    */   }
/*    */   
/*    */   private static class PPayRespectOnTimeOut extends LogicProcedure
/*    */   {
/*    */     private final long masterRoleId;
/*    */     private final long apprenticeRoleId;
/*    */     
/*    */     public PPayRespectOnTimeOut(long masterRoleId, long apprenticeRoleId)
/*    */     {
/* 45 */       this.masterRoleId = masterRoleId;
/* 46 */       this.apprenticeRoleId = apprenticeRoleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 52 */       String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/* 53 */       String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/* 54 */       lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/* 55 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*    */       
/* 57 */       ShiTuManager.checkAndInitPayRespectInfo(this.apprenticeRoleId, this.masterRoleId);
/* 58 */       Role2PayRespectInfo xApprenticePayRespectInfo = Role2payrespect.get(Long.valueOf(this.apprenticeRoleId));
/* 59 */       Role2PayRespectInfo xMasterPayRespectInfo = Role2payrespect.get(Long.valueOf(this.masterRoleId));
/* 60 */       if ((!xApprenticePayRespectInfo.getApprentice_is_paying_respect()) || (!xMasterPayRespectInfo.getMaster_is_paying_respect()))
/*    */       {
/* 62 */         GameServer.logger().info(String.format("[shitu]PayRespectSession.PPayRespectOnTimeOut.processImp@pay respect may be answered|master_role_id=%d|apprentice_role_id=%d|apprentice_state=%b|master_state=%b", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), Boolean.valueOf(xApprenticePayRespectInfo.getApprentice_is_paying_respect()), Boolean.valueOf(xMasterPayRespectInfo.getMaster_is_paying_respect()) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 67 */         return false;
/*    */       }
/* 69 */       xApprenticePayRespectInfo.setApprentice_is_paying_respect(false);
/*    */       
/* 71 */       xMasterPayRespectInfo.setMaster_is_paying_respect(false);
/*    */       
/* 73 */       SReplyPayRespect sReplyPayRespect = new SReplyPayRespect();
/* 74 */       sReplyPayRespect.master_role_id = this.masterRoleId;
/* 75 */       sReplyPayRespect.apprentice_role_id = this.apprenticeRoleId;
/* 76 */       sReplyPayRespect.operator = 2;
/*    */       
/* 78 */       OnlineManager.getInstance().send(this.apprenticeRoleId, sReplyPayRespect);
/*    */       
/* 80 */       ShiTuManager.tlogShiTuPayRespect(this.apprenticeRoleId, apprenticeUserId, this.masterRoleId, masterUserId, ShiTuPayRespectTLogEnum.PAY_RESPECT_TIME_OUT);
/*    */       
/*    */ 
/* 83 */       GameServer.logger().info(String.format("[shitu]PayRespectSession.PPayRespectOnTimeOut.processImp@pay respect time out|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*    */       
/*    */ 
/*    */ 
/* 87 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PayRespectSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */