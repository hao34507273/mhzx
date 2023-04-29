/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.SSyncTreasureBoxActivityLeftTime;
/*    */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxSwitchOpenForRole(((Long)this.arg).longValue())) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.CLOSE_STAGE) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/* 31 */     if (!OnlineTreasureBoxManager.canJoinOnlineTreasureBoxWithLevel(level)) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     SSyncTreasureBoxActivityLeftTime sSyncTreasureBoxActivityLeftTime = new SSyncTreasureBoxActivityLeftTime();
/* 36 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 38 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.BROADCAST_STAGE) {
/* 39 */       if (curTime >= OnlineTreasureBoxManager.TREASUREBOX_BROADCAST_TIME) {
/* 40 */         return false;
/*    */       }
/* 42 */       sSyncTreasureBoxActivityLeftTime.startlefttime = ((int)TimeUnit.MILLISECONDS.toSeconds(OnlineTreasureBoxManager.TREASUREBOX_BROADCAST_TIME - curTime));
/* 43 */       sSyncTreasureBoxActivityLeftTime.endlefttime = ((int)TimeUnit.MILLISECONDS.toSeconds(OnlineTreasureBoxManager.TREASUREBOX_ACTIVITY_END_TIME - curTime));
/* 44 */       OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), sSyncTreasureBoxActivityLeftTime);
/* 45 */       return true;
/*    */     }
/* 47 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.START_STAGE)
/*    */     {
/* 49 */       if (curTime >= OnlineTreasureBoxManager.TREASUREBOX_ACTIVITY_END_TIME) {
/* 50 */         return false;
/*    */       }
/* 52 */       sSyncTreasureBoxActivityLeftTime.endlefttime = ((int)TimeUnit.MILLISECONDS.toSeconds(OnlineTreasureBoxManager.TREASUREBOX_ACTIVITY_END_TIME - curTime));
/* 53 */       OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), sSyncTreasureBoxActivityLeftTime);
/*    */       
/* 55 */       BuffInterface.installBuff(((Long)this.arg).longValue(), OnlineTreasureBoxActivityConst.getInstance().activityAwardBuffId);
/* 56 */       return true;
/*    */     }
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */