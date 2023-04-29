/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pod;
/*    */ import xbean.WantedRank;
/*    */ import xdb.Table;
/*    */ import xtable.Role2wantedawardinfo;
/*    */ import xtable.Role2wantedinfo;
/*    */ import xtable.Wantedrank;
/*    */ 
/*    */ public class WantedMerge implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 20 */     List<Table> tables = new ArrayList();
/* 21 */     tables.add(Wantedrank.getTable());
/* 22 */     tables.add(Role2wantedinfo.getTable());
/* 23 */     tables.add(Role2wantedawardinfo.getTable());
/* 24 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 30 */     if (!new WantedRankMerge().call())
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   class WantedRankMerge extends LogicProcedure
/*    */   {
/*    */     WantedRankMerge() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 42 */       long mainKey = MergeMain.getMainZoneid();
/* 43 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/* 45 */       lock(Wantedrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 47 */       WantedRank xViceWantedRank = Wantedrank.get(Long.valueOf(viceKey));
/* 48 */       if (xViceWantedRank == null)
/*    */       {
/* 50 */         return true;
/*    */       }
/* 52 */       WantedRank xMainWantedRank = Wantedrank.get(Long.valueOf(mainKey));
/* 53 */       if (xMainWantedRank == null)
/*    */       {
/* 55 */         xMainWantedRank = Pod.newWantedRank();
/* 56 */         Wantedrank.insert(Long.valueOf(mainKey), xMainWantedRank);
/*    */       }
/*    */       
/*    */ 
/* 60 */       xMainWantedRank.getRoleids().addAll(xViceWantedRank.getRoleids());
/*    */       
/*    */ 
/* 63 */       Wantedrank.remove(Long.valueOf(viceKey));
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */