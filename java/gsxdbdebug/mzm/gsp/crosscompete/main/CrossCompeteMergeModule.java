/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.CrossCompeteSignUp;
/*     */ import xdb.Table;
/*     */ import xtable.Crosscompete;
/*     */ import xtable.Role_crosscompete;
/*     */ 
/*     */ public class CrossCompeteMergeModule implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  22 */     List<Table> tables = new java.util.ArrayList();
/*  23 */     tables.add(Crosscompete.getTable());
/*  24 */     tables.add(xtable.Faction_crosscompete.getTable());
/*  25 */     tables.add(xtable.Roam_crosscompete_faction.getTable());
/*  26 */     tables.add(xtable.Roam_crosscompete_role.getTable());
/*  27 */     tables.add(Role_crosscompete.getTable());
/*  28 */     return tables;
/*     */   }
/*     */   
/*     */   public boolean handleMerge()
/*     */   {
/*  33 */     if (!new PMergeCrossCompete().call()) {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   static class PMergeCrossCompete
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  45 */       long mainKey = MergeMain.getMainZoneid();
/*  46 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  48 */       lock(Crosscompete.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  50 */       CrossCompete xMainCompete = Crosscompete.get(Long.valueOf(mainKey));
/*  51 */       CrossCompete xViceCompete = Crosscompete.get(Long.valueOf(viceKey));
/*     */       
/*  53 */       if (xViceCompete == null)
/*     */       {
/*  55 */         MergeMain.logger().warn("PMergeCrossCompete.processImp@vice record null");
/*  56 */         return true;
/*     */       }
/*     */       
/*  59 */       if (xMainCompete == null) {
/*  60 */         xMainCompete = xbean.Pod.newCrossCompete();
/*  61 */         Crosscompete.insert(Long.valueOf(mainKey), xMainCompete);
/*  62 */         CrossCompeteManager.initXCrossCompete(xMainCompete);
/*     */       }
/*     */       
/*     */ 
/*  66 */       Iterator<Map.Entry<Long, CrossCompeteSignUp>> signUpIter = xViceCompete.getSignup_factions().entrySet().iterator();
/*     */       
/*  68 */       while (signUpIter.hasNext()) {
/*  69 */         Map.Entry<Long, CrossCompeteSignUp> entry = (Map.Entry)signUpIter.next();
/*  70 */         signUpIter.remove();
/*     */         
/*  72 */         long factionid = ((Long)entry.getKey()).longValue();
/*  73 */         CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)entry.getValue();
/*     */         
/*  75 */         CrossCompeteSignUp xOld = (CrossCompeteSignUp)xMainCompete.getSignup_factions().put(Long.valueOf(factionid), xSignUp);
/*  76 */         if (xOld != null) {
/*  77 */           MergeMain.formatLogError("PMergeCrossCompete.processImp@duplicated sign up|factionid=%d", new Object[] { Long.valueOf(factionid) });
/*     */           
/*     */ 
/*  80 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  87 */       Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> againstIter = xViceCompete.getAgainsts().entrySet().iterator();
/*     */       
/*     */ 
/*  90 */       while (againstIter.hasNext()) {
/*  91 */         Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)againstIter.next();
/*  92 */         againstIter.remove();
/*  93 */         CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/*  94 */         CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*     */         
/*  96 */         xMainCompete.getAgainsts().put(cMatch, xAgainst);
/*     */       }
/*     */       
/*     */ 
/* 100 */       xMainCompete.getMiss_turn_factions().addAll(xViceCompete.getMiss_turn_factions());
/*     */       
/*     */ 
/* 103 */       Crosscompete.remove(Long.valueOf(viceKey));
/*     */       
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */