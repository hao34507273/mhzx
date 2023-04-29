/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Ceremony;
/*     */ import xbean.Ceremonys;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xtable.Marriageparade;
/*     */ import xtable.Weddingceremony;
/*     */ 
/*     */ public class MarriageMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger(MarriageMergeModule.class);
/*     */   
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> tableList = new java.util.ArrayList();
/*     */     
/*  23 */     tableList.add(xtable.Role2lesscold1.getTable());
/*     */     
/*  25 */     tableList.add(Weddingceremony.getTable());
/*     */     
/*  27 */     tableList.add(xtable.Marriage.getTable());
/*     */     
/*  29 */     tableList.add(xtable.Role2marriage.getTable());
/*     */     
/*  31 */     tableList.add(xtable.Role2notnotifymarriage.getTable());
/*     */     
/*  33 */     tableList.add(Marriageparade.getTable());
/*  34 */     return tableList;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  40 */     final long viceZoneid = MergeMain.getViceZoneid();
/*  41 */     long mainZoneid = MergeMain.getMainZoneid();
/*     */     
/*     */ 
/*  44 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  48 */         lock(Weddingceremony.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*  49 */         Ceremonys xViceCeremonys = Weddingceremony.get(Long.valueOf(viceZoneid));
/*  50 */         if (xViceCeremonys == null) {
/*  51 */           MarriageMergeModule.logger.info(String.format("[Merge]MarriageMergeModule.handleMerge@vice server donot has data", new Object[0]));
/*  52 */           return true;
/*     */         }
/*  54 */         Ceremonys xMainCeremonys = Weddingceremony.get(Long.valueOf(this.val$mainZoneid));
/*  55 */         if (xMainCeremonys == null) {
/*  56 */           xMainCeremonys = xbean.Pod.newCeremonys();
/*  57 */           Weddingceremony.insert(Long.valueOf(this.val$mainZoneid), xMainCeremonys);
/*     */         }
/*  59 */         xMainCeremonys.setCeremonycounter(xMainCeremonys.getCeremonycounter() + xViceCeremonys.getCeremonycounter());
/*     */         
/*  61 */         Iterator<Ceremony> xViceCeremoneysIterator = xViceCeremonys.getCeremonys().iterator();
/*  62 */         while (xViceCeremoneysIterator.hasNext()) {
/*  63 */           Ceremony xCeremony = (Ceremony)xViceCeremoneysIterator.next();
/*  64 */           xViceCeremoneysIterator.remove();
/*  65 */           xMainCeremonys.getCeremonys().add(xCeremony);
/*     */         }
/*     */         
/*     */ 
/*  69 */         Weddingceremony.remove(Long.valueOf(viceZoneid));
/*     */         
/*  71 */         MarriageMergeModule.logger.info(String.format("[Merge]MarriageMergeModule.handleMerge@merge Weddingceremony data finished", new Object[0]));
/*     */         
/*     */ 
/*  74 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  78 */     }.call();
/*  79 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  83 */         lock(Marriageparade.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*  84 */         MarriageParades xViceMarriageParades = Marriageparade.get(Long.valueOf(viceZoneid));
/*  85 */         if (xViceMarriageParades == null) {
/*  86 */           MarriageMergeModule.logger.info(String.format("[Merge]MarriageMergeModule.handleMerge@vice server Marriageparade donot has data", new Object[0]));
/*     */           
/*     */ 
/*  89 */           return true;
/*     */         }
/*     */         
/*  92 */         MarriageParades xMainMarriageParades = Marriageparade.get(Long.valueOf(this.val$mainZoneid));
/*  93 */         if (xMainMarriageParades == null) {
/*  94 */           xMainMarriageParades = xbean.Pod.newMarriageParades();
/*  95 */           Marriageparade.insert(Long.valueOf(this.val$mainZoneid), xMainMarriageParades);
/*     */         }
/*     */         
/*  98 */         Iterator<MarriageParade> xViceMarriageParadeIterator = xViceMarriageParades.getMarriageparades().iterator();
/*     */         
/* 100 */         while (xViceMarriageParadeIterator.hasNext()) {
/* 101 */           MarriageParade xMarriageParade = (MarriageParade)xViceMarriageParadeIterator.next();
/* 102 */           xViceMarriageParadeIterator.remove();
/* 103 */           xMainMarriageParades.getMarriageparades().add(xMarriageParade);
/*     */         }
/*     */         
/* 106 */         MarriageMergeModule.logger.info(String.format("[Merge]MarriageMergeModule.handleMerge@merge Marriageparade data finished", new Object[0]));
/*     */         
/*     */ 
/* 109 */         Marriageparade.remove(Long.valueOf(viceZoneid));
/* 110 */         return true;
/*     */       }
/* 112 */     }.call();
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */