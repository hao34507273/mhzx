/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.homeland.event.CreateHomeWorldArg;
/*    */ import mzm.gsp.homeland.event.CreateHomeWorldEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BanquestInfo;
/*    */ import xbean.BanquestSessionInfo;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2banquestinfo;
/*    */ import xtable.Role2banqustsession;
/*    */ import xtable.User;
/*    */ 
/*    */ public class CreateHomeWorldEvent
/*    */   extends CreateHomeWorldEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long masterId = ((CreateHomeWorldArg)this.arg).ownerRoleId;
/*    */     
/*    */ 
/* 24 */     String userId = RoleInterface.getUserId(masterId);
/* 25 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 27 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/* 28 */     if (xBanquestInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!xBanquestInfo.getHoldbanqueststate())
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     BanquestSessionInfo xBanquestSessionInfo = Role2banqustsession.get(Long.valueOf(masterId));
/* 37 */     if (xBanquestSessionInfo != null)
/*    */     {
/* 39 */       GameServer.logger().info(String.format("[banquest]CreateHomeWorldEvent.processImp@ in hold banquest state, server restart not happened!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     xBanquestSessionInfo = Pod.newBanquestSessionInfo();
/* 47 */     Role2banqustsession.insert(Long.valueOf(masterId), xBanquestSessionInfo);
/*    */     
/* 49 */     if (!BanquestManager.reCheckAndInitBanquest(masterId, xBanquestInfo, xBanquestSessionInfo))
/*    */     {
/* 51 */       GameServer.logger().info(String.format("[banquest]CreateHomeWorldEvent.processImp@ reCheckAndInitBanquest fail!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*    */     }
/*    */     
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\CreateHomeWorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */