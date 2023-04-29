/*     */ package mzm.gsp.partneryuanshen.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenConsts;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveBean;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.PartnerYuanshenInfo;
/*     */ import xbean.PartnerYuanshenPositionInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2partner_yuanshen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PartnerYuanshenManager
/*     */ {
/*     */   static boolean isNotEnable()
/*     */   {
/*  24 */     return !OpenInterface.getOpenStatus(433);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean notMeetOpenLevel(long roleId)
/*     */   {
/*  32 */     return RoleInterface.getLevel(roleId) < SPartnerYuanshenConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, PartnerYuanshenPositionInfo> getPartnerYuanshenPositionInfoMap(long roleId, boolean holdLock)
/*     */   {
/*  41 */     PartnerYuanshenInfo xPartnerYuanshenInfo = holdLock ? Role2partner_yuanshen.get(Long.valueOf(roleId)) : Role2partner_yuanshen.select(Long.valueOf(roleId));
/*     */     
/*  43 */     if (xPartnerYuanshenInfo == null)
/*     */     {
/*  45 */       return null;
/*     */     }
/*  47 */     return xPartnerYuanshenInfo.getPosition_info_map();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, PartnerYuanshenPositionInfo> getOrCreatePartnerYuanshenPositionInfoMap(long roleId)
/*     */   {
/*  55 */     PartnerYuanshenInfo xPartnerYuanshenInfo = Role2partner_yuanshen.get(Long.valueOf(roleId));
/*  56 */     if (xPartnerYuanshenInfo == null)
/*     */     {
/*  58 */       xPartnerYuanshenInfo = Pod.newPartnerYuanshenInfo();
/*  59 */       Role2partner_yuanshen.add(Long.valueOf(roleId), xPartnerYuanshenInfo);
/*     */     }
/*  61 */     return xPartnerYuanshenInfo.getPosition_info_map();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static PartnerYuanshenPositionInfo getPartnerYuanshenPositionInfo(long roleId, int position, boolean holdLock)
/*     */   {
/*  70 */     PartnerYuanshenInfo xPartnerYuanshenInfo = holdLock ? Role2partner_yuanshen.get(Long.valueOf(roleId)) : Role2partner_yuanshen.select(Long.valueOf(roleId));
/*     */     
/*  72 */     if (xPartnerYuanshenInfo == null)
/*     */     {
/*  74 */       return null;
/*     */     }
/*  76 */     return (PartnerYuanshenPositionInfo)xPartnerYuanshenInfo.getPosition_info_map().get(Integer.valueOf(position));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static PartnerYuanshenPositionInfo getOrCreatePartnerYuanshenPositionInfo(long roleId, int position)
/*     */   {
/*  84 */     PartnerYuanshenInfo xPartnerYuanshenInfo = Role2partner_yuanshen.get(Long.valueOf(roleId));
/*  85 */     if (xPartnerYuanshenInfo == null)
/*     */     {
/*  87 */       xPartnerYuanshenInfo = Pod.newPartnerYuanshenInfo();
/*  88 */       Role2partner_yuanshen.add(Long.valueOf(roleId), xPartnerYuanshenInfo);
/*     */     }
/*  90 */     PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo = (PartnerYuanshenPositionInfo)xPartnerYuanshenInfo.getPosition_info_map().get(Integer.valueOf(position));
/*     */     
/*  92 */     if (xPartnerYuanshenPositionInfo == null)
/*     */     {
/*  94 */       xPartnerYuanshenPositionInfo = Pod.newPartnerYuanshenPositionInfo();
/*  95 */       xPartnerYuanshenInfo.getPosition_info_map().put(Integer.valueOf(position), xPartnerYuanshenPositionInfo);
/*     */     }
/*  97 */     return xPartnerYuanshenPositionInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getExtraPropertyRatioMap(int position, int level, int propertyNum)
/*     */   {
/* 105 */     Map<Integer, Integer> map = new HashMap();
/*     */     
/* 107 */     SPartnerYuanshenImproveCfg cfg = SPartnerYuanshenImproveCfg.get(position);
/* 108 */     if (cfg == null)
/*     */     {
/* 110 */       return map;
/*     */     }
/* 112 */     if (propertyNum <= 0)
/*     */     {
/* 114 */       return map;
/*     */     }
/*     */     
/*     */ 
/* 118 */     SPartnerYuanshenImproveBean currentLevelBean = (SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(level));
/* 119 */     if (currentLevelBean == null)
/*     */     {
/* 121 */       return map;
/*     */     }
/* 123 */     for (int i = 0; i < propertyNum; i++)
/*     */     {
/* 125 */       map.put(currentLevelBean.propertyTypes.get(i), currentLevelBean.propertyRatios.get(i));
/*     */     }
/* 127 */     SPartnerYuanshenImproveBean previousLevelBean = (SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(level - 1));
/* 128 */     if (previousLevelBean != null)
/*     */     {
/* 130 */       for (int i = propertyNum; i < previousLevelBean.propertyTypes.size(); i++)
/*     */       {
/* 132 */         map.put(previousLevelBean.propertyTypes.get(i), previousLevelBean.propertyRatios.get(i));
/*     */       }
/*     */     }
/* 135 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFightScoreFromPartnerYuanshen(long roleId, boolean holdLock)
/*     */   {
/* 143 */     Map<Integer, PartnerYuanshenPositionInfo> positionInfoMap = getPartnerYuanshenPositionInfoMap(roleId, holdLock);
/*     */     
/* 145 */     if (positionInfoMap == null)
/*     */     {
/* 147 */       return 0;
/*     */     }
/* 149 */     double score = 0.0D;
/* 150 */     double factor = SPartnerYuanshenConsts.getInstance().FIGHT_SCORE_FACTOR / 10000.0D;
/* 151 */     for (Map.Entry<Integer, PartnerYuanshenPositionInfo> entry : positionInfoMap.entrySet())
/*     */     {
/* 153 */       SPartnerYuanshenImproveCfg cfg = SPartnerYuanshenImproveCfg.get(((Integer)entry.getKey()).intValue());
/* 154 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 158 */         int level = ((PartnerYuanshenPositionInfo)entry.getValue()).getLevel();
/* 159 */         SPartnerYuanshenImproveBean bean = (SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(level));
/* 160 */         if (bean != null)
/*     */         {
/*     */ 
/*     */ 
/* 164 */           int totalPropertyNum = bean.propertyTypes.size();
/* 165 */           int propertyNum = ((PartnerYuanshenPositionInfo)entry.getValue()).getProperty_num();
/* 166 */           if (propertyNum != 0)
/*     */           {
/* 168 */             score += level * propertyNum * factor;
/* 169 */             if (level - 1 > 0)
/*     */             {
/* 171 */               score += (level - 1) * (totalPropertyNum - propertyNum) * factor; }
/*     */           }
/*     */         }
/*     */       } }
/* 175 */     return (int)Math.round(score);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PartnerYuanshenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */