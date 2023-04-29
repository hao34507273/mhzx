/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JiuXiaoRank;
/*     */ import xbean.JiuXiaoRankRole;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Jiuxiaorank;
/*     */ import xtable.Jiuxiaotable;
/*     */ 
/*     */ public class JiuXiaoMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(JiuXiaoMergeModule.class);
/*     */   
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  26 */     List<Table> tables = new java.util.ArrayList();
/*     */     
/*  28 */     tables.add(xtable.Role2jiuxiao.getTable());
/*     */     
/*  30 */     tables.add(Jiuxiaotable.getTable());
/*     */     
/*  32 */     tables.add(Jiuxiaorank.getTable());
/*  33 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  39 */     final long viceZoneid = MergeMain.getViceZoneid();
/*  40 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  44 */         boolean ret = Jiuxiaotable.remove(Long.valueOf(viceZoneid));
/*  45 */         if (ret) {
/*  46 */           JiuXiaoMergeModule.logger.info(String.format("[Merge]JiuXiaoMergeModule.handleMerge@delete vice zoneid data|viceZoneid=%d", new Object[] { Long.valueOf(viceZoneid) }));
/*     */         }
/*     */         
/*  49 */         return true;
/*     */       }
/*     */       
/*  52 */     }.call();
/*  53 */     long mainZoneid = MergeMain.getMainZoneid();
/*     */     
/*     */ 
/*  56 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  60 */         Map<Long, Long> viceKeyToMainKey = new java.util.HashMap();
/*  61 */         for (SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg : SJiuXiaoActivityInfoCfg.getAll().values()) {
/*  62 */           long viceKey = GameServerInfoManager.toGlobalId(jiuXiaoActivityInfoCfg.rankType, viceZoneid);
/*  63 */           long mainKey = GameServerInfoManager.toGlobalId(jiuXiaoActivityInfoCfg.rankType, this.val$mainZoneid);
/*  64 */           viceKeyToMainKey.put(Long.valueOf(viceKey), Long.valueOf(mainKey));
/*     */         }
/*     */         
/*  67 */         Set<Long> allKeys = new java.util.HashSet();
/*  68 */         allKeys.addAll(viceKeyToMainKey.keySet());
/*  69 */         allKeys.addAll(viceKeyToMainKey.values());
/*  70 */         lock(Jiuxiaorank.getTable(), allKeys);
/*     */         
/*  72 */         for (Map.Entry<Long, Long> viceKey2MainKeyEntry : viceKeyToMainKey.entrySet()) {
/*  73 */           long viceUniqkeyid = ((Long)viceKey2MainKeyEntry.getKey()).longValue();
/*  74 */           long mainUniqKeyid = ((Long)viceKey2MainKeyEntry.getValue()).longValue();
/*     */           
/*  76 */           JiuXiaoRank xViceJiuXiaoRank = Jiuxiaorank.get(Long.valueOf(viceUniqkeyid));
/*  77 */           if (xViceJiuXiaoRank != null) {
/*  78 */             JiuXiaoRank xMainJiuXiaoRank = Jiuxiaorank.get(Long.valueOf(mainUniqKeyid));
/*  79 */             if (xMainJiuXiaoRank == null) {
/*  80 */               xMainJiuXiaoRank = Pod.newJiuXiaoRank();
/*  81 */               Jiuxiaorank.insert(Long.valueOf(mainUniqKeyid), xMainJiuXiaoRank);
/*     */             }
/*  83 */             JiuXiaoMergeModule.JiuXiaoRankManagerForMerge forMergeRank = new JiuXiaoMergeModule.JiuXiaoRankManagerForMerge(Integer.MAX_VALUE, 0);
/*     */             
/*  85 */             for (JiuXiaoRankRole xJiuXiaoRankRole : xMainJiuXiaoRank.getRanklist()) {
/*  86 */               JiuXiaoRankObj jiuXiaoRankObj = new JiuXiaoRankObj(xJiuXiaoRankRole.getRoleid(), xJiuXiaoRankRole.getLayer(), xJiuXiaoRankRole.getSec());
/*     */               
/*  88 */               forMergeRank.rank(jiuXiaoRankObj);
/*     */             }
/*     */             
/*  91 */             for (JiuXiaoRankRole xJiuXiaoRankRole : xViceJiuXiaoRank.getRanklist()) {
/*  92 */               JiuXiaoRankObj jiuXiaoRankObj = new JiuXiaoRankObj(xJiuXiaoRankRole.getRoleid(), xJiuXiaoRankRole.getLayer(), xJiuXiaoRankRole.getSec());
/*     */               
/*  94 */               forMergeRank.rank(jiuXiaoRankObj);
/*     */             }
/*     */             
/*  97 */             xMainJiuXiaoRank.getRanklist().clear();
/*  98 */             for (JiuXiaoRankObj jiuXiaoRankObj : forMergeRank.getAllChartObjs()) {
/*  99 */               JiuXiaoRankRole xJiuXiaoRankRole = Pod.newJiuXiaoRankRole();
/* 100 */               xJiuXiaoRankRole.setLayer(jiuXiaoRankObj.getLayer());
/* 101 */               xJiuXiaoRankRole.setRoleid(jiuXiaoRankObj.getRoleid());
/* 102 */               xJiuXiaoRankRole.setSec(jiuXiaoRankObj.getSec());
/* 103 */               xMainJiuXiaoRank.getRanklist().add(xJiuXiaoRankRole);
/*     */             }
/*     */             
/*     */ 
/* 107 */             forMergeRank.clear();
/*     */             
/* 109 */             Jiuxiaorank.remove(Long.valueOf(viceUniqkeyid));
/*     */             
/* 111 */             JiuXiaoMergeModule.logger.info(String.format("[Merge]JiuXiaoMergeModule.handleMerge@handle jiuxiao rankdata|viceUniqKey=%d|mainUniqKeyid=%d|viceZoneid=%d|mainZoneid=%d", new Object[] { Long.valueOf(viceUniqkeyid), Long.valueOf(mainUniqKeyid), Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 118 */         return true;
/*     */       }
/*     */       
/* 121 */     }.call();
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   private static class JiuXiaoRankManagerForMerge extends RankManagerNew<Long, JiuXiaoRankObj>
/*     */   {
/*     */     public JiuXiaoRankManagerForMerge(int capacity, int extraSize) {
/* 128 */       super(extraSize);
/*     */     }
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */     
/*     */     public void saveToDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */