/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GetFirworkData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGM_GetFirworkData(long roleId, int activityId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("活动配置不存在！|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/* 31 */       return false;
/*    */     }
/* 33 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("%s", new Object[] { FireworkGmDataCache.getInstance().getActivityGMData(this.activityId).getActivityDataString() }));
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\PGM_GetFirworkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */