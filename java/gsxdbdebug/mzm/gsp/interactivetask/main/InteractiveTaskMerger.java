/*    */ package mzm.gsp.interactivetask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2interactivetask;
/*    */ 
/*    */ 
/*    */ public class InteractiveTaskMerger
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/* 16 */     tables.add(Role2interactivetask.getTable());
/* 17 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\InteractiveTaskMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */