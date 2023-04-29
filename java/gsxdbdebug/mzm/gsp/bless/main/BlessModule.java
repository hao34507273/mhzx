/*    */ package mzm.gsp.bless.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2bless;
/*    */ 
/*    */ public class BlessModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     BlessManager.init();
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
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
/* 41 */     List<Table> tables = new ArrayList();
/* 42 */     tables.add(Role2bless.getTable());
/* 43 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\main\BlessModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */