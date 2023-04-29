/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.CompetitionMatch;
/*    */ import xdb.Table;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.Role_competition;
/*    */ 
/*    */ public class CompetitionMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 22 */     List<Table> tables = new ArrayList();
/*    */     
/* 24 */     tables.add(xtable.Competition.getTable());
/* 25 */     tables.add(Faction_competition.getTable());
/* 26 */     tables.add(Role_competition.getTable());
/*    */     
/* 28 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 33 */     PCompetitionMerge pMerge = new PCompetitionMerge(null);
/* 34 */     if (!pMerge.call()) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private static class PCompetitionMerge
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       long mainKey = MergeMain.getMainZoneid();
/* 48 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/* 50 */       lock(xtable.Competition.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 52 */       xbean.Competition xViceCompetition = xtable.Competition.get(Long.valueOf(viceKey));
/*    */       
/* 54 */       if (xViceCompetition == null)
/*    */       {
/* 56 */         MergeMain.logger().warn("PCompetitionMerge.processImp@vice record null");
/* 57 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 61 */       xbean.Competition xMainCompetition = xtable.Competition.get(Long.valueOf(mainKey));
/* 62 */       if (xMainCompetition == null) {
/* 63 */         xMainCompetition = xbean.Pod.newCompetition();
/* 64 */         xtable.Competition.insert(Long.valueOf(mainKey), xMainCompetition);
/*    */       }
/*    */       
/* 67 */       Iterator<Map.Entry<CompetitionMatch, CompetitionAgainst>> iter = xViceCompetition.getAgainsts().entrySet().iterator();
/* 68 */       while (iter.hasNext()) {
/* 69 */         Map.Entry<CompetitionMatch, CompetitionAgainst> entry = (Map.Entry)iter.next();
/* 70 */         iter.remove();
/*    */         
/* 72 */         CompetitionMatch xMatch = (CompetitionMatch)entry.getKey();
/* 73 */         CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*    */         
/* 75 */         CompetitionAgainst xOld = (CompetitionAgainst)xMainCompetition.getAgainsts().put(xMatch, xAgainst);
/* 76 */         if (xOld != null) {
/* 77 */           MergeMain.formatLogError("PCompetitionMerge.processImp@duplicated against|factionid1=%d|factionid2=%d", new Object[] { Long.valueOf(xMatch.getFrontfaction()), Long.valueOf(xMatch.getBehindfaction()) });
/*    */           
/* 79 */           return false;
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 84 */       xtable.Competition.remove(Long.valueOf(viceKey));
/*    */       
/* 86 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */