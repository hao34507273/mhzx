/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.qingfu.SSyncDailyGiftInfo;
/*    */ import mzm.gsp.qingfu.confbean.SDailyGiftConsts;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.DailyGiftInfo;
/*    */ import xtable.User2dailygift;
/*    */ 
/*    */ public class DailyGiftManager
/*    */ {
/*    */   public static boolean isFunOpen(long roleid)
/*    */   {
/* 17 */     if (!OpenInterface.getOpenStatus(202))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     if (OpenInterface.isBanPlay(roleid, 202))
/*    */     {
/* 23 */       OpenInterface.sendBanPlayMsg(roleid, 202);
/* 24 */       return false;
/*    */     }
/* 26 */     if (!OpenInterface.getOpenStatus(132))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (OpenInterface.isBanPlay(roleid, 132))
/*    */     {
/* 32 */       OpenInterface.sendBanPlayMsg(roleid, 202);
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean canDoAction(long roleid, int action)
/*    */   {
/* 49 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*    */   }
/*    */   
/*    */   public static void onRoleLogin(String userid, long roleid)
/*    */   {
/* 54 */     DailyGiftInfo xDailyGiftInfo = User2dailygift.get(userid);
/* 55 */     if (xDailyGiftInfo == null)
/*    */     {
/* 57 */       xDailyGiftInfo = xbean.Pod.newDailyGiftInfo();
/* 58 */       User2dailygift.insert(userid, xDailyGiftInfo);
/*    */     }
/*    */     
/* 61 */     long time = xDailyGiftInfo.getReceive_time();
/* 62 */     byte isReceive = (byte)(canReceive(time) ? 0 : 1);
/*    */     
/* 64 */     SSyncDailyGiftInfo msg = new SSyncDailyGiftInfo();
/* 65 */     msg.is_receive = isReceive;
/* 66 */     OnlineManager.getInstance().send(roleid, msg);
/*    */   }
/*    */   
/*    */   public static boolean canReceive(long time)
/*    */   {
/* 71 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 72 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SDailyGiftConsts.getInstance().DAYLY_GIFT_RESET_TIME);
/* 73 */     return DateTimeUtils.needDailyReset(time, now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\DailyGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */