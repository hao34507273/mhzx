/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2giftcards;
/*    */ import xtable.Role2levelaward;
/*    */ import xtable.Role2sign;
/*    */ 
/*    */ public class SignMerger implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/*    */     
/* 17 */     tables.add(Role2sign.getTable());
/* 18 */     tables.add(Role2levelaward.getTable());
/* 19 */     tables.add(xtable.Role2onlineaward.getTable());
/* 20 */     tables.add(xtable.Role2loginaward.getTable());
/* 21 */     tables.add(xtable.Role2openserver.getTable());
/* 22 */     tables.add(Role2giftcards.getTable());
/* 23 */     tables.add(xtable.Role2timelimitgift.getTable());
/*    */     
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\SignMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */