/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2magicmark;
/*    */ 
/*    */ public class MagicMarkMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 13 */     List<Table> lists = new ArrayList();
/* 14 */     lists.add(Role2magicmark.getTable());
/* 15 */     return lists;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\MagicMarkMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */