/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.instance.confbean.OperaInstanceProcessCfg;
/*     */ import mzm.gsp.instance.confbean.SActivityId2OperaCfgid;
/*     */ import mzm.gsp.instance.confbean.SGraphidToInstanceid;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SInstanceidToMapids;
/*     */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SOperaProcessCfgMap;
/*     */ import mzm.gsp.instance.confbean.SSingleInstanceMapCfg;
/*     */ import mzm.gsp.instance.confbean.SingleInstanceData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class InstanceCfgManager
/*     */ {
/*     */   static SingleInstanceData getSingleInstanceCfg(int instanceid, int processid)
/*     */   {
/*  27 */     SSingleInstanceMapCfg singleInstanceMapCfg = SSingleInstanceMapCfg.get(instanceid);
/*  28 */     if (singleInstanceMapCfg == null) {
/*  29 */       return null;
/*     */     }
/*  31 */     return (SingleInstanceData)singleInstanceMapCfg.process2CfgMap.get(Integer.valueOf(processid));
/*     */   }
/*     */   
/*     */   static int getSingleInstanceProcessNum(int instanceid) {
/*  35 */     SSingleInstanceMapCfg singleInstanceMapCfg = SSingleInstanceMapCfg.get(instanceid);
/*  36 */     if (singleInstanceMapCfg == null) {
/*  37 */       return -1;
/*     */     }
/*  39 */     return singleInstanceMapCfg.process2CfgMap.size();
/*     */   }
/*     */   
/*     */   static SOperaInstanceCfg getOperaInstanceCfg(int instanceid) {
/*  43 */     return SOperaInstanceCfg.get(instanceid);
/*     */   }
/*     */   
/*     */   static int getOperaInstanceCfgIdByActivityid(int activityid) {
/*  47 */     SActivityId2OperaCfgid activityId2OperaCfgid = SActivityId2OperaCfgid.get(activityid);
/*  48 */     if (activityId2OperaCfgid == null) {
/*  49 */       return 0;
/*     */     }
/*  51 */     return activityId2OperaCfgid.instanceCfgid;
/*     */   }
/*     */   
/*     */   static OperaInstanceProcessCfg getOperaInstanceProcessCfg(int instanceid, int processid)
/*     */   {
/*  56 */     SOperaProcessCfgMap processMap = SOperaProcessCfgMap.get(instanceid);
/*  57 */     if (processMap == null) {
/*  58 */       return null;
/*     */     }
/*  60 */     return (OperaInstanceProcessCfg)processMap.process2CfgMap.get(Integer.valueOf(processid));
/*     */   }
/*     */   
/*     */   static int getOperaInstanceProcessSize(int instanceid) {
/*  64 */     SOperaProcessCfgMap processMap = SOperaProcessCfgMap.get(instanceid);
/*  65 */     if (processMap == null) {
/*  66 */       return 0;
/*     */     }
/*  68 */     return processMap.process2CfgMap.size();
/*     */   }
/*     */   
/*     */   static boolean isInstanceTaskGraph(int graphid) {
/*  72 */     return SGraphidToInstanceid.get(graphid) != null;
/*     */   }
/*     */   
/*     */   static int getInstanceFightType(int graphid) {
/*  76 */     SGraphidToInstanceid graphidToInstanceid = SGraphidToInstanceid.get(graphid);
/*  77 */     if (graphidToInstanceid != null) {
/*  78 */       int instanceid = graphidToInstanceid.instanceid;
/*  79 */       return SInstanceCfg.get(instanceid).fightType;
/*     */     }
/*  81 */     return -1;
/*     */   }
/*     */   
/*     */   static int getInstanceidByGraphid(int graphid) {
/*  85 */     SGraphidToInstanceid graphidToInstanceid = SGraphidToInstanceid.get(graphid);
/*  86 */     if (graphidToInstanceid != null) {
/*  87 */       return graphidToInstanceid.instanceid;
/*     */     }
/*  89 */     return -1;
/*     */   }
/*     */   
/*     */   static Set<Integer> getMapsByInstanceid(int instanceid) {
/*  93 */     return SInstanceidToMapids.get(instanceid).mapids;
/*     */   }
/*     */   
/*     */   static List<SingleInstanceData> getAllSingleInstanceCfgs() {
/*  97 */     List<SingleInstanceData> allSingleInstanceCfgs = new ArrayList();
/*  98 */     for (SSingleInstanceMapCfg singleInstanceMapCfg : SSingleInstanceMapCfg.getAll().values()) {
/*  99 */       allSingleInstanceCfgs.addAll(singleInstanceMapCfg.process2CfgMap.values());
/*     */     }
/* 101 */     return allSingleInstanceCfgs;
/*     */   }
/*     */   
/*     */   static List<OperaInstanceProcessCfg> getAllOperaInstanceProcessCfgs() {
/* 105 */     List<OperaInstanceProcessCfg> allOperaProcessInstanceCfgs = new ArrayList();
/* 106 */     for (SOperaProcessCfgMap sOperaProcessCfgMap : SOperaProcessCfgMap.getAll().values()) {
/* 107 */       allOperaProcessInstanceCfgs.addAll(sOperaProcessCfgMap.process2CfgMap.values());
/*     */     }
/* 109 */     return allOperaProcessInstanceCfgs;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\InstanceCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */