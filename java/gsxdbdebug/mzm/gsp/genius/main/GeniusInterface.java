/*     */ package mzm.gsp.genius.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.confbean.SGeniusSkillToSourceCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.GeniusInfo;
/*     */ import xbean.GeniusSeries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GeniusInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getPassiveSkillMap(long roleid, boolean retainLock)
/*     */   {
/*  23 */     List<Integer> skills = GeniusManager.getPassiveSkills(roleid, retainLock);
/*  24 */     if (skills.isEmpty())
/*     */     {
/*  26 */       return Collections.emptyMap();
/*     */     }
/*     */     
/*  29 */     Map<Integer, Integer> result = new HashMap();
/*  30 */     for (Iterator i$ = skills.iterator(); i$.hasNext();) { int skillCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  32 */       result.put(Integer.valueOf(skillCfgid), Integer.valueOf(1));
/*     */     }
/*  34 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getGeniusAddPoint(long roleid, int geniusCfgid, boolean holdLock)
/*     */   {
/*  48 */     return GeniusManager.getGeniusAddPoint(roleid, geniusCfgid, holdLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getPassiveSkillList(long roleid, boolean retainLock)
/*     */   {
/*  60 */     return GeniusManager.getPassiveSkills(roleid, retainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getActiveSkills(long roleid, boolean retainLock)
/*     */   {
/*  72 */     return GeniusManager.getActiveSkills(roleid, retainLock);
/*     */   }
/*     */   
/*     */   public static boolean isFunOpen(long roleid)
/*     */   {
/*  77 */     return GeniusManager.isFunOpen(roleid);
/*     */   }
/*     */   
/*     */   public static GeniusInfo getAndInitGeniusInfo(long roleid)
/*     */   {
/*  82 */     return GeniusManager.getAndInitGeniusInfo(roleid);
/*     */   }
/*     */   
/*     */   public static int getMaxExtraPoint()
/*     */   {
/*  87 */     int maxPoint = SGeniusConst.getInstance().MAX_POINT;
/*     */     
/*  89 */     int openLevel = SGeniusConst.getInstance().OPEN_LEVEL;
/*  90 */     int maxLevel = SGeniusConst.getInstance().MAX_LEVEL;
/*  91 */     int num = (maxLevel - openLevel) / SGeniusConst.getInstance().ADD_POINT_INTERVAL_LEVEL;
/*  92 */     int freePoint = SGeniusConst.getInstance().BASIC_POINT + num * SGeniusConst.getInstance().ADD_POINT_NUM;
/*     */     
/*  94 */     return maxPoint - freePoint;
/*     */   }
/*     */   
/*     */   public static void syncExtraPoint(long roleid, int extraPoint, boolean sendAtOnce)
/*     */   {
/*  99 */     GeniusManager.syncExtraPoint(roleid, extraPoint, sendAtOnce);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getSourceSkill(long roleid, int skillCfgid, boolean holdLock)
/*     */   {
/* 113 */     SGeniusSkillToSourceCfg cfg = SGeniusSkillToSourceCfg.get(skillCfgid);
/* 114 */     if (cfg == null)
/*     */     {
/* 116 */       return skillCfgid;
/*     */     }
/*     */     
/* 119 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 120 */     GeniusSeries xGeniusSeries = GeniusManager.getGeniusSeries(roleid, ocpid, holdLock);
/* 121 */     if (xGeniusSeries == null)
/*     */     {
/* 123 */       return skillCfgid;
/*     */     }
/*     */     
/* 126 */     int curGeniusSeries = xGeniusSeries.getCur_series();
/* 127 */     Integer sourceSkill = (Integer)cfg.series.get(Integer.valueOf(curGeniusSeries));
/* 128 */     return sourceSkill == null ? skillCfgid : sourceSkill.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\GeniusInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */