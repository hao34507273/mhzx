/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FireworkRecord;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_StartFirework
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGM_StartFirework(long roleId, int activityId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/* 30 */     if (cfg == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("活动配置不存在！|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/* 33 */       return false;
/*    */     }
/* 35 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("开关未打开！|switchId=%d", new Object[] { Integer.valueOf(cfg.switchId) }));
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     FireworkRecord xFireworkRecord = FireworkManager.getXFireworkRecordIfAbsent(this.activityId);
/*    */     
/* 43 */     Session.removeSession(xFireworkRecord.getCleansessionid());
/*    */     
/* 45 */     xFireworkRecord.setCleansessionid(0L);
/* 46 */     FireworkManager.startFirework(this.activityId, OperFireorkReason.TIG_GM, xFireworkRecord);
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\PGM_StartFirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */