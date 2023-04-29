/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SGetApprenticeNumAwardSuccess;
/*     */ import mzm.gsp.shitu.confbean.SChuShiApprenticeNumAwardCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetApprenticeNumAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int awardCfgId;
/*     */   
/*     */   public PCGetApprenticeNumAward(long roleId, int awardCfgId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.awardCfgId = awardCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!ShiTuManager.isShiTuSwitchOpen(this.roleId, "[shitu]PCGetApprenticeNumAward.processImp"))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  39 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  42 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1716, true, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(this.roleId));
/*     */     
/*  49 */     if (xRole2ShiTuInfo == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[shitu]PCGetApprenticeNumAward.processImp@role shi tu info is null|role_id=%d|award_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     SChuShiApprenticeNumAwardCfg sChuShiApprenticeNumAwardCfg = SChuShiApprenticeNumAwardCfg.get(this.awardCfgId);
/*     */     
/*  60 */     if (sChuShiApprenticeNumAwardCfg == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[shitu]PCGetApprenticeNumAward.processImp@chu shi apprentice num award cfg id not exist|role_id=%d|award_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     MasterInfo xMasterInfo = xRole2ShiTuInfo.getMasterinfo();
/*  70 */     int nowChuShiApprenticeSize = xMasterInfo.getApprentice_graduate().size();
/*  71 */     int awardNeedChuShiApprenticeNum = sChuShiApprenticeNumAwardCfg.chuShiApprenticeNum;
/*  72 */     if (nowChuShiApprenticeSize < awardNeedChuShiApprenticeNum)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[shitu]PCGetApprenticeNumAward.processImp@chu shi apprentice num not enough|role_id=%d|award_cfg_id=%d|now_apprentice_size=%d|need_apprentice_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId), Integer.valueOf(nowChuShiApprenticeSize), Integer.valueOf(awardNeedChuShiApprenticeNum) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*  80 */     Set<Integer> xAleardyAwardedCfgSet = xRole2ShiTuInfo.getMasterinfo().getAlwardy_awarded_cfg_set();
/*  81 */     if (xAleardyAwardedCfgSet.contains(Integer.valueOf(this.awardCfgId)))
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[shitu]PCGetApprenticeNumAward.processImp@award cfg id alwardy awarded|role_id=%d|award_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     xAleardyAwardedCfgSet.add(Integer.valueOf(this.awardCfgId));
/*     */     
/*  92 */     int awardId = sChuShiApprenticeNumAwardCfg.awardId;
/*  93 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, new AwardReason(LogReason.SHI_TU_APPELLATION_AWARD));
/*     */     
/*  95 */     if (awardModel == null)
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[shitu]PCGetApprenticeNumAward.processImp@award appellation failed|role_id=%d|award_cfg_id=%d|award_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/*     */ 
/* 101 */       return false;
/*     */     }
/* 103 */     SGetApprenticeNumAwardSuccess sGetApprenticeNumAwardSuccess = new SGetApprenticeNumAwardSuccess();
/* 104 */     sGetApprenticeNumAwardSuccess.award_score_cfg_id = this.awardCfgId;
/*     */     
/* 106 */     OnlineManager.getInstance().send(this.roleId, sGetApprenticeNumAwardSuccess);
/*     */     
/* 108 */     GameServer.logger().info(String.format("[shitu]PCGetApprenticeNumAward.processImp@awarded success|role_id=%d|award_cfg_id=%d|aleardy_awarded_set=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardCfgId), xAleardyAwardedCfgSet.toString() }));
/*     */     
/*     */ 
/*     */ 
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCGetApprenticeNumAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */