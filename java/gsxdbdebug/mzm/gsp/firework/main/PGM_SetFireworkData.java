/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_SetFireworkData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int findLastInterval;
/*    */   private final int triggerCount;
/*    */   private final int triggerShowNeedCount;
/*    */   
/*    */   public PGM_SetFireworkData(long roleId, int activityId, int findLastInterval, int triggerCount, int triggerShowNeedCount)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.activityId = activityId;
/* 23 */     this.findLastInterval = findLastInterval;
/* 24 */     this.triggerCount = triggerCount;
/* 25 */     this.triggerShowNeedCount = triggerShowNeedCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (SFireworkCfg.get(this.activityId) == null)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("操作失败：非烟花活动！|活动=%d", new Object[] { Integer.valueOf(this.activityId) }));
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if ((this.findLastInterval > 0) && (this.findLastInterval > TimeUnit.MINUTES.toSeconds(30L)))
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, "操作失败：找烟花需要的时长 不能大于 30分钟！");
/* 40 */       return false;
/*    */     }
/* 42 */     if ((this.triggerCount > 0) && (this.triggerCount > 200))
/*    */     {
/* 44 */       GmManager.getInstance().sendResultToGM(this.roleId, "操作失败：触发采集物个数 不能大于 200个！");
/* 45 */       return false;
/*    */     }
/* 47 */     String str = FireworkGmDataCache.getInstance().setNewData(this.activityId, this.findLastInterval, this.triggerCount, this.triggerShowNeedCount);
/*    */     
/*    */ 
/* 50 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置后：%s", new Object[] { str }));
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\PGM_SetFireworkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */