/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SKitchenLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SKitchenCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PKitchenLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PKitchenLevelUpReq(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  37 */       String logStr = String.format("[home]PKitchenLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       HomelandManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     String userid = RoleInterface.getUserId(this.roleId);
/*  43 */     if (userid == null)
/*     */     {
/*  45 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       HomelandManager.logger.error(logString);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  53 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  54 */     if (homeInfoWrapper == null)
/*     */     {
/*  56 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  58 */       HomelandManager.logger.warn(logString);
/*     */       
/*  60 */       return false;
/*     */     }
/*  62 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  63 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  65 */     if (!isOwner)
/*     */     {
/*  67 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  71 */       HomelandManager.logger.warn(logString);
/*  72 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  77 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  78 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  80 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  84 */       HomelandManager.logger.info(logString);
/*  85 */       return false;
/*     */     }
/*  87 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  91 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  93 */       HomelandManager.logger.warn(logString);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  99 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 100 */     if (sHomelandCfg == null)
/*     */     {
/* 102 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 106 */       HomelandManager.logger.error(logString);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     int currentKitchenlevel = xHomeInfo.getKitchenlevel();
/* 111 */     if (currentKitchenlevel >= sHomelandCfg.maxKitchenLevel)
/*     */     {
/* 113 */       HomelandManager.sendSCommonResultRes(this.roleId, 4);
/* 114 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@kitchen room level to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|kitchenLevel=%d|maxKitchenLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentKitchenlevel), Integer.valueOf(sHomelandCfg.maxKitchenLevel) });
/*     */       
/*     */ 
/*     */ 
/* 118 */       HomelandManager.logger.info(logString);
/*     */       
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     SKitchenCfg sKitchenCfg = SKitchenCfg.get(currentKitchenlevel + 1);
/* 124 */     if (sKitchenCfg == null)
/*     */     {
/* 126 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@SKitchenCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|kitchenLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentKitchenlevel + 1) });
/*     */       
/*     */ 
/*     */ 
/* 130 */       HomelandManager.logger.error(logString);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.KITCHEN_LEVEl_UP, 0, sKitchenCfg.moneyType, sKitchenCfg.moneyNum, CostType.COST_BIND_FIRST_KITCHEN_LEVEL_UP);
/*     */     
/* 137 */     if (!ret)
/*     */     {
/* 139 */       String logString = String.format("[home]PKitchenLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|kitchenLevel=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentKitchenlevel + 1), Integer.valueOf(sKitchenCfg.moneyType), Integer.valueOf(sKitchenCfg.moneyNum) });
/*     */       
/*     */ 
/* 142 */       HomelandManager.logger.error(logString);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     xHomeInfo.setKitchenlevel(currentKitchenlevel + 1);
/*     */     
/* 148 */     SKitchenLevelUpRes res = new SKitchenLevelUpRes();
/* 149 */     res.kitchenlevel = (currentKitchenlevel + 1);
/* 150 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 152 */     if (partnerRoleId != -1L)
/*     */     {
/* 154 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/* 157 */     String logString = String.format("[home]PKitchenLevelUpReq.processImp@kitchen room level up success|roleId=%d|partnerRoleid=%d|homeLevel=%d|oldKitchenLevel=%d|newKitchenLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentKitchenlevel), Integer.valueOf(currentKitchenlevel + 1) });
/*     */     
/*     */ 
/* 160 */     HomelandManager.logger.info(logString);
/* 161 */     tlogKitchenLevelUp(userid, roleLevel, currentKitchenlevel, xHomeInfo, sKitchenCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogKitchenLevelUp(String userid, int roleLevel, int oldKitchenLevel, HomeInfo xHomeInfo, SKitchenCfg sKitchenCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 170 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 172 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(oldKitchenLevel), Integer.valueOf(xHomeInfo.getKitchenlevel()), Integer.valueOf(sKitchenCfg.moneyType), Integer.valueOf(sKitchenCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 175 */     TLogManager.getInstance().addLog(userid, this.roleId, "Kitchenlevelup", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PKitchenLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */