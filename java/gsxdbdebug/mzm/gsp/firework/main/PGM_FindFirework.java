/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCollectCfg;
/*    */ import mzm.gsp.activity3.confbean.STFireworkCollectCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ public class PGM_FindFirework extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int controllerId;
/*    */   
/*    */   public PGM_FindFirework(long roleId, int activityId, int controllerId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.activityId = activityId;
/* 20 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/* 27 */     if (cfg == null)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("活动配置不存在！|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/* 30 */       return false;
/*    */     }
/* 32 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("开关未打开！|switchId=%d", new Object[] { Integer.valueOf(cfg.switchId) }));
/* 35 */       return false;
/*    */     }
/* 37 */     if (!isActivityController(this.activityId, this.controllerId))
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("该活动下不存在此控制器id！|activityId=%d|controllerId=%d", new Object[] { Integer.valueOf(cfg.switchId), Integer.valueOf(this.controllerId) }));
/*    */       
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     FireworkManager.refreshFirework(this.activityId, this.controllerId);
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   boolean isActivityController(int activityId, int controllerId)
/*    */   {
/* 50 */     for (Iterator i$ = STFireworkCollectCfg.get(activityId).triggerInfos.iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*    */       
/* 52 */       if (SFireworkCollectCfg.get(cfgId).controllerId == controllerId)
/*    */       {
/* 54 */         return true;
/*    */       }
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\PGM_FindFirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */