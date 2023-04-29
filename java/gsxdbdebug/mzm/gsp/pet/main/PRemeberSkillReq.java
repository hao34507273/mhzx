/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SRemeberSkillRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.RemmberSkill;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ public class PRemeberSkillReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int skillId;
/*     */   private final long yuanBaoNum;
/*     */   private final int costType;
/*     */   
/*     */   public PRemeberSkillReq(long roleId, long petId, int skillId, long yuanBaoNum, int costType)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.petId = petId;
/*  37 */     this.skillId = skillId;
/*  38 */     this.yuanBaoNum = yuanBaoNum;
/*  39 */     this.costType = costType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  46 */       return false;
/*     */     }
/*  48 */     String userid = RoleInterface.getUserId(this.roleId);
/*  49 */     if (this.yuanBaoNum != QingfuInterface.getBalance(userid, true)) {
/*  50 */       PetManager.logDebug("PRemeberSkillReq.processImp@cyuanbao not match syuanbao|roleid=%d|yuanbaonum=%d|serverYua-nBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.yuanBaoNum), Long.valueOf(QingfuInterface.getBalance(userid, false)) });
/*  51 */       return false;
/*     */     }
/*  53 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  54 */     Pet xPet; if ((xPetBag == null) || ((xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId))) == null)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     Pet xPet;
/*     */     
/*     */ 
/*  62 */     if ((xPet.getRememberskillid() == this.skillId) || (RememberSkillManager.isRememberSkill(this.petId, this.skillId))) {
/*  63 */       return false;
/*     */     }
/*  65 */     int itemId = PetConstants.getInstance().PET_REMEBER_SKILL_ITEM_ID;
/*     */     
/*  67 */     if (xPet.getRememberskillid() > 0) {
/*  68 */       int rememberCount = RememberSkillManager.getRememberSkillCount(this.petId);
/*  69 */       RemmberSkill skill = getSkillItem(rememberCount);
/*  70 */       if (skill == null) {
/*  71 */         sendToast(this.roleId, "没有适合铭记技能得道具");
/*  72 */         return false;
/*     */       }
/*  74 */       itemId = skill.id;
/*     */     }
/*     */     
/*  77 */     if (this.costType == 1) {
/*  78 */       if (!PetManager.getInstance().removeItemAndYuanBao(userid, this.roleId, itemId, 1, CostType.COST_BIND_FIRST_PET_MINGJI, new TLogArg(LogReason.PET_MINGJI_REM))) {
/*  79 */         return false;
/*     */       }
/*  81 */     } else if (!ItemInterface.removeItemById(this.roleId, 340600000, itemId, 1, new TLogArg(LogReason.PET_MINGJI_REM))) {
/*  82 */       PetManager.logDebug("PRemeberSkillReq.processImp@not have item num|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId) });
/*  83 */       return false;
/*     */     }
/*  85 */     if (xPet.getRememberskillid() == -1) {
/*  86 */       xPet.setRememberskillid(this.skillId);
/*     */     }
/*     */     else {
/*  89 */       RememberSkillManager.addRememberSkill(this.petId, this.skillId);
/*     */     }
/*  91 */     SRemeberSkillRes sRemeberSkillRes = new SRemeberSkillRes();
/*  92 */     sRemeberSkillRes.petid = this.petId;
/*  93 */     sRemeberSkillRes.skillid = this.skillId;
/*  94 */     OnlineManager.getInstance().send(this.roleId, sRemeberSkillRes);
/*  95 */     PetManager.logInfo("PRemeberSkillReq.processImp@remeber pet skill success！|" + this.roleId + "|" + this.petId + "|" + xPet.getTemplateid() + "|" + xPet.getLevel() + "|" + this.skillId, new Object[0]);
/*  96 */     TLogManager.getInstance().addLog(this.roleId, "PetRemeberSkill", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()), Integer.valueOf(this.skillId) }));
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private RemmberSkill getSkillItem(int count) {
/* 101 */     for (RemmberSkill skill : PetConstants.getInstance().PET_REMBER_SKILL_ITEM_IDS) {
/* 102 */       if (skill.index == count + 1) {
/* 103 */         return skill;
/*     */       }
/*     */     }
/* 106 */     return null;
/*     */   }
/*     */   
/* 109 */   private void sendToast(long roleId, String message) { SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 110 */     messagetip.result = 41;
/* 111 */     messagetip.args.add(message);
/* 112 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PRemeberSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */