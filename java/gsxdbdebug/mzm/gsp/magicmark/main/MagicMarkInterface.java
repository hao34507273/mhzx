/*     */ package mzm.gsp.magicmark.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.MagicMarkInfo;
/*     */ import xbean.MagicMarkSys;
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
/*     */ 
/*     */ public class MagicMarkInterface
/*     */ {
/*     */   public static int getMagicMarkCount(long roleid, boolean retainLock)
/*     */   {
/*  30 */     if (!OpenInterface.getOpenStatus(206)) {
/*  31 */       return 0;
/*     */     }
/*  33 */     if (OpenInterface.isBanPlay(roleid, 206)) {
/*  34 */       return 0;
/*     */     }
/*  36 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(roleid, retainLock);
/*  37 */     if (xMagicMarkSys == null) {
/*  38 */       return 0;
/*     */     }
/*  40 */     int count = 0;
/*  41 */     Set<Map.Entry<Integer, MagicMarkInfo>> entrySet = xMagicMarkSys.getMagicmarkinfos().entrySet();
/*  42 */     for (Map.Entry<Integer, MagicMarkInfo> entry : entrySet) {
/*  43 */       MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)entry.getValue();
/*  44 */       if (MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo)) {
/*  45 */         count++;
/*     */       }
/*     */     }
/*  48 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMagicMarkAvailable(int magicmarkType, long roleid, boolean retainLock)
/*     */   {
/*  60 */     if (!OpenInterface.getOpenStatus(206)) {
/*  61 */       return false;
/*     */     }
/*  63 */     if (OpenInterface.isBanPlay(roleid, 206)) {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(roleid, retainLock);
/*  68 */     if (xMagicMarkSys == null) {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(magicmarkType));
/*  73 */     if ((xMagicMarkInfo != null) && (MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo))) {
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getEquipMagicMarkType(long roleid, boolean retainLock)
/*     */   {
/*  87 */     if (!OpenInterface.getOpenStatus(206)) {
/*  88 */       return 0;
/*     */     }
/*  90 */     if (OpenInterface.isBanPlay(roleid, 206)) {
/*  91 */       return 0;
/*     */     }
/*  93 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(roleid, retainLock);
/*  94 */     if (xMagicMarkSys == null) {
/*  95 */       return 0;
/*     */     }
/*  97 */     int magicMarkType = xMagicMarkSys.getEuqipedmagicmarktype();
/*  98 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(magicMarkType));
/*  99 */     if (MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo)) {
/* 100 */       return magicMarkType;
/*     */     }
/* 102 */     return 0;
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
/*     */ 
/*     */   public static Map<Integer, Integer> getMagicMarkPassiveSkillMap(long roleid, boolean retainLock)
/*     */   {
/* 117 */     if (!OpenInterface.getOpenStatus(206)) {
/* 118 */       return Collections.EMPTY_MAP;
/*     */     }
/* 120 */     if (OpenInterface.isBanPlay(roleid, 206)) {
/* 121 */       return Collections.EMPTY_MAP;
/*     */     }
/* 123 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(roleid, retainLock);
/* 124 */     if (xMagicMarkSys == null) {
/* 125 */       return Collections.EMPTY_MAP;
/*     */     }
/* 127 */     List<Integer> effectPassiveSkillList = getMagicMarkEffectSkill(xMagicMarkSys);
/* 128 */     Map<Integer, Integer> skill2LvMap = new HashMap();
/* 129 */     for (Iterator i$ = effectPassiveSkillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/* 130 */       skill2LvMap.put(Integer.valueOf(skillId), Integer.valueOf(1));
/*     */     }
/*     */     
/* 133 */     int magicMarkProp = xMagicMarkSys.getPropmagicmarktype();
/* 134 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(magicMarkProp));
/* 135 */     SMagicMarkTypeCfg magicMarkTypeCfg = SMagicMarkTypeCfg.get(magicMarkProp);
/* 136 */     if (magicMarkTypeCfg == null) {
/* 137 */       return skill2LvMap;
/*     */     }
/* 139 */     if (MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo)) {
/* 140 */       for (Iterator i$ = magicMarkTypeCfg.passiveSkillList.iterator(); i$.hasNext();) { int passiveSkillid = ((Integer)i$.next()).intValue();
/* 141 */         skill2LvMap.put(Integer.valueOf(passiveSkillid), Integer.valueOf(1));
/*     */       }
/* 143 */       return skill2LvMap;
/*     */     }
/* 145 */     return skill2LvMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getMagicMarkEffectSkill(MagicMarkSys xMagicMarkSys)
/*     */   {
/* 157 */     List<Integer> list = new ArrayList();
/* 158 */     Map<Integer, MagicMarkInfo> map = xMagicMarkSys.getMagicmarkinfos();
/* 159 */     Set<Map.Entry<Integer, MagicMarkInfo>> set = map.entrySet();
/* 160 */     for (Map.Entry<Integer, MagicMarkInfo> entry : set) {
/* 161 */       int magicMarkProp = ((Integer)entry.getKey()).intValue();
/* 162 */       MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)entry.getValue();
/* 163 */       SMagicMarkTypeCfg magicMarkTypeCfg = SMagicMarkTypeCfg.get(magicMarkProp);
/* 164 */       if (magicMarkTypeCfg != null)
/*     */       {
/*     */ 
/* 167 */         if (MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo))
/* 168 */           for (i$ = magicMarkTypeCfg.effectSkillList.iterator(); i$.hasNext();) { int passiveSkillid = ((Integer)i$.next()).intValue();
/* 169 */             list.add(Integer.valueOf(passiveSkillid));
/*     */           } }
/*     */     }
/*     */     Iterator i$;
/* 173 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int removeMagicMarkByItem(long roleId, int itemId)
/*     */   {
/* 183 */     return MagicMarkManager.removeMagicMarkByItem(roleId, itemId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\MagicMarkInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */