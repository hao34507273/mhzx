/*    */ package mzm.gsp.yuanbao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Buyyuanbaoorder;
/*    */ import xtable.Role2yuanbaoinfo;
/*    */ 
/*    */ public class YuanbaoMerger
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/*    */     
/* 17 */     tables.add(Role2yuanbaoinfo.getTable());
/* 18 */     tables.add(Buyyuanbaoorder.getTable());
/*    */     
/* 20 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\YuanbaoMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */