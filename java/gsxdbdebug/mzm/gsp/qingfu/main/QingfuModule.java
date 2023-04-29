/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Checkorders;
/*    */ import xtable.Qingfu;
/*    */ import xtable.User2dailygift;
/*    */ 
/*    */ public class QingfuModule implements mzm.event.Module, mzm.event.PostModuleInitListner, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     QingfuArgs.init();
/*    */     
/* 18 */     QingfuManager.init(envs);
/*    */     
/* 20 */     SaveAmtActivityManager.init();
/*    */     
/* 22 */     LevelGrowthFundActivityManager.init();
/*    */     
/* 24 */     MonthCardActivityManager.init();
/*    */     
/* 26 */     AccumTotalCostActivityManager.init();
/*    */     
/* 28 */     TimeLimitGiftActivityManager.init();
/*    */     
/* 30 */     RMBGiftBagActivityManager.init();
/*    */     
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 50 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void postInit() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 62 */     List<Table> tables = new ArrayList();
/* 63 */     tables.add(Qingfu.getTable());
/* 64 */     tables.add(xtable.User2auanycheckorders.getTable());
/* 65 */     tables.add(Checkorders.getTable());
/* 66 */     tables.add(User2dailygift.getTable());
/* 67 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\QingfuModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */