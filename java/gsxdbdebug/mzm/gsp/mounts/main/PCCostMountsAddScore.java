/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.mounts.SCostMountsAddScoreSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.MountsRankInfoBean;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifeLevelBean;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifePropertyBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsStarLifeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCostMountsAddScore extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long costMountsId;
/*     */   private final long addScoreMountsId;
/*     */   
/*     */   public PCCostMountsAddScore(long roleId, long costMounstId, long addScoreAddMountsId)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.costMountsId = costMounstId;
/*  41 */     this.addScoreMountsId = addScoreAddMountsId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCCostMountsAddScore.processImp"))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!MountsManager.isLevelOpen(this.roleId, "PCCostMountsAddScore.processImp"))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  58 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*  60 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1032, true, true))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  66 */     if (xRole2MountsInfo == null)
/*     */     {
/*  68 */       onCostMountsAddScoreFailed(2);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (this.costMountsId == this.addScoreMountsId)
/*     */     {
/*  74 */       onCostMountsAddScoreFailed(37);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     for (BattleMountsInfo xBattleMountsInfo : xRole2MountsInfo.getBattle_mounts_info_map().values())
/*     */     {
/*  80 */       long battleMountsId = xBattleMountsInfo.getMounts_id();
/*  81 */       if (battleMountsId == this.costMountsId)
/*     */       {
/*  83 */         onCostMountsAddScoreFailed(38);
/*  84 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  88 */     if (xRole2MountsInfo.getCurrent_ride_mounts_id() == this.costMountsId)
/*     */     {
/*  90 */       onCostMountsAddScoreFailed(39);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*  95 */     MountsInfo xCostMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.costMountsId));
/*  96 */     if (xCostMountsInfo == null)
/*     */     {
/*  98 */       onCostMountsAddScoreFailed(4);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     MountsInfo xAddScoreMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.addScoreMountsId));
/* 103 */     if (xAddScoreMountsInfo == null)
/*     */     {
/* 105 */       onCostMountsAddScoreFailed(4);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     int costMountsCfgId = xCostMountsInfo.getMounts_cfg_id();
/* 111 */     SMountsCfg sCostMountsCfg = SMountsCfg.get(costMountsCfgId);
/*     */     
/*     */ 
/* 114 */     int addScoreMountsCfgId = xAddScoreMountsInfo.getMounts_cfg_id();
/* 115 */     SMountsCfg sAddScoreMountsCfg = SMountsCfg.get(addScoreMountsCfgId);
/*     */     
/* 117 */     if ((sCostMountsCfg == null) || (sAddScoreMountsCfg == null))
/*     */     {
/* 119 */       onCostMountsAddScoreFailed(24);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     if ((sCostMountsCfg.mountsType == 6) || (sCostMountsCfg.mountsType == 6))
/*     */     {
/*     */ 
/* 126 */       onCostMountsAddScoreFailed(63);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if (sCostMountsCfg.mountsType != sAddScoreMountsCfg.mountsType)
/*     */     {
/* 132 */       onCostMountsAddScoreFailed(43);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     SMountsRankCfg sCostMountsRankCfg = SMountsRankCfg.get(costMountsCfgId);
/* 137 */     if (sCostMountsRankCfg == null)
/*     */     {
/* 139 */       onCostMountsAddScoreFailed(58);
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     int costMountsRank = xCostMountsInfo.getMounts_rank();
/* 144 */     MountsRankInfoBean costMountsRankInfoBean = (MountsRankInfoBean)sCostMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(costMountsRank));
/* 145 */     if (costMountsRankInfoBean == null)
/*     */     {
/* 147 */       onCostMountsAddScoreFailed(58);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     SMountsRankCfg sAddScoreMountsRankCfg = SMountsRankCfg.get(addScoreMountsCfgId);
/* 152 */     if (sAddScoreMountsRankCfg == null)
/*     */     {
/* 154 */       onCostMountsAddScoreFailed(59);
/* 155 */       return false;
/*     */     }
/* 157 */     int addScoreMountsRank = xAddScoreMountsInfo.getMounts_rank();
/* 158 */     MountsRankInfoBean addScoreMountsRankInfoBean = (MountsRankInfoBean)sAddScoreMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(addScoreMountsRank + 1));
/* 159 */     if (addScoreMountsRankInfoBean == null)
/*     */     {
/* 161 */       onCostMountsAddScoreFailed(59);
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     int nextRankScore = addScoreMountsRankInfoBean.rankUpNeedScoreNum;
/* 166 */     int currentScore = xAddScoreMountsInfo.getCurrent_score();
/* 167 */     if (currentScore >= nextRankScore)
/*     */     {
/*     */ 
/* 170 */       onCostMountsAddScoreFailed(60);
/* 171 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 175 */     int costMountsConvertScore = costMountsRankInfoBean.rankUpConvertScore;
/* 176 */     xAddScoreMountsInfo.setCurrent_score(currentScore + costMountsConvertScore);
/*     */     
/* 178 */     xMountsInfoMap.remove(Long.valueOf(this.costMountsId));
/*     */     
/* 180 */     if (!sendStarLifeCompensateMail(xCostMountsInfo))
/*     */     {
/* 182 */       onCostMountsAddScoreFailed(65);
/* 183 */       return false;
/*     */     }
/*     */     
/* 186 */     SCostMountsAddScoreSuccess sCostMountsAddScoreSuccess = new SCostMountsAddScoreSuccess();
/* 187 */     sCostMountsAddScoreSuccess.add_score_mounts_id = this.addScoreMountsId;
/* 188 */     sCostMountsAddScoreSuccess.cost_mounts_id = this.costMountsId;
/* 189 */     sCostMountsAddScoreSuccess.now_score = xAddScoreMountsInfo.getCurrent_score();
/*     */     
/* 191 */     OnlineManager.getInstance().send(this.roleId, sCostMountsAddScoreSuccess);
/*     */     
/* 193 */     MountsManager.tlogMountsCostMountsAddScore(userId, this.roleId, this.addScoreMountsId, addScoreMountsCfgId, addScoreMountsRank, this.costMountsId, costMountsCfgId, costMountsRank, costMountsConvertScore, xAddScoreMountsInfo.getCurrent_score());
/*     */     
/*     */ 
/*     */ 
/* 197 */     GameServer.logger().info(String.format("[mounts]PCCostMountsAddScore.processImp@handle cost mounts add score success|role_id=%d|cost_mounts_id=%d|add_score_mounts_id=%d|add_score=%d|now_score=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.costMountsId), Long.valueOf(this.addScoreMountsId), Integer.valueOf(costMountsConvertScore), Integer.valueOf(sCostMountsAddScoreSuccess.now_score) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 202 */     return true;
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
/*     */   private boolean sendStarLifeCompensateMail(MountsInfo xMountsInfo)
/*     */   {
/* 215 */     Map<Integer, Integer> costItemMap = new HashMap();
/*     */     
/* 217 */     int currentStarLifeLevel = xMountsInfo.getCurrent_mounts_star_level();
/* 218 */     int currentStarMaxNum = xMountsInfo.getCurrent_max_star_num();
/* 219 */     int maxStarNum; for (int starLevel = 1; starLevel <= currentStarLifeLevel; starLevel++)
/*     */     {
/* 221 */       SMountsStarLifeCfg sMountsStarLifeCfg = SMountsStarLifeCfg.get(xMountsInfo.getMounts_cfg_id());
/* 222 */       if (sMountsStarLifeCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 227 */         MountsStarLifeLevelBean mountsStarLevelBean = (MountsStarLifeLevelBean)sMountsStarLifeCfg.starLifeLevelMap.get(Integer.valueOf(starLevel));
/* 228 */         if (mountsStarLevelBean != null)
/*     */         {
/*     */ 
/*     */ 
/* 232 */           TreeMap<Integer, MountsStarLifePropertyBean> mountsStarNumBeanMap = mountsStarLevelBean.starNumMap;
/* 233 */           if (!mountsStarNumBeanMap.isEmpty())
/*     */           {
/*     */ 
/*     */ 
/* 237 */             maxStarNum = starLevel == currentStarLifeLevel ? currentStarMaxNum : ((Integer)mountsStarNumBeanMap.lastKey()).intValue();
/* 238 */             for (Map.Entry<Integer, MountsStarLifePropertyBean> entry : mountsStarNumBeanMap.entrySet())
/*     */             {
/* 240 */               MountsStarLifePropertyBean mountsStarLifePropertyBean = (MountsStarLifePropertyBean)entry.getValue();
/* 241 */               int costItemId = mountsStarLifePropertyBean.costItemId;
/* 242 */               int costItemNum = mountsStarLifePropertyBean.costItemNum;
/* 243 */               if (((Integer)entry.getKey()).intValue() > maxStarNum) {
/*     */                 break;
/*     */               }
/*     */               
/* 247 */               Integer oldValue = (Integer)costItemMap.get(Integer.valueOf(costItemId));
/* 248 */               if (oldValue != null)
/*     */               {
/* 250 */                 costItemMap.put(Integer.valueOf(costItemId), Integer.valueOf(oldValue.intValue() + costItemNum));
/*     */               }
/*     */               else
/*     */               {
/* 254 */                 costItemMap.put(Integer.valueOf(costItemId), Integer.valueOf(costItemNum)); }
/*     */             }
/*     */           }
/*     */         }
/*     */       } }
/* 259 */     MailAttachment mailAttachment = new MailAttachment();
/* 260 */     Map<Integer, Integer> realMailItemMap = new HashMap();
/* 261 */     for (Map.Entry<Integer, Integer> entry : costItemMap.entrySet())
/*     */     {
/*     */ 
/* 264 */       int realMailItemNum = ((Integer)entry.getValue()).intValue() * SMountsConsts.getInstance().rankUpMountsRestoreProb / 10000;
/* 265 */       if (realMailItemNum != 0)
/*     */       {
/*     */ 
/*     */ 
/* 269 */         realMailItemMap.put(entry.getKey(), Integer.valueOf(realMailItemNum));
/*     */       }
/*     */     }
/* 272 */     if (realMailItemMap.isEmpty())
/*     */     {
/* 274 */       GameServer.logger().info(String.format("[mounts]PCCostMountsAddScore.sendStarLifeCompensateMail@send mail item empty|role_id=%d|cost_mounts_id=%d|add_score_mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.costMountsId), Long.valueOf(this.addScoreMountsId) }));
/*     */       
/*     */ 
/*     */ 
/* 278 */       return true;
/*     */     }
/*     */     
/* 281 */     for (Map.Entry<Integer, Integer> entry : realMailItemMap.entrySet())
/*     */     {
/* 283 */       mailAttachment.addItem(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), true);
/*     */     }
/*     */     
/* 286 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleId, SMountsConsts.getInstance().rankUpMountsRestoreMailId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(mzm.gsp.tlog.LogReason.MOUNTS_RANK_UP_COMPENSATE_ITEM));
/*     */     
/*     */ 
/* 289 */     if (!sendMailRet.isOK())
/*     */     {
/* 291 */       GameServer.logger().error(String.format("[mounts]PCCostMountsAddScore.sendStarLifeCompensateMail@send mail failed|role_id=%d|cost_mounts_id=%d|add_score_mounts_id=%d|ret=%d|ret_msg=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.costMountsId), Long.valueOf(this.addScoreMountsId), Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 296 */       return false;
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   private void onCostMountsAddScoreFailed(int ret)
/*     */   {
/* 303 */     GameServer.logger().error(String.format("[mounts]PCCostMountsAddScore.processImp@cost mounst id failed|ret=%d|role_id=%d|cost_mounts_id=%d|add_score_mounts_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.costMountsId), Long.valueOf(this.addScoreMountsId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 308 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 309 */     sMountsNormalFail.result = ret;
/*     */     
/* 311 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCCostMountsAddScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */