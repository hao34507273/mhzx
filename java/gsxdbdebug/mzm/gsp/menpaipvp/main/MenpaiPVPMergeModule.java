/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MenpaiPVPCharts;
/*    */ import xdb.Table;
/*    */ import xtable.Menpaipvpcharts;
/*    */ import xtable.Menpaipvpscore;
/*    */ 
/*    */ public class MenpaiPVPMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 20 */     List<Table> tables = new ArrayList();
/*    */     
/* 22 */     tables.add(Menpaipvpscore.getTable());
/* 23 */     tables.add(Menpaipvpcharts.getTable());
/*    */     
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 33 */     if (!new PClearMenpaiPVPCharts(null).call()) {
/* 34 */       MergeMain.formatLogError("MenpaiPVPMergeModule.handleMerge@handle charts failed!!!", new Object[0]);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static class PClearMenpaiPVPCharts
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 51 */       long mainKey = MergeMain.getMainZoneid();
/* 52 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/*    */ 
/* 55 */       lock(Menpaipvpcharts.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 57 */       MenpaiPVPCharts xMainCharts = Menpaipvpcharts.get(Long.valueOf(mainKey));
/* 58 */       if (xMainCharts != null) {
/* 59 */         xMainCharts.getCharts().clear();
/*    */       }
/*    */       
/*    */ 
/* 63 */       Menpaipvpcharts.remove(Long.valueOf(viceKey));
/*    */       
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */