/*    */ package mzm.gsp.axe.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role_axe_activity_infos;
/*    */ import xtable.User_axe_activity_infos;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AxeMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 19 */     return Arrays.asList(new Table[] { Role_axe_activity_infos.getTable(), User_axe_activity_infos.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\AxeMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */