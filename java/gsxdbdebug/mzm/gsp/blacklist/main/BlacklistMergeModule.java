/*    */ package mzm.gsp.blacklist.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Blacklist;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlacklistMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 17 */     List<Table> tables = new ArrayList();
/*    */     
/* 19 */     tables.add(Blacklist.getTable());
/*    */     
/* 21 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\BlacklistMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */