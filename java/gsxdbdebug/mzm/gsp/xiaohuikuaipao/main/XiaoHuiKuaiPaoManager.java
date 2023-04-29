/*     */ package mzm.gsp.xiaohuikuaipao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.STXiaoHuiKuaiPaoGridCfg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.SXiaoHuiKuaiPaoGridInfo;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*     */ import xbean.Pod;
/*     */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*     */ import xbean.XiaoHuiKuaiPaoInfo;
/*     */ import xtable.Role2xiaohuikuaipaoactivityinfo;
/*     */ 
/*     */ public class XiaoHuiKuaiPaoManager
/*     */ {
/*     */   static final int ONCE = 1;
/*     */   static final int TEN_TIMES = 10;
/*     */   
/*     */   public static MainSubItemYuanBaoInfo cutMainSubItemWithYuanBaoSupply(String userId, long roleId, int mainItemId, int subItemId, int totalItemNeed)
/*     */   {
/*  40 */     MainSubItemYuanBaoInfo mainSubItemYuanBaoInfo = new MainSubItemYuanBaoInfo();
/*     */     
/*     */ 
/*  43 */     int subItemCountInBag = ItemInterface.getItemNumberById(roleId, subItemId);
/*     */     
/*  45 */     int mainItemCountInBag = ItemInterface.getItemNumberById(roleId, mainItemId);
/*     */     
/*     */     int mainItemCountNeed;
/*     */     int mainItemCountNeed;
/*  49 */     if (totalItemNeed <= subItemCountInBag)
/*     */     {
/*  51 */       mainSubItemYuanBaoInfo.itemId2countToCost.put(Integer.valueOf(subItemId), Integer.valueOf(totalItemNeed));
/*  52 */       mainItemCountNeed = 0;
/*     */     }
/*     */     else
/*     */     {
/*  56 */       mainItemCountNeed = totalItemNeed - subItemCountInBag;
/*  57 */       if (subItemCountInBag != 0)
/*     */       {
/*  59 */         mainSubItemYuanBaoInfo.itemId2countToCost.put(Integer.valueOf(subItemId), Integer.valueOf(subItemCountInBag));
/*     */       }
/*     */     }
/*     */     
/*  63 */     if (mainItemCountNeed != 0)
/*     */     {
/*  65 */       if (mainItemCountNeed <= mainItemCountInBag)
/*     */       {
/*  67 */         mainSubItemYuanBaoInfo.itemId2countToCost.put(Integer.valueOf(mainItemId), Integer.valueOf(mainItemCountNeed));
/*  68 */         mainItemCountNeed = 0;
/*     */       }
/*  70 */       else if (mainItemCountInBag != 0)
/*     */       {
/*  72 */         mainSubItemYuanBaoInfo.itemId2countToCost.put(Integer.valueOf(mainItemId), Integer.valueOf(mainItemCountInBag));
/*  73 */         mainItemCountNeed -= mainItemCountInBag;
/*     */       }
/*     */     }
/*     */     
/*  77 */     int yuanBaoToCost = ItemInterface.getItemYuanBaoPrice(mainItemId) * mainItemCountNeed;
/*     */     
/*  79 */     mainSubItemYuanBaoInfo.yuanBaoSupplyItemCount = mainItemCountNeed;
/*  80 */     mainSubItemYuanBaoInfo.yuanBaoToCost = yuanBaoToCost;
/*     */     
/*     */ 
/*  83 */     if (!mainSubItemYuanBaoInfo.itemId2countToCost.isEmpty())
/*     */     {
/*  85 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(roleId, mainSubItemYuanBaoInfo.itemId2countToCost, new TLogArg(LogReason.XIAO_HUI_KUAI_PAO_OUTER_DRAW));
/*     */       
/*  87 */       if (!itemOperateResult.success())
/*     */       {
/*  89 */         mainSubItemYuanBaoInfo.isSuccess = false;
/*  90 */         mainSubItemYuanBaoInfo.isItemNotEnough = true;
/*  91 */         return mainSubItemYuanBaoInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (yuanBaoToCost != 0)
/*     */     {
/*  98 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, yuanBaoToCost, CostType.COST_BIND_FIRST_XIAO_HUI_KUAI_PAO_OUTER_DRAW, new TLogArg(LogReason.XIAO_HUI_KUAI_PAO_OUTER_DRAW));
/*     */       
/* 100 */       if (costResult != CostResult.Success)
/*     */       {
/* 102 */         mainSubItemYuanBaoInfo.isSuccess = false;
/* 103 */         mainSubItemYuanBaoInfo.isYuanBaoNotEnough = true;
/* 104 */         return mainSubItemYuanBaoInfo;
/*     */       }
/*     */     }
/* 107 */     return mainSubItemYuanBaoInfo;
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> getMaxGridNeededForPoolTypeIds(long roleId, int activityId)
/*     */   {
/* 112 */     STXiaoHuiKuaiPaoGridCfg xiaoHuiKuaiPaoGridCfg = STXiaoHuiKuaiPaoGridCfg.get(activityId);
/* 113 */     if (xiaoHuiKuaiPaoGridCfg == null)
/*     */     {
/* 115 */       return java.util.Collections.emptyMap();
/*     */     }
/*     */     
/* 118 */     Set<Integer> poolTypeIds = new HashSet();
/* 119 */     for (Map.Entry<Integer, SXiaoHuiKuaiPaoGridInfo> entry : xiaoHuiKuaiPaoGridCfg.index2gridInfo.entrySet())
/*     */     {
/* 121 */       poolTypeIds.add(Integer.valueOf(((SXiaoHuiKuaiPaoGridInfo)entry.getValue()).poolTypeId));
/*     */     }
/*     */     
/* 124 */     return AwardPoolInterface.getMaxGridNeededForPoolTypeIds(roleId, poolTypeIds);
/*     */   }
/*     */   
/*     */   static int getCurrentActivityId()
/*     */   {
/* 129 */     Set<Integer> activityIdSet = ActivityInterface.getActivityIdsByLogicType(124);
/*     */     
/* 131 */     if ((activityIdSet == null) || (activityIdSet.isEmpty()))
/*     */     {
/* 133 */       return -1;
/*     */     }
/* 135 */     for (Integer id : activityIdSet)
/*     */     {
/* 137 */       if (ActivityInterface.isActivityOpen(id.intValue()))
/*     */       {
/* 139 */         return id.intValue();
/*     */       }
/*     */     }
/* 142 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   static XiaoHuiKuaiPaoInfo getXiaoHuiKuaiPaoInfo(long roleId, int activityId, XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg)
/*     */   {
/* 148 */     XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoActivityInfo = Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(roleId));
/* 149 */     if (xXiaoHuiKuaiPaoActivityInfo == null)
/*     */     {
/* 151 */       xXiaoHuiKuaiPaoActivityInfo = Pod.newXiaoHuiKuaiPaoActivityInfo();
/* 152 */       Role2xiaohuikuaipaoactivityinfo.insert(Long.valueOf(roleId), xXiaoHuiKuaiPaoActivityInfo);
/*     */     }
/*     */     
/* 155 */     Map<Integer, XiaoHuiKuaiPaoInfo> xXiaoHuiKuaiPaoInfoMap = xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo();
/*     */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo;
/* 157 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo; if (xXiaoHuiKuaiPaoInfoMap.containsKey(Integer.valueOf(activityId)))
/*     */     {
/* 159 */       xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)xXiaoHuiKuaiPaoInfoMap.get(Integer.valueOf(activityId));
/*     */     }
/*     */     else
/*     */     {
/* 163 */       xXiaoHuiKuaiPaoInfo = Pod.newXiaoHuiKuaiPaoInfo();
/* 164 */       xXiaoHuiKuaiPaoInfoMap.put(Integer.valueOf(activityId), xXiaoHuiKuaiPaoInfo);
/* 165 */       xXiaoHuiKuaiPaoInfo.setEndtimestamp(ActivityInterface.getActivityEndTime(activityId) + TimeUnit.DAYS.toMillis(xiaoHuiKuaiPaoActivityCfg.duration));
/*     */     }
/*     */     
/* 168 */     return xXiaoHuiKuaiPaoInfo;
/*     */   }
/*     */   
/*     */   static void clearFanBaoDi(long roleId, int lotteryViewRandomCfgId)
/*     */   {
/* 173 */     AwardPoolInterface.clearLotteryWeightCorrectionInfo(roleId, lotteryViewRandomCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static AwardPoolResultData getInnerDrawAwardPoolResultData(long roleId, XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo, XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg, SLotteryViewRandomCfg lotteryViewRandomCfg)
/*     */   {
/* 180 */     if (lotteryViewRandomCfg.typeIds.size() == xXiaoHuiKuaiPaoInfo.getHitindexes().size())
/*     */     {
/*     */ 
/* 183 */       clearFanBaoDi(roleId, xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId);
/* 184 */       xXiaoHuiKuaiPaoInfo.getHitindexes().clear();
/* 185 */       xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids().clear();
/*     */     }
/* 187 */     List<Integer> removeTypeIds = new ArrayList();
/* 188 */     removeTypeIds.addAll(xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids());
/*     */     
/* 190 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(roleId, xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId, false, null, removeTypeIds);
/*     */     
/*     */ 
/*     */ 
/* 194 */     xXiaoHuiKuaiPaoInfo.getHitindexes().add(Integer.valueOf(awardPoolResultData.getIndex()));
/* 195 */     xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids().add(Integer.valueOf(awardPoolResultData.getTypeId()));
/* 196 */     xXiaoHuiKuaiPaoInfo.setTicketcount(xXiaoHuiKuaiPaoInfo.getTicketcount() - xiaoHuiKuaiPaoActivityCfg.ticketCount);
/* 197 */     return awardPoolResultData;
/*     */   }
/*     */   
/*     */   static void sendBulletinInfo(long roleId, Map<Integer, Integer> itemId2Count, int bulletinType)
/*     */   {
/* 202 */     String roleName = mzm.gsp.role.main.RoleInterface.getName(roleId);
/*     */     
/*     */ 
/* 205 */     for (Map.Entry<Integer, Integer> entry : itemId2Count.entrySet())
/*     */     {
/* 207 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 208 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemId))
/*     */       {
/*     */ 
/*     */ 
/* 212 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 213 */         bulletinInfo.bulletintype = bulletinType;
/* 214 */         bulletinInfo.params.put(Integer.valueOf(1), roleName);
/* 215 */         bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemId));
/* 216 */         bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(entry.getValue()));
/* 217 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\XiaoHuiKuaiPaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */