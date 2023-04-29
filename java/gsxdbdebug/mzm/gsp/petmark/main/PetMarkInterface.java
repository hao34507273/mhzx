/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ import xtable.Role2petmark;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetMarkInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getPetMarkProps(long roleId, long petId, boolean retainLock)
/*     */   {
/*  25 */     Map<Integer, Integer> res = new HashMap();
/*     */     
/*     */ 
/*  28 */     if (!PetMarkManager.isPetMarkOpen(roleId))
/*     */     {
/*  30 */       return res;
/*     */     }
/*     */     
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*  35 */     if (retainLock)
/*     */     {
/*  37 */       xRole2PetMarkInfo = Role2petmark.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  41 */       xRole2PetMarkInfo = Role2petmark.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  44 */     if (null == xRole2PetMarkInfo)
/*     */     {
/*  46 */       return res;
/*     */     }
/*     */     
/*     */ 
/*  50 */     Long equipedPetMarkId = (Long)xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(petId));
/*  51 */     if (null == equipedPetMarkId)
/*     */     {
/*  53 */       return res;
/*     */     }
/*  55 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(equipedPetMarkId);
/*  56 */     if (null == xPetMarkInfo)
/*     */     {
/*  58 */       return res;
/*     */     }
/*     */     
/*     */ 
/*  62 */     SPetMarkLevelBean levelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(xPetMarkInfo.getPet_mark_cfg_id()).level2Bean.get(Integer.valueOf(xPetMarkInfo.getLevel()));
/*  63 */     res.putAll(levelBean.propMap);
/*     */     
/*  65 */     return res;
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
/*     */   public static Collection<Integer> getPetMarkSkillId(long roleId, long petId, boolean retainLock)
/*     */   {
/*  79 */     ArrayList<Integer> res = new ArrayList(1);
/*     */     
/*     */ 
/*  82 */     if (!PetMarkManager.isPetMarkOpen(roleId))
/*     */     {
/*  84 */       return res;
/*     */     }
/*     */     
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*  89 */     if (retainLock)
/*     */     {
/*  91 */       xRole2PetMarkInfo = Role2petmark.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  95 */       xRole2PetMarkInfo = Role2petmark.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  98 */     if (null == xRole2PetMarkInfo)
/*     */     {
/* 100 */       return res;
/*     */     }
/*     */     
/*     */ 
/* 104 */     Long equipedPetMarkId = (Long)xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(petId));
/* 105 */     if (null == equipedPetMarkId)
/*     */     {
/* 107 */       return res;
/*     */     }
/* 109 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(equipedPetMarkId);
/* 110 */     if (null == xPetMarkInfo)
/*     */     {
/* 112 */       return res;
/*     */     }
/*     */     
/*     */ 
/* 116 */     SPetMarkLevelBean levelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(xPetMarkInfo.getPet_mark_cfg_id()).level2Bean.get(Integer.valueOf(xPetMarkInfo.getLevel()));
/* 117 */     res.add(Integer.valueOf(levelBean.passiveSkillId));
/*     */     
/* 119 */     return res;
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
/*     */   public static int getPetMarkYaoli(long roleId, long petId, boolean retainLock)
/*     */   {
/* 134 */     if (!PetMarkManager.isPetMarkOpen(roleId))
/*     */     {
/* 136 */       return 0;
/*     */     }
/*     */     
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/* 141 */     if (retainLock)
/*     */     {
/* 143 */       xRole2PetMarkInfo = Role2petmark.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 147 */       xRole2PetMarkInfo = Role2petmark.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 150 */     if (null == xRole2PetMarkInfo)
/*     */     {
/* 152 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 156 */     Long equipedPetMarkId = (Long)xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(petId));
/* 157 */     if (null == equipedPetMarkId)
/*     */     {
/* 159 */       return 0;
/*     */     }
/* 161 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(equipedPetMarkId);
/* 162 */     if (null == xPetMarkInfo)
/*     */     {
/* 164 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 168 */     SPetMarkLevelBean levelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(xPetMarkInfo.getPet_mark_cfg_id()).level2Bean.get(Integer.valueOf(xPetMarkInfo.getLevel()));
/* 169 */     return levelBean.addYaoli;
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
/*     */   public static Pair<Integer, Integer> getPetMarkCfgIdAndLevel(long roleId, long petId, boolean retainLock)
/*     */   {
/* 183 */     Pair<Integer, Integer> res = new Pair(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/*     */ 
/* 186 */     if (!PetMarkManager.isPetMarkOpen(roleId))
/*     */     {
/* 188 */       return res;
/*     */     }
/*     */     
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/*     */     Role2PetMarkInfo xRole2PetMarkInfo;
/* 193 */     if (retainLock)
/*     */     {
/* 195 */       xRole2PetMarkInfo = Role2petmark.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 199 */       xRole2PetMarkInfo = Role2petmark.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 202 */     if (null == xRole2PetMarkInfo)
/*     */     {
/* 204 */       return res;
/*     */     }
/*     */     
/*     */ 
/* 208 */     Long equipedPetMarkId = (Long)xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(petId));
/* 209 */     if (null == equipedPetMarkId)
/*     */     {
/* 211 */       return res;
/*     */     }
/* 213 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(equipedPetMarkId);
/* 214 */     if (null == xPetMarkInfo)
/*     */     {
/* 216 */       return res;
/*     */     }
/*     */     
/* 219 */     res.first = Integer.valueOf(xPetMarkInfo.getPet_mark_cfg_id());
/* 220 */     res.second = Integer.valueOf(xPetMarkInfo.getLevel());
/*     */     
/* 222 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PetMarkInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */