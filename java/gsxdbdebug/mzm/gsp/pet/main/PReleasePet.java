/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetReleaseCfg;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ public class PReleasePet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   
/*     */   public PReleasePet(long roleId, long petId)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.petId = petId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 202, true))
/*     */     {
/*  53 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  54 */       GameServer.logger().error(String.format("[pet]PReleasePet.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (PetFightInterface.isPetInDefenseTeam(this.roleId, this.petId, false))
/*     */     {
/*  62 */       SPetNormalResult p = new SPetNormalResult();
/*  63 */       p.result = 300;
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, p);
/*  65 */       PetManager.logDebug("PReleasePet.processImp()@last pet in defense team|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  70 */     if (xPetBag == null)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     Pet xPet = (Pet)xPetBag.getPetmap().remove(Long.valueOf(this.petId));
/*  76 */     if (xPet == null)
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     int petFightFlag = PetManager.getPetFightFlag(this.roleId, this.petId);
/*  83 */     if (petFightFlag == 1)
/*     */     {
/*  85 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  86 */       sPetNormalResult.result = 200;
/*  87 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  88 */       return false;
/*     */     }
/*  90 */     if (this.petId == xPetBag.getFightpet())
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (this.petId == xPetBag.getShowpet())
/*     */     {
/*  97 */       xPetBag.setShowpet(-1L);
/*  98 */       resetPet(this.petId);
/*     */     }
/*     */     
/*     */ 
/* 102 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 103 */     if (petCfg == null)
/*     */     {
/* 105 */       return false;
/*     */     }
/* 107 */     if ((petCfg.isShenShou()) || (petCfg.isMoShou()) || (petCfg.isBianYi()) || (petCfg.isBaoBao()))
/*     */     {
/*     */ 
/* 110 */       if (xPet.getLevel() >= PetConstants.getInstance().PET_FREE_REWARD_LEVEL)
/*     */       {
/* 112 */         for (Map.Entry<Integer, SPetReleaseCfg> sEntry : SPetReleaseCfg.getAll().entrySet())
/*     */         {
/* 114 */           if ((xPet.getLevel() >= ((SPetReleaseCfg)sEntry.getValue()).levelLowerLimit) && (xPet.getLevel() <= ((SPetReleaseCfg)sEntry.getValue()).levelUpperLimit))
/*     */           {
/*     */ 
/* 117 */             MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 118 */             for (int i = 0; i < ((SPetReleaseCfg)sEntry.getValue()).PetReleaseRewardItems.size(); i++)
/*     */             {
/* 120 */               mailAttachment.addItem(((Integer)((SPetReleaseCfg)sEntry.getValue()).PetReleaseRewardItems.get(i)).intValue(), ((Integer)((SPetReleaseCfg)sEntry.getValue()).PetReleaseRewardNums.get(i)).intValue());
/*     */             }
/*     */             
/*     */ 
/* 124 */             MailInterface.synBuildAndSendMail(this.roleId, PetConstants.getInstance().PET_FREE_REWARD_EMAILID, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.PET_FANGSHENG_REWARD_REM));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 132 */     SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 133 */     sSyncPetStateChange.petid = this.petId;
/* 134 */     sSyncPetStateChange.state = 2;
/* 135 */     OnlineManager.getInstance().send(this.roleId, sSyncPetStateChange);
/* 136 */     PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 137 */     PetEventArg arg = new PetEventArg();
/* 138 */     arg.petId = this.petId;
/* 139 */     arg.roleId = this.roleId;
/* 140 */     arg.enventType = PetDeleteTLogEnum.RELEASE.value;
/* 141 */     TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, arg);
/*     */     
/* 143 */     SPetNormalResult result = new SPetNormalResult();
/* 144 */     result.result = 6;
/* 145 */     OnlineManager.getInstance().send(this.roleId, result);
/*     */     
/* 147 */     PlayerShowPetChange change = new PlayerShowPetChange();
/* 148 */     PetEventArg petEventArg = new PetEventArg();
/* 149 */     petEventArg.petId = this.petId;
/* 150 */     petEventArg.roleId = this.roleId;
/* 151 */     TriggerEventsManger.getInstance().triggerEvent(change, petEventArg);
/*     */     
/*     */ 
/* 154 */     PetManager.addPetDeleteTlog(this.roleId, xPet.getId(), xPet.getTemplateid(), PetDeleteTLogEnum.RELEASE);
/*     */     
/* 156 */     PetManager.logInfo("PReleasePet.processImp@release pet success！|" + this.roleId + "|" + this.petId + "|" + petCfg.getId() + "|" + xPet.getLevel() + "|" + petCfg.getPetType(), new Object[0]);
/*     */     
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   private void resetPet(long petId)
/*     */   {
/* 164 */     SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 165 */     petStateChange.petid = petId;
/* 166 */     petStateChange.state = 4;
/* 167 */     OnlineManager.getInstance().send(this.roleId, petStateChange);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PReleasePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */