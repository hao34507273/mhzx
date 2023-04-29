/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.STrainPetRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SPetRoomCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetBag;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PTrainPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   
/*     */   public PTrainPetReq(long roleId, long petId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.petId = petId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[home]PTrainPetReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  40 */       HomelandManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*  43 */     String userid = RoleInterface.getUserId(this.roleId);
/*  44 */     if (userid == null)
/*     */     {
/*  46 */       String logString = String.format("[home]PTrainPetReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  48 */       HomelandManager.logger.error(logString);
/*  49 */       return false;
/*     */     }
/*  51 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  53 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  54 */     if (homeInfoWrapper == null)
/*     */     {
/*  56 */       String logString = String.format("[home]PTrainPetReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  58 */       HomelandManager.logger.warn(logString);
/*     */       
/*  60 */       return false;
/*     */     }
/*  62 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  63 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  65 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  66 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  67 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  69 */       String logString = String.format("[home]PTrainPetReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  73 */       HomelandManager.logger.info(logString);
/*  74 */       return false;
/*     */     }
/*  76 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  80 */       String logString = String.format("[home]PTrainPetReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  82 */       HomelandManager.logger.warn(logString);
/*  83 */       return false;
/*     */     }
/*  85 */     PetBag petbag = PetInterface.getPetBag(this.roleId, true);
/*     */     
/*  87 */     Pet pet = petbag.getPetById(this.petId);
/*  88 */     if (pet == null)
/*     */     {
/*  90 */       String logString = String.format("[home]PTrainPetReq.processImp@pet is null|roleId=%d|partnerRoleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.petId) });
/*     */       
/*     */ 
/*  93 */       HomelandManager.logger.error(logString);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*  98 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     HomelandManager.initHomeOperateCount(this.roleId, xHomeOperate, now);
/* 100 */     HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/* 101 */     int restTrainCount = HomelandManager.getRestTrainPetCount(xHomeInfo.getCleanliness(), xHomeInfo.getPetroomlevel(), xHomeOperate.getDayttrainpetcount());
/*     */     
/* 103 */     if (restTrainCount <= 0)
/*     */     {
/* 105 */       String logString = String.format("[home]PTrainPetReq.processImp@rest train pet cout error|roleId=%d|partnerRoleid=%d|petId=%d|restTrainCount=%d|cleanliness=%d|petRoomLevel=%d|alreadyTrainCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.petId), Integer.valueOf(restTrainCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(xHomeOperate.getDayttrainpetcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 110 */       HomelandManager.logger.info(logString);
/* 111 */       HomelandManager.sendSCommonResultRes(this.roleId, 11);
/* 112 */       return false;
/*     */     }
/* 114 */     xHomeOperate.setDayttrainpetcount(xHomeOperate.getDayttrainpetcount() + 1);
/*     */     
/* 116 */     SPetRoomCfg sPetRoomCfg = SPetRoomCfg.get(xHomeInfo.getPetroomlevel());
/* 117 */     if (sPetRoomCfg == null)
/*     */     {
/* 119 */       String logString = String.format("[home]PTrainPetReq.processImp@SPetRoomCfg is null|roleId=%d|partnerRoleid=%d|petId=%d|restTrainCount=%d|cleanliness=%d|petRoomLevel=%d|alreadyTrainCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.petId), Integer.valueOf(restTrainCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(xHomeOperate.getDayttrainpetcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 124 */       HomelandManager.logger.error(logString);
/*     */       
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     int addExpNum = pet.addExp(sPetRoomCfg.addExpNum);
/*     */     
/* 131 */     if (addExpNum <= 0)
/*     */     {
/*     */ 
/* 134 */       String logString = String.format("[home]PTrainPetReq.processImp@add pet exp failed|roleId=%d|partnerRoleid=%d|petId=%d|restTrainCount=%d|cleanliness=%d|petRoomLevel=%d|alreadyTrainCount=%d|addExpNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.petId), Integer.valueOf(restTrainCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(xHomeOperate.getDayttrainpetcount()), Integer.valueOf(addExpNum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 139 */       HomelandManager.logger.info(logString);
/*     */       
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 145 */     STrainPetRes res = new STrainPetRes();
/* 146 */     res.addexpnum = addExpNum;
/* 147 */     res.dayttrainpetcount = xHomeOperate.getDayttrainpetcount();
/* 148 */     res.petid = this.petId;
/*     */     
/* 150 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 152 */     String logString = String.format("[home]PTrainPetReq.processImp@add pet exp success|roleId=%d|partnerRoleid=%d|petId=%d|restTrainCount=%d|cleanliness=%d|petRoomLevel=%d|alreadyTrainCount=%d|addExpNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.petId), Integer.valueOf(restTrainCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(xHomeOperate.getDayttrainpetcount()), Integer.valueOf(addExpNum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 157 */     HomelandManager.logger.info(logString);
/*     */     
/* 159 */     tlogHometrainpet(userid, roleLevel, res.dayttrainpetcount, restTrainCount - 1, this.petId, pet.getCfgId(), addExpNum, pet.getLevel(), xHomeInfo, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 162 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogHometrainpet(String userid, int roleLevel, int traincount, int restcount, long petid, int petCfgId, int addExp, int petlevel, HomeInfo xHomeInfo, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 171 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 173 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(traincount), Integer.valueOf(restcount), Long.valueOf(petid), Integer.valueOf(petCfgId), Integer.valueOf(addExp), Integer.valueOf(petlevel), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 176 */     TLogManager.getInstance().addLog(userid, this.roleId, "Hometrainpet", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PTrainPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */