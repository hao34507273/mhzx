/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RSendMailOnActivityStart
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   RSendMailOnActivityStart(int activityId)
/*    */   {
/* 19 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     int minLevel = SActivityCfg.get(this.activityId).levelMin - 1;
/* 26 */     Set<Long> roleIds = OnlineManager.getInstance().getOnlineHigherRoleidSet(minLevel);
/* 27 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 28 */       new PCheckAndSendRewardMail(this.activityId, roleId).call();
/*    */     }
/* 30 */     GratefulDeliveryManager.info(this, ".process()@done|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityId) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\RSendMailOnActivityStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */