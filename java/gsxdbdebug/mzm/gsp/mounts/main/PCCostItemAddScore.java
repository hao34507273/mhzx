/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mounts.SCostItemAddScoreSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.MountsRankInfoBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsTypeChipCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsUnLockItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCCostItemAddScore
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long addScoreMountsId;
/*     */   private final int itemId;
/*     */   private final int itemType;
/*     */   private final int isUseAll;
/*     */   private int mountsCfgId;
/*     */   
/*     */   public PCCostItemAddScore(long roleId, long addScoreMountsId, int itemId, int itemType, int isUseAll)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.addScoreMountsId = addScoreMountsId;
/*  45 */     this.itemType = itemType;
/*  46 */     this.itemId = itemId;
/*  47 */     this.isUseAll = isUseAll;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if ((this.itemId <= 0) || ((this.itemType != 0) && (this.itemType != 1)) || ((this.isUseAll != 1) && (this.isUseAll != 0)))
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCCostItemAddScore.processImp"))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!MountsManager.isLevelOpen(this.roleId, "PCCostItemAddScore.processImp"))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     String userId = RoleInterface.getUserId(this.roleId);
/*  71 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  73 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1031, true, true))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  79 */     if (xRole2MountsInfo == null)
/*     */     {
/*  81 */       onCostItemAddScoreFail(2);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.addScoreMountsId));
/*  86 */     if (xMountsInfo == null)
/*     */     {
/*  88 */       onCostItemAddScoreFail(4);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     int mountsRank = xMountsInfo.getMounts_rank();
/*  93 */     if (mountsRank >= SMountsConsts.getInstance().maxMountsRank)
/*     */     {
/*  95 */       Map<String, Object> extraMap = new HashMap();
/*  96 */       extraMap.put("mounts_rank", Integer.valueOf(mountsRank));
/*  97 */       extraMap.put("max_mounts_rank", Integer.valueOf(SMountsConsts.getInstance().maxMountsRank));
/*     */       
/*  99 */       onCostItemAddScoreFail(24, extraMap);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     this.mountsCfgId = xMountsInfo.getMounts_cfg_id();
/* 104 */     SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(this.mountsCfgId);
/* 105 */     if (sMountsRankCfg == null)
/*     */     {
/* 107 */       onCostItemAddScoreFail(24);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     SMountsCfg sMountsCfg = SMountsCfg.get(this.mountsCfgId);
/* 112 */     if (sMountsCfg == null)
/*     */     {
/* 114 */       onCostItemAddScoreFail(24);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (sMountsCfg.mountsType == 6)
/*     */     {
/* 120 */       onCostItemAddScoreFail(63);
/* 121 */       return false;
/*     */     }
/* 123 */     MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(mountsRank + 1));
/* 124 */     if (mountsRankInfoBean == null)
/*     */     {
/* 126 */       Map<String, Object> extraMap = new HashMap();
/* 127 */       extraMap.put("next_rank", Integer.valueOf(mountsRank + 1));
/*     */       
/* 129 */       onCostItemAddScoreFail(24, extraMap);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     int currentScore = xMountsInfo.getCurrent_score();
/* 134 */     int nextRankNeedScore = mountsRankInfoBean.rankUpNeedScoreNum;
/* 135 */     if (currentScore >= nextRankNeedScore)
/*     */     {
/* 137 */       Map<String, Object> extraMap = new HashMap();
/* 138 */       extraMap.put("current_score", Integer.valueOf(currentScore));
/* 139 */       extraMap.put("next_rank_need_score", Integer.valueOf(nextRankNeedScore));
/*     */       
/* 141 */       onCostItemAddScoreFail(60, extraMap);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     int itemConvertScore = 0;
/* 146 */     int mountsType = sMountsCfg.mountsType;
/* 147 */     if (this.itemType == 0)
/*     */     {
/* 149 */       SMountsTypeChipCfg sMountsTypeChipCfg = SMountsTypeChipCfg.get(mountsType);
/* 150 */       if (sMountsTypeChipCfg == null)
/*     */       {
/* 152 */         onCostItemAddScoreFail(43);
/* 153 */         return false;
/*     */       }
/*     */       
/* 156 */       Integer tmpScore = (Integer)sMountsTypeChipCfg.chipItemId2score.get(Integer.valueOf(this.itemId));
/* 157 */       if (tmpScore == null)
/*     */       {
/* 159 */         onCostItemAddScoreFail(62);
/* 160 */         return false;
/*     */       }
/* 162 */       itemConvertScore = tmpScore.intValue();
/*     */     }
/*     */     else
/*     */     {
/* 166 */       SMountsUnLockItemCfg sMountsUnLockItemCfg = SMountsUnLockItemCfg.get(this.itemId);
/* 167 */       if (sMountsUnLockItemCfg == null)
/*     */       {
/* 169 */         onCostItemAddScoreFail(62);
/* 170 */         return false;
/*     */       }
/*     */       
/* 173 */       if (sMountsUnLockItemCfg.mountsType != mountsType)
/*     */       {
/* 175 */         onCostItemAddScoreFail(43);
/* 176 */         return false;
/*     */       }
/*     */       
/* 179 */       itemConvertScore = sMountsUnLockItemCfg.addScore;
/*     */     }
/*     */     
/* 182 */     int removeItemNum = 0;
/* 183 */     if (this.isUseAll == 0)
/*     */     {
/* 185 */       removeItemNum = 1;
/*     */     }
/*     */     else
/*     */     {
/* 189 */       int needItemNum = (nextRankNeedScore - currentScore - 1) / itemConvertScore + 1;
/* 190 */       int itemHasNum = ItemInterface.getItemNumberById(this.roleId, this.itemId);
/* 191 */       removeItemNum = itemHasNum > needItemNum ? needItemNum : itemHasNum;
/*     */     }
/*     */     
/* 194 */     boolean removeResult = ItemInterface.removeItemById(this.roleId, this.itemId, removeItemNum, new TLogArg(LogReason.MOUNTS_ADD_SCORE_COST_ITEM));
/*     */     
/* 196 */     if (!removeResult)
/*     */     {
/* 198 */       onCostItemAddScoreFail(20);
/* 199 */       return false;
/*     */     }
/* 201 */     int addScore = itemConvertScore * removeItemNum;
/*     */     
/* 203 */     xMountsInfo.setCurrent_score(addScore + currentScore);
/*     */     
/* 205 */     SCostItemAddScoreSuccess sCostItemAddScoreSuccess = new SCostItemAddScoreSuccess();
/* 206 */     sCostItemAddScoreSuccess.add_score_mounts_id = this.addScoreMountsId;
/* 207 */     sCostItemAddScoreSuccess.now_score = xMountsInfo.getCurrent_score();
/*     */     
/* 209 */     OnlineManager.getInstance().send(this.roleId, sCostItemAddScoreSuccess);
/*     */     
/* 211 */     MountsManager.tlogMountsCostItemAddScore(userId, this.roleId, this.addScoreMountsId, this.mountsCfgId, mountsRank, this.itemId, removeItemNum, addScore, xMountsInfo.getCurrent_score());
/*     */     
/*     */ 
/* 214 */     GameServer.logger().info(String.format("[mounts]PCCostItemAddScore.processImp@cost item add score success|role_id=%d|add_score_mounts_id=%d|is_use_all=%d|remove_item_num=%d|add_score=%d|now_score=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.addScoreMountsId), Integer.valueOf(this.isUseAll), Integer.valueOf(removeItemNum), Integer.valueOf(addScore), Integer.valueOf(xMountsInfo.getCurrent_score()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onCostItemAddScoreFail(int ret)
/*     */   {
/* 230 */     onCostItemAddScoreFail(ret, null);
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
/*     */   private void onCostItemAddScoreFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 243 */     StringBuilder sbLog = new StringBuilder();
/* 244 */     sbLog.append("[mounts]PCCostItemAddScore.processImp@cost item add score failed");
/* 245 */     sbLog.append("|ret=").append(ret);
/* 246 */     sbLog.append("|role_id=").append(this.roleId);
/* 247 */     sbLog.append("|add_score_mounts_id=").append(this.addScoreMountsId);
/* 248 */     sbLog.append("|mounts_cfg_id=").append(this.mountsCfgId);
/* 249 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 251 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 253 */         sbLog.append('|').append((String)entry.getKey()).append('|').append(entry.getValue());
/*     */       }
/*     */     }
/* 256 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 258 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 259 */     sMountsNormalFail.result = ret;
/*     */     
/* 261 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCCostItemAddScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */