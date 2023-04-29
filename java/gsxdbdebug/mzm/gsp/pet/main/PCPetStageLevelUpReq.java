/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SPetStageLevelUpRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetJinJieCfg;
/*     */ import mzm.gsp.pet.confbean.SPetJinJieSkillCfg;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.pet.event.PetStageLevelUp;
/*     */ import mzm.gsp.pet.event.PetStageLevelUpEventArg;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Aptitude;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.Role2petoutfightbean;
/*     */ 
/*     */ public class PCPetStageLevelUpReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int iscostyuanbao;
/*     */   private final long curyuanbao;
/*     */   private final int costyuanbao;
/*     */   
/*     */   public PCPetStageLevelUpReq(long roleId, long petId, int iscostyuanbao, long curyuanbao, int costyuanbao)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.petId = petId;
/*  48 */     this.iscostyuanbao = iscostyuanbao;
/*  49 */     this.curyuanbao = curyuanbao;
/*  50 */     this.costyuanbao = costyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  56 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!isPetStageLevelUpOpenForRole(this.roleId)) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  66 */     if (this.curyuanbao != QingfuInterface.getBalance(userid, true)) {
/*  67 */       PetManager.logDebug("PCPetStageLevelUpReq.processImp@PCReplacePetSkillReq yuanbaonum not match|roleid=%d|cyuanbao=%d|syuanbao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curyuanbao), Long.valueOf(QingfuInterface.getBalance(userid, true)) });
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  72 */     if (xPetBag == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  76 */     if (xPet == null) {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  81 */     if (petCfg == null) {
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */     if (xPet.getStagelevel() == PetConstants.getInstance().PET_MAX_STAGE) {
/*  90 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  91 */       normalResult.result = 36;
/*  92 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     SPetJinJieCfg sPetJinJieCfg = null;
/*  97 */     for (SPetJinJieCfg spetJinJieCfg : SPetJinJieCfg.getAll().values()) {
/*  98 */       if ((spetJinJieCfg.petCfgId == xPet.getTemplateid()) && (spetJinJieCfg.stage == xPet.getStagelevel() + 1)) {
/*  99 */         sPetJinJieCfg = spetJinJieCfg;
/* 100 */         break;
/*     */       }
/*     */     }
/*     */     
/* 104 */     if (sPetJinJieCfg == null) {
/* 105 */       PetManager.logDebug("PCPetStageLevelUpReq.processImp@can not find sPetJinJieCfg!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 106 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 107 */       normalResult.result = 34;
/* 108 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     if (xPet.getLevel() < sPetJinJieCfg.upStageNeedLevel) {
/* 114 */       PetManager.logDebug("PCPetStageLevelUpReq.processImp@level limit!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 115 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 116 */       normalResult.result = 35;
/* 117 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     if (FightInterface.isInFight(this.roleId)) {
/* 123 */       Role2PetBean role2PetBean = Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 124 */       role2PetBean.setAction(this);
/* 125 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 126 */       normalResult.result = 19;
/* 127 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     int curItemNum = ItemInterface.getItemNumberByType(this.roleId, 340600000, sPetJinJieCfg.itemType, true);
/*     */     
/* 133 */     if (this.iscostyuanbao == 1) {
/* 134 */       if (curItemNum < sPetJinJieCfg.itemNum) {
/* 135 */         int yuanbaoNum = (sPetJinJieCfg.itemNum - curItemNum) * ItemInterface.getItemYuanBaoPrice(sPetJinJieCfg.priceItemId);
/* 136 */         if (yuanbaoNum != this.costyuanbao) {
/* 137 */           PetManager.logDebug("PCPetStageLevelUpReq.processImp@costyuanbao not equal to real cost yuanbao!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 138 */           SPetNormalResult normalResult = new SPetNormalResult();
/* 139 */           normalResult.result = 39;
/* 140 */           OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 141 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 145 */         if (QingfuInterface.costYuanbao(userid, this.roleId, yuanbaoNum, CostType.COST_BIND_FIRST_PET_REPLACE_SKILL, new TLogArg(LogReason.PET_STAGE_LEVEL_UP_REM)) != CostResult.Success) {
/* 146 */           PetManager.logDebug("PCPetStageLevelUpReq.processImp@yuanbao not enough|roleid=%d|yuanbaoNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(yuanbaoNum) });
/* 147 */           return false;
/*     */         }
/* 149 */         if (curItemNum > 0)
/*     */         {
/* 151 */           if (!ItemInterface.removeItemsByType(this.roleId, sPetJinJieCfg.itemType, curItemNum, new TLogArg(LogReason.PET_STAGE_LEVEL_UP_REM))) {
/* 152 */             PetManager.logDebug("PCPetStageLevelUpReq.processImp@not have item with itemNum!|" + sPetJinJieCfg.itemNum + "|" + sPetJinJieCfg.itemType + "|" + this.roleId + "|" + this.petId, new Object[0]);
/* 153 */             SPetNormalResult normalResult = new SPetNormalResult();
/* 154 */             normalResult.result = 37;
/* 155 */             OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 156 */             return false;
/*     */           }
/*     */         }
/*     */       } else {
/* 160 */         PetManager.logDebug("PCPetStageLevelUpReq.processImp@costitem not enough and not use yuanbao!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 161 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 162 */         normalResult.result = 37;
/* 163 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 164 */         return false;
/*     */       }
/*     */     } else {
/* 167 */       if (curItemNum < sPetJinJieCfg.itemNum) {
/* 168 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 169 */         normalResult.result = 37;
/* 170 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 171 */         return false;
/*     */       }
/*     */       
/* 174 */       if (!ItemInterface.removeItemsByType(this.roleId, sPetJinJieCfg.itemType, sPetJinJieCfg.itemNum, new TLogArg(LogReason.PET_STAGE_LEVEL_UP_REM))) {
/* 175 */         PetManager.logDebug("PCPetStageLevelUpReq.processImp@not have item with itemNum!|" + sPetJinJieCfg.itemNum + "|" + sPetJinJieCfg.itemType + "|" + this.roleId + "|" + this.petId, new Object[0]);
/* 176 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 177 */         normalResult.result = 37;
/* 178 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 179 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 183 */     boolean isChangeSkill = false;
/*     */     
/* 185 */     SPetJinJieSkillCfg sPetJinJieSkillCfg = SPetJinJieSkillCfg.get(xPet.getTemplateid());
/* 186 */     Integer skillId; Integer nextSkillId; if (sPetJinJieSkillCfg != null) {
/* 187 */       skillId = (Integer)sPetJinJieSkillCfg.stageSkills.get(xPet.getStagelevel());
/* 188 */       nextSkillId = (Integer)sPetJinJieSkillCfg.stageSkills.get(xPet.getStagelevel() + 1);
/* 189 */       if ((skillId != null) && (nextSkillId != null)) {
/* 190 */         for (PetSkill petSkill : xPet.getSkilllist()) {
/* 191 */           if (petSkill.getSkillid() == skillId.intValue()) {
/* 192 */             petSkill.setSkillid(nextSkillId.intValue());
/* 193 */             isChangeSkill = true;
/* 194 */             if (xPet.getRememberskillid() != skillId.intValue()) break;
/* 195 */             xPet.setRememberskillid(nextSkillId.intValue()); break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 203 */     xPet.setGrow(xPet.getGrow() + sPetJinJieCfg.growAddRate / 10000.0F);
/*     */     
/* 205 */     Aptitude xAptitude = xPet.getAptitude();
/* 206 */     setAPTWithType(xAptitude, 0, sPetJinJieCfg.hpAptAdd);
/* 207 */     setAPTWithType(xAptitude, 1, sPetJinJieCfg.phyAtkAptAdd);
/* 208 */     setAPTWithType(xAptitude, 2, sPetJinJieCfg.phyDefAptAdd);
/* 209 */     setAPTWithType(xAptitude, 3, sPetJinJieCfg.magAtkAptAdd);
/* 210 */     setAPTWithType(xAptitude, 4, sPetJinJieCfg.magDefAptAdd);
/* 211 */     setAPTWithType(xAptitude, 5, sPetJinJieCfg.speedAptAdd);
/*     */     
/*     */ 
/* 214 */     xPet.setStagelevel(xPet.getStagelevel() + 1);
/*     */     
/* 216 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 217 */     normalResult.result = 38;
/* 218 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*     */     
/* 220 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 221 */     petOutFightObj.updateOutFightProperty();
/* 222 */     petOutFightObj.syncPetInfo();
/*     */     
/* 224 */     SPetStageLevelUpRes sPetStageLevelUpRes = new SPetStageLevelUpRes();
/* 225 */     sPetStageLevelUpRes.petid = this.petId;
/* 226 */     OnlineManager.getInstance().send(this.roleId, sPetStageLevelUpRes);
/*     */     
/* 228 */     PetStageLevelUp stageLevelUp = new PetStageLevelUp();
/* 229 */     PetStageLevelUpEventArg arg = new PetStageLevelUpEventArg();
/* 230 */     arg.petId = this.petId;
/* 231 */     arg.roleId = this.roleId;
/* 232 */     arg.oldStageLevel = (xPet.getStagelevel() - 1);
/* 233 */     arg.newStageLevel = xPet.getStagelevel();
/* 234 */     TriggerEventsManger.getInstance().triggerEvent(stageLevelUp, arg);
/*     */     
/* 236 */     if (isChangeSkill)
/*     */     {
/* 238 */       PetEventArg skillChangeArg = new PetEventArg();
/* 239 */       skillChangeArg.roleId = this.roleId;
/* 240 */       skillChangeArg.petId = this.petId;
/* 241 */       skillChangeArg.enventType = PetSkillChangeLogEnum.JINJIE.value;
/* 242 */       TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), skillChangeArg);
/*     */     }
/*     */     
/* 245 */     PetManager.logInfo("PCPetStageLevelUpReq.processImp@replace pet skill success!|" + this.roleId + "|" + this.petId, new Object[0]);
/*     */     
/*     */ 
/* 248 */     TLogManager.getInstance().addLog(this.roleId, "PetStageLevelUp", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(xPet.getStagelevel() - 1), Integer.valueOf(xPet.getStagelevel()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     java.util.List<Integer> skillList = PetInterface.getPetNativeSkillList(this.roleId, this.petId);
/* 259 */     String hostIp = GameServerInfoManager.getHostIP();
/* 260 */     String userId = RoleInterface.getUserId(this.roleId);
/* 261 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.petId, xPet.getTemplateid(), PetSkillChangeLogEnum.JINJIE, skillList);
/*     */     
/* 263 */     return true;
/*     */   }
/*     */   
/*     */   private void setAPTWithType(Aptitude xAptitude, int type, int addAptNum) {
/* 267 */     Integer aptValue = (Integer)xAptitude.getAptmap().get(Integer.valueOf(type));
/* 268 */     if (aptValue != null) {
/* 269 */       xAptitude.getAptmap().put(Integer.valueOf(type), Integer.valueOf(aptValue.intValue() + addAptNum));
/*     */     }
/* 271 */     Integer aptLimitValue = (Integer)xAptitude.getAptlimitmap().get(Integer.valueOf(type));
/* 272 */     if (aptLimitValue != null) {
/* 273 */       xAptitude.getAptlimitmap().put(Integer.valueOf(type), Integer.valueOf(aptLimitValue.intValue() + addAptNum));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isPetStageLevelUpOpenForRole(long roleid)
/*     */   {
/* 279 */     if (!OpenInterface.getOpenStatus(142))
/*     */     {
/* 281 */       return false;
/*     */     }
/* 283 */     if (OpenInterface.isBanPlay(roleid, 142))
/*     */     {
/* 285 */       OpenInterface.sendBanPlayMsg(roleid, 142);
/* 286 */       return false;
/*     */     }
/* 288 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCPetStageLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */