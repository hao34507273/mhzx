/*     */ package mzm.gsp.drawcarnival.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.drawcarnival.AwardWinnerInfo;
/*     */ import mzm.gsp.drawcarnival.DrawAwardInfo;
/*     */ import mzm.gsp.drawcarnival.FreePassInfo;
/*     */ import mzm.gsp.drawcarnival.PassAwardInfo;
/*     */ import mzm.gsp.drawcarnival.SBroadcastBigAwardInfo;
/*     */ import mzm.gsp.drawcarnival.SBroadcastChestAwardInfo;
/*     */ import mzm.gsp.drawcarnival.SDrawError;
/*     */ import mzm.gsp.drawcarnival.SDrawRsp;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalBigAwardCountMaxCfg;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg;
/*     */ import mzm.gsp.drawcarnival.confbean.SOrigDrawCarnivalBigAwardCfg;
/*     */ import mzm.gsp.drawcarnival.confbean.SOrigDrawCarnivalSpreadWealthCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawCarnivalActivityInfo;
/*     */ import xbean.DrawCarnivalAwardWinnerInfo;
/*     */ import xbean.DrawCarnivalGlobalInfo;
/*     */ import xbean.DrawCarnivalRoleActivityInfo;
/*     */ import xbean.DrawCarnivalRoleFreePassInfo;
/*     */ import xbean.DrawCarnivalRoleInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Drawcarnivalactivityglobal;
/*     */ 
/*     */ public class DrawCarnivalManager
/*     */ {
/*     */   static final String CHARSET = "utf-8";
/*     */   static final String GS_LOG_MODULE_NAME = "draw_carnival";
/*     */   private static final String GS_LOG_CLASS_NAME = "DrawCarnivalManager";
/*     */   
/*     */   static void init()
/*     */   {
/*  59 */     mzm.gsp.activity.main.ActivityInterface.registerActivityByLogicType(149, new DrawCarnivalActivityHandler());
/*     */   }
/*     */   
/*     */ 
/*     */   static DrawCarnivalGlobalInfo getDrawCarnivalGlobalInfoCreateIfNotExist()
/*     */   {
/*  65 */     long globalTableKey = mzm.gsp.GameServerInfoManager.getLocalId();
/*     */     
/*  67 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = Drawcarnivalactivityglobal.get(Long.valueOf(globalTableKey));
/*  68 */     if (xDrawCarnivalGlobalInfo == null)
/*     */     {
/*  70 */       xDrawCarnivalGlobalInfo = Pod.newDrawCarnivalGlobalInfo();
/*  71 */       Drawcarnivalactivityglobal.insert(Long.valueOf(globalTableKey), xDrawCarnivalGlobalInfo);
/*     */       
/*     */ 
/*  74 */       xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(SDrawCarnivalConsts.getInstance().AWARD_POOL_INIT_YUAN_BAO_COUNT);
/*     */     }
/*     */     
/*     */ 
/*  78 */     return xDrawCarnivalGlobalInfo;
/*     */   }
/*     */   
/*     */   static DrawCarnivalGlobalInfo getDrawCarnivalGlobalInfo(boolean isHoldLock)
/*     */   {
/*  83 */     long globalTableKey = mzm.gsp.GameServerInfoManager.getLocalId();
/*     */     
/*  85 */     return isHoldLock ? Drawcarnivalactivityglobal.get(Long.valueOf(globalTableKey)) : Drawcarnivalactivityglobal.select(Long.valueOf(globalTableKey));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static DrawCarnivalActivityInfo getCurrentDrawCarnivalActivityInfoCreateIfNotExist(Map<Integer, DrawCarnivalActivityInfo> activityId2info)
/*     */   {
/*  93 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)activityId2info.get(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID));
/*     */     
/*  95 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/*  97 */       xDrawCarnivalActivityInfo = Pod.newDrawCarnivalActivityInfo();
/*  98 */       activityId2info.put(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), xDrawCarnivalActivityInfo);
/*     */       
/*     */ 
/* 101 */       initPassTypeId2extraRatePerPass(xDrawCarnivalActivityInfo.getPass_type_id2extra_rate_per_pass());
/*     */     }
/* 103 */     return xDrawCarnivalActivityInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static DrawCarnivalActivityInfo getCurrentDrawCarnivalActivityInfo(Map<Integer, DrawCarnivalActivityInfo> activityId2info)
/*     */   {
/* 109 */     return (DrawCarnivalActivityInfo)activityId2info.get(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID));
/*     */   }
/*     */   
/*     */ 
/*     */   static void initPassTypeId2extraRatePerPass(Map<Integer, Integer> passTypeId2extraRatePerPass)
/*     */   {
/* 115 */     for (Map.Entry<Integer, SDrawCarnivalPassTypeCfg> entry : SDrawCarnivalPassTypeCfg.getAll().entrySet())
/*     */     {
/* 117 */       SDrawCarnivalPassTypeCfg sDrawCarnivalPassTypeCfg = (SDrawCarnivalPassTypeCfg)entry.getValue();
/* 118 */       passTypeId2extraRatePerPass.put(entry.getKey(), Integer.valueOf(sDrawCarnivalPassTypeCfg.extraRatePerPass));
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillAwardWinnerInfo(DrawCarnivalActivityInfo xFrom, AwardWinnerInfo to)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 125 */     to.role_id = xFrom.getLast_winner_role_info().getRole_id();
/* 126 */     to.role_name.setString(xFrom.getLast_winner_role_info().getRole_name(), "utf-8");
/* 127 */     to.random_type_id = xFrom.getLast_winner_role_info().getRandom_type_id();
/* 128 */     to.award_count = xFrom.getLast_winner_role_info().getAward_count();
/*     */   }
/*     */   
/*     */   static DrawCarnivalRoleInfo getDrawCarnivalRoleInfoCreateIfNotExist(long roleId)
/*     */   {
/* 133 */     DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = xtable.Role2drawcarnivalactivity.get(Long.valueOf(roleId));
/* 134 */     if (xDrawCarnivalRoleInfo == null)
/*     */     {
/* 136 */       xDrawCarnivalRoleInfo = Pod.newDrawCarnivalRoleInfo();
/* 137 */       xtable.Role2drawcarnivalactivity.insert(Long.valueOf(roleId), xDrawCarnivalRoleInfo);
/*     */     }
/* 139 */     return xDrawCarnivalRoleInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static DrawCarnivalRoleActivityInfo getCurrentDrawCarnivalRoleActivityInfoCreateIfNotExist(long roleId, DrawCarnivalRoleInfo xDrawCarnivalRoleInfo)
/*     */   {
/* 145 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = (DrawCarnivalRoleActivityInfo)xDrawCarnivalRoleInfo.getActivity_id2role_info().get(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID));
/*     */     
/* 147 */     if (xDrawCarnivalRoleActivityInfo == null)
/*     */     {
/* 149 */       xDrawCarnivalRoleActivityInfo = Pod.newDrawCarnivalRoleActivityInfo();
/* 150 */       xDrawCarnivalRoleInfo.getActivity_id2role_info().put(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), xDrawCarnivalRoleActivityInfo);
/*     */       
/*     */ 
/*     */ 
/* 154 */       xDrawCarnivalRoleActivityInfo.setInit_point_count(MallInterface.getJifen(roleId, 17));
/*     */     }
/*     */     
/* 157 */     return xDrawCarnivalRoleActivityInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndResetFreePasses(DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo)
/*     */   {
/* 166 */     for (Map.Entry<Integer, SDrawCarnivalPassTypeCfg> entry : SDrawCarnivalPassTypeCfg.getAll().entrySet())
/*     */     {
/* 168 */       int passTypeId = ((Integer)entry.getKey()).intValue();
/* 169 */       SDrawCarnivalPassTypeCfg sDrawCarnivalPassTypeCfg = (SDrawCarnivalPassTypeCfg)entry.getValue();
/* 170 */       DrawCarnivalRoleFreePassInfo xDrawCarnivalRoleFreePassInfo = (DrawCarnivalRoleFreePassInfo)xDrawCarnivalRoleActivityInfo.getFree_pass_type_id2info().get(Integer.valueOf(passTypeId));
/* 171 */       if (xDrawCarnivalRoleFreePassInfo == null)
/*     */       {
/* 173 */         xDrawCarnivalRoleFreePassInfo = Pod.newDrawCarnivalRoleFreePassInfo();
/* 174 */         xDrawCarnivalRoleActivityInfo.getFree_pass_type_id2info().put(Integer.valueOf(passTypeId), xDrawCarnivalRoleFreePassInfo);
/*     */         
/* 176 */         xDrawCarnivalRoleFreePassInfo.setCount(sDrawCarnivalPassTypeCfg.freePassCountPerDay);
/* 177 */         xDrawCarnivalRoleFreePassInfo.setReset_time_stamp(TimeCommonUtil.getNextStartTime(DateTimeUtils.getCurrTimeInMillis(), sDrawCarnivalPassTypeCfg.freePassResetTime, false));
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 182 */       else if (xDrawCarnivalRoleFreePassInfo.getReset_time_stamp() <= DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 187 */         xDrawCarnivalRoleFreePassInfo.setCount(sDrawCarnivalPassTypeCfg.freePassCountPerDay);
/* 188 */         xDrawCarnivalRoleFreePassInfo.setReset_time_stamp(TimeCommonUtil.getNextStartTime(DateTimeUtils.getCurrTimeInMillis(), sDrawCarnivalPassTypeCfg.freePassResetTime, false));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillPassTypeId2freePassInfo(Map<Integer, DrawCarnivalRoleFreePassInfo> xFrom, Map<Integer, FreePassInfo> to)
/*     */   {
/* 200 */     for (Map.Entry<Integer, DrawCarnivalRoleFreePassInfo> entry : xFrom.entrySet())
/*     */     {
/* 202 */       FreePassInfo freePassInfo = new FreePassInfo();
/* 203 */       to.put(entry.getKey(), freePassInfo);
/*     */       
/* 205 */       DrawCarnivalRoleFreePassInfo xDrawCarnivalRoleFreePassInfo = (DrawCarnivalRoleFreePassInfo)entry.getValue();
/* 206 */       fillFreePassInfo(xDrawCarnivalRoleFreePassInfo, freePassInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillFreePassInfo(DrawCarnivalRoleFreePassInfo xFrom, FreePassInfo to)
/*     */   {
/* 212 */     to.count = xFrom.getCount();
/* 213 */     to.reset_time_stamp = java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(xFrom.getReset_time_stamp());
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
/*     */   static UseItemsWithYuanBaoMakeUpResultInfo useItemsWithYuanBaoMakeUp(String userId, long roleId, List<Integer> itemCfgIdList, int needItemCount, int yuanBaoPricePerItem)
/*     */   {
/* 229 */     UseItemsWithYuanBaoMakeUpResultInfo useItemsWithYuanBaoMakeUpResultInfo = new UseItemsWithYuanBaoMakeUpResultInfo();
/*     */     
/*     */ 
/* 232 */     int needMoreItemCount = needItemCount;
/* 233 */     for (Iterator i$ = itemCfgIdList.iterator(); i$.hasNext();) { int itemCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 235 */       if (needMoreItemCount <= 0) {
/*     */         break;
/*     */       }
/*     */       
/* 239 */       int itemCountInBag = ItemInterface.getItemNumberById(roleId, itemCfgId);
/* 240 */       if (itemCountInBag != 0)
/*     */       {
/*     */ 
/*     */ 
/* 244 */         useItemsWithYuanBaoMakeUpResultInfo.itemId2countToCost.put(Integer.valueOf(itemCfgId), Integer.valueOf(itemCountInBag >= needMoreItemCount ? needMoreItemCount : itemCountInBag));
/*     */         
/*     */ 
/* 247 */         needMoreItemCount -= itemCountInBag;
/*     */       }
/*     */     }
/* 250 */     if (needMoreItemCount <= 0)
/*     */     {
/* 252 */       useItemsWithYuanBaoMakeUpResultInfo.yuanBaoSupplyItemCount = 0;
/* 253 */       useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost = 0;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 258 */       useItemsWithYuanBaoMakeUpResultInfo.yuanBaoSupplyItemCount = needMoreItemCount;
/* 259 */       useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost = (needMoreItemCount * yuanBaoPricePerItem);
/*     */     }
/*     */     
/*     */ 
/* 263 */     if (!useItemsWithYuanBaoMakeUpResultInfo.itemId2countToCost.isEmpty())
/*     */     {
/* 265 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(roleId, useItemsWithYuanBaoMakeUpResultInfo.itemId2countToCost, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW));
/*     */       
/* 267 */       if (!itemOperateResult.success())
/*     */       {
/* 269 */         useItemsWithYuanBaoMakeUpResultInfo.result = 3;
/*     */         
/* 271 */         return useItemsWithYuanBaoMakeUpResultInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 276 */     if (useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost != 0)
/*     */     {
/* 278 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_DRAW_CARNIVAL__DRAW, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW));
/*     */       
/*     */ 
/* 281 */       if (costResult != CostResult.Success)
/*     */       {
/* 283 */         useItemsWithYuanBaoMakeUpResultInfo.result = 2;
/* 284 */         return useItemsWithYuanBaoMakeUpResultInfo;
/*     */       }
/*     */     }
/* 287 */     useItemsWithYuanBaoMakeUpResultInfo.result = 1;
/* 288 */     return useItemsWithYuanBaoMakeUpResultInfo;
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
/*     */   static boolean draw(String userId, long roleId, int passCount, SDrawCarnivalPassTypeCfg sDrawCarnivalPassTypeCfg, DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, DrawCarnivalActivityInfo xDrawCarnivalActivityInfo, DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo, DrawCarnivalRoleFreePassInfo xDrawCarnivalRoleFreePassInfo, SDrawRsp sDrawRsp, SDrawError sDrawError, boolean isFree, boolean isDelayAward, Map<String, String> GS_LOG_PARAMS)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 316 */     int lotteryViewCfgId = isFree ? sDrawCarnivalPassTypeCfg.freePassLotteryViewCfgId : sDrawCarnivalPassTypeCfg.passLotteryViewCfgId;
/*     */     
/*     */ 
/*     */ 
/* 320 */     List<PassAwardInfo> passAwardInfoList = sDrawRsp.pass_award_info_list;
/* 321 */     FreePassInfo freePassInfo = sDrawRsp.free_pass_info;
/*     */     
/* 323 */     GS_LOG_PARAMS.put("isFree", String.valueOf(isFree));
/*     */     
/*     */ 
/* 326 */     Integer extraRatePerPassInDB = (Integer)xDrawCarnivalActivityInfo.getPass_type_id2extra_rate_per_pass().get(Integer.valueOf(sDrawCarnivalPassTypeCfg.passTypeId));
/*     */     
/* 328 */     if (extraRatePerPassInDB == null)
/*     */     {
/* 330 */       gsLog("draw_carnival", "DrawCarnivalManager", "draw", "extraRatePerPassInDB null", GS_LOG_PARAMS, 2);
/*     */       
/* 332 */       return false;
/*     */     }
/*     */     
/* 335 */     int drawCount = passCount * sDrawCarnivalPassTypeCfg.drawCountPerPass;
/*     */     
/*     */ 
/* 338 */     Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2LotteryNeedGrid(lotteryViewCfgId);
/* 339 */     Map<Integer, Integer> bagId2NeedGridNumMultiDrawCount = new HashMap();
/* 340 */     for (Map.Entry<Integer, Integer> entry : bagId2NeedGridNum.entrySet())
/*     */     {
/* 342 */       bagId2NeedGridNumMultiDrawCount.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() * drawCount));
/*     */     }
/* 344 */     if (AwardPoolInterface.checkGridNum(roleId, bagId2NeedGridNumMultiDrawCount, true, true) > 0)
/*     */     {
/* 346 */       gsLog("draw_carnival", "DrawCarnivalManager", "draw", "bag full", GS_LOG_PARAMS, 2);
/*     */       
/* 348 */       return false;
/*     */     }
/*     */     
/* 351 */     List<AwardPoolResultData> awardPoolResultDataList = new ArrayList();
/*     */     
/*     */ 
/* 354 */     List<Integer> removeTypeIds = new ArrayList();
/*     */     
/* 356 */     List<Integer> removeTypeIdsFromPassHistory = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 364 */     for (int passCountIndex = 0; passCountIndex < passCount; passCountIndex++)
/*     */     {
/*     */ 
/* 367 */       PassAwardInfo passAwardInfo = new PassAwardInfo();
/* 368 */       passAwardInfoList.add(passAwardInfo);
/*     */       
/* 370 */       removeTypeIdsFromPassHistory.clear();
/*     */       
/* 372 */       for (int drawCountIndex = 0; drawCountIndex < sDrawCarnivalPassTypeCfg.drawCountPerPass; drawCountIndex++)
/*     */       {
/*     */ 
/* 375 */         GS_LOG_PARAMS.put("passCountIndex", String.valueOf(passCountIndex));
/* 376 */         GS_LOG_PARAMS.put("drawCountIndex", String.valueOf(drawCountIndex));
/* 377 */         GS_LOG_PARAMS.remove("awardPoolResultData");
/* 378 */         GS_LOG_PARAMS.remove("nextBigAwardDrawCount");
/*     */         
/*     */ 
/* 381 */         removeTypeIds.clear();
/*     */         
/*     */ 
/* 384 */         removeTypeIds.addAll(removeTypeIdsFromPassHistory);
/*     */         
/*     */ 
/* 387 */         boolean ret = fillRemoveTypeIdsFromCfg(userId, roleId, xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, xDrawCarnivalRoleActivityInfo, removeTypeIds, new HashMap(GS_LOG_PARAMS));
/*     */         
/* 389 */         if (!ret)
/*     */         {
/* 391 */           gsLog("draw_carnival", "DrawCarnivalManager", "draw", "fillRemoveTypeIdsFromCfg error", GS_LOG_PARAMS, 2);
/*     */           
/* 393 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 397 */         AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(roleId, lotteryViewCfgId, false, null, removeTypeIds);
/*     */         
/*     */ 
/*     */ 
/* 401 */         removeTypeIdsFromPassHistory.add(Integer.valueOf(awardPoolResultData.getTypeId()));
/*     */         
/* 403 */         DrawAwardInfo drawAwardInfo = new DrawAwardInfo();
/* 404 */         passAwardInfo.draw_award_info_list.add(drawAwardInfo);
/*     */         
/* 406 */         drawAwardInfo.index = awardPoolResultData.getIndex();
/* 407 */         drawAwardInfo.item_cfg_id2count.putAll(awardPoolResultData.getItemMap());
/*     */         
/* 409 */         boolean isBigAward = isBigAward(awardPoolResultData.getTypeId());
/* 410 */         if (isBigAward)
/*     */         {
/* 412 */           ret = handleBigAward(userId, roleId, SOrigDrawCarnivalBigAwardCfg.get(awardPoolResultData.getTypeId()), xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, xDrawCarnivalRoleActivityInfo, awardPoolResultData, drawAwardInfo, new HashMap(GS_LOG_PARAMS));
/*     */           
/*     */ 
/* 415 */           if (!ret)
/*     */           {
/* 417 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 421 */         boolean isChestAward = isChestAward(awardPoolResultData.getTypeId());
/* 422 */         if (isChestAward)
/*     */         {
/* 424 */           ret = handleChestAward(roleId, SOrigDrawCarnivalSpreadWealthCfg.get(awardPoolResultData.getTypeId()), xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, awardPoolResultDataList, awardPoolResultData, drawAwardInfo, new HashMap(GS_LOG_PARAMS));
/*     */           
/*     */ 
/* 427 */           if (!ret)
/*     */           {
/* 429 */             return false;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 434 */         boolean isOtherAward = isOtherAward(awardPoolResultData.getTypeId());
/* 435 */         if (isOtherAward)
/*     */         {
/* 437 */           ret = handleOtherAward(awardPoolResultDataList, awardPoolResultData, drawAwardInfo, new HashMap(GS_LOG_PARAMS));
/*     */           
/* 439 */           if (!ret)
/*     */           {
/* 441 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 445 */         if ((!isBigAward) && (xDrawCarnivalRoleActivityInfo.getGet_next_big_award_draw_count() > 0))
/*     */         {
/* 447 */           xDrawCarnivalRoleActivityInfo.setGet_next_big_award_draw_count(xDrawCarnivalRoleActivityInfo.getGet_next_big_award_draw_count() - 1);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 452 */         DrawCarnivalTLogManger.tLogDraw(roleId, SDrawCarnivalConsts.getInstance().ACTIVITY_ID, sDrawCarnivalPassTypeCfg.passTypeId, Byte.parseByte((String)GS_LOG_PARAMS.get("isUseYuanBao")), isFree ? 1 : 0, passCountIndex, drawCountIndex, drawAwardInfo.item_type, awardPoolResultData);
/*     */         
/*     */ 
/*     */ 
/* 456 */         GS_LOG_PARAMS.put("awardPoolResultData", awardPoolResultData.toString());
/* 457 */         GS_LOG_PARAMS.put("nextBigAwardDrawCount", String.valueOf(xDrawCarnivalRoleActivityInfo.getGet_next_big_award_draw_count()));
/*     */         
/* 459 */         gsLog("draw_carnival", "DrawCarnivalManager", "draw", "draw success", GS_LOG_PARAMS, 0);
/*     */       }
/*     */       
/*     */ 
/* 463 */       if (isFree)
/*     */       {
/*     */ 
/* 466 */         xDrawCarnivalRoleFreePassInfo.setCount(xDrawCarnivalRoleFreePassInfo.getCount() - 1);
/* 467 */         if (sDrawCarnivalPassTypeCfg.useFreePassPointCount > 0)
/*     */         {
/*     */ 
/* 470 */           JifenOperateResult jifenOperateResult = MallInterface.addJifen(roleId, sDrawCarnivalPassTypeCfg.useFreePassPointCount, 17, false, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW, 0));
/*     */           
/* 472 */           if (!jifenOperateResult.isSuccess())
/*     */           {
/* 474 */             gsLog("draw_carnival", "DrawCarnivalManager", "draw", "add ji fen fail", GS_LOG_PARAMS, 2);
/*     */             
/*     */ 
/* 477 */             return false;
/*     */           }
/* 479 */           sDrawRsp.add_point_count += sDrawCarnivalPassTypeCfg.useFreePassPointCount;
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 486 */         int yuanBaoCountToAdd = (int)Math.floor(sDrawCarnivalPassTypeCfg.yuanBaoPrice * ((sDrawCarnivalPassTypeCfg.baseRatePerPass + extraRatePerPassInDB.intValue()) / 10000.0D));
/*     */         
/*     */ 
/* 489 */         xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() + yuanBaoCountToAdd);
/*     */         
/*     */ 
/*     */ 
/* 493 */         xDrawCarnivalActivityInfo.setAccumulate_yuan_bao_cost_count(xDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count() + sDrawCarnivalPassTypeCfg.yuanBaoPrice);
/*     */         
/*     */ 
/* 496 */         if (sDrawCarnivalPassTypeCfg.usePassPointCount > 0)
/*     */         {
/* 498 */           JifenOperateResult jifenOperateResult = MallInterface.addJifen(roleId, sDrawCarnivalPassTypeCfg.usePassPointCount, 17, false, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW, 1));
/*     */           
/* 500 */           if (!jifenOperateResult.isSuccess())
/*     */           {
/* 502 */             gsLog("draw_carnival", "DrawCarnivalManager", "draw", "add ji fen fail", GS_LOG_PARAMS, 2);
/*     */             
/*     */ 
/* 505 */             return false;
/*     */           }
/* 507 */           sDrawRsp.add_point_count += sDrawCarnivalPassTypeCfg.usePassPointCount;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 513 */     if (!isFree)
/*     */     {
/* 515 */       mzm.gsp.drawcarnival.SBroadcastYuanBaoChangeInfo sBroadcastYuanBaoChangeInfo = new mzm.gsp.drawcarnival.SBroadcastYuanBaoChangeInfo();
/* 516 */       sBroadcastYuanBaoChangeInfo.award_pool_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/* 517 */       OnlineManager.getInstance().sendAll(sBroadcastYuanBaoChangeInfo);
/*     */     }
/*     */     
/*     */ 
/* 521 */     if (isDelayAward)
/*     */     {
/* 523 */       boolean ret = doDelayAward(roleId, awardPoolResultDataList, sDrawError);
/* 524 */       if (!ret)
/*     */       {
/* 526 */         gsLog("draw_carnival", "DrawCarnivalManager", "draw", "delay award fail", GS_LOG_PARAMS, 2);
/*     */         
/* 528 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 533 */       for (AwardPoolResultData aprs : awardPoolResultDataList)
/*     */       {
/* 535 */         AwardPoolInterface.doAward(userId, roleId, aprs, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW));
/*     */       }
/*     */     }
/*     */     
/* 539 */     fillFreePassInfo(xDrawCarnivalRoleFreePassInfo, freePassInfo);
/*     */     
/* 541 */     OnlineManager.getInstance().send(roleId, sDrawRsp);
/* 542 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBigAward(int typeId)
/*     */   {
/* 553 */     return SOrigDrawCarnivalBigAwardCfg.getAll().keySet().contains(Integer.valueOf(typeId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChestAward(int typeId)
/*     */   {
/* 564 */     return SOrigDrawCarnivalSpreadWealthCfg.getAll().keySet().contains(Integer.valueOf(typeId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isOtherAward(int typeId)
/*     */   {
/* 575 */     return (!isBigAward(typeId)) && (!isChestAward(typeId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean handleBigAward(String userId, long roleId, SOrigDrawCarnivalBigAwardCfg sOrigDrawCarnivalBigAwardCfg, DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, DrawCarnivalActivityInfo xDrawCarnivalActivityInfo, DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo, AwardPoolResultData awardPoolResultData, DrawAwardInfo drawAwardInfo, Map<String, String> GS_LOG_PARAMS)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 598 */     SBroadcastBigAwardInfo sBroadcastBigAwardInfo = new SBroadcastBigAwardInfo();
/* 599 */     sBroadcastBigAwardInfo.orig_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/*     */     
/*     */ 
/* 602 */     int awardYuanBaoCount = (int)Math.floor(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() * (sOrigDrawCarnivalBigAwardCfg.awardRate / 10000.0D));
/*     */     
/*     */ 
/*     */ 
/* 606 */     xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() - awardYuanBaoCount);
/*     */     
/*     */ 
/* 609 */     SDrawCarnivalPassTypeCfg sDrawCarnivalPassTypeCfg = SDrawCarnivalPassTypeCfg.get(SDrawCarnivalConsts.getInstance().BASE_PASS_TYPE_ID);
/*     */     
/* 611 */     if (sDrawCarnivalPassTypeCfg == null)
/*     */     {
/* 613 */       gsLog("draw_carnival", "DrawCarnivalManager", "handleBigAward", "sDrawCarnivalPassTypeCfg null", GS_LOG_PARAMS, 2);
/*     */       
/* 615 */       return false;
/*     */     }
/*     */     
/* 618 */     int nextBigAwardDrawCount = (int)Math.ceil(awardYuanBaoCount / sDrawCarnivalPassTypeCfg.yuanBaoPrice * (sOrigDrawCarnivalBigAwardCfg.nextAwardDrawCountRate / 10000.0D));
/*     */     
/*     */ 
/* 621 */     xDrawCarnivalRoleActivityInfo.setGet_next_big_award_draw_count(nextBigAwardDrawCount);
/*     */     
/*     */ 
/* 624 */     DrawCarnivalAwardWinnerInfo xDrawCarnivalAwardWinnerInfo = xDrawCarnivalActivityInfo.getLast_winner_role_info();
/* 625 */     xDrawCarnivalAwardWinnerInfo.setRole_id(roleId);
/* 626 */     xDrawCarnivalAwardWinnerInfo.setRole_name(RoleInterface.getName(roleId));
/* 627 */     xDrawCarnivalAwardWinnerInfo.setAward_count(awardYuanBaoCount);
/* 628 */     xDrawCarnivalAwardWinnerInfo.setRandom_type_id(awardPoolResultData.getTypeId());
/* 629 */     xDrawCarnivalAwardWinnerInfo.setAward_time_stamp(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 632 */     xDrawCarnivalActivityInfo.setBig_award_count(xDrawCarnivalActivityInfo.getBig_award_count() + 1);
/*     */     
/*     */ 
/* 635 */     PresentResult presentResult = QingfuInterface.presentYuanbao(userId, roleId, awardYuanBaoCount, mzm.gsp.qingfu.main.PresentType.PRESENT_BIND_DRAW_CARNIVAL_ACTIVITY_DRAW, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW));
/*     */     
/* 637 */     if (presentResult != PresentResult.Success)
/*     */     {
/* 639 */       GS_LOG_PARAMS.put("presentResultCode", String.valueOf(presentResult.code));
/* 640 */       gsLog("draw_carnival", "DrawCarnivalManager", "handleBigAward", "present yuan bao fail", GS_LOG_PARAMS, 2);
/*     */       
/* 642 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 646 */     sBroadcastBigAwardInfo.yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/* 647 */     fillAwardWinnerInfo(xDrawCarnivalActivityInfo, sBroadcastBigAwardInfo.winner_info);
/* 648 */     OnlineManager.getInstance().sendAll(sBroadcastBigAwardInfo);
/*     */     
/* 650 */     drawAwardInfo.item_type += 1;
/*     */     
/* 652 */     GS_LOG_PARAMS.put("awardYuanBaoCount", String.valueOf(awardYuanBaoCount));
/* 653 */     GS_LOG_PARAMS.put("awardPoolYuanBaoCount", String.valueOf(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count()));
/* 654 */     GS_LOG_PARAMS.put("bigAwardCount", String.valueOf(xDrawCarnivalActivityInfo.getBig_award_count()));
/* 655 */     GS_LOG_PARAMS.put("randomTypeCfgId", String.valueOf(sOrigDrawCarnivalBigAwardCfg.randomTypeCfgId));
/* 656 */     GS_LOG_PARAMS.put("nextBigAwardDrawCount", String.valueOf(nextBigAwardDrawCount));
/* 657 */     gsLog("draw_carnival", "DrawCarnivalManager", "handleBigAward", "big award info", GS_LOG_PARAMS, 0);
/*     */     
/*     */ 
/* 660 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean handleChestAward(long roleId, SOrigDrawCarnivalSpreadWealthCfg sOrigDrawCarnivalSpreadWealthCfg, DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, DrawCarnivalActivityInfo xDrawCarnivalActivityInfo, List<AwardPoolResultData> awardPoolResultDataList, AwardPoolResultData awardPoolResultData, DrawAwardInfo drawAwardInfo, Map<String, String> GS_LOG_PARAMS)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 681 */     SBroadcastChestAwardInfo sBroadcastChestAwardInfo = new SBroadcastChestAwardInfo();
/* 682 */     sBroadcastChestAwardInfo.orig_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/*     */     
/*     */ 
/* 685 */     int yuanBaoCountToCut = (int)Math.floor(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() * (sOrigDrawCarnivalSpreadWealthCfg.reduceAwardPoolYuanBaoRate / 10000.0D));
/*     */     
/*     */ 
/* 688 */     xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() - yuanBaoCountToCut);
/*     */     
/*     */ 
/*     */ 
/* 692 */     int chestCount = yuanBaoCountToCut * sOrigDrawCarnivalSpreadWealthCfg.moneyExchangeRate / sOrigDrawCarnivalSpreadWealthCfg.chestContainMoneyCount;
/*     */     
/*     */ 
/* 695 */     chestCount = chestCount < sOrigDrawCarnivalSpreadWealthCfg.chestCountMin ? sOrigDrawCarnivalSpreadWealthCfg.chestCountMin : chestCount;
/*     */     
/*     */     int xChestCount;
/*     */     
/*     */     int xChestCount;
/* 700 */     if (xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().containsKey(Integer.valueOf(awardPoolResultData.getTypeId())))
/*     */     {
/* 702 */       xChestCount = ((Integer)xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().get(Integer.valueOf(awardPoolResultData.getTypeId()))).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 706 */       xChestCount = 0;
/* 707 */       xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(awardPoolResultData.getTypeId()), Integer.valueOf(xChestCount));
/*     */     }
/* 709 */     int chestCountToAddByXdb = sOrigDrawCarnivalSpreadWealthCfg.chestCountMax - xChestCount;
/* 710 */     chestCount = chestCount > chestCountToAddByXdb ? chestCountToAddByXdb : chestCount;
/* 711 */     if (chestCount > 0)
/*     */     {
/* 713 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.drawcarnival.event.ChestAwardEvent(), new mzm.gsp.drawcarnival.event.ChestAwardEventArg(sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId, chestCount));
/*     */       
/*     */ 
/* 716 */       xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(awardPoolResultData.getTypeId()), Integer.valueOf(xChestCount + chestCount));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 721 */     sBroadcastChestAwardInfo.yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/* 722 */     sBroadcastChestAwardInfo.winner_info.role_id = roleId;
/* 723 */     sBroadcastChestAwardInfo.winner_info.role_name.setString(RoleInterface.getName(roleId), "utf-8");
/* 724 */     sBroadcastChestAwardInfo.winner_info.random_type_id = sOrigDrawCarnivalSpreadWealthCfg.randomTypeCfgId;
/* 725 */     sBroadcastChestAwardInfo.winner_info.award_count = chestCount;
/* 726 */     OnlineManager.getInstance().sendAll(sBroadcastChestAwardInfo);
/*     */     
/*     */ 
/* 729 */     if (!isBigAward(awardPoolResultData.getTypeId()))
/*     */     {
/* 731 */       awardPoolResultDataList.add(awardPoolResultData);
/*     */     }
/*     */     
/* 734 */     drawAwardInfo.item_type += 2;
/*     */     
/* 736 */     GS_LOG_PARAMS.put("yuanBaoCountToCut", String.valueOf(yuanBaoCountToCut));
/* 737 */     GS_LOG_PARAMS.put("awardPoolYuanBaoCount", String.valueOf(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count()));
/* 738 */     GS_LOG_PARAMS.put("chestCount", String.valueOf(chestCount));
/* 739 */     GS_LOG_PARAMS.put("randomTypeCfgId", String.valueOf(sOrigDrawCarnivalSpreadWealthCfg.randomTypeCfgId));
/* 740 */     GS_LOG_PARAMS.put("spreadWealthControllerId", String.valueOf(sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId));
/*     */     
/*     */ 
/* 743 */     gsLog("draw_carnival", "DrawCarnivalManager", "handleChestAward", "chest award info", GS_LOG_PARAMS, 0);
/*     */     
/*     */ 
/* 746 */     return true;
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
/*     */   static boolean handleOtherAward(List<AwardPoolResultData> awardPoolResultDataList, AwardPoolResultData awardPoolResultData, DrawAwardInfo drawAwardInfo, Map<String, String> GS_LOG_PARAMS)
/*     */   {
/* 763 */     awardPoolResultDataList.add(awardPoolResultData);
/* 764 */     drawAwardInfo.item_type += 4;
/* 765 */     GS_LOG_PARAMS.put("randomTypeCfgId", String.valueOf(awardPoolResultData.getTypeId()));
/*     */     
/* 767 */     gsLog("draw_carnival", "DrawCarnivalManager", "handleOtherAward", "other award info", GS_LOG_PARAMS, 0);
/*     */     
/*     */ 
/* 770 */     return true;
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
/*     */ 
/*     */ 
/*     */   static boolean fillRemoveTypeIdsFromCfg(String userId, long roleId, DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, DrawCarnivalActivityInfo xDrawCarnivalActivityInfo, DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo, List<Integer> removeTypeIds, Map<String, String> GS_LOG_PARAMS)
/*     */   {
/* 789 */     if (!fillRemoveTypeIdsByBigAward(userId, roleId, xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, xDrawCarnivalRoleActivityInfo, removeTypeIds))
/*     */     {
/*     */ 
/* 792 */       return false;
/*     */     }
/*     */     
/* 795 */     if (!fillRemoveTypeIdsByChestAward(xDrawCarnivalGlobalInfo, removeTypeIds))
/*     */     {
/* 797 */       return false;
/*     */     }
/*     */     
/* 800 */     GS_LOG_PARAMS.put("removeTypeIds", removeTypeIds.toString());
/* 801 */     gsLog("draw_carnival", "DrawCarnivalManager", "fillRemoveTypeIdsFromCfg", "removeTypeIds info", GS_LOG_PARAMS, 0);
/*     */     
/* 803 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean fillRemoveTypeIdsByBigAward(String userId, long roleId, DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, DrawCarnivalActivityInfo xDrawCarnivalActivityInfo, DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo, List<Integer> removeTypeIds)
/*     */   {
/* 813 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 815 */     long rolePointCountInActivity = MallInterface.getJifen(roleId, 17) - xDrawCarnivalRoleActivityInfo.getInit_point_count();
/*     */     
/*     */ 
/* 818 */     long saveAmt = QingfuInterface.getSaveAmt(userId, true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 825 */     for (Map.Entry<Integer, SOrigDrawCarnivalBigAwardCfg> entry : SOrigDrawCarnivalBigAwardCfg.getAll().entrySet())
/*     */     {
/* 827 */       int randomTypeId = ((Integer)entry.getKey()).intValue();
/* 828 */       SOrigDrawCarnivalBigAwardCfg sOrigDrawCarnivalBigAwardCfg = (SOrigDrawCarnivalBigAwardCfg)entry.getValue();
/*     */       
/* 830 */       if (xDrawCarnivalRoleActivityInfo.getGet_next_big_award_draw_count() > 0)
/*     */       {
/* 832 */         removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 837 */         SDrawCarnivalBigAwardCountMaxCfg sDrawCarnivalBigAwardCountMaxCfg = SDrawCarnivalBigAwardCountMaxCfg.get(sOrigDrawCarnivalBigAwardCfg.countTypeId);
/* 838 */         if (sDrawCarnivalBigAwardCountMaxCfg == null)
/*     */         {
/* 840 */           return false; }
/*     */         Map.Entry<Integer, Integer> drawYuanBaoAccumulateCount2bigAwardCountMaxEntry;
/*     */         Map.Entry<Integer, Integer> drawYuanBaoAccumulateCount2bigAwardCountMaxEntry;
/* 843 */         if (xDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count() > 2147483647L)
/*     */         {
/* 845 */           drawYuanBaoAccumulateCount2bigAwardCountMaxEntry = sDrawCarnivalBigAwardCountMaxCfg.drawYuanBaoAccumulateCount2bigAwardCountMax.lastEntry();
/*     */         }
/*     */         else
/*     */         {
/* 849 */           drawYuanBaoAccumulateCount2bigAwardCountMaxEntry = sDrawCarnivalBigAwardCountMaxCfg.drawYuanBaoAccumulateCount2bigAwardCountMax.ceilingEntry(Integer.valueOf((int)xDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count()));
/*     */           
/* 851 */           if (drawYuanBaoAccumulateCount2bigAwardCountMaxEntry == null)
/*     */           {
/* 853 */             drawYuanBaoAccumulateCount2bigAwardCountMaxEntry = sDrawCarnivalBigAwardCountMaxCfg.drawYuanBaoAccumulateCount2bigAwardCountMax.floorEntry(Integer.valueOf((int)xDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count()));
/*     */           }
/*     */         }
/*     */         
/* 857 */         if (drawYuanBaoAccumulateCount2bigAwardCountMaxEntry == null)
/*     */         {
/* 859 */           return false;
/*     */         }
/*     */         
/* 862 */         int bigAwardCountMax = ((Integer)drawYuanBaoAccumulateCount2bigAwardCountMaxEntry.getValue()).intValue();
/* 863 */         if (xDrawCarnivalActivityInfo.getBig_award_count() >= bigAwardCountMax)
/*     */         {
/* 865 */           removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */ 
/*     */ 
/*     */         }
/* 869 */         else if (sOrigDrawCarnivalBigAwardCfg.roleLevelMin > roleLevel)
/*     */         {
/* 871 */           removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */ 
/*     */         }
/* 874 */         else if (sOrigDrawCarnivalBigAwardCfg.rolePointCountMin > rolePointCountInActivity)
/*     */         {
/* 876 */           removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */ 
/*     */         }
/* 879 */         else if (sOrigDrawCarnivalBigAwardCfg.roleRechargeCountMin > saveAmt)
/*     */         {
/* 881 */           removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */ 
/*     */         }
/* 884 */         else if (sOrigDrawCarnivalBigAwardCfg.awardPoolYuanBaoCountMin > xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count())
/*     */         {
/* 886 */           removeTypeIds.add(Integer.valueOf(randomTypeId));
/*     */         }
/*     */       }
/*     */     }
/* 890 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean fillRemoveTypeIdsByChestAward(DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo, List<Integer> removeTypeIds)
/*     */   {
/* 898 */     for (Map.Entry<Integer, SOrigDrawCarnivalSpreadWealthCfg> entry : SOrigDrawCarnivalSpreadWealthCfg.getAll().entrySet())
/*     */     {
/* 900 */       int typeId = ((Integer)entry.getKey()).intValue();
/* 901 */       SOrigDrawCarnivalSpreadWealthCfg sOrigDrawCarnivalSpreadWealthCfg = (SOrigDrawCarnivalSpreadWealthCfg)entry.getValue();
/* 902 */       if (xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() < sOrigDrawCarnivalSpreadWealthCfg.awardPoolYuanBaoCountMin)
/*     */       {
/*     */ 
/* 905 */         removeTypeIds.add(Integer.valueOf(typeId));
/*     */       }
/*     */     }
/*     */     
/* 909 */     return true;
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
/*     */   static boolean doDelayAward(long roleId, List<AwardPoolResultData> awardPoolResultDataList, SDrawError sDrawError)
/*     */   {
/* 924 */     boolean ret = mzm.gsp.item.main.LotteryManager.addLottery(roleId, 15, 0, awardPoolResultDataList, new TLogArg(LogReason.DRAW_CARNIVAL__DRAW), SDrawCarnivalConsts.getInstance().DELAY_AWARD_SECONDS);
/*     */     
/* 926 */     if (!ret)
/*     */     {
/* 928 */       sDrawError.code = 4;
/* 929 */       OnlineManager.getInstance().sendAtOnce(roleId, sDrawError);
/* 930 */       return false;
/*     */     }
/* 932 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void gsLog(String moduleName, String className, String methodName, String logMessage, Map<String, String> params, int logLevel)
/*     */   {
/* 938 */     StringBuilder logContent = new StringBuilder(String.format("[%s]%s.%s@%s", new Object[] { moduleName, className, methodName, logMessage }));
/*     */     
/*     */ 
/* 941 */     for (Map.Entry<String, String> entry : params.entrySet())
/*     */     {
/* 943 */       logContent.append("|").append((String)entry.getKey()).append("=").append((String)entry.getValue());
/*     */     }
/* 945 */     if (logLevel == 0)
/*     */     {
/* 947 */       GameServer.logger().info(logContent.toString());
/* 948 */       return;
/*     */     }
/* 950 */     if (logLevel == 1)
/*     */     {
/* 952 */       GameServer.logger().warn(logContent.toString());
/* 953 */       return;
/*     */     }
/* 955 */     if (logLevel == 2)
/*     */     {
/* 957 */       GameServer.logger().error(logContent.toString());
/* 958 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static int getCurrentFreePassCount(long roleId, int passTypeId)
/*     */   {
/* 965 */     DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = getDrawCarnivalRoleInfoCreateIfNotExist(roleId);
/*     */     
/* 967 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = getCurrentDrawCarnivalRoleActivityInfoCreateIfNotExist(roleId, xDrawCarnivalRoleInfo);
/*     */     
/*     */ 
/*     */ 
/* 971 */     checkAndResetFreePasses(xDrawCarnivalRoleActivityInfo);
/*     */     
/* 973 */     return ((DrawCarnivalRoleFreePassInfo)xDrawCarnivalRoleActivityInfo.getFree_pass_type_id2info().get(Integer.valueOf(passTypeId))).getCount();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */