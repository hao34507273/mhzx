/*    */ package mzm.gsp.mondayfree.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2mondayfree;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MondayFreeMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 17 */     List<Table> tables = new ArrayList();
/* 18 */     tables.add(Role2mondayfree.getTable());
/* 19 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\MondayFreeMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */