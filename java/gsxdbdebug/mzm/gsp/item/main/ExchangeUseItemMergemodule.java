/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role_exchange_use_item_infos;
/*    */ 
/*    */ public class ExchangeUseItemMergemodule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 14 */     return Arrays.asList(new Table[] { Role_exchange_use_item_infos.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ExchangeUseItemMergemodule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */