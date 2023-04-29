/*    */ package mzm.gsp.exchange.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2exchangeinfo;
/*    */ 
/*    */ public class ExchangeModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 16 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 22 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 28 */     ExchangeManager.init();
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 41 */     return Arrays.asList(new Table[] { Role2exchangeinfo.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\ExchangeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */