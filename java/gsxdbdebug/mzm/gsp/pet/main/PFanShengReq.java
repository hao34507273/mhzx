/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SFanShengRes;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetFanSHengConf;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetFanSheng;
/*     */ import mzm.gsp.pet.event.PetFanShengEventArg;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PFanShengReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final long yuanBaoNum;
/*     */   private final int fanShengType;
/*     */   private final int costType;
/*     */   
/*     */   public PFanShengReq(long roleId, long petId, long yuanBaoNum, int fanShengType, int costType)
/*     */   {
/*  47 */     this.roleId = roleId;
/*  48 */     this.petId = petId;
/*  49 */     this.yuanBaoNum = yuanBaoNum;
/*  50 */     this.fanShengType = fanShengType;
/*  51 */     this.costType = costType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  59 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  60 */       return false;
/*     */     }
/*  62 */     String userid = RoleInterface.getUserId(this.roleId);
/*  63 */     if (this.yuanBaoNum != QingfuInterface.getBalance(userid, true)) {
/*  64 */       PetManager.logDebug("PFanShengReq.processImp@cyuanbao not match syuanbao|roleid=%d|yuanBaoNum=%d|serverYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.yuanBaoNum), Long.valueOf(QingfuInterface.getBalance(userid, false)) });
/*  65 */       return false;
/*     */     }
/*  67 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  68 */     Pet xPet; if ((xPetBag == null) || ((xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId))) == null))
/*  69 */       return false;
/*     */     Pet xPet;
/*  71 */     int petFightFlag = PetManager.getPetFightFlag(this.roleId, this.petId);
/*  72 */     if (petFightFlag == 1) {
/*  73 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  74 */       sPetNormalResult.result = 200;
/*  75 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  76 */       return false; }
/*  77 */     if (PetFightInterface.isPetInDefenseTeam(this.roleId, this.petId, true)) {
/*  78 */       SPetNormalResult sPetNormalResult2 = new SPetNormalResult();
/*  79 */       sPetNormalResult2.result = 300;
/*  80 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult2);
/*  81 */       PetManager.logDebug("PFanShengReq.processImp()@last pet in defense team|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  82 */       return false; }
/*  83 */     PetCfg petCfg; if ((xPet.getId() == xPetBag.getFightpet()) || ((petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid())) == null) || (petCfg.isShenShou()) || (petCfg.isMoShou()) || (petCfg.isSpecial()))
/*  84 */       return false;
/*     */     PetCfg petCfg;
/*  86 */     if ((!petCfg.isWild()) && (xPet.getLevel() > PetConstants.getInstance().CAN_FANSHENG_MAX_LEVEL)) {
/*  87 */       return false;
/*     */     }
/*  89 */     int fanShengDanItemType = PetConstants.getInstance().PET_PUTTONG_FANSHENG_ITEM_TYPE;
/*  90 */     if (this.fanShengType == 0) {
/*  91 */       if ((petCfg.isBaoBao()) || (petCfg.isWild())) {
/*  92 */         return false;
/*     */       }
/*  94 */       fanShengDanItemType = PetConstants.getInstance().PET_GAOJI_FANSHENG_ITEM_TYPE;
/*     */     }
/*  96 */     SPetFanSHengConf fanShengConf = SPetFanSHengConf.get(petCfg.getPetFanSHengConfId());
/*  97 */     if (fanShengConf == null) {
/*  98 */       return false;
/*     */     }
/* 100 */     int itemNum = fanShengConf.putTongFanShengDanItemNum;
/* 101 */     int itemId = PetConstants.getInstance().PET_PUTONG_FANSHENGDAN_ID;
/* 102 */     if (fanShengDanItemType == PetConstants.getInstance().PET_GAOJI_FANSHENG_ITEM_TYPE) {
/* 103 */       itemNum = fanShengConf.gaoJiFanShengDanItemNum;
/* 104 */       itemId = PetConstants.getInstance().PET_GAOJI_FANSHENGDAN_ID;
/*     */     }
/* 106 */     if (this.costType == 1) {
/* 107 */       if (!PetManager.getInstance().removeItemAndYuanBao(userid, this.roleId, itemId, itemNum, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_PET_FANSHENG, new TLogArg(LogReason.PET_FANSHENG_REM))) {
/* 108 */         return false;
/*     */       }
/* 110 */     } else if (!ItemInterface.removeItemsByTypeId(this.roleId, fanShengDanItemType, itemNum, new TLogArg(LogReason.PET_FANSHENG_REM))) {
/* 111 */       PetManager.logDebug("PFanShengReq.processImp@not have item num|roleid=%d|itemNum=%d|fanShengDanItemType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemNum), Integer.valueOf(fanShengDanItemType) });
/* 112 */       return false;
/*     */     }
/* 114 */     int fanshengUnBianyiNum = xPet.getFanshengunbianyinum();
/* 115 */     PetCfg newPetCfg; if ((petCfg.getPetType() == 2) && (this.fanShengType == 0)) {
/* 116 */       PetCfg newPetCfg = PetManager.getInstance().getPetCfg(petCfg.getFanShengBianYiId());
/* 117 */       if (newPetCfg == null) {
/* 118 */         return false;
/*     */       }
/* 120 */       fanshengUnBianyiNum = 0;
/*     */     } else {
/* 122 */       int prop = Xdb.random().nextInt(10000);
/* 123 */       int addProp = mzm.gsp.skill.main.SkillInterface.getBianYiAddRateWithSkills(FashionDressInterface.getFashionDressPassiveSkillMap(this.roleId, false));
/* 124 */       int bianyiRate = fanShengConf.bianYiProp + addProp;
/* 125 */       PetCfg newPetCfg; if (petCfg.getFanshengBianyiNum() == -1) {
/* 126 */         newPetCfg = PetManager.getInstance().getPetCfg(petCfg.getFanShengBaoBaoId());
/* 127 */       } else if ((prop < bianyiRate) || (fanshengUnBianyiNum >= petCfg.getFanshengBianyiNum())) {
/* 128 */         PetCfg newPetCfg = PetManager.getInstance().getPetCfg(petCfg.getFanShengBianYiId());
/* 129 */         if (newPetCfg == null) {
/* 130 */           newPetCfg = PetManager.getInstance().getPetCfg(petCfg.getFanShengBaoBaoId());
/*     */         }
/* 132 */         fanshengUnBianyiNum = 0;
/*     */       } else {
/* 134 */         newPetCfg = PetManager.getInstance().getPetCfg(petCfg.getFanShengBaoBaoId());
/* 135 */         fanshengUnBianyiNum++;
/*     */       }
/*     */     }
/* 138 */     if ((newPetCfg != null) && (newPetCfg.getsPetCfg() != null)) {
/* 139 */       xPetBag.getPetmap().remove(Long.valueOf(this.petId));
/* 140 */       RememberSkillManager.remeoveAllSkill(this.petId);
/* 141 */       if (xPetBag.getFightpet() == this.petId) {
/* 142 */         return false;
/*     */       }
/* 144 */       if (xPetBag.getShowpet() == this.petId) {
/* 145 */         xPetBag.setShowpet(-1L);
/* 146 */         PetEventArg arg = new PetEventArg();
/* 147 */         arg.petId = this.petId;
/* 148 */         arg.roleId = this.roleId;
/* 149 */         TriggerEventsManger.getInstance().triggerEvent(new PlayerShowPetChange(), arg);
/*     */       }
/* 151 */       Pet xNewPet = xbean.Pod.newPet();
/* 152 */       long newPetId = PetManager.getInstance().createPetAction(this.roleId, newPetCfg.getId(), 0, xNewPet);
/* 153 */       if (newPetId < 0L) {
/* 154 */         PetManager.logDebug("PFanShengReq.processImp@create pet error|roleid=%d|petcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(newPetCfg.getId()) });
/* 155 */         return false;
/*     */       }
/* 157 */       xNewPet.setFanshengunbianyinum(fanshengUnBianyiNum);
/* 158 */       PetOutFightObj obj = new PetOutFightObj(this.roleId, xNewPet);
/* 159 */       PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 160 */       PetEventArg arg2 = new PetEventArg();
/* 161 */       arg2.roleId = this.roleId;
/* 162 */       arg2.petId = this.petId;
/* 163 */       arg2.enventType = PetDeleteTLogEnum.FANSHENG.value;
/* 164 */       TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, arg2);
/* 165 */       SFanShengRes sFanShengRes = new SFanShengRes();
/* 166 */       obj.fillPetInfo(sFanShengRes.newpetinfo);
/* 167 */       sFanShengRes.oldpetid = this.petId;
/* 168 */       OnlineManager.getInstance().send(this.roleId, sFanShengRes);
/* 169 */       PetFanShengLogEnum status = PetFanShengLogEnum.FANSHENG;
/* 170 */       if (newPetCfg.isBianYi()) {
/* 171 */         status = PetFanShengLogEnum.FANSHENG_BIANYI;
/*     */       }
/* 173 */       TLogManager.getInstance().addLog(this.roleId, "PetFanSheng", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(petCfg.getId()), Long.valueOf(this.petId), status, Integer.valueOf(newPetCfg.getId()), Long.valueOf(newPetId), Integer.valueOf(RoleInterface.getLevel(this.roleId)) }));
/* 174 */       PetFanShengEventArg petFanShengEventArg = new PetFanShengEventArg(this.roleId, this.petId, xNewPet.getId());
/* 175 */       for (PetSkill xPetSkill : xNewPet.getSkilllist()) {
/* 176 */         petFanShengEventArg.newPetSkillIdList.add(Integer.valueOf(xPetSkill.getSkillid()));
/*     */       }
/* 178 */       TriggerEventsManger.getInstance().triggerEvent(new PetFanSheng(), petFanShengEventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/* 179 */       PetEventArg killChangeArg = new PetEventArg();
/* 180 */       killChangeArg.roleId = this.roleId;
/* 181 */       killChangeArg.petId = xNewPet.getId();
/* 182 */       killChangeArg.enventType = PetSkillChangeLogEnum.FANSHENG.value;
/* 183 */       TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), killChangeArg);
/* 184 */       int skillNum = xNewPet.getSkilllist().size();
/* 185 */       String hostIp = GameServerInfoManager.getHostIP();
/* 186 */       String userId = RoleInterface.getUserId(this.roleId);
/* 187 */       PetManager.addPetGetTlog(this.roleId, hostIp, userId, newPetId, xNewPet.getTemplateid(), PetGetTLogEnum.FANSHENG_GET, skillNum);
/* 188 */       List<Integer> skillList = new ArrayList();
/* 189 */       for (PetSkill xPetSkill2 : xPet.getSkilllist()) {
/* 190 */         skillList.add(Integer.valueOf(xPetSkill2.getSkillid()));
/*     */       }
/* 192 */       PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, newPetId, xNewPet.getTemplateid(), PetSkillChangeLogEnum.FANSHENG, skillList);
/* 193 */       PetManager.addPetDeleteTlog(this.roleId, this.petId, petCfg.getId(), PetDeleteTLogEnum.FANSHENG);
/* 194 */       return true; }
/* 195 */     if (!GameServer.logger().isDebugEnabled()) {
/* 196 */       return false;
/*     */     }
/* 198 */     GameServer.logger().debug("PFanShengReq.processImp@new petcfgid not exist|oldpetcfgid=" + petCfg.getId());
/* 199 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PFanShengReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */