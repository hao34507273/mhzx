/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2daytargetdata;
/*    */ import xtable.Role2daytargetinfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrowMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2daytargetinfo.getTable());
/* 24 */     tables.add(Role2daytargetdata.getTable());
/* 25 */     tables.add(Role2levelguide.getTable());
/*    */     
/* 27 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\GrowMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */