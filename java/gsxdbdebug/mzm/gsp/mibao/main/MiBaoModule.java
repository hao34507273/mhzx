/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.item.main.access.ItemAccessManager;
/*    */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*    */ import xdb.Table;
/*    */ import xtable.Role2mibao;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MiBaoModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 23 */     MiBaoActivityHandler handler = new MiBaoActivityHandler();
/* 24 */     ActivityInterface.registerActivityByLogicType(48, handler);
/*    */     
/*    */ 
/* 27 */     ItemAccessManager.registerActivityReward(BaoKuConsts.getInstance().miBaoActivityId, BaoKuConsts.getInstance().itemAwardId);
/*    */     
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 47 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 53 */     return Arrays.asList(new Table[] { Role2mibao.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\MiBaoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */