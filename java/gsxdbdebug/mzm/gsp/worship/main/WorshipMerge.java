/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Faction2worship;
/*    */ import xtable.Role2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorshipMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2worship.getTable());
/* 24 */     tables.add(Faction2worship.getTable());
/*    */     
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\WorshipMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */