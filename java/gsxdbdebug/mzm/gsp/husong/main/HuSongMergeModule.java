/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2husong;
/*    */ 
/*    */ public class HuSongMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 13 */     List<Table> tables = new ArrayList();
/*    */     
/* 15 */     tables.add(Role2husong.getTable());
/* 16 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */