/*    */ package mzm.gsp.legoushangcheng.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2legoushangchenginfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeGouShangChengMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 17 */     ArrayList<Table> tables = new ArrayList();
/* 18 */     tables.add(Role2legoushangchenginfo.getTable());
/* 19 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\main\LeGouShangChengMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */