/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2factiontaskinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangTaskMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2factiontaskinfo.getTable());
/*    */     
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\GangTaskMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */