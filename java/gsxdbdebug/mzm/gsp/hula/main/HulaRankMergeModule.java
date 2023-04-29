/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.HulaRank;
/*    */ import xdb.Table;
/*    */ import xtable.Hularank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HulaRankMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 23 */     return Arrays.asList(new Table[] { Hularank.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 29 */     if (!new PHulaRankMerge(null).call())
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   private static class PHulaRankMerge
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       long mainZoneid = MergeMain.getMainZoneid();
/* 43 */       long viceZoneid = MergeMain.getViceZoneid();
/* 44 */       Set<Long> zoneids = new HashSet();
/* 45 */       zoneids.add(Long.valueOf(mainZoneid));
/* 46 */       zoneids.add(Long.valueOf(viceZoneid));
/* 47 */       lock(Hularank.getTable(), zoneids);
/* 48 */       HulaRank xMainHulaRank = Hularank.get(Long.valueOf(mainZoneid));
/* 49 */       HulaRank xViceHulaRank = Hularank.get(Long.valueOf(viceZoneid));
/*    */       
/* 51 */       if ((xMainHulaRank == null) && (xViceHulaRank == null))
/*    */       {
/* 53 */         return true;
/*    */       }
/*    */       
/* 56 */       if ((xMainHulaRank != null) && (xViceHulaRank == null))
/*    */       {
/* 58 */         return true;
/*    */       }
/*    */       
/* 61 */       if ((xMainHulaRank == null) && (xViceHulaRank != null))
/*    */       {
/* 63 */         Hularank.remove(Long.valueOf(viceZoneid));
/* 64 */         Hularank.insert(Long.valueOf(mainZoneid), xViceHulaRank.copy());
/* 65 */         return true;
/*    */       }
/*    */       
/* 68 */       xMainHulaRank.getRanklist().addAll(xViceHulaRank.getRanklist());
/* 69 */       Hularank.remove(Long.valueOf(viceZoneid));
/* 70 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaRankMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */