/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SSyncAddSkill;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.pet.event.UseSkillBook;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public final class PStudySkillBookReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemKey;
/*     */   private static final int PERCENT_BASE = 10000;
/*     */   
/*     */   public PStudySkillBookReq(long roleId, long petId, int itemKey)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.petId = petId;
/*  42 */     this.itemKey = itemKey;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 197, true)) {
/*  54 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  55 */       GameServer.logger().error(String.format("[pet]PReleasePet.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*  56 */       return false;
/*     */     }
/*  58 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/*  59 */     SPetSkillBookCfg sPetSkillBookCfg; if ((basicItem == null) || ((sPetSkillBookCfg = SPetSkillBookCfg.get(basicItem.getCfgId())) == null) || (sPetSkillBookCfg.skillId == 0))
/*  60 */       return false;
/*     */     SPetSkillBookCfg sPetSkillBookCfg;
/*  62 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.PET_STUDY_SKILL_BOOK_REM, basicItem.getCfgId()))) {
/*  63 */       PetManager.logDebug("PStudySkillBookReq.processImp@not have item num|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), basicItem.getFirstUuid() });
/*  64 */       return false;
/*     */     }
/*  66 */     PetBag petBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  67 */     Pet xPet = (Pet)petBag.getPetmap().get(Long.valueOf(this.petId));
/*  68 */     if (xPet == null) {
/*  69 */       return false;
/*     */     }
/*  71 */     List<PetSkill> allSkillList = new ArrayList();
/*  72 */     Map<Integer, PetSkill> bookSkillMap = new HashMap();
/*  73 */     for (PetSkill xPetSkill : xPet.getSkilllist()) {
/*  74 */       if (xPetSkill.getSkillfrom() == 1) {
/*  75 */         bookSkillMap.put(Integer.valueOf(xPetSkill.getSkillid()), xPetSkill);
/*     */       }
/*  77 */       if (xPetSkill.getSkillid() == sPetSkillBookCfg.skillId) {
/*  78 */         return false;
/*     */       }
/*  80 */       if (xPet.getRememberskillid() != xPetSkill.getSkillid()) {
/*  81 */         allSkillList.add(xPetSkill);
/*     */       }
/*     */     }
/*     */     
/*  85 */     int skremcount = RememberSkillManager.getRememberSkillCount(this.petId);
/*  86 */     if (skremcount > 0) {
/*  87 */       List<Integer> ids = RememberSkillManager.getRemberSkillIds(this.petId);
/*  88 */       for (Integer skid : ids) {
/*  89 */         Iterator<PetSkill> skillIterator = allSkillList.iterator();
/*  90 */         while (skillIterator.hasNext()) {
/*  91 */           PetSkill sk = (PetSkill)skillIterator.next();
/*  92 */           if (skid.intValue() == sk.getSkillid()) {
/*  93 */             skillIterator.remove();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  99 */     int studyBookNum = bookSkillMap.size();
/* 100 */     int totalSkill = xPet.getSkilllist().size();
/* 101 */     int replaceProp; switch (totalSkill) {
/*     */     case 1: 
/* 103 */       replaceProp = PetConstants.getInstance().PET_1_SKILL_LEARN_BOOK_REPLACE_PROP;
/* 104 */       break;
/*     */     case 2: 
/* 106 */       replaceProp = PetConstants.getInstance().PET_2_SKILL_LEARN_BOOK_REPLACE_PROP;
/* 107 */       break;
/*     */     case 3: 
/* 109 */       replaceProp = PetConstants.getInstance().PET_3_SKILL_LEARN_BOOK_REPLACE_PROP;
/* 110 */       break;
/*     */     default: 
/* 112 */       replaceProp = PetConstants.getInstance().PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP;
/*     */     }
/*     */     
/* 115 */     if ((studyBookNum >= PetConstants.getInstance().LEARN_SKILLBOOK_SKILL_NUM_LIMIT) || (totalSkill >= PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT)) {
/* 116 */       replaceProp = 10000;
/*     */     }
/* 118 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 119 */     int randomProp = Xdb.random().nextInt(10000);
/* 120 */     boolean replace = false;
/* 121 */     int removeSkillId = 0;
/* 122 */     if ((randomProp < replaceProp) && (!allSkillList.isEmpty())) {
/* 123 */       int idx = Xdb.random().nextInt(allSkillList.size());
/* 124 */       PetSkill xPetSkill2 = (PetSkill)allSkillList.get(idx);
/* 125 */       removeSkillId = xPetSkill2.getSkillid();
/* 126 */       xPetSkill2.setSkillid(sPetSkillBookCfg.skillId);
/* 127 */       xPetSkill2.setSkillfrom(1);
/* 128 */       replace = true;
/*     */     }
/* 130 */     if (!replace) {
/* 131 */       PetSkill xPetSkill3 = xbean.Pod.newPetSkill();
/* 132 */       xPetSkill3.setSkillid(sPetSkillBookCfg.skillId);
/* 133 */       xPetSkill3.setSkillfrom(1);
/* 134 */       xPet.getSkilllist().add(xPetSkill3);
/*     */     }
/* 136 */     pet.updatePassiveSkill();
/* 137 */     pet.syncPetInfo();
/* 138 */     SSyncAddSkill sSyncAddSkill = new SSyncAddSkill();
/* 139 */     sSyncAddSkill.skillid = sPetSkillBookCfg.skillId;
/* 140 */     sSyncAddSkill.petid = this.petId;
/* 141 */     sSyncAddSkill.reason = 0;
/* 142 */     sSyncAddSkill.removeskillid = removeSkillId;
/* 143 */     OnlineManager.getInstance().send(this.roleId, sSyncAddSkill);
/* 144 */     int skillId = sPetSkillBookCfg.skillId;
/* 145 */     int skillType; int skillType; if (SkillInterface.isSuperSkill(skillId)) {
/* 146 */       skillType = 3; } else { int skillType;
/* 147 */       if (SkillInterface.isHighSkill(skillId)) {
/* 148 */         skillType = 2;
/*     */       } else
/* 150 */         skillType = 1;
/*     */     }
/* 152 */     PetEventArg skillEventArg = new PetEventArg();
/* 153 */     skillEventArg.roleId = this.roleId;
/* 154 */     skillEventArg.petId = this.petId;
/* 155 */     skillEventArg.enventType = PetSkillChangeLogEnum.SKILLBOOK.value;
/* 156 */     TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), skillEventArg);
/* 157 */     PetEventArg bookEventArg = new PetEventArg();
/* 158 */     bookEventArg.roleId = this.roleId;
/* 159 */     bookEventArg.petId = this.petId;
/* 160 */     bookEventArg.enventType = basicItem.getCfgId();
/* 161 */     TriggerEventsManger.getInstance().triggerEvent(new UseSkillBook(), bookEventArg);
/* 162 */     int skillNum = xPet.getSkilllist().size();
/* 163 */     TLogManager.getInstance().addLog(this.roleId, "SkillBookUse", PetManager.createTLog(new Object[] { Integer.valueOf(RoleInterface.getIp(this.roleId)), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(RoleInterface.getLevel(this.roleId)), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()), Integer.valueOf(skillType), Integer.valueOf(sPetSkillBookCfg.id), Integer.valueOf(sPetSkillBookCfg.skillId), Integer.valueOf(skillNum), Integer.valueOf(removeSkillId) }));
/* 164 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(this.roleId, this.petId);
/* 165 */     String hostIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 166 */     String userId = RoleInterface.getUserId(this.roleId);
/* 167 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.petId, xPet.getTemplateid(), PetSkillChangeLogEnum.SKILLBOOK, skillList);
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PStudySkillBookReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */