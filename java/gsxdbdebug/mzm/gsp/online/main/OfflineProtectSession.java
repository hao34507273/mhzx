/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LoginStatus;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class OfflineProtectSession extends Session
/*    */ {
/*    */   public OfflineProtectSession(long roleid, long timeout)
/*    */   {
/* 13 */     super(timeout, roleid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     final long roleid = getOwerId();
/* 19 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 24 */         String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 25 */         lock(Lockeys.get(xtable.User.getTable(), userid));
/*    */         
/* 27 */         LoginStatus loginStatus = xtable.Loginstatus.get(Long.valueOf(roleid));
/* 28 */         if (loginStatus == null) {
/* 29 */           return false;
/*    */         }
/* 31 */         if (loginStatus.getStatus() != 8) {
/* 32 */           return false;
/*    */         }
/* 34 */         loginStatus.setStatus(4);
/* 35 */         OnlineInfo onlineInfo = OnlineManager.getInstance().getOnlineInfo(roleid);
/* 36 */         if (onlineInfo != null) {
/* 37 */           onlineInfo.setOnlineStatus(4);
/*    */         } else {
/* 39 */           GameServer.logger().error(String.format("OfflineProtectSession.onTimeOut@不应该出现玩家在线情况不存在玩家的在线信息|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */         }
/*    */         
/* 42 */         new PPlayerPreLogout(roleid, 1).call();
/*    */         
/* 44 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OfflineProtectSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */