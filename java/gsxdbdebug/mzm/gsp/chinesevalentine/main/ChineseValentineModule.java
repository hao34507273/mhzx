/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2chinesevalentineaward;
/*    */ 
/*    */ 
/*    */ public class ChineseValentineModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 17 */     List<Table> tables = new ArrayList();
/* 18 */     tables.add(Role2chinesevalentineaward.getTable());
/* 19 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 31 */     ChineseValentineManager.init();
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 46 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 53 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */