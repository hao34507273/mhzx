/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xdb.Table;
/*    */ import xtable.Role2christmasstockinginfo;
/*    */ 
/*    */ 
/*    */ public class ChristmasStockingModule
/*    */   implements Module, MergeModule, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 38 */     ActivityInterface.registerActivityByLogicType(146, new ChristmasStockingActivityHandler(), false);
/*    */     
/* 40 */     ActivityInterface.registerActivityByLogicType(147, new ChristmasStockingHidingActivityHandler(), false);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 45 */     int activityCfgId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/* 46 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityCfgId);
/* 47 */     long activityEndTime = TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/* 48 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 49 */     long retainMillisecs = SChristmasStockingConsts.getInstance().AFTER_ACTIVITY_RETAIN_MINUTES * 60000L;
/*    */     
/* 51 */     long activityAlreadyEndTime = currentTime - activityEndTime;
/* 52 */     if ((activityAlreadyEndTime > 0L) && (activityAlreadyEndTime < retainMillisecs))
/*    */     {
/* 54 */       new RemoveTreeObserver((retainMillisecs - activityAlreadyEndTime) / 1000L);
/*    */     }
/*    */     
/* 57 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 63 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 70 */     ArrayList<Table> tables = new ArrayList(1);
/* 71 */     tables.add(Role2christmasstockinginfo.getTable());
/* 72 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 78 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 85 */     int handlerType = SChristmasStockingHidingConsts.getInstance().HANDLER_TYPE;
/* 86 */     if (!MapInterface.regisMapItemGatherHandler(handlerType, new StockingGatherHandler()))
/*    */     {
/* 88 */       throw new RuntimeException(String.format("[christmasstocking]ChristmasStockingModule.postInit@regisMapItemGatherHandler failed!|handlerType=%d", new Object[] { Integer.valueOf(handlerType) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\ChristmasStockingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */