/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoFloorToKeyCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoMapToKeyCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ 
/*     */ class JiuXiaoCfgManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  16 */     ActivityInterface.registerActivityByLogicType(17, new JiuXiaoActivityHandler());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SJueZhanJiuXiaoCfg getNextJiuXiaoCfg(int activityid, int curFloor)
/*     */   {
/*  26 */     SJueZhanJiuXiaoFloorToKeyCfg activityFloorToKeyCfg = SJueZhanJiuXiaoFloorToKeyCfg.get(activityid);
/*  27 */     Integer key = (Integer)activityFloorToKeyCfg.floor2key.get(Integer.valueOf(++curFloor));
/*  28 */     if (key == null) {
/*  29 */       return null;
/*     */     }
/*  31 */     return SJueZhanJiuXiaoCfg.get(key.intValue());
/*     */   }
/*     */   
/*     */   static int getActivityidByRankType(int rankType) {
/*  35 */     for (SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg : SJiuXiaoActivityInfoCfg.getAll().values()) {
/*  36 */       if (jiuXiaoActivityInfoCfg.rankType == rankType) {
/*  37 */         return jiuXiaoActivityInfoCfg.activityid;
/*     */       }
/*     */     }
/*  40 */     return 0;
/*     */   }
/*     */   
/*     */   static int getMaxFloorByActivityid(int activityid) {
/*  44 */     SJueZhanJiuXiaoFloorToKeyCfg activityFloorToKeyCfg = SJueZhanJiuXiaoFloorToKeyCfg.get(activityid);
/*  45 */     if (activityFloorToKeyCfg == null) {
/*  46 */       return -1;
/*     */     }
/*  48 */     return activityFloorToKeyCfg.maxFloor;
/*     */   }
/*     */   
/*     */   static SJueZhanJiuXiaoCfg getJiuXiaoCfg(int activityid, int floor)
/*     */   {
/*  53 */     SJueZhanJiuXiaoFloorToKeyCfg activityFloorToKeyCfg = SJueZhanJiuXiaoFloorToKeyCfg.get(activityid);
/*  54 */     if (activityFloorToKeyCfg == null) {
/*  55 */       return null;
/*     */     }
/*  57 */     Integer key = (Integer)activityFloorToKeyCfg.floor2key.get(Integer.valueOf(floor));
/*  58 */     if (key == null) {
/*  59 */       return null;
/*     */     }
/*  61 */     return SJueZhanJiuXiaoCfg.get(key.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isJiuXiaoMap(int activityid, int mapid)
/*     */   {
/*  67 */     SJueZhanJiuXiaoMapToKeyCfg jueZhanJiuXiaoMapToKeyCfg = SJueZhanJiuXiaoMapToKeyCfg.get(activityid);
/*  68 */     if (jueZhanJiuXiaoMapToKeyCfg == null) {
/*  69 */       return false;
/*     */     }
/*  71 */     if (jueZhanJiuXiaoMapToKeyCfg.mapid2key.containsKey(Integer.valueOf(mapid))) {
/*  72 */       return true;
/*     */     }
/*  74 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/*  75 */     if (jiuXiaoActivityInfoCfg == null) {
/*  76 */       return false;
/*     */     }
/*  78 */     return jiuXiaoActivityInfoCfg.waitRoomMapid == mapid;
/*     */   }
/*     */   
/*     */   static Set<Integer> getJiuXiaoAllMapidsByActivityid(int activityid) {
/*  82 */     Set<Integer> allMapids = new java.util.HashSet();
/*  83 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/*  84 */     if (jiuXiaoActivityInfoCfg != null) {
/*  85 */       allMapids.add(Integer.valueOf(jiuXiaoActivityInfoCfg.waitRoomMapid));
/*     */     }
/*  87 */     SJueZhanJiuXiaoMapToKeyCfg jueZhanJiuXiaoMapToKeyCfg = SJueZhanJiuXiaoMapToKeyCfg.get(activityid);
/*  88 */     if (jueZhanJiuXiaoMapToKeyCfg != null) {
/*  89 */       allMapids.addAll(jueZhanJiuXiaoMapToKeyCfg.mapid2key.keySet());
/*     */     }
/*  91 */     return allMapids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SJueZhanJiuXiaoCfg getJueZhanJiuXiaoByMapId(int activityid, int mapid)
/*     */   {
/* 101 */     SJueZhanJiuXiaoMapToKeyCfg jueZhanJiuXiaoMapToKeyCfg = SJueZhanJiuXiaoMapToKeyCfg.get(activityid);
/* 102 */     if (jueZhanJiuXiaoMapToKeyCfg != null) {
/* 103 */       Integer key = (Integer)jueZhanJiuXiaoMapToKeyCfg.mapid2key.get(Integer.valueOf(mapid));
/* 104 */       if (key == null) {
/* 105 */         return null;
/*     */       }
/* 107 */       return SJueZhanJiuXiaoCfg.get(key.intValue());
/*     */     }
/* 109 */     return null;
/*     */   }
/*     */   
/*     */   static int getMapAwardid(int activityid, int mapid)
/*     */   {
/* 114 */     SJueZhanJiuXiaoMapToKeyCfg jueZhanJiuXiaoMapToKeyCfg = SJueZhanJiuXiaoMapToKeyCfg.get(activityid);
/* 115 */     if (jueZhanJiuXiaoMapToKeyCfg != null) {
/* 116 */       Integer key = (Integer)jueZhanJiuXiaoMapToKeyCfg.mapid2key.get(Integer.valueOf(mapid));
/* 117 */       if (key != null) {
/* 118 */         SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = SJueZhanJiuXiaoCfg.get(key.intValue());
/* 119 */         if (jueZhanJiuXiaoCfg != null) {
/* 120 */           return jueZhanJiuXiaoCfg.fixAwardid;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 125 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/* 126 */     if ((jiuXiaoActivityInfoCfg != null) && 
/* 127 */       (mapid == jiuXiaoActivityInfoCfg.waitRoomMapid)) {
/* 128 */       return jiuXiaoActivityInfoCfg.fixAwardid;
/*     */     }
/*     */     
/* 131 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */