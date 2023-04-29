/*    */ package mzm.gsp.zhenfa.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2zhenfa;
/*    */ 
/*    */ 
/*    */ public class ZhenfaMerger
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/*    */     
/* 17 */     tables.add(Role2zhenfa.getTable());
/*    */     
/* 19 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\ZhenfaMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */