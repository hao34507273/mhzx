/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fabao.SLongjingPropertyTransferErrorRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.confbean.SLongJingItem2FirstLevelId;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.shanghui.main.ShanghuiInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ class LongjingTransferInterface
/*     */ {
/*     */   static int getMaxLongjingTransferCount()
/*     */   {
/*  22 */     return SFabaoConstants.getInstance().MAX_LONG_JING_TRANSFER_COUNT;
/*     */   }
/*     */   
/*     */   static boolean isLongjingTransferSwitchOpenForRole(long roleId)
/*     */   {
/*  27 */     if (!OpenInterface.getOpenStatus(190))
/*     */     {
/*  29 */       OpenInterface.sendCloseProtocol(roleId, 190, null);
/*     */       
/*  31 */       return false;
/*     */     }
/*  33 */     if (OpenInterface.isBanPlay(roleId, 190))
/*     */     {
/*  35 */       OpenInterface.sendBanPlayMsg(roleId, 190);
/*  36 */       return false;
/*     */     }
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   static void initLongjingTransferCount(long roleid)
/*     */   {
/*  43 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(roleid);
/*  44 */     if (xRoleFabaoSysInfo != null)
/*     */     {
/*  46 */       xRoleFabaoSysInfo.setTransfercount(0);
/*     */     }
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
/*     */ 
/*     */   static boolean activeNewOccupation(long roleid, int newOccupation, int currentOccupation)
/*     */   {
/*  63 */     initLongjingTransferCount(roleid);
/*  64 */     return true;
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
/*     */   static boolean switchOccupation(long roleid, int newOccupation, int oldOccupation)
/*     */   {
/*  79 */     initLongjingTransferCount(roleid);
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanTransferLongjing(long roleid)
/*     */   {
/*  91 */     return RoleStatusInterface.checkCanSetStatus(roleid, 132, true);
/*     */   }
/*     */   
/*     */   static void sendErrorCode(long roleid, int errorCode)
/*     */   {
/*  96 */     SLongjingPropertyTransferErrorRes res = new SLongjingPropertyTransferErrorRes();
/*  97 */     res.resultcode = errorCode;
/*  98 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */   static float getLongJingItemBasePrice(int itemId)
/*     */   {
/* 103 */     SLongJingItem2FirstLevelId targetCfg = SLongJingItem2FirstLevelId.get(itemId);
/* 104 */     if (targetCfg == null)
/*     */     {
/* 106 */       return -1.0F;
/*     */     }
/* 108 */     int targetFirstLevelId = targetCfg.firstLevelLongjingid;
/* 109 */     Set<Integer> targetItemids = getTopThreeBaseItem(targetFirstLevelId);
/* 110 */     if ((targetItemids == null) || (targetItemids.isEmpty()))
/*     */     {
/* 112 */       return -1.0F;
/*     */     }
/* 114 */     return computePrice(targetItemids);
/*     */   }
/*     */   
/*     */   private static float computePrice(Set<Integer> itemids)
/*     */   {
/* 119 */     if ((itemids == null) || (itemids.isEmpty()))
/*     */     {
/* 121 */       return -1.0F;
/*     */     }
/* 123 */     float total = 0.0F;
/*     */     
/* 125 */     for (Iterator i$ = itemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 127 */       SLongJingItem sLongJingItem = SLongJingItem.get(itemid);
/* 128 */       if (sLongJingItem == null)
/*     */       {
/* 130 */         return -1.0F;
/*     */       }
/* 132 */       if (sLongJingItem.lv - 1 < 0)
/*     */       {
/* 134 */         return -1.0F;
/*     */       }
/* 136 */       double size = Math.pow(2.0D, sLongJingItem.lv - 1);
/* 137 */       int temp = ShanghuiInterface.getItemPrice(itemid);
/* 138 */       if (temp <= 0)
/*     */       {
/* 140 */         return -1.0F;
/*     */       }
/*     */       
/*     */ 
/* 144 */       total = (float)(total + temp / size);
/*     */     }
/*     */     
/*     */ 
/* 148 */     return total / itemids.size();
/*     */   }
/*     */   
/*     */ 
/*     */   private static Set<Integer> getTopThreeBaseItem(int firstLevelId)
/*     */   {
/* 154 */     Set<Integer> targetItemids = new HashSet();
/* 155 */     targetItemids.add(Integer.valueOf(firstLevelId));
/* 156 */     int curTargetItem = firstLevelId;
/*     */     
/* 158 */     for (int i = 1; i < SFabaoConstants.getInstance().BASE_PRICE_ITEM_LEVEL; i++)
/*     */     {
/* 160 */       SLongJingItem t = SLongJingItem.get(curTargetItem);
/* 161 */       if (t == null)
/*     */       {
/* 163 */         return null;
/*     */       }
/* 165 */       targetItemids.add(Integer.valueOf(t.nextId));
/* 166 */       curTargetItem = t.nextId;
/*     */     }
/* 168 */     return targetItemids;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\LongjingTransferInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */