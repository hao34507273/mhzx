/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.active.event.ClearActivePointArg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SClearShiTuActiveRewardInfo;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveAwardIndex2RewardCfg;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueConsts;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueRewardBean;
/*     */ import mzm.gsp.shitu.confbean.SShiTuActiveValueRewardCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.AwardIndexIds;
/*     */ import xbean.ShiTuActive;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class POnClearActivePointPoint extends mzm.gsp.active.event.ClearActivePointPointProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     long roleId = ((ClearActivePointArg)this.arg).roleId;
/*  32 */     int activeValue = ((ClearActivePointArg)this.arg).lastActivePoint;
/*     */     
/*     */ 
/*  35 */     ShiTuActive xShiTuActive = xtable.Role2shituactive.get(Long.valueOf(roleId));
/*  36 */     if (xShiTuActive == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     AwardIndexIds xAwardIndexIds = (AwardIndexIds)xShiTuActive.getAward_map().get(Long.valueOf(roleId));
/*  41 */     if (xShiTuActive.getAward_map().size() > 0)
/*     */     {
/*  43 */       xShiTuActive.getAward_map().clear();
/*     */       
/*  45 */       SClearShiTuActiveRewardInfo rsp = new SClearShiTuActiveRewardInfo();
/*  46 */       OnlineManager.getInstance().send(roleId, rsp);
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (!ShiTuManager.isShiTuActiveOpen(roleId))
/*     */     {
/*  52 */       return true;
/*     */     }
/*     */     
/*  55 */     if (activeValue <= 0)
/*     */     {
/*  57 */       return true;
/*     */     }
/*  59 */     role2ShiTuInfo xRoleIdShiTuInfo = Role2shitu.get(Long.valueOf(roleId));
/*     */     
/*  61 */     if (ShiTuManager.getMasterId(xRoleIdShiTuInfo) <= 0L)
/*     */     {
/*  63 */       return true;
/*     */     }
/*  65 */     ShiTuTimeInfo xApprenticeTimeInfo = xRoleIdShiTuInfo.getApprenticeinfo().getTimeinfo();
/*     */     
/*  67 */     if (mzm.gsp.util.DateTimeUtils.diffDaysFromNow(xApprenticeTimeInfo.getStarttime()) < 2)
/*     */     {
/*  69 */       return true;
/*     */     }
/*     */     
/*  72 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(roleId);
/*  73 */     SShiTuActiveValueRewardCfg sShiTuActiveValueRewardCfg = SShiTuActiveValueRewardCfg.get(SShiTuActiveValueConsts.getInstance().APPRENTICE_REWARD_ID);
/*  74 */     Map.Entry<Integer, SShiTuActiveAwardIndex2RewardCfg> matchLevelEntry = sShiTuActiveValueRewardCfg.role_level2CfgMap.floorEntry(Integer.valueOf(roleLevel));
/*  75 */     if (matchLevelEntry == null)
/*     */     {
/*  77 */       return true;
/*     */     }
/*     */     
/*  80 */     SShiTuActiveAwardIndex2RewardCfg sShiTuActiveAwardIndex2RewardCfg = (SShiTuActiveAwardIndex2RewardCfg)matchLevelEntry.getValue();
/*  81 */     List<AwardModel> awardModelItemBindList = new ArrayList();
/*  82 */     List<AwardModel> awardModelItemUnBindList = new ArrayList();
/*  83 */     for (Map.Entry<Integer, SShiTuActiveValueRewardBean> entry : sShiTuActiveAwardIndex2RewardCfg.award_indexCfgMap.entrySet())
/*     */     {
/*  85 */       int awardedIndex = ((Integer)entry.getKey()).intValue();
/*  86 */       if ((xAwardIndexIds == null) || (!xAwardIndexIds.getAward_index_id_set().contains(Integer.valueOf(awardedIndex))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  91 */         SShiTuActiveValueRewardBean sShiTuActiveValueRewardBean = (SShiTuActiveValueRewardBean)entry.getValue();
/*  92 */         if (sShiTuActiveValueRewardBean.activite_value <= activeValue)
/*     */         {
/*  94 */           AwardModel awardModel = AwardInterface.getRoleFixAwardModel(sShiTuActiveValueRewardBean.award_id, roleId, new mzm.gsp.award.main.AwardReason(LogReason.SHI_TU_ACTIVE_APPRENTICE_MAIL_AWARD));
/*     */           
/*  96 */           if (sShiTuActiveValueRewardBean.is_bind == 1)
/*     */           {
/*  98 */             awardModelItemBindList.add(awardModel);
/*     */           }
/*     */           else
/*     */           {
/* 102 */             awardModelItemUnBindList.add(awardModel);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 107 */     if ((!awardModelItemBindList.isEmpty()) || (!awardModelItemUnBindList.isEmpty()))
/*     */     {
/* 109 */       MailAttachment mailAttachment = new MailAttachment();
/* 110 */       AwardInterface.fillMailAttchMentBy(awardModelItemUnBindList, awardModelItemBindList, mailAttachment);
/* 111 */       if (mailAttachment.isHasItem())
/*     */       {
/*     */ 
/* 114 */         mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, SShiTuActiveValueConsts.getInstance().APPRENTICE_AWARD_MAIL_ID, new ArrayList(), new ArrayList(), mailAttachment, new mzm.gsp.tlog.TLogArg(LogReason.SHI_TU_ACTIVE_AWARD_MODEL_MAIl_AWARD));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnClearActivePointPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */