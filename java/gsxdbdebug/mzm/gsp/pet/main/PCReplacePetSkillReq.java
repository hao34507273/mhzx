/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SReplacePetSkillSuccess;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetReplaceSkillCfg;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PCReplacePetSkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int iscostyuanbao;
/*     */   private final long curyuanbao;
/*     */   private final int costyuanbao;
/*     */   
/*     */   public PCReplacePetSkillReq(long roleId, long petId, int iscostyuanbao, long curyuanbao, int costyuanbao)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.petId = petId;
/*  43 */     this.iscostyuanbao = iscostyuanbao;
/*  44 */     this.curyuanbao = curyuanbao;
/*  45 */     this.costyuanbao = costyuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!isPetReplaceSkillOpenForRole(this.roleId)) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  62 */     if (this.curyuanbao != QingfuInterface.getBalance(userid, true)) {
/*  63 */       PetManager.logDebug("PCReplacePetSkillReq.processImp@PCReplacePetSkillReq yuanbaonum not match|roleid=%d|cyuanbao=%d|syuanbao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curyuanbao), Long.valueOf(QingfuInterface.getBalance(userid, true)) });
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  68 */     if (xPetBag == null) {
/*  69 */       return false;
/*     */     }
/*  71 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  72 */     if (xPet == null) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  77 */     if (petCfg == null) {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if ((!petCfg.isMoShou()) && (!petCfg.isShenShou())) {
/*  82 */       if (GameServer.logger().isDebugEnabled()) {
/*  83 */         GameServer.logger().debug("PCReplacePetSkillReq.processImp@replace skill only shenshou or moshou!|" + this.roleId + "|" + this.petId);
/*     */       }
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     SPetReplaceSkillCfg sPetReplaceSkillCfg = SPetReplaceSkillCfg.get(xPet.getTemplateid());
/*  89 */     if (sPetReplaceSkillCfg == null) {
/*  90 */       if (GameServer.logger().isDebugEnabled()) {
/*  91 */         GameServer.logger().debug("PCReplacePetSkillReq.processImp@can not find SPetReplaceSkillCfg!|" + this.roleId + "|" + this.petId);
/*     */       }
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (xPet.getLevel() > PetConstants.getInstance().PET_REPLACE_SKILL_LEVELLIMIT) {
/*  97 */       if (GameServer.logger().isDebugEnabled()) {
/*  98 */         GameServer.logger().debug("PCReplacePetSkillReq.processImp@level limit!|" + this.roleId + "|" + this.petId);
/*     */       }
/* 100 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 101 */       normalResult.result = 30;
/* 102 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     List<PetSkill> petSkills = xPet.getSkilllist();
/* 107 */     List<Integer> skillLists = petCfg.getBornSkillList();
/* 108 */     boolean canReplaceSkill = false;
/* 109 */     if (petSkills.size() != skillLists.size()) {
/* 110 */       canReplaceSkill = true;
/*     */     } else {
/* 112 */       for (PetSkill petSkill : petSkills) {
/* 113 */         if (!skillLists.contains(Integer.valueOf(petSkill.getSkillid()))) {
/* 114 */           canReplaceSkill = true;
/*     */         }
/*     */       }
/*     */     }
/* 118 */     if (!canReplaceSkill) {
/* 119 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 120 */       normalResult.result = 33;
/* 121 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     if (mzm.gsp.fight.main.FightInterface.isInFight(this.roleId)) {
/* 127 */       Role2PetBean role2PetBean = xtable.Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 128 */       role2PetBean.setAction(this);
/* 129 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 130 */       normalResult.result = 19;
/* 131 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 132 */       return true;
/*     */     }
/*     */     
/* 135 */     int curItemNum = ItemInterface.getItemNumberById(this.roleId, sPetReplaceSkillCfg.itemId);
/*     */     
/* 137 */     if (this.iscostyuanbao == 1) {
/* 138 */       if (curItemNum < sPetReplaceSkillCfg.itemNum) {
/* 139 */         int yuanbaoNum = (sPetReplaceSkillCfg.itemNum - curItemNum) * ItemInterface.getItemYuanBaoPrice(sPetReplaceSkillCfg.itemId);
/* 140 */         if (yuanbaoNum != this.costyuanbao) {
/* 141 */           if (GameServer.logger().isDebugEnabled()) {
/* 142 */             GameServer.logger().debug("PCReplacePetSkillReq.processImp@costyuanbao not equal to real cost yuanbao!|" + this.roleId + "|" + this.petId);
/*     */           }
/* 144 */           return false;
/*     */         }
/*     */         
/* 147 */         if (!PetManager.getInstance().removeItemAndYuanBao(userid, this.roleId, sPetReplaceSkillCfg.itemId, sPetReplaceSkillCfg.itemNum, CostType.COST_BIND_FIRST_PET_REPLACE_SKILL, new TLogArg(LogReason.PET_REPLACE_SKILL_REM)))
/*     */         {
/* 149 */           return false;
/*     */         }
/*     */       } else {
/* 152 */         if (GameServer.logger().isDebugEnabled()) {
/* 153 */           GameServer.logger().debug("PCReplacePetSkillReq.processImp@costitem not enough and not use yuanbao!|" + this.roleId + "|" + this.petId);
/*     */         }
/* 155 */         return false;
/*     */       }
/*     */     } else {
/* 158 */       if (curItemNum < sPetReplaceSkillCfg.itemNum) {
/* 159 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 160 */         normalResult.result = 31;
/* 161 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 162 */         return false;
/*     */       }
/*     */       
/* 165 */       if (!ItemInterface.removeItemById(this.roleId, sPetReplaceSkillCfg.itemId, sPetReplaceSkillCfg.itemNum, new TLogArg(LogReason.PET_REPLACE_SKILL_REM))) {
/* 166 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */     int oldSkillNum = xPet.getSkilllist().size();
/*     */     
/* 180 */     xPet.getSkilllist().clear();
/* 181 */     xPet.setRememberskillid(-1);
/*     */     
/* 183 */     List<Integer> skillList = petCfg.getBornSkillList();
/* 184 */     for (Iterator i$ = skillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/* 185 */       PetSkill xPetSkill = xbean.Pod.newPetSkill();
/* 186 */       xPetSkill.setSkillid(skillId);
/* 187 */       xPetSkill.setSkillfrom(0);
/* 188 */       xPet.getSkilllist().add(xPetSkill);
/* 189 */       if (PetManager.isSkillAutoRemember(skillId)) {
/* 190 */         xPet.setRememberskillid(skillId);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 196 */     SReplacePetSkillSuccess sReplacePetSkillSuccess = new SReplacePetSkillSuccess();
/* 197 */     sReplacePetSkillSuccess.petid = this.petId;
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sReplacePetSkillSuccess);
/* 199 */     xPet.setExtramodelcfgid(0);
/*     */     
/* 201 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 202 */     petOutFightObj.updatePassiveSkill();
/* 203 */     petOutFightObj.syncPetInfo();
/*     */     
/* 205 */     PetEventArg arg = new PetEventArg();
/* 206 */     arg.roleId = this.roleId;
/* 207 */     arg.petId = this.petId;
/* 208 */     arg.enventType = PetSkillChangeLogEnum.ZAISHENG.value;
/* 209 */     TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), arg);
/*     */     
/* 211 */     int newSkillNum = xPet.getSkilllist().size();
/*     */     
/* 213 */     TLogManager.getInstance().addLog(this.roleId, "PetReplaceSkill", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(oldSkillNum), Integer.valueOf(newSkillNum) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 222 */     String hostIp = GameServerInfoManager.getHostIP();
/* 223 */     String userId = RoleInterface.getUserId(this.roleId);
/* 224 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.petId, xPet.getTemplateid(), PetSkillChangeLogEnum.ZAISHENG, skillList);
/*     */     
/* 226 */     PetManager.logInfo("PCReplacePetSkillReq.processImp@replace pet skill success!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 227 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isPetReplaceSkillOpenForRole(long roleid)
/*     */   {
/* 232 */     if (!OpenInterface.getOpenStatus(143))
/*     */     {
/*     */ 
/* 235 */       return false;
/*     */     }
/* 237 */     if (OpenInterface.isBanPlay(roleid, 143))
/*     */     {
/* 239 */       OpenInterface.sendBanPlayMsg(roleid, 143);
/* 240 */       return false;
/*     */     }
/* 242 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCReplacePetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */