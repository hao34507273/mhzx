/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2partnerbag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PartnerMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2partnerbag.getTable());
/*    */     
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */