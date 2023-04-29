/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.SSignAwardErrorInfo;
/*     */ import mzm.gsp.signaward.SSignPreciousDrawLotterySuccess;
/*     */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*     */ import mzm.gsp.signprecious.confbean.LuckyGoldPerciousBean;
/*     */ import mzm.gsp.signprecious.confbean.SChessBoxAwardCfg;
/*     */ import mzm.gsp.signprecious.confbean.SChessBoxBuffAwardCfg;
/*     */ import mzm.gsp.signprecious.confbean.SSignPreciousConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Sign;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2sign;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSignPreciousOpenLuckyBox extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long clientYuanBao;
/*     */   
/*     */   public PCSignPreciousOpenLuckyBox(long roleId, long clientYuanBao)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.clientYuanBao = clientYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!SignAwardManager.isSignPreciousSwitchOpen(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  56 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 943, true, true))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     Sign xSign = Role2sign.get(Long.valueOf(this.roleId));
/*  66 */     if (xSign == null)
/*     */     {
/*  68 */       onSignPreciousOpenLuckyBoxFail(14);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  73 */     if (roleLevel < SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL)
/*     */     {
/*  75 */       onSignPreciousOpenLuckyBoxFail(4);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int xCurrentPreciousCellNum = xSign.getCurrent_precious_cell_num();
/*  80 */     SChessBoxAwardCfg sChessBoxAwardCfg = SChessBoxAwardCfg.get(xCurrentPreciousCellNum);
/*  81 */     if (sChessBoxAwardCfg == null)
/*     */     {
/*  83 */       Map<String, Object> extraMap = new HashMap();
/*  84 */       extraMap.put("cell_num", Integer.valueOf(xCurrentPreciousCellNum));
/*     */       
/*  86 */       onSignPreciousOpenLuckyBoxFail(14, extraMap);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     int xLuckyBoxGoldPreciousCfgId = xSign.getLucky_box_gold_precious_cfg_id();
/*  91 */     if (xLuckyBoxGoldPreciousCfgId <= 0)
/*     */     {
/*  93 */       onSignPreciousOpenLuckyBoxFail(16);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (xSign.getLucky_box_sign_box_buff_id() > 0)
/*     */     {
/*  99 */       onSignPreciousOpenLuckyBoxFail(32);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     LuckyGoldPerciousBean luckyGoldPerciousBean = null;
/* 104 */     for (LuckyGoldPerciousBean templuckyGoldPerciousBean : sChessBoxAwardCfg.lucky_gold_percious_random_map.values())
/*     */     {
/* 106 */       if (templuckyGoldPerciousBean.lucky_gold_precious_cfg_id == xLuckyBoxGoldPreciousCfgId)
/*     */       {
/* 108 */         luckyGoldPerciousBean = templuckyGoldPerciousBean;
/* 109 */         break;
/*     */       }
/*     */     }
/*     */     
/* 113 */     if (luckyGoldPerciousBean == null)
/*     */     {
/* 115 */       Map<String, Object> extraMap = new HashMap();
/* 116 */       extraMap.put("cell_num", Integer.valueOf(xCurrentPreciousCellNum));
/* 117 */       extraMap.put("lucky_box_draw_sign_lottery_cfg_id", Integer.valueOf(xLuckyBoxGoldPreciousCfgId));
/*     */       
/* 119 */       onSignPreciousOpenLuckyBoxFail(17, extraMap);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     int boxAwardType = luckyGoldPerciousBean.box_award_type;
/* 124 */     SChessBoxBuffAwardCfg sChessBoxBuffAwardCfg = SChessBoxBuffAwardCfg.get(boxAwardType);
/* 125 */     if (sChessBoxBuffAwardCfg == null)
/*     */     {
/* 127 */       Map<String, Object> extraMap = new HashMap();
/* 128 */       extraMap.put("cell_num", Integer.valueOf(xCurrentPreciousCellNum));
/* 129 */       extraMap.put("lucky_box_draw_sign_lottery_cfg_id", Integer.valueOf(xLuckyBoxGoldPreciousCfgId));
/* 130 */       extraMap.put("box_award_type", Integer.valueOf(boxAwardType));
/*     */       
/* 132 */       onSignPreciousOpenLuckyBoxFail(12, extraMap);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     long currentYuanBao = QingfuInterface.getBalance(userId, true);
/* 137 */     if (currentYuanBao != this.clientYuanBao)
/*     */     {
/* 139 */       Map<String, Object> extraMap = new HashMap();
/* 140 */       extraMap.put("client_yuan_bao", Long.valueOf(this.clientYuanBao));
/* 141 */       extraMap.put("current_yuan_bao", Long.valueOf(currentYuanBao));
/*     */       
/* 143 */       onSignPreciousOpenLuckyBoxFail(11, extraMap);
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     TreeMap<Integer, Integer> randomBuffMap = sChessBoxBuffAwardCfg.random_map;
/* 149 */     Map.Entry<Integer, Integer> randomBuffEntry = SignAwardManager.getRandomBuffEntry(this.roleId, randomBuffMap);
/* 150 */     if (randomBuffEntry == null)
/*     */     {
/* 152 */       onSignPreciousOpenLuckyBoxFail(13);
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     int costYuanBao = luckyGoldPerciousBean.cost_yuan_bao;
/* 157 */     if (currentYuanBao < costYuanBao)
/*     */     {
/* 159 */       Map<String, Object> extraMap = new HashMap();
/* 160 */       extraMap.put("cell_num", Integer.valueOf(xCurrentPreciousCellNum));
/* 161 */       extraMap.put("current_yuan_bao", Long.valueOf(currentYuanBao));
/* 162 */       extraMap.put("need_yuan_bao", Integer.valueOf(costYuanBao));
/*     */       
/* 164 */       onSignPreciousOpenLuckyBoxFail(18, extraMap);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, costYuanBao, CostType.COST_BIND_FIRST_SIGN_PRECIOUS_OPEN_CELL, new TLogArg(LogReason.SIGN_PRECIOUS_OPEN_LUCKY_BOX_COST_YUAN_BAO));
/*     */     
/*     */ 
/* 171 */     if (costResult != CostResult.Success)
/*     */     {
/* 173 */       Map<String, Object> extraMap = new HashMap();
/* 174 */       extraMap.put("code", Integer.valueOf(costResult.code));
/* 175 */       extraMap.put("des", costResult.desc);
/*     */       
/* 177 */       onSignPreciousOpenLuckyBoxFail(19, extraMap);
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     int luckyBuffCfgId = ((Integer)randomBuffEntry.getValue()).intValue();
/* 182 */     int lotteryViewId = xSign.getLucky_box_gold_precious_cfg_id();
/*     */     
/*     */ 
/* 185 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(this.roleId, lotteryViewId);
/*     */     
/* 187 */     if (awardPoolResultData == null)
/*     */     {
/* 189 */       onSignPreciousOpenLuckyBoxFail(26);
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     if (awardPoolResultData.getItemMap().isEmpty())
/*     */     {
/* 195 */       onSignPreciousOpenLuckyBoxFail(27);
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     boolean ret = LotteryManager.addLottery(this.roleId, 9, 0, awardPoolResultData, new TLogArg(LogReason.SIGN_PRECIOUS_DRAW_LOTTERY_AWARD_ITEM), SSignPreciousConsts.getInstance().draw_lottery_delay_award_seconds);
/*     */     
/*     */ 
/* 202 */     if (!ret)
/*     */     {
/* 204 */       onSignPreciousOpenLuckyBoxFail(28);
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     int itemId = ((Integer)awardPoolResultData.getItemMap().keySet().iterator().next()).intValue();
/* 209 */     int itemNum = ((Integer)awardPoolResultData.getItemMap().get(Integer.valueOf(itemId))).intValue();
/*     */     
/* 211 */     xSign.setLucky_box_sign_box_buff_id(luckyBuffCfgId);
/*     */     
/* 213 */     SSignPreciousDrawLotterySuccess signPreciousDrawLotterySuccess = new SSignPreciousDrawLotterySuccess();
/* 214 */     signPreciousDrawLotterySuccess.item_id = itemId;
/* 215 */     signPreciousDrawLotterySuccess.item_num = itemNum;
/* 216 */     signPreciousDrawLotterySuccess.lottery_view_id = lotteryViewId;
/* 217 */     signPreciousDrawLotterySuccess.final_index = (awardPoolResultData.getIndex() + 1);
/* 218 */     signPreciousDrawLotterySuccess.buff_id = luckyBuffCfgId;
/* 219 */     signPreciousDrawLotterySuccess.box_type = boxAwardType;
/*     */     
/* 221 */     OnlineManager.getInstance().send(this.roleId, signPreciousDrawLotterySuccess);
/*     */     
/* 223 */     addSignPreciousOpenLuckyBoxTlog(userId, this.roleId, roleLevel, boxAwardType);
/*     */     
/* 225 */     GameServer.logger().info(String.format("[sign]PCSignPreciousOpenLuckyBox.processImp@sign precious open lucky box success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addSignPreciousOpenLuckyBoxTlog(String userId, long roleId, int roleLevel, int boxAwardType)
/*     */   {
/* 235 */     StringBuilder sbLog = new StringBuilder();
/* 236 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 237 */     sbLog.append(userId).append('|');
/* 238 */     sbLog.append(roleId).append('|');
/* 239 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 241 */     sbLog.append(boxAwardType);
/*     */     
/* 243 */     TLogManager.getInstance().addLog(roleId, "YuanBaoOpenLuckyBox", sbLog.toString());
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
/*     */   private void onSignPreciousOpenLuckyBoxFail(int ret)
/*     */   {
/* 256 */     onSignPreciousOpenLuckyBoxFail(ret, null);
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
/*     */   private void onSignPreciousOpenLuckyBoxFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 269 */     StringBuilder sbLog = new StringBuilder();
/* 270 */     sbLog.append("[sign]PCSignPreciousOpenLuckyBox.processImp@open lucky precious box failed");
/* 271 */     sbLog.append("|ret=").append(ret);
/* 272 */     sbLog.append("|role_id=").append(this.roleId);
/* 273 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 275 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 277 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 280 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 282 */     SSignAwardErrorInfo sSignAwardErrorInfo = new SSignAwardErrorInfo();
/* 283 */     sSignAwardErrorInfo.rescode = ret;
/*     */     
/* 285 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sSignAwardErrorInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PCSignPreciousOpenLuckyBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */