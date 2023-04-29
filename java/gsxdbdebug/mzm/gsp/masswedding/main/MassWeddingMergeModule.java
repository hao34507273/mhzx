/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWeddingBless;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xtable.Massweddingbless;
/*     */ import xtable.Massweddingrank;
/*     */ import xtable.Massweddingrob;
/*     */ 
/*     */ public class MassWeddingMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*  17 */   private final Logger logger = Logger.getLogger(MassWeddingMergeModule.class);
/*     */   
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> tables = new java.util.ArrayList();
/*     */     
/*  23 */     tables.add(xtable.Masswedding.getTable());
/*     */     
/*  25 */     tables.add(Massweddingrank.getTable());
/*     */     
/*  27 */     tables.add(Massweddingbless.getTable());
/*     */     
/*  29 */     tables.add(Massweddingrob.getTable());
/*     */     
/*  31 */     tables.add(xtable.Role2massweddingredgift.getTable());
/*  32 */     return tables;
/*     */   }
/*     */   
/*     */   public boolean handleMerge()
/*     */   {
/*  37 */     final long viceZoneid = mzm.gsp.MergeMain.getViceZoneid();
/*  38 */     long mainZoneid = mzm.gsp.MergeMain.getMainZoneid();
/*     */     
/*     */ 
/*  41 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  45 */         MassWeddingMergeModule.this.logger.info(String.format("[Merge]MassWeddingMergeModule.handleMerge@begin merge Massweddingrank", new Object[0]));
/*  46 */         lock(Massweddingrank.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*  47 */         MassWeddingRankInfos xMainMassWeddingRankInfos = Massweddingrank.get(Long.valueOf(this.val$mainZoneid));
/*  48 */         MassWeddingRankInfos xViceMassWeddingRankInfos = Massweddingrank.get(Long.valueOf(viceZoneid));
/*  49 */         if (xViceMassWeddingRankInfos == null) {
/*  50 */           MassWeddingMergeModule.this.logger.info(String.format("[Merge]MassWeddingMergeModule.handleMerge@vice Massweddingrank data is null!|viceid=%d", new Object[] { Long.valueOf(viceZoneid) }));
/*     */           
/*     */ 
/*  53 */           return false;
/*     */         }
/*  55 */         if (xMainMassWeddingRankInfos == null) {
/*  56 */           xMainMassWeddingRankInfos = xbean.Pod.newMassWeddingRankInfos();
/*  57 */           Massweddingrank.insert(Long.valueOf(this.val$mainZoneid), xMainMassWeddingRankInfos);
/*     */         }
/*     */         
/*  60 */         MassWeddingSignUpChartManager.getInstance().clear();
/*     */         
/*     */ 
/*  63 */         xMainMassWeddingRankInfos.getNotbackcoinsroleids().addAll(xViceMassWeddingRankInfos.getNotbackcoinsroleids());
/*     */         
/*     */ 
/*     */ 
/*  67 */         for (MassWeddingRankInfo xMassWeddingRankInfo : xMainMassWeddingRankInfos.getMassweddingrankinfos())
/*     */         {
/*  69 */           MassWeddingSignUpChart massWeddingSignUpChart = new MassWeddingSignUpChart(xMassWeddingRankInfo.getRoleida(), xMassWeddingRankInfo.getRoleaoffer(), xMassWeddingRankInfo.getRoleidb(), xMassWeddingRankInfo.getRoleidboffer());
/*     */           
/*     */ 
/*  72 */           MassWeddingSignUpChartManager.getInstance().rank(massWeddingSignUpChart);
/*     */         }
/*     */         
/*     */ 
/*  76 */         for (MassWeddingRankInfo xMassWeddingRankInfo : xViceMassWeddingRankInfos.getMassweddingrankinfos())
/*     */         {
/*  78 */           MassWeddingSignUpChart massWeddingSignUpChart = new MassWeddingSignUpChart(xMassWeddingRankInfo.getRoleida(), xMassWeddingRankInfo.getRoleaoffer(), xMassWeddingRankInfo.getRoleidb(), xMassWeddingRankInfo.getRoleidboffer());
/*     */           
/*     */ 
/*  81 */           MassWeddingSignUpChartManager.getInstance().rank(massWeddingSignUpChart);
/*     */         }
/*     */         
/*     */ 
/*  85 */         xMainMassWeddingRankInfos.getRoleid2index().clear();
/*  86 */         xMainMassWeddingRankInfos.getMassweddingrankinfos().clear();
/*     */         
/*  88 */         int i = 0;
/*  89 */         for (MassWeddingSignUpChart chart : MassWeddingSignUpChartManager.getInstance().getAllChartObjs()) {
/*  90 */           MassWeddingRankInfo xMassWeddingRankInfo = xbean.Pod.newMassWeddingRankInfo();
/*  91 */           xMassWeddingRankInfo.setRoleida(chart.roleidA);
/*  92 */           xMassWeddingRankInfo.setRoleaoffer(chart.roleAPrice);
/*  93 */           xMassWeddingRankInfo.setRoleidb(chart.roleidB);
/*  94 */           xMassWeddingRankInfo.setRoleidboffer(chart.roleBPrice);
/*  95 */           xMainMassWeddingRankInfos.getMassweddingrankinfos().add(xMassWeddingRankInfo);
/*  96 */           xMainMassWeddingRankInfos.getRoleid2index().put(Long.valueOf(chart.roleidA), Integer.valueOf(i));
/*  97 */           i++;
/*     */         }
/*     */         
/* 100 */         Massweddingrank.remove(Long.valueOf(viceZoneid));
/*     */         
/* 102 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 106 */     }.call();
/* 107 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 111 */         MassWeddingMergeModule.this.logger.info(String.format("[Merge]MassWeddingMergeModule.handleMerge@begin merge Massweddingbless", new Object[0]));
/* 112 */         lock(Massweddingbless.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/* 113 */         MassWeddingBless xMainMassWeddingBless = Massweddingbless.get(Long.valueOf(this.val$mainZoneid));
/* 114 */         MassWeddingBless xViceMassWeddingBless = Massweddingbless.get(Long.valueOf(viceZoneid));
/* 115 */         if (xViceMassWeddingBless == null) {
/* 116 */           mzm.gsp.GameServer.logger().info(String.format("[Merge]MassWeddingMergeModule.handleMerge@Massweddingbless vice data is null", new Object[0]));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 121 */           return false;
/*     */         }
/* 123 */         if (xMainMassWeddingBless == null) {
/* 124 */           xMainMassWeddingBless = xbean.Pod.newMassWeddingBless();
/* 125 */           Massweddingbless.insert(Long.valueOf(this.val$mainZoneid), xMainMassWeddingBless);
/*     */         }
/* 127 */         Iterator<Map.Entry<Long, xbean.BlessRoles>> iterator = xViceMassWeddingBless.getBlessmap().entrySet().iterator();
/*     */         
/* 129 */         while (iterator.hasNext()) {
/* 130 */           Map.Entry<Long, xbean.BlessRoles> entry = (Map.Entry)iterator.next();
/* 131 */           iterator.remove();
/* 132 */           xMainMassWeddingBless.getBlessmap().put(entry.getKey(), entry.getValue());
/*     */         }
/* 134 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 138 */     }.call();
/* 139 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 143 */         MassWeddingMergeModule.this.logger.info(String.format("[Merge]MassWeddingMergeModule.handleMerge@begin merge Massweddingrob", new Object[0]));
/* 144 */         lock(Massweddingrob.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/* 145 */         xbean.MassWeddingRob xMainMassWeddingRob = Massweddingrob.get(Long.valueOf(this.val$mainZoneid));
/* 146 */         xbean.MassWeddingRob xViceMassWeddingRob = Massweddingrob.get(Long.valueOf(viceZoneid));
/* 147 */         if (xViceMassWeddingRob == null) {
/* 148 */           mzm.gsp.GameServer.logger().info(String.format("[Merge]MassWeddingMergeModule.handleMerge@Massweddingrob vice data is null", new Object[0]));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 153 */           return false;
/*     */         }
/* 155 */         if (xMainMassWeddingRob == null) {
/* 156 */           xMainMassWeddingRob = xbean.Pod.newMassWeddingRob();
/* 157 */           Massweddingrob.insert(Long.valueOf(this.val$mainZoneid), xMainMassWeddingRob);
/*     */         }
/* 159 */         Iterator<Map.Entry<Long, xbean.MassWeddingRobRoles>> iterator = xViceMassWeddingRob.getRobmap().entrySet().iterator();
/*     */         
/* 161 */         while (iterator.hasNext()) {
/* 162 */           Map.Entry<Long, xbean.MassWeddingRobRoles> entry = (Map.Entry)iterator.next();
/* 163 */           iterator.remove();
/* 164 */           xMainMassWeddingRob.getRobmap().put(entry.getKey(), entry.getValue());
/*     */         }
/* 166 */         return true;
/*     */       }
/*     */       
/* 169 */     }.call();
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */