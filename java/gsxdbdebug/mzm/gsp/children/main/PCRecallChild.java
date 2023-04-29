/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SRecallChildSuccess;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenRecallCostCfg;
/*     */ import mzm.gsp.children.event.AddChildIntoHome;
/*     */ import mzm.gsp.children.event.ChildAddHomeReason;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2children;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRecallChild extends LogicProcedure
/*     */ {
/*     */   private final long childId;
/*     */   private final long roleId;
/*     */   private final long clientCurrencyNum;
/*     */   
/*     */   public PCRecallChild(long childId, long roleId, long clientCurrencyNum)
/*     */   {
/*  50 */     this.childId = childId;
/*  51 */     this.roleId = roleId;
/*  52 */     this.clientCurrencyNum = clientCurrencyNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  58 */     if (!isChildrenRecallSwitchOpen(this.roleId))
/*     */     {
/*  60 */       onFail(80);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleId, false);
/*  66 */     if (homeInfoWrapper == null)
/*     */     {
/*  68 */       onFail(10);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int maidNpcId = HomelandInterface.getMaidNpc(homeInfoWrapper);
/*     */     
/*  74 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().recall_child_npc_service, maidNpcId, new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*  77 */       onFail(78);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     String userId = RoleInterface.getUserId(this.roleId);
/*  82 */     if (userId == null)
/*     */     {
/*  84 */       onFail(55);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     long marriedId = MarriageInterface.getMarriedId(this.roleId, false);
/*     */     
/*  90 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  91 */     if (marriedRoleId > 0L)
/*     */     {
/*  93 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  94 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  95 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  99 */       lock(Lockeys.get(User.getTable(), userId));
/* 100 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/* 103 */     if (marriedId > 0L)
/*     */     {
/* 105 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriedId)));
/*     */     }
/*     */     
/* 108 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/* 109 */     if (xRole2ChildrenInfo == null)
/*     */     {
/* 111 */       onFail(4);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int periodRecallTimes = ChildrenManager.getAndRefreshPeriodRecallTimes(xRole2ChildrenInfo);
/* 116 */     if (periodRecallTimes >= SChildrenConsts.getInstance().period_recall_times_limit)
/*     */     {
/* 118 */       onFail(81);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 848, true, true))
/*     */     {
/* 124 */       onFail(71);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/* 129 */     if (xChildInfo == null)
/*     */     {
/* 131 */       onFail(2);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     if (!xChildInfo.getIs_discard())
/*     */     {
/* 137 */       onFail(79);
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     if (xChildInfo.getOwn_role_id() != this.roleId)
/*     */     {
/* 143 */       onFail(1);
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     SChildrenRecallCostCfg sChildrenRecallCostCfg = SChildrenRecallCostCfg.get(xChildInfo.getChild_period());
/* 148 */     if (sChildrenRecallCostCfg == null)
/*     */     {
/* 150 */       onFail(73);
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     long serverClientNum = -1L;
/* 155 */     if (sChildrenRecallCostCfg.cost_currency_type == 1)
/*     */     {
/* 157 */       serverClientNum = QingfuInterface.getBalance(userId, true);
/*     */     }
/* 159 */     else if (sChildrenRecallCostCfg.cost_currency_type == 2)
/*     */     {
/* 161 */       serverClientNum = RoleInterface.getGold(this.roleId);
/*     */     }
/*     */     else
/*     */     {
/* 165 */       onFail(77);
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     if (serverClientNum != this.clientCurrencyNum)
/*     */     {
/* 171 */       onFail(76);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     if (serverClientNum < sChildrenRecallCostCfg.cost_currency_num)
/*     */     {
/* 177 */       onFail(74);
/* 178 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 182 */     int ownChildSize = ChildrenManager.getOwnChildSize(this.roleId, true);
/*     */     
/*     */ 
/* 185 */     int realCheckChildSize = ownChildSize;
/* 186 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(this.roleId, true);
/* 187 */     if ((breedInfo != null) && (breedInfo.belongRoleId == this.roleId))
/*     */     {
/* 189 */       realCheckChildSize++;
/*     */     }
/*     */     
/* 192 */     if (realCheckChildSize >= SChildrenConsts.getInstance().max_children_can_carrey)
/*     */     {
/* 194 */       Map<String, Object> extraMap = new HashMap();
/* 195 */       extraMap.put("real_own_child_size", Integer.valueOf(realCheckChildSize));
/* 196 */       if (breedInfo != null)
/*     */       {
/* 198 */         extraMap.put("breed_info_belong_role_id", Long.valueOf(breedInfo.belongRoleId));
/* 199 */         extraMap.put("breed_info_breed_state", Integer.valueOf(breedInfo.breed_state));
/*     */       }
/*     */       
/* 202 */       onFail(59, extraMap);
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     if (sChildrenRecallCostCfg.cost_currency_type == 1)
/*     */     {
/* 208 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, sChildrenRecallCostCfg.cost_currency_num, mzm.gsp.qingfu.main.CostType.CHILDREN_RECALL, new TLogArg(LogReason.CHILDREN_RECALL_COST_YUAN_BAO));
/*     */       
/*     */ 
/* 211 */       if (costResult != CostResult.Success)
/*     */       {
/* 213 */         onFail(75);
/* 214 */         return false;
/*     */       }
/*     */     }
/* 217 */     else if (sChildrenRecallCostCfg.cost_currency_type == 2)
/*     */     {
/* 219 */       boolean costResult = RoleInterface.cutGold(this.roleId, sChildrenRecallCostCfg.cost_currency_num, new TLogArg(LogReason.CHILDREN_RECALL_COST_GOLD));
/*     */       
/* 221 */       if (!costResult)
/*     */       {
/* 223 */         onFail(75);
/* 224 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 229 */       onFail(77);
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     xChildInfo.setIs_discard(false);
/* 234 */     xChildInfo.setDiscard_time(0L);
/* 235 */     xChildInfo.setHome_state(1);
/*     */     
/* 237 */     xChildInfo.setAnother_parent_role_id(marriedRoleId);
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
/* 261 */     if (xChildInfo.getChild_period() == 0)
/*     */     {
/* 263 */       BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/* 264 */       xBabyPeriodInfo.setHealth_refresh_time(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     
/* 267 */     xRole2ChildrenInfo.setPeriod_recall_times(xRole2ChildrenInfo.getPeriod_recall_times() + 1);
/* 268 */     xRole2ChildrenInfo.setTotal_discard_child_num(xRole2ChildrenInfo.getTotal_discard_child_num() - 1);
/* 269 */     SRecallChildSuccess sRecallChildSuccess = new SRecallChildSuccess();
/* 270 */     sRecallChildSuccess.child_id = this.childId;
/* 271 */     sRecallChildSuccess.left_recall_times = (SChildrenConsts.getInstance().period_recall_times_limit - xRole2ChildrenInfo.getPeriod_recall_times());
/*     */     
/*     */ 
/* 274 */     OnlineManager.getInstance().send(this.roleId, sRecallChildSuccess);
/*     */     
/* 276 */     if (marriedRoleId > 0L)
/*     */     {
/* 278 */       OnlineManager.getInstance().send(marriedRoleId, sRecallChildSuccess);
/*     */     }
/*     */     
/* 281 */     ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), new mzm.gsp.children.event.AddChildIntoHomeArg(this.roleId, this.childId, HomelandInterface.getCurrentHomeMapId(this.roleId), ChildAddHomeReason.GIVE_BIRTH));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 286 */     ChildrenManager.triggerChildRatingChange(this.roleId, this.childId, false);
/*     */     
/* 288 */     tlogRecallChild(userId, this.roleId, marriedRoleId, this.childId);
/*     */     
/* 290 */     StringBuilder sBuilder = new StringBuilder();
/* 291 */     sBuilder.append("[children]PCRecallChild.processImp@recall child success");
/* 292 */     sBuilder.append("|child_id=").append(this.childId);
/* 293 */     sBuilder.append("|role_id=").append(this.roleId);
/* 294 */     sBuilder.append("|client_currency_num=").append(this.clientCurrencyNum);
/*     */     
/* 296 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 303 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 308 */     StringBuilder sBuilder = new StringBuilder();
/* 309 */     sBuilder.append("[children]PCRecallChild.processImp@recall child failed");
/* 310 */     sBuilder.append("|ret=").append(ret);
/* 311 */     sBuilder.append("|child_id=").append(this.childId);
/* 312 */     sBuilder.append("|role_id=").append(this.roleId);
/* 313 */     sBuilder.append("|client_currency_num=").append(this.clientCurrencyNum);
/*     */     
/* 315 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 317 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 319 */         sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 322 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 324 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 325 */     sChildNormalFail.result = ret;
/*     */     
/* 327 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */   
/*     */   private void tlogRecallChild(String userId, long roleId, long partnerRoleId, long childId)
/*     */   {
/* 332 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 334 */     StringBuilder sbLog = new StringBuilder();
/* 335 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 336 */     sbLog.append(userId).append('|');
/* 337 */     sbLog.append(roleId).append('|');
/* 338 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 340 */     sbLog.append(partnerRoleId).append('|');
/* 341 */     sbLog.append(childId);
/*     */     
/* 343 */     TLogManager.getInstance().addLog(roleId, "ChildRecallStatis", sbLog.toString());
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
/*     */   boolean isChildrenRecallSwitchOpen(long roleId)
/*     */   {
/* 356 */     if (!OpenInterface.getOpenStatus(575))
/*     */     {
/* 358 */       return false;
/*     */     }
/*     */     
/* 361 */     if (OpenInterface.isBanPlay(roleId, 575))
/*     */     {
/* 363 */       OpenInterface.sendBanPlayMsg(roleId, 575);
/* 364 */       return false;
/*     */     }
/* 366 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCRecallChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */