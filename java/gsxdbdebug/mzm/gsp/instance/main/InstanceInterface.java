/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*     */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.InstanceBean;
/*     */ import xbean.SingleInstance;
/*     */ import xtable.Role2instance;
/*     */ import xtable.Role2instanceuuid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InstanceInterface
/*     */ {
/*     */   public static boolean isRoleInInstance(long roleid, boolean remainRoleLock)
/*     */   {
/*  23 */     if (remainRoleLock) {
/*  24 */       return Role2instanceuuid.get(Long.valueOf(roleid)) != null;
/*     */     }
/*  26 */     return Role2instanceuuid.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHasInstanceid(int instanceid)
/*     */   {
/*  37 */     return SInstanceCfg.getAll().containsKey(Integer.valueOf(instanceid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInstanceTaskGraph(int graphid)
/*     */   {
/*  49 */     return InstanceCfgManager.isInstanceTaskGraph(graphid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getInstanceFightType(int graphid)
/*     */   {
/*  60 */     return InstanceCfgManager.getInstanceFightType(graphid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getInstanceidByGraphid(int graphid)
/*     */   {
/*  70 */     return InstanceCfgManager.getInstanceidByGraphid(graphid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isFinishInstance(String userid, long roleid, int instanceid)
/*     */   {
/*  81 */     InstanceBean xInstanceBean = Role2instance.select(Long.valueOf(roleid));
/*  82 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/*  83 */     switch (instanceCfg.instanceType) {
/*     */     case 1: 
/*  85 */       SingleInstance xSingleInstance = (SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid));
/*  86 */       if (xSingleInstance == null) {
/*  87 */         return false;
/*     */       }
/*  89 */       return xSingleInstance.getFinishtimes() >= instanceCfg.finishTime;
/*     */     case 2: 
/*  91 */       SOperaInstanceCfg sOperaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/*  92 */       return ActivityInterface.isToMaxCount(userid, roleid, sOperaInstanceCfg.activityid);
/*     */     }
/*     */     
/*     */     
/*  96 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getSingleInstanceActivityid()
/*     */   {
/* 105 */     return SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMulInstanceActivityid(int instanceid)
/*     */   {
/* 114 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/* 115 */     return operaInstanceCfg.activityid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Pair<Integer, Integer>> getAllSingleInstanceLevelLimit()
/*     */   {
/* 126 */     Map<Integer, Pair<Integer, Integer>> levelLimits = new HashMap();
/* 127 */     for (SInstanceCfg cfg : SInstanceCfg.getAll().values())
/*     */     {
/* 129 */       if (cfg.instanceType == 1)
/*     */       {
/*     */ 
/*     */ 
/* 133 */         levelLimits.put(Integer.valueOf(cfg.id), new Pair(Integer.valueOf(cfg.level), Integer.valueOf(cfg.closeLevel))); }
/*     */     }
/* 135 */     return levelLimits;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\InstanceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */