/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BanquestInfo;
/*    */ import xbean.BanquestSessionInfo;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2banquestinfo;
/*    */ import xtable.Role2banqustsession;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 28 */         new POnRoleLogin.PCheckBanquest(POnRoleLogin.this, ((Long)POnRoleLogin.this.arg).longValue()).call();
/*    */         
/* 30 */         new PSynBanquestInfo(((Long)POnRoleLogin.this.arg).longValue()).call();
/*    */       }
/* 32 */     }.execute();
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private class PCheckBanquest
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long masterId;
/*    */     
/*    */ 
/*    */ 
/*    */     public PCheckBanquest(long masterId)
/*    */     {
/* 48 */       this.masterId = masterId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       String userId = RoleInterface.getUserId(this.masterId);
/* 56 */       lock(Lockeys.get(User.getTable(), userId));
/*    */       
/* 58 */       BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(this.masterId));
/* 59 */       if (xBanquestInfo == null)
/*    */       {
/* 61 */         return false;
/*    */       }
/* 63 */       if (!xBanquestInfo.getHoldbanqueststate())
/*    */       {
/* 65 */         return false;
/*    */       }
/* 67 */       BanquestSessionInfo xBanquestSessionInfo = Role2banqustsession.get(Long.valueOf(this.masterId));
/* 68 */       if (xBanquestSessionInfo != null)
/*    */       {
/* 70 */         GameServer.logger().info(String.format("[banquest]PCheckBanquest.processImp@ in hold banquest state, server restart not happened!|roleId=%d", new Object[] { Long.valueOf(this.masterId) }));
/*    */         
/*    */ 
/*    */ 
/* 74 */         return false;
/*    */       }
/*    */       
/* 77 */       xBanquestSessionInfo = Pod.newBanquestSessionInfo();
/* 78 */       Role2banqustsession.insert(Long.valueOf(this.masterId), xBanquestSessionInfo);
/*    */       
/* 80 */       if (!BanquestManager.reCheckAndInitBanquest(this.masterId, xBanquestInfo, xBanquestSessionInfo))
/*    */       {
/* 82 */         GameServer.logger().info(String.format("[banquest]PCheckBanquest.processImp@ reCheckAndInitBanquest fail!|roleId=%d", new Object[] { Long.valueOf(this.masterId) }));
/*    */       }
/*    */       
/*    */ 
/* 86 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */