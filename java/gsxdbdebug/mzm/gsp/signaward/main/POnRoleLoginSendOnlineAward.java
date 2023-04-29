/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OnlineAward;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2onlineaward;
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginSendOnlineAward
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/* 18 */     OnlineAward xOnlineAward = Role2onlineaward.get((Long)this.arg);
/*    */     
/* 20 */     if (xOnlineAward == null)
/*    */     {
/* 22 */       xOnlineAward = Pod.newOnlineAward();
/* 23 */       Role2onlineaward.insert((Long)this.arg, xOnlineAward);
/*    */       
/* 25 */       SignAwardManager.resetOnlineAward(xOnlineAward, cur);
/*    */ 
/*    */ 
/*    */     }
/* 29 */     else if ((!DateTimeUtils.isInSameDay(cur, xOnlineAward.getLogintime())) && (cur > xOnlineAward.getLogintime()))
/*    */     {
/* 31 */       SignAwardManager.resetOnlineAward(xOnlineAward, cur);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 36 */       xOnlineAward.setLogintime(cur);
/*    */     }
/*    */     
/*    */ 
/* 40 */     int onlinetime = (int)xOnlineAward.getOnlinetime();
/*    */     
/* 42 */     SignAwardManager.sendSSynOnlineTimeRes(((Long)this.arg).longValue(), onlinetime);
/* 43 */     SignAwardManager.sendSSynAwardedRes(((Long)this.arg).longValue(), xOnlineAward, null);
/*    */     
/* 45 */     String logstr = String.format("[onlineaward]POnRoleLoginSendOnlineAward.processImp@role login|roleid=%d|logintime=%s|totaltime=%d", new Object[] { this.arg, DateTimeUtils.formatTimestamp(cur), Integer.valueOf(onlinetime) });
/*    */     
/*    */ 
/* 48 */     SignAwardManager.logger.info(logstr);
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POnRoleLoginSendOnlineAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */