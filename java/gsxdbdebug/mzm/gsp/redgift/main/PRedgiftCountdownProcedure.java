/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.SSyncRedgiftActivityLeftTime;
/*    */ import mzm.gsp.activity.confbean.RedGiftActivityConst;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRedgiftCountdownProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int minute;
/*    */   
/*    */   public PRedgiftCountdownProcedure(int minute)
/*    */   {
/* 24 */     this.minute = minute;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     long leftTime = TimeUnit.MINUTES.toSeconds(this.minute);
/*    */     
/* 37 */     SSyncRedgiftActivityLeftTime sSyncRedgiftActivityLeftTime = new SSyncRedgiftActivityLeftTime();
/* 38 */     sSyncRedgiftActivityLeftTime.lefttime = ((int)leftTime);
/* 39 */     List<Long> levelHighSet = OnlineManager.getInstance().getOnlineHigherRoleidList(ActivityInterface.getActivityLevelMin(RedGiftActivityConst.getInstance().activityId));
/* 40 */     List<Long> levelLowSet = OnlineManager.getInstance().getOnlineLowererRoleidList(ActivityInterface.getActivityLevelMax(RedGiftActivityConst.getInstance().activityId));
/* 41 */     List<Long> receiverSet = new ArrayList();
/* 42 */     for (Iterator i$ = levelHighSet.iterator(); i$.hasNext();) { long rolid = ((Long)i$.next()).longValue();
/* 43 */       if (levelLowSet.contains(Long.valueOf(rolid))) {
/* 44 */         receiverSet.add(Long.valueOf(rolid));
/*    */       }
/*    */     }
/* 47 */     OnlineManager.getInstance().sendMulti(sSyncRedgiftActivityLeftTime, receiverSet);
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\PRedgiftCountdownProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */