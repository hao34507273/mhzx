/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2zhenyaocount;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhenyaoMerger
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 16 */     List<Table> tables = new ArrayList();
/*    */     
/* 18 */     tables.add(Role2zhenyaocount.getTable());
/*    */     
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenyaoMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */