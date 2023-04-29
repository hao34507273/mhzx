/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SReceiveShiTuActiveRewardRep;
/*     */ import mzm.gsp.shitu.ShiTuActiveInfo;
/*     */ import mzm.gsp.shitu.SynShiTuActiveInfo;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveAwardIndex2RewardCfg;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueConsts;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueRewardBean;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueRewardCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.AwardIndexIds;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.ShiTuActive;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReceiveShiTuActiveRewardReq extends LogicProcedure
/*     */ {
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   private final int awardIndexId;
/*     */   private final boolean isSelf;
/*     */   private int awardTypeId;
/*     */   private long checkTime;
/*     */   
/*     */   public PCReceiveShiTuActiveRewardReq(long masterRoleId, long apprenticeRoleId, int awardIndexId)
/*     */   {
/*  51 */     this.masterRoleId = masterRoleId;
/*  52 */     this.apprenticeRoleId = apprenticeRoleId;
/*  53 */     this.awardIndexId = awardIndexId;
/*  54 */     this.isSelf = (masterRoleId == apprenticeRoleId);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  60 */     if (!ShiTuManager.isShiTuActiveOpen(this.masterRoleId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/*  66 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  67 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*     */     {
/*  69 */       onFailed(9);
/*  70 */       return false;
/*     */     }
/*  72 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  75 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*  77 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1642, true, true))
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (ItemInterface.isBagFull(this.masterRoleId, 340600000, true))
/*     */     {
/*  84 */       onFailed(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  89 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  91 */       onFailed(8);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*     */     
/*     */ 
/*  98 */     if (this.isSelf)
/*     */     {
/* 100 */       if (ShiTuManager.getMasterId(xApprenticeShiTuInfo) <= 0L)
/*     */       {
/* 102 */         onFailed(10);
/* 103 */         return false;
/*     */       }
/* 105 */       this.awardTypeId = SShiTuActiveValueConsts.getInstance().APPRENTICE_REWARD_ID;
/* 106 */       ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeInfo.getTimeinfo();
/* 107 */       this.checkTime = xApprenticeTimeInfo.getStarttime();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 113 */       if (xApprenticeInfo.getMasterroleid() != this.masterRoleId)
/*     */       {
/* 115 */         onFailed(8);
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/* 120 */       if (xMasterShiTuInfo == null)
/*     */       {
/* 122 */         onFailed(8);
/* 123 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 127 */       MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 128 */       Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/* 129 */       ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */       
/* 131 */       if (xMasterTimeInfo == null)
/*     */       {
/* 133 */         onFailed(8);
/* 134 */         return false;
/*     */       }
/* 136 */       this.awardTypeId = SShiTuActiveValueConsts.getInstance().MASTER_REWARD_ID;
/* 137 */       this.checkTime = xMasterTimeInfo.getStarttime();
/*     */     }
/*     */     
/*     */ 
/* 141 */     if (DateTimeUtils.isInSameDay(this.checkTime, DateTimeUtils.getCurrTimeInMillis())) {
/* 142 */       onFailed(11);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     int rolelevel = RoleInterface.getLevel(this.masterRoleId);
/*     */     
/* 148 */     SShiTuActiveValueRewardCfg sShiTuActiveValueRewardCfg = SShiTuActiveValueRewardCfg.get(this.awardTypeId);
/* 149 */     Map.Entry<Integer, SShiTuActiveAwardIndex2RewardCfg> entry = sShiTuActiveValueRewardCfg.role_level2CfgMap.floorEntry(Integer.valueOf(rolelevel));
/* 150 */     if (entry == null)
/*     */     {
/* 152 */       onFailed(6);
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     SShiTuActiveAwardIndex2RewardCfg sShiTuActiveAwardIndex2RewardCfg = (SShiTuActiveAwardIndex2RewardCfg)entry.getValue();
/*     */     
/* 158 */     SShiTuActiveValueRewardBean sShiTuActiveValueRewardBean = (SShiTuActiveValueRewardBean)sShiTuActiveAwardIndex2RewardCfg.award_indexCfgMap.get(Integer.valueOf(this.awardIndexId));
/* 159 */     if (sShiTuActiveValueRewardBean == null)
/*     */     {
/* 161 */       onFailed(7);
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     int activeValue = ActiveInterface.getTotalActiveValue(this.apprenticeRoleId);
/*     */     
/* 167 */     if (activeValue < sShiTuActiveValueRewardBean.activite_value)
/*     */     {
/* 169 */       Map<String, Object> extraMap = new HashMap();
/* 170 */       extraMap.put("need_active_value", Integer.valueOf(sShiTuActiveValueRewardBean.activite_value));
/* 171 */       extraMap.put("active_value", Integer.valueOf(activeValue));
/*     */       
/* 173 */       onFailed(4, extraMap);
/* 174 */       return false;
/*     */     }
/* 176 */     ShiTuActive xShiTuActive = xtable.Role2shituactive.get(Long.valueOf(this.masterRoleId));
/* 177 */     if (xShiTuActive == null)
/*     */     {
/* 179 */       onFailed(10);
/* 180 */       return false;
/*     */     }
/* 182 */     AwardIndexIds xAwardIndexIds = (AwardIndexIds)xShiTuActive.getAward_map().get(Long.valueOf(this.apprenticeRoleId));
/* 183 */     if (xAwardIndexIds == null) {
/* 184 */       xAwardIndexIds = Pod.newAwardIndexIds();
/* 185 */       xShiTuActive.getAward_map().put(Long.valueOf(this.apprenticeRoleId), xAwardIndexIds);
/*     */     }
/*     */     
/* 188 */     if (xAwardIndexIds.getAward_index_id_set().contains(Integer.valueOf(this.awardIndexId)))
/*     */     {
/* 190 */       Map<String, Object> extraMap = new HashMap();
/* 191 */       extraMap.put("aleardy_award_index_id_set", xAwardIndexIds.getAward_index_id_set().toString());
/* 192 */       onFailed(3, extraMap);
/* 193 */       return false;
/*     */     }
/*     */     AwardReason awardReason;
/*     */     AwardReason awardReason;
/* 197 */     if (this.isSelf) {
/* 198 */       awardReason = new AwardReason(LogReason.SHI_TU_ACTIVE_APPRENTICE_AWARD);
/*     */     } else {
/* 200 */       awardReason = new AwardReason(LogReason.SHI_TU_ACTIVE_MASTER_AWARD);
/*     */     }
/* 202 */     if (sShiTuActiveValueRewardBean.is_bind == 1)
/*     */     {
/* 204 */       awardReason.setAwardItemBind(true);
/*     */     }
/*     */     
/* 207 */     AwardModel awardModule = AwardInterface.awardFixAward(sShiTuActiveValueRewardBean.award_id, masterUserId, this.masterRoleId, true, true, awardReason);
/*     */     
/* 209 */     if (awardModule == null)
/*     */     {
/* 211 */       Map<String, Object> extraMap = new HashMap();
/* 212 */       extraMap.put("award_id", Integer.valueOf(sShiTuActiveValueRewardBean.award_id));
/* 213 */       onFailed(5, extraMap);
/* 214 */       return false;
/*     */     }
/*     */     
/* 217 */     xAwardIndexIds.getAward_index_id_set().add(Integer.valueOf(this.awardIndexId));
/*     */     
/*     */ 
/* 220 */     SReceiveShiTuActiveRewardRep rsp = new SReceiveShiTuActiveRewardRep();
/* 221 */     rsp.result = 1;
/* 222 */     OnlineManager.getInstance().send(this.masterRoleId, rsp);
/*     */     
/*     */ 
/* 225 */     SynShiTuActiveInfo pro = new SynShiTuActiveInfo();
/* 226 */     ShiTuActiveInfo shiTuActiveInfo = new ShiTuActiveInfo();
/* 227 */     shiTuActiveInfo.role_id = this.apprenticeRoleId;
/* 228 */     shiTuActiveInfo.relation_start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(this.checkTime));
/* 229 */     shiTuActiveInfo.active_value = activeValue;
/* 230 */     shiTuActiveInfo.award_active_index_id_set.addAll(xAwardIndexIds.getAward_index_id_set());
/* 231 */     pro.shitu_active_info = shiTuActiveInfo;
/* 232 */     OnlineManager.getInstance().send(this.masterRoleId, pro);
/*     */     
/* 234 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int error_code)
/*     */   {
/* 239 */     onFailed(error_code, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int error_code, Map<String, Object> extraParams)
/*     */   {
/* 250 */     SReceiveShiTuActiveRewardRep rsp = new SReceiveShiTuActiveRewardRep();
/* 251 */     rsp.result = error_code;
/* 252 */     OnlineManager.getInstance().sendAtOnce(this.masterRoleId, rsp);
/*     */     
/* 254 */     StringBuffer logBuilder = new StringBuffer();
/* 255 */     logBuilder.append("[shitu]PCReceiveShiTuActiveRewardReq.onFailed@processImp() failed");
/* 256 */     logBuilder.append('|').append("masterId=").append(this.masterRoleId);
/* 257 */     logBuilder.append('|').append("apprenticeId=").append(this.apprenticeRoleId);
/* 258 */     logBuilder.append('|').append("awardIndexId=").append(this.awardIndexId);
/* 259 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 261 */     if (extraParams != null)
/*     */     {
/* 263 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 265 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 269 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCReceiveShiTuActiveRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */