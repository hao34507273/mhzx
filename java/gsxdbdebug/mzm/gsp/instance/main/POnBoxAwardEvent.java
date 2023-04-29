/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*    */ import mzm.gsp.instance.event.BoxAwardArg;
/*    */ import xbean.InstanceCacheBean;
/*    */ 
/*    */ public class POnBoxAwardEvent extends mzm.gsp.instance.event.BoxAwardEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AwardContext awardContext = ((BoxAwardArg)this.arg).awardContext;
/* 12 */     if ((awardContext instanceof TeamAwardContext)) {
/* 13 */       TeamAwardContext teamAwardContext = (TeamAwardContext)awardContext;
/* 14 */       long instanceUUid = teamAwardContext.instanceUuid;
/*    */       
/* 16 */       InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(Long.valueOf(instanceUUid));
/* 17 */       if (xInstanceCacheBean == null) {
/* 18 */         return false;
/*    */       }
/* 20 */       xInstanceCacheBean.getExtra().put(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_AWARD_STATUS.ordinal()), Integer.valueOf(3));
/*    */       
/* 22 */       mzm.gsp.instance.SSynInstanceLeaveTimer synInstanceLeaveTimer = new mzm.gsp.instance.SSynInstanceLeaveTimer();
/* 23 */       synInstanceLeaveTimer.instancecfgid = xInstanceCacheBean.getInstancecfgid();
/* 24 */       mzm.gsp.online.main.OnlineManager.getInstance().sendMulti(synInstanceLeaveTimer, xInstanceCacheBean.getRoleids());
/*    */       
/* 26 */       new TeamInstanceLeaveTimer(SInstanceConsts.getInstance().MULTI_INSTANCE_LEAVE_TIMER, instanceUUid, xInstanceCacheBean.getRoleids());
/*    */     }
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnBoxAwardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */