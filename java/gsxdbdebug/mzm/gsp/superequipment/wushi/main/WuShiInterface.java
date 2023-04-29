/*     */ package mzm.gsp.superequipment.wushi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WuShiInfo;
/*     */ import xbean.WuShiInfoMap;
/*     */ import xtable.Role2wushiinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WuShiInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getProperties(long roleId)
/*     */   {
/*  29 */     Map<Integer, Integer> proType2value = new HashMap();
/*  30 */     if (!OpenInterface.getOpenStatus(397)) {
/*  31 */       return proType2value;
/*     */     }
/*  33 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(roleId));
/*  34 */     if (xWuShiInfoMap == null)
/*     */     {
/*  36 */       return proType2value;
/*     */     }
/*  38 */     Map<Integer, WuShiInfo> xWuShiCfgId2WuShiInfo = xWuShiInfoMap.getWushicfgid2wushiinfo();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  43 */     for (Map.Entry<Integer, WuShiInfo> entry : xWuShiCfgId2WuShiInfo.entrySet())
/*     */     {
/*  45 */       if (((WuShiInfo)entry.getValue()).getIsactivate() != 4)
/*     */       {
/*     */ 
/*     */ 
/*  49 */         int wuShiCfgId = ((Integer)entry.getKey()).intValue();
/*  50 */         WuShiCfg wuShiCfg = WuShiCfg.get(wuShiCfgId);
/*  51 */         if (wuShiCfg == null)
/*     */         {
/*  53 */           GameServer.logger().error(String.format("[wushi]WuShiInterface.getProperties wuShiCfg null|roleId=%d|wuShiCfgId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(wuShiCfgId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  59 */           for (int i = 0; i < wuShiCfg.properTypes.size(); i++)
/*     */           {
/*  61 */             int type = ((Integer)wuShiCfg.properTypes.get(i)).intValue();
/*     */             int value;
/*  63 */             int value; if (proType2value.containsKey(Integer.valueOf(type)))
/*     */             {
/*  65 */               value = ((Integer)proType2value.get(Integer.valueOf(type))).intValue();
/*     */             }
/*     */             else
/*     */             {
/*  69 */               value = 0;
/*     */             }
/*  71 */             value += ((Integer)wuShiCfg.propertyValues.get(i)).intValue();
/*  72 */             proType2value.put(Integer.valueOf(type), Integer.valueOf(value));
/*     */           } }
/*     */       }
/*     */     }
/*  76 */     return proType2value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int getWuShiCfgIdForRole(long roleId, boolean isRemainRoleLock)
/*     */   {
/*     */     WuShiInfoMap xWuShiInfoMap;
/*     */     
/*     */ 
/*     */     WuShiInfoMap xWuShiInfoMap;
/*     */     
/*     */ 
/*  89 */     if (isRemainRoleLock)
/*     */     {
/*  91 */       xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  95 */       xWuShiInfoMap = Role2wushiinfo.select(Long.valueOf(roleId));
/*     */     }
/*  97 */     if (xWuShiInfoMap == null)
/*     */     {
/*  99 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 103 */     return WuShiManager.getOnWuShiCfgId(xWuShiInfoMap);
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
/*     */   public static Set<Integer> getRoleActivatedWuShiCfgIds(long roleId, boolean isHoldRoleLock)
/*     */   {
/* 116 */     Set<Integer> result = new HashSet();
/*     */     
/* 118 */     WuShiInfoMap xWuShiInfoMap = isHoldRoleLock ? Role2wushiinfo.get(Long.valueOf(roleId)) : Role2wushiinfo.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 121 */     if (xWuShiInfoMap == null)
/*     */     {
/* 123 */       return result;
/*     */     }
/* 125 */     Map<Integer, WuShiInfo> xWuShiCfgId2WuShiInfo = xWuShiInfoMap.getWushicfgid2wushiinfo();
/*     */     
/*     */ 
/*     */ 
/* 129 */     for (Map.Entry<Integer, WuShiInfo> entry : xWuShiCfgId2WuShiInfo.entrySet())
/*     */     {
/* 131 */       if (((WuShiInfo)entry.getValue()).getIsactivate() != 4)
/*     */       {
/*     */ 
/*     */ 
/* 135 */         int wuShiCfgId = ((Integer)entry.getKey()).intValue();
/* 136 */         WuShiCfg wuShiCfg = WuShiCfg.get(wuShiCfgId);
/* 137 */         if (wuShiCfg == null)
/*     */         {
/* 139 */           GameServer.logger().error(String.format("[wushi]WuShiInterface.getRoleActivatedWuShiCfgIds wuShiCfg null|roleId=%d|wuShiCfgId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(wuShiCfgId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 144 */           result.add(Integer.valueOf(wuShiCfgId)); }
/*     */       }
/*     */     }
/* 147 */     return result;
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
/*     */   public static int removeWuShiByFragmentForIDIP(long roleId, int wuShiTypeId, int fragmentCountToRemove, boolean isHoldRoleLock)
/*     */   {
/* 162 */     int idipRet = WuShiManager.removeWuShiByFragment(roleId, wuShiTypeId, fragmentCountToRemove, isHoldRoleLock);
/* 163 */     if (idipRet == 0)
/*     */     {
/* 165 */       OnlineManager.getInstance().forceReconnect(roleId);
/*     */     }
/* 167 */     return idipRet;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\WuShiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */