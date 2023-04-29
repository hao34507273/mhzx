/*     */ package mzm.gsp.floor.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.FloorCfg;
/*     */ import mzm.gsp.activity3.confbean.SFloorActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.STFloorRuleCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.floor.SSweepFloorSuc;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GlobalFloorActivityInfo;
/*     */ import xbean.GlobalFloorInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFloorActivityInfo;
/*     */ import xbean.RoleFloorInfo;
/*     */ import xbean.RoleSingleFloorInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Globalfloor;
/*     */ import xtable.Role2flooractivity;
/*     */ 
/*     */ public class PCSweepFloor extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final int startFloor;
/*     */   private final int endFloor;
/*     */   private final long yuanBao;
/*     */   private final boolean useYuanbao;
/*     */   private final long clientNeedYuanbao;
/*     */   private String userId;
/*  53 */   private Map<Integer, SweepFloorInfo> floor2SweepInfo = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*  57 */   private int needItemNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   private int sweepItemId;
/*     */   
/*     */ 
/*     */ 
/*  65 */   private List<Integer> awardIds = new ArrayList();
/*     */   
/*     */ 
/*     */   public PCSweepFloor(long roleId, int activityId, int startFloor, int endFloor, long yuanbao, boolean useYuanBao, long clientNeedYuanbao)
/*     */   {
/*  70 */     this.roleId = roleId;
/*  71 */     this.activityId = activityId;
/*  72 */     this.yuanBao = yuanbao;
/*  73 */     this.useYuanbao = useYuanBao;
/*  74 */     this.startFloor = startFloor;
/*  75 */     this.endFloor = endFloor;
/*  76 */     this.clientNeedYuanbao = clientNeedYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  82 */     SFloorActivityCfg sFloorActivityCfg = SFloorActivityCfg.get(this.activityId);
/*  83 */     if (!isSwithOpened(sFloorActivityCfg))
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     this.sweepItemId = sFloorActivityCfg.sweepCostItemId;
/*     */     
/*     */ 
/*  91 */     if (!checkAndInitFloorData(this.roleId, this.startFloor, this.endFloor, this.activityId))
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ checkAndInitFloorData error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     if (this.floor2SweepInfo.size() == 0)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     this.userId = RoleInterface.getUserId(this.roleId);
/*     */     
/* 106 */     Lockeys.lock(xtable.User.getTable(), Arrays.asList(new String[] { this.userId }));
/*     */     
/* 108 */     Lockeys.lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/* 110 */     GlobalFloorActivityInfo xGlobalFloorActivityInfo = Globalfloor.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 111 */     if (xGlobalFloorActivityInfo == null)
/*     */     {
/* 113 */       Globalfloor.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalFloorActivityInfo = Pod.newGlobalFloorActivityInfo());
/*     */     }
/*     */     
/* 116 */     GlobalFloorInfo xGlobalFloorInfo = (GlobalFloorInfo)xGlobalFloorActivityInfo.getActivityinfo().get(Integer.valueOf(this.activityId));
/* 117 */     if (xGlobalFloorInfo == null)
/*     */     {
/* 119 */       xGlobalFloorActivityInfo.getActivityinfo().put(Integer.valueOf(this.activityId), xGlobalFloorInfo = Pod.newGlobalFloorInfo());
/*     */     }
/* 121 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(this.roleId));
/* 122 */     if (xRoleActivityInfo == null)
/*     */     {
/*     */ 
/* 125 */       return false;
/*     */     }
/* 127 */     RoleFloorInfo xFloorInfo = (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(this.activityId));
/* 128 */     if (xFloorInfo == null)
/*     */     {
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1381, true))
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not join activity!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(this.userId, this.roleId, this.activityId);
/* 144 */     if (!res.isCanJoin())
/*     */     {
/* 146 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not join activity!|roleId=%d|activityId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (!kickOutFinishedFloors(xFloorInfo))
/*     */     {
/* 155 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not join activity!|roleId=%d|activityId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 159 */       return false;
/*     */     }
/* 161 */     if (!doSweep(xFloorInfo))
/*     */     {
/*     */ 
/* 164 */       return false;
/*     */     }
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isSwithOpened(SFloorActivityCfg sFloorActivityCfg)
/*     */   {
/* 171 */     if (sFloorActivityCfg == null)
/*     */     {
/* 173 */       return false;
/*     */     }
/* 175 */     if (!sFloorActivityCfg.canSweep)
/*     */     {
/*     */ 
/* 178 */       return false;
/*     */     }
/* 180 */     if (!OpenInterface.getOpenStatus(sFloorActivityCfg.activityOpenId))
/*     */     {
/* 182 */       return false;
/*     */     }
/* 184 */     if (!OpenInterface.getOpenStatus(sFloorActivityCfg.sweepSwithId))
/*     */     {
/* 186 */       return false;
/*     */     }
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doSweep(RoleFloorInfo xFloorInfo)
/*     */   {
/* 193 */     if (!payPrice())
/*     */     {
/*     */ 
/* 196 */       return false;
/*     */     }
/* 198 */     if (!sweepAndAward(this.userId, xFloorInfo))
/*     */     {
/*     */ 
/* 201 */       return false;
/*     */     }
/* 203 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean kickOutFinishedFloors(RoleFloorInfo xFloorInfo)
/*     */   {
/* 214 */     Iterator<Map.Entry<Integer, SweepFloorInfo>> it = this.floor2SweepInfo.entrySet().iterator();
/* 215 */     while (it.hasNext())
/*     */     {
/* 217 */       Map.Entry<Integer, SweepFloorInfo> entry = (Map.Entry)it.next();
/* 218 */       int floor = ((Integer)entry.getKey()).intValue();
/*     */       
/* 220 */       if (xFloorInfo.getFloor2info().containsKey(Integer.valueOf(floor)))
/*     */       {
/*     */ 
/* 223 */         it.remove();
/*     */       }
/*     */       else {
/* 226 */         if (!xFloorInfo.getHistoryfloors().contains(Integer.valueOf(floor)))
/*     */         {
/*     */ 
/* 229 */           GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.kickOutFinishedFloor@ never finish this floor!|roleId=%d|activityId=%d|floor=%d|historyFloors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(floor), xFloorInfo.getHistoryfloors() }));
/*     */           
/*     */ 
/*     */ 
/* 233 */           return false;
/*     */         }
/*     */         
/* 236 */         this.awardIds.add(Integer.valueOf(((SweepFloorInfo)entry.getValue()).getAwardId()));
/*     */         
/* 238 */         this.needItemNum += ((SweepFloorInfo)entry.getValue()).getNeedItemNum();
/*     */       } }
/* 240 */     if (this.floor2SweepInfo.size() == 0)
/*     */     {
/*     */ 
/* 243 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.kickOutFinishedFloor@ finished all floors!|roleId=%d|activityId=%d|startFloor=%d|endFloor=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.startFloor), Integer.valueOf(this.endFloor) }));
/*     */       
/*     */ 
/*     */ 
/* 247 */       return false;
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean sweepAndAward(String userId, RoleFloorInfo xFloorInfo)
/*     */   {
/* 255 */     for (Iterator i$ = this.floor2SweepInfo.keySet().iterator(); i$.hasNext();) { int floor = ((Integer)i$.next()).intValue();
/*     */       
/* 257 */       RoleSingleFloorInfo xRoleSingleFloorInfo = (RoleSingleFloorInfo)xFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 258 */       if (xRoleSingleFloorInfo != null)
/*     */       {
/* 260 */         return false;
/*     */       }
/* 262 */       xFloorInfo.getFloor2info().put(Integer.valueOf(floor), xRoleSingleFloorInfo = Pod.newRoleSingleFloorInfo());
/*     */     }
/*     */     
/* 265 */     AwardReason awardReason = new AwardReason(LogReason.WIN_FLOOR_AWARD, this.activityId);
/* 266 */     AwardModel awardModel = AwardInterface.award(this.awardIds, null, userId, this.roleId, false, false, awardReason);
/* 267 */     if (awardModel == null)
/*     */     {
/* 269 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.doAward@ do sweep award error!|roleId=%d|activityId=%d|startFloor=%d|endFloor=%s|awardIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.startFloor), Integer.valueOf(this.endFloor), this.awardIds }));
/*     */       
/*     */ 
/*     */ 
/* 273 */       return false;
/*     */     }
/*     */     
/* 276 */     FloorManager.tlogSweepFloorActivity(userId, this.roleId, this.activityId, this.floor2SweepInfo.keySet(), FloorManager.getFinishFloors(xFloorInfo));
/*     */     
/*     */ 
/*     */ 
/* 280 */     sweepSucNotice(awardModel);
/*     */     
/* 282 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sweepSucNotice(AwardModel awardModel)
/*     */   {
/* 290 */     SSweepFloorSuc suc = new SSweepFloorSuc();
/* 291 */     suc.activityid = this.activityId;
/* 292 */     suc.floors.addAll(this.floor2SweepInfo.keySet());
/* 293 */     AwardInterface.fillAwardBean(suc.awardbean, awardModel);
/* 294 */     OnlineManager.getInstance().send(this.roleId, suc);
/*     */   }
/*     */   
/*     */   private boolean payPrice()
/*     */   {
/* 299 */     if (this.needItemNum < 0)
/*     */     {
/* 301 */       return false;
/*     */     }
/* 303 */     if (this.needItemNum == 0)
/*     */     {
/* 305 */       return true;
/*     */     }
/* 307 */     int ownNum = ItemInterface.getItemNumberById(this.roleId, this.sweepItemId);
/* 308 */     if (ownNum >= this.needItemNum)
/*     */     {
/* 310 */       return onlyPayItem(this.roleId, this.sweepItemId, this.needItemNum, new TLogArg(LogReason.SWEEP_FLOOR_COST, this.activityId));
/*     */     }
/* 312 */     if (!this.useYuanbao)
/*     */     {
/* 314 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.payPrice@ item num not enough!|roleId=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.needItemNum), Integer.valueOf(ownNum) }));
/*     */       
/*     */ 
/* 317 */       return false;
/*     */     }
/* 319 */     int needYuan = ItemInterface.getItemYuanBaoPrice(this.sweepItemId) * (this.needItemNum - ownNum);
/* 320 */     if (needYuan != this.clientNeedYuanbao)
/*     */     {
/* 322 */       FloorManager.sendFloorNotice(this.roleId, false, 2, new String[0]);
/* 323 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.payPrice@ client yuanbao num is error!|roleId=%d|needNum=%d|clientNeedYuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.needItemNum), Long.valueOf(this.clientNeedYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 327 */       return false;
/*     */     }
/* 329 */     if (!useYuanPay(this.userId, this.roleId, this.sweepItemId, this.needItemNum, ownNum, needYuan, this.yuanBao, CostType.COST_BIND_FIRST_SWEEP_FLOOR, new TLogArg(LogReason.SWEEP_FLOOR_COST, this.activityId)))
/*     */     {
/*     */ 
/* 332 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.payPrice@ use yuan pay error!|roleId=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.needItemNum), Integer.valueOf(ownNum) }));
/*     */       
/*     */ 
/* 335 */       return false;
/*     */     }
/* 337 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean onlyPayItem(long roleId, int item, int needNum, TLogArg tLogArg)
/*     */   {
/* 349 */     boolean ret = ItemInterface.removeItemById(roleId, 340600000, item, needNum, tLogArg);
/* 350 */     if (!ret)
/*     */     {
/* 352 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.onlyPayItem@ cut item error!|roleId=%d|itemId=%d|num=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(item), Integer.valueOf(needNum) }));
/*     */       
/*     */ 
/* 355 */       return false;
/*     */     }
/* 357 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   boolean useYuanPay(String userid, long roleId, int item, int needNum, int ownNum, int needYuanNum, long clientYuanbao, CostType costType, TLogArg tLogArg)
/*     */   {
/* 363 */     long ownYuan = QingfuInterface.getBalance(userid, false);
/* 364 */     if (ownYuan != clientYuanbao)
/*     */     {
/* 366 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.useYuanPay@ yuanbao not same!|roleId=%d||ownYuan=%d|clientYuan=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(ownYuan), Long.valueOf(clientYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 370 */       return false;
/*     */     }
/*     */     
/* 373 */     if (needYuanNum > 0)
/*     */     {
/* 375 */       CostResult cutYuanRes = QingfuInterface.costYuanbao(userid, roleId, needYuanNum, costType, tLogArg);
/* 376 */       if (cutYuanRes != CostResult.Success)
/*     */       {
/* 378 */         GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.useYuanPay@ cut yuanbao error!|roleId=%d|ownYuan=%d|needYuanNum=%d|res=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(ownYuan), Integer.valueOf(needYuanNum), Integer.valueOf(cutYuanRes.code) }));
/*     */         
/*     */ 
/*     */ 
/* 382 */         if (cutYuanRes == CostResult.BalanceNotEnough) {}
/*     */         
/*     */ 
/*     */ 
/* 386 */         return false;
/*     */       }
/*     */     }
/* 389 */     if (ownNum > 0)
/*     */     {
/* 391 */       boolean ret = ItemInterface.removeItemById(roleId, 340600000, item, ownNum, tLogArg);
/* 392 */       if (!ret)
/*     */       {
/* 394 */         GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.useYuanPay@ cut item error!|roleId=%d|itemId=%d|ownNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(item), Integer.valueOf(ownNum) }));
/*     */         
/*     */ 
/* 397 */         return false;
/*     */       }
/*     */     }
/* 400 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkAndInitFloorData(long roleId, int startFloor, int endFloor, int activityId)
/*     */   {
/* 405 */     STFloorRuleCfg stCfg = STFloorRuleCfg.get(activityId);
/* 406 */     if (stCfg == null)
/*     */     {
/* 408 */       return false;
/*     */     }
/* 410 */     if (!checkClientParamValid(startFloor, endFloor, stCfg))
/*     */     {
/* 412 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.checkAndInitFloorData@ client param invalid!|activityId=%d|roleId=%d|startFloor=%d|endFloor=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(startFloor), Integer.valueOf(endFloor) }));
/*     */       
/*     */ 
/*     */ 
/* 416 */       return false;
/*     */     }
/* 418 */     return canSweepAllFloorInCfg(roleId, startFloor, endFloor, activityId, stCfg);
/*     */   }
/*     */   
/*     */   private boolean canSweepAllFloorInCfg(long roleId, int startFloor, int endFloor, int activityId, STFloorRuleCfg stCfg)
/*     */   {
/* 423 */     int fightValue = RoleInterface.getFightValue(roleId);
/* 424 */     int level = RoleInterface.getLevel(roleId);
/*     */     
/* 426 */     for (int floor = startFloor; floor <= endFloor; floor++)
/*     */     {
/* 428 */       FloorCfg floorCfg = (FloorCfg)stCfg.floorCfgs.get(Integer.valueOf(floor));
/* 429 */       if (!canSweepThisFloorInCfg(roleId, fightValue, level, floor, floorCfg))
/*     */       {
/* 431 */         GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepAllFloorInCfg@ forbid sweep floor!|activityId=%d|roleId=%d|floor=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(floor) }));
/*     */         
/*     */ 
/*     */ 
/* 435 */         return false;
/*     */       }
/*     */       
/* 438 */       this.floor2SweepInfo.put(Integer.valueOf(floor), new SweepFloorInfo(floorCfg.awardId, floorCfg.sweepCostNum));
/*     */     }
/* 440 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canSweepThisFloorInCfg(long roleId, int fightValue, int level, int floor, FloorCfg floorCfg)
/*     */   {
/* 445 */     if (floorCfg == null)
/*     */     {
/*     */ 
/* 448 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepThisFloorInCfg@ floor cfg is null!|roleId=%d|floor=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(floor) }));
/*     */       
/*     */ 
/* 451 */       return false;
/*     */     }
/* 453 */     if (!floorCfg.canSweep)
/*     */     {
/*     */ 
/* 456 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepThisFloorInCfg@ floor can not sweep!|roleId=%d|floor=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(floor) }));
/*     */       
/*     */ 
/* 459 */       return false;
/*     */     }
/* 461 */     if (fightValue < floorCfg.sweepFightValue)
/*     */     {
/*     */ 
/* 464 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepThisFloorInCfg@ fight not enough!|roleId=%d|floor=%d|roleFightValue=%d|cfgFightValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(floor), Integer.valueOf(fightValue), Integer.valueOf(floorCfg.sweepFightValue) }));
/*     */       
/*     */ 
/*     */ 
/* 468 */       return false;
/*     */     }
/* 470 */     if (!OpenInterface.getOpenStatus(floorCfg.floorOpenId))
/*     */     {
/*     */ 
/* 473 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepThisFloorInCfg@ floor not open!|roleId=%d|floor=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(floor) }));
/*     */       
/*     */ 
/* 476 */       return false;
/*     */     }
/*     */     
/* 479 */     if (level < floorCfg.joinLevel)
/*     */     {
/*     */ 
/* 482 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.canSweepThisFloorInCfg@ fight not enough!|roleId=%d|floor=%d|roleLevel=%d|cfgLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(floor), Integer.valueOf(level), Integer.valueOf(floorCfg.joinLevel) }));
/*     */       
/*     */ 
/*     */ 
/* 486 */       return false;
/*     */     }
/* 488 */     return true;
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
/*     */   private boolean checkClientParamValid(int startFloor, int endFloor, STFloorRuleCfg stCfg)
/*     */   {
/* 501 */     if ((startFloor <= 0) || (startFloor > endFloor))
/*     */     {
/* 503 */       return false;
/*     */     }
/* 505 */     if (endFloor > stCfg.floorCfgs.size())
/*     */     {
/* 507 */       return false;
/*     */     }
/* 509 */     return true;
/*     */   }
/*     */   
/*     */   private final class SweepFloorInfo
/*     */   {
/*     */     private final int awardId;
/*     */     private final int needItemNum;
/*     */     
/*     */     public SweepFloorInfo(int awardId, int needItemNum)
/*     */     {
/* 519 */       this.awardId = awardId;
/* 520 */       this.needItemNum = needItemNum;
/*     */     }
/*     */     
/*     */     public int getAwardId()
/*     */     {
/* 525 */       return this.awardId;
/*     */     }
/*     */     
/*     */     public int getNeedItemNum()
/*     */     {
/* 530 */       return this.needItemNum;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PCSweepFloor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */