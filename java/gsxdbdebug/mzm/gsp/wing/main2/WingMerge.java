/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2wing;
/*    */ import xtable.Role2wingmodel;
/*    */ import xtable.Role2wingplans;
/*    */ import xtable.Role2wingrandomproperty;
/*    */ import xtable.Role2wingrandomskill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2wingplans.getTable());
/*    */     
/* 25 */     tables.add(Role2wing.getTable());
/* 26 */     tables.add(Role2wingrandomproperty.getTable());
/* 27 */     tables.add(Role2wingrandomskill.getTable());
/* 28 */     tables.add(Role2wingmodel.getTable());
/*    */     
/* 30 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */