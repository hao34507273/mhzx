/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Table;
/*    */ import xtable.Constellation;
/*    */ import xtable.Role2constellation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConstellationMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 19 */     List<Table> tables = new ArrayList();
/*    */     
/* 21 */     tables.add(Constellation.getTable());
/* 22 */     tables.add(Role2constellation.getTable());
/*    */     
/* 24 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 29 */     if (!new PConstellationMerge(null).call()) {
/* 30 */       MergeMain.formatLogError("ConstellationMergeModule.handleMerge@merge constellation error", new Object[0]);
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   private static class PConstellationMerge
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 42 */       long viceKey = MergeMain.getViceZoneid();
/* 43 */       Constellation.remove(Long.valueOf(viceKey));
/*    */       
/* 45 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\ConstellationMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */