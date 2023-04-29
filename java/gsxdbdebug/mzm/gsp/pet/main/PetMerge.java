/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2petbag;
/*    */ import xtable.Role2petdepot;
/*    */ import xtable.Role2petshop;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/* 22 */     tables.add(Role2petbag.getTable());
/* 23 */     tables.add(Role2petdepot.getTable());
/* 24 */     tables.add(Role2petshop.getTable());
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */