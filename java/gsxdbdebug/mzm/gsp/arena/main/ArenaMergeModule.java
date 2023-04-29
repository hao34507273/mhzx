/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaChart;
/*    */ import xdb.Table;
/*    */ import xtable.Arena;
/*    */ import xtable.Arenachart;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ public class ArenaMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 20 */     List<Table> tables = new ArrayList();
/* 21 */     tables.add(Arena.getTable());
/* 22 */     tables.add(Arenachart.getTable());
/* 23 */     tables.add(Arenascore.getTable());
/*    */     
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 30 */     if (!new PMergeArena(null).call()) {
/* 31 */       MergeMain.formatLogError("ArenaMergeModule.handleMerge@merge arena failed!", new Object[0]);
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!new PClearArenaChart(null).call()) {
/* 36 */       MergeMain.formatLogError("ArenaMergeModule.handleMerge@clear chart failed!", new Object[0]);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static class PMergeArena
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/*    */ 
/* 58 */       Arena.remove(Long.valueOf(viceKey));
/*    */       
/* 60 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static class PClearArenaChart
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 75 */       long mainKey = MergeMain.getMainZoneid();
/* 76 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/*    */ 
/* 79 */       lock(Arenachart.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 81 */       ArenaChart xChart = Arenachart.get(Long.valueOf(mainKey));
/* 82 */       if (xChart == null) {
/* 83 */         MergeMain.formatLogWarn("PClearArenaChart.processImp@xarenachart null|key=%d", new Object[] { Long.valueOf(mainKey) });
/*    */       }
/*    */       else {
/* 86 */         xChart.getRanklist().clear();
/*    */       }
/*    */       
/*    */ 
/* 90 */       Arenachart.remove(Long.valueOf(viceKey));
/*    */       
/* 92 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */