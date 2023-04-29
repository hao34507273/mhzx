/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2leveltask;
/*    */ import xtable.Role2singleinfo;
/*    */ 
/*    */ public class SingleTaskMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/*    */     
/* 17 */     tables.add(Role2singleinfo.getTable());
/* 18 */     tables.add(Role2leveltask.getTable());
/*    */     
/* 20 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\SingleTaskMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */