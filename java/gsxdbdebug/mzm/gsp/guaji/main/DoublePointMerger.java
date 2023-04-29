/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DoubleTime;
/*    */ import xdb.Table;
/*    */ import xtable.Doubletime;
/*    */ import xtable.Role2doublepoint;
/*    */ 
/*    */ public class DoublePointMerger implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 18 */     List<Table> tables = new ArrayList();
/* 19 */     tables.add(Role2doublepoint.getTable());
/* 20 */     tables.add(Doubletime.getTable());
/*    */     
/* 22 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 29 */     return new Merge_Flowerpointclear_Pro(null).call();
/*    */   }
/*    */   
/*    */   private static class Merge_Flowerpointclear_Pro
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 38 */       long mainKey = MergeMain.getMainZoneid();
/* 39 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/* 41 */       lock(Doubletime.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 42 */       DoubleTime xMain = Doubletime.get(Long.valueOf(mainKey));
/* 43 */       DoubleTime xVice = Doubletime.get(Long.valueOf(viceKey));
/*    */       
/*    */ 
/* 46 */       xMain.setPointoffertime(Math.max(xMain.getPointoffertime(), xVice.getPointoffertime()));
/* 47 */       xMain.setItemcountcleartime(Math.max(xMain.getItemcountcleartime(), xVice.getItemcountcleartime()));
/*    */       
/* 49 */       Doubletime.remove(Long.valueOf(viceKey));
/* 50 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\DoublePointMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */