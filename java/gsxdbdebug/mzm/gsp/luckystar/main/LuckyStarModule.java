/*    */ package mzm.gsp.luckystar.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2luckystar;
/*    */ 
/*    */ 
/*    */ public class LuckyStarModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 18 */     return Arrays.asList(new Table[] { Role2luckystar.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 30 */     LuckyStarActivityHandler handler = new LuckyStarActivityHandler();
/* 31 */     ActivityInterface.registerActivityByLogicType(63, handler);
/*    */     
/* 33 */     LuckyStarManager.init();
/*    */     
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 47 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 53 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\LuckyStarModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */