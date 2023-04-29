/*     */ package mzm.gsp.zhenyao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.SSynZheyaoCount;
/*     */ import mzm.gsp.activity.confbean.SZhenYaoModifyCfg;
/*     */ import mzm.gsp.activity.confbean.SZhenyaoRingcount2Modifyids;
/*     */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.guaji.main.GuajiInterface;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.ZhenyaoCount;
/*     */ import xtable.Role2zhenyaocount;
/*     */ 
/*     */ 
/*     */ class ZhenyaoManager
/*     */ {
/*  29 */   static final Logger logger = Logger.getLogger("Zhenyao");
/*     */   private static final int WAN = 10000;
/*     */   
/*     */   static void init()
/*     */   {
/*     */     try
/*     */     {
/*  36 */       ActivityInterface.registerActivityByLogicType(1, new ZhenyaoActivityInit());
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  41 */       throw new RuntimeException(e);
/*     */     }
/*     */     
/*  44 */     registerRewardItemAccess();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void registerRewardItemAccess()
/*     */   {
/*  52 */     ItemAccessManager.registerActivityReward(ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ZhenYaoActivityCfgConsts.getInstance().REWARDID);
/*     */     
/*  54 */     ItemAccessManager.registerActivityReward(ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ZhenYaoActivityCfgConsts.getInstance().REWARDID2);
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
/*     */ 
/*     */   static int getModifyId(int ringcount, boolean isCutDoublePoint, int levelDelta)
/*     */   {
/*  71 */     SZhenyaoRingcount2Modifyids zhenyaoRingcount2Modifyids = SZhenyaoRingcount2Modifyids.get(ringcount % ZhenYaoActivityCfgConsts.getInstance().CIRCLE_MOD);
/*     */     
/*  73 */     if (zhenyaoRingcount2Modifyids == null)
/*     */     {
/*  75 */       return -1;
/*     */     }
/*  77 */     List<Integer> targetids = null;
/*  78 */     if (isCutDoublePoint)
/*     */     {
/*  80 */       targetids = zhenyaoRingcount2Modifyids.doubleIds;
/*     */     }
/*     */     else
/*     */     {
/*  84 */       targetids = zhenyaoRingcount2Modifyids.singleIds;
/*     */     }
/*  86 */     if ((targetids == null) || (targetids.isEmpty()))
/*     */     {
/*  88 */       return -1;
/*     */     }
/*  90 */     for (Iterator i$ = targetids.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/*  92 */       SZhenYaoModifyCfg zhenYaoModifyCfg = SZhenYaoModifyCfg.get(id);
/*  93 */       if (zhenYaoModifyCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*  97 */         if ((zhenYaoModifyCfg.minLevel <= levelDelta) && (levelDelta <= zhenYaoModifyCfg.maxLevel))
/*     */         {
/*  99 */           return zhenYaoModifyCfg.modifyId;
/*     */         }
/*     */       }
/*     */     }
/* 103 */     return -1;
/*     */   }
/*     */   
/*     */   static boolean addZhenyaoCount(long roleid, int count)
/*     */   {
/* 108 */     if (count <= 0)
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     ZhenyaoCount zhenyaoCount = Role2zhenyaocount.get(Long.valueOf(roleid));
/* 113 */     if (zhenyaoCount == null)
/*     */     {
/* 115 */       zhenyaoCount = Pod.newZhenyaoCount();
/* 116 */       zhenyaoCount.setZhenyaocount(0);
/* 117 */       Role2zhenyaocount.insert(Long.valueOf(roleid), zhenyaoCount);
/*     */     }
/* 119 */     zhenyaoCount.setZhenyaocount(zhenyaoCount.getZhenyaocount() + count);
/* 120 */     return true;
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
/*     */   static void computeReserveExp(String userid, long roleid, int zhenyaocount, int turn)
/*     */   {
/* 133 */     if (zhenyaocount < 0)
/*     */     {
/* 135 */       return;
/*     */     }
/* 137 */     if (!ActivityInterface.isInActivityLevel(userid, roleid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID))
/*     */     {
/* 139 */       return;
/*     */     }
/* 141 */     boolean isFiftyAwardOpen = isZhenyaoFiftyAwardSwitchOpen();
/* 142 */     int rewardId = getZhenyaoRewardId(isFiftyAwardOpen);
/* 143 */     int recommendCount = getZhenyaoRecommendCount(isFiftyAwardOpen);
/* 144 */     int oneturnexp = getZhenyaoExp(roleid, 1, recommendCount, rewardId);
/* 145 */     double exp = oneturnexp * turn;
/*     */     
/* 147 */     if (zhenyaocount >= 0)
/*     */     {
/* 149 */       exp += getZhenyaoExp(roleid, zhenyaocount + 1, recommendCount, rewardId);
/*     */     }
/*     */     
/* 152 */     int toaddexp = (int)(exp * ZhenYaoActivityCfgConsts.getInstance().EXP_CHANGE_RATE / 10000.0D);
/* 153 */     if (toaddexp > 0)
/*     */     {
/* 155 */       StorageExpInterface.addStorageExp(roleid, toaddexp);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getZhenyaoRecommendCount(boolean is50Time)
/*     */   {
/* 167 */     if (is50Time)
/*     */     {
/* 169 */       return ZhenYaoActivityCfgConsts.getInstance().STORAGE_EXP_NUM2;
/*     */     }
/*     */     
/*     */ 
/* 173 */     return ZhenYaoActivityCfgConsts.getInstance().STORAGE_EXP_NUM;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static int getZhenyaoExp(long roleid, int startcount, int endcount, int rewardid)
/*     */   {
/* 180 */     List<Long> list = new ArrayList();
/* 181 */     list.add(Long.valueOf(roleid));
/* 182 */     List<Long> list2 = new ArrayList();
/* 183 */     list2.add(Long.valueOf(roleid));
/* 184 */     int exp = 0;
/* 185 */     AwardReason awardReason = new AwardReason(LogReason.ZHENYAO_DAY_STORAGE_AWARD, rewardid);
/* 186 */     awardReason.setJustQuery(true);
/* 187 */     for (int i = startcount; i <= endcount; i++)
/*     */     {
/* 189 */       int modifyId = getModifyId(i, false, 0);
/*     */       
/* 191 */       AwardModel award = AwardInterface.getRoleAwardModel(rewardid, roleid, modifyId, list, list2, awardReason);
/* 192 */       if (award != null)
/*     */       {
/* 194 */         exp += award.getRoleExp();
/*     */       }
/*     */     }
/*     */     
/* 198 */     return exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canCostDouble(long roleId)
/*     */   {
/* 210 */     int num = GuajiInterface.getUsableDoublePoint(roleId);
/* 211 */     int needNum = ZhenYaoActivityCfgConsts.getInstance().FIGHT_DEC_DOUBLE_POINT;
/* 212 */     return num >= needNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synXYaoData2Client(long roleId, ZhenyaoCount xCount)
/*     */   {
/* 222 */     SSynZheyaoCount pro = new SSynZheyaoCount();
/* 223 */     pro.doublecount = xCount.getDoublecount();
/* 224 */     pro.singlecount = xCount.getSinglecount();
/*     */     
/* 226 */     OnlineManager.getInstance().send(roleId, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isZhenyaoSwitchOpenForRole(long leaderRoleid, List<Long> roleids)
/*     */   {
/* 238 */     if (!OpenInterface.getOpenStatus(1))
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 244 */       if (OpenInterface.isBanPlay(roleid, 1))
/*     */       {
/* 246 */         OpenInterface.sendBanPlayMsg(leaderRoleid, roleid, RoleInterface.getName(roleid), 1);
/*     */         
/*     */ 
/* 249 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 253 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isZhenyaoSwitchOpenForRole(long roleid)
/*     */   {
/* 265 */     return isZhenyaoSwitchOpenForRole(roleid, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isZhenyaoSwitchOpenForRole(long roleid, boolean isSendTip)
/*     */   {
/* 276 */     if (!OpenInterface.getOpenStatus(1))
/*     */     {
/* 278 */       return false;
/*     */     }
/*     */     
/* 281 */     if (OpenInterface.isBanPlay(roleid, 1))
/*     */     {
/* 283 */       if (isSendTip)
/*     */       {
/* 285 */         OpenInterface.sendBanPlayMsg(roleid, 1);
/*     */       }
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenyaoMaxAwardCount(boolean is50Time)
/*     */   {
/* 296 */     if (is50Time)
/*     */     {
/* 298 */       return ZhenYaoActivityCfgConsts.getInstance().MAX_AWARD_COUNT2;
/*     */     }
/*     */     
/*     */ 
/* 302 */     return ZhenYaoActivityCfgConsts.getInstance().MAX_AWARD_COUNT;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenyaoNeedCutDoublePoint(boolean is50Time)
/*     */   {
/* 308 */     if (is50Time)
/*     */     {
/* 310 */       return ZhenYaoActivityCfgConsts.getInstance().FIGHT_DEC_DOUBLE_POINT2;
/*     */     }
/*     */     
/*     */ 
/* 314 */     return ZhenYaoActivityCfgConsts.getInstance().FIGHT_DEC_DOUBLE_POINT;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenyaoAwardXiayiNum(boolean is50Time)
/*     */   {
/* 320 */     if (is50Time)
/*     */     {
/* 322 */       return ZhenYaoActivityCfgConsts.getInstance().XIAYI_ADD_NUM2;
/*     */     }
/*     */     
/*     */ 
/* 326 */     return ZhenYaoActivityCfgConsts.getInstance().XIAYI_ADD_NUM;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenyaoRewardId(boolean is50Time)
/*     */   {
/* 332 */     if (is50Time)
/*     */     {
/* 334 */       return ZhenYaoActivityCfgConsts.getInstance().REWARDID2;
/*     */     }
/*     */     
/*     */ 
/* 338 */     return ZhenYaoActivityCfgConsts.getInstance().REWARDID;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isZhenyaoFiftyAwardSwitchOpen()
/*     */   {
/* 344 */     return OpenInterface.getOpenStatus(193);
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
/*     */   static int getZhenyaoRestExp(long roleid, int finishCount)
/*     */   {
/* 358 */     if (finishCount < 0)
/*     */     {
/* 360 */       return 0;
/*     */     }
/* 362 */     boolean is50Time = isZhenyaoFiftyAwardSwitchOpen();
/* 363 */     int recommendCount = getZhenyaoRecommendCount(is50Time);
/* 364 */     if (finishCount >= recommendCount)
/*     */     {
/* 366 */       return 0;
/*     */     }
/* 368 */     int rewardid = getZhenyaoRewardId(is50Time);
/* 369 */     int addexp = getZhenyaoExp(roleid, finishCount + 1, recommendCount, rewardid);
/* 370 */     return addexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getZhenyaoExpByRing(long roleid, int ring)
/*     */   {
/* 382 */     if (ring <= 0)
/*     */     {
/* 384 */       return 0;
/*     */     }
/* 386 */     List<Long> list = new ArrayList();
/* 387 */     list.add(Long.valueOf(roleid));
/* 388 */     List<Long> list2 = new ArrayList();
/* 389 */     list2.add(Long.valueOf(roleid));
/* 390 */     int exp = 0;
/* 391 */     boolean is50Time = isZhenyaoFiftyAwardSwitchOpen();
/* 392 */     int rewardid = getZhenyaoRewardId(is50Time);
/* 393 */     AwardReason awardReason = new AwardReason(LogReason.ZHENYAO_DAY_STORAGE_AWARD, rewardid);
/* 394 */     awardReason.setJustQuery(true);
/* 395 */     int modifyId = getModifyId(ring, false, 0);
/* 396 */     AwardModel award = AwardInterface.getRoleAwardModel(rewardid, roleid, modifyId, list, list2, awardReason);
/* 397 */     if (award != null)
/*     */     {
/* 399 */       exp += award.getRoleExp();
/*     */     }
/* 401 */     return exp;
/*     */   }
/*     */   
/*     */   static float getRate()
/*     */   {
/* 406 */     return ZhenYaoActivityCfgConsts.getInstance().RETURN_BACK_EXP_CHANGE_RATE / 10000.0F;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenyaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */