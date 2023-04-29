/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xbean.PrisonRank;
/*    */ import xdb.Table;
/*    */ import xtable.Prisonrank;
/*    */ import xtable.Role2jailprotect;
/*    */ import xtable.Role2jailstatinfo;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ public class PrisonMerge implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 19 */     List<Table> tables = new ArrayList();
/* 20 */     tables.add(Prisonrank.getTable());
/* 21 */     tables.add(Role2prisoninfo.getTable());
/* 22 */     tables.add(Role2jailprotect.getTable());
/* 23 */     tables.add(Role2jailstatinfo.getTable());
/* 24 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 30 */     if (!new PrisonRankMerge().call())
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   class PrisonRankMerge extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     PrisonRankMerge() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 42 */       long mainKey = MergeMain.getMainZoneid();
/* 43 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/* 45 */       lock(Prisonrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 47 */       PrisonRank xVicePrisonRank = Prisonrank.get(Long.valueOf(viceKey));
/* 48 */       if (xVicePrisonRank == null)
/*    */       {
/* 50 */         return true;
/*    */       }
/* 52 */       PrisonRank xMainPrisonRank = Prisonrank.get(Long.valueOf(mainKey));
/* 53 */       if (xMainPrisonRank == null)
/*    */       {
/* 55 */         xMainPrisonRank = xbean.Pod.newPrisonRank();
/* 56 */         Prisonrank.insert(Long.valueOf(mainKey), xMainPrisonRank);
/*    */       }
/*    */       
/*    */ 
/* 60 */       xMainPrisonRank.getRoleids().addAll(xVicePrisonRank.getRoleids());
/*    */       
/*    */ 
/* 63 */       Prisonrank.remove(Long.valueOf(viceKey));
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */