/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetFightSetPositionFail;
/*     */ import mzm.gsp.pet.SPetFightSetPositionSuccess;
/*     */ import mzm.gsp.pet.event.PetFightDefenseTeamChanged;
/*     */ import mzm.gsp.pet.event.PetFightDefenseTeamChangedArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pet;
/*     */ import xbean.PetFightTeamInfo;
/*     */ import xbean.RolePetFightTeam;
/*     */ 
/*     */ public class PPetFightSetPosition extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int teamNo;
/*     */   private final Map<Integer, Long> position2pet;
/*     */   
/*     */   public PPetFightSetPosition(long roleId, int teamNo, Map<Integer, Long> position2pet)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.teamNo = teamNo;
/*  31 */     this.position2pet = position2pet;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!PetFightManager.isEnabled())
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!PetFightManager.isTeamNumberValid(this.teamNo))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     Iterator<Map.Entry<Integer, Long>> iterator = this.position2pet.entrySet().iterator();
/*  51 */     while (iterator.hasNext())
/*     */     {
/*  53 */       Map.Entry<Integer, Long> entry = (Map.Entry)iterator.next();
/*  54 */       if (!PetFightManager.isPositionValid(((Integer)entry.getKey()).intValue()))
/*     */       {
/*  56 */         iterator.remove();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  61 */     Set<Long> setToCheckDuplicatedPetId = new HashSet();
/*  62 */     for (Long petId : this.position2pet.values())
/*     */     {
/*  64 */       Pet xPet = PetInterface.getXPetById(this.roleId, petId.longValue(), true);
/*  65 */       if (xPet == null)
/*     */       {
/*  67 */         onFail(1);
/*  68 */         PetFightManager.logError("PPetFightSetPosition.processImp()@pet not exists|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), petId });
/*     */         
/*  70 */         return false;
/*     */       }
/*  72 */       if (xPet.getIsbinded() == 0)
/*     */       {
/*  74 */         onFail(2);
/*  75 */         PetFightManager.logError("PPetFightSetPosition.processImp()@pet not bound|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), petId });
/*     */         
/*  77 */         return false;
/*     */       }
/*  79 */       if (!setToCheckDuplicatedPetId.add(petId))
/*     */       {
/*  81 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  85 */     RolePetFightTeam xRolePetFightTeam = PetFightManager.getOrCreateRolePetFightTeam(this.roleId);
/*  86 */     if ((xRolePetFightTeam.getDefense_team() == this.teamNo) && (this.position2pet.size() == 0))
/*     */     {
/*  88 */       onFail(3);
/*  89 */       PetFightManager.logError("PPetFightSetPosition.removePetFromTeam()@remove last pet in defense team|roleid=%d|team=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo) });
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*  94 */     PetFightTeamInfo xPetFightTeamInfo = PetFightManager.getOrCreatePetFightTeamInfo(xRolePetFightTeam, this.teamNo);
/*  95 */     xPetFightTeamInfo.getPosition2pet().clear();
/*  96 */     xPetFightTeamInfo.getPosition2pet().putAll(this.position2pet);
/*  97 */     onSuccess(xRolePetFightTeam.getDefense_team() == this.teamNo);
/*  98 */     PetFightManager.logInfo("PPetFightSetPosition.processImp()@success|roleid=%d|team=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo) });
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   private void onSuccess(boolean triggerDefenseTeamChanged)
/*     */   {
/* 104 */     SPetFightSetPositionSuccess success = new SPetFightSetPositionSuccess();
/* 105 */     success.team = this.teamNo;
/* 106 */     success.position2pet.putAll(this.position2pet);
/* 107 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */     
/* 109 */     if (triggerDefenseTeamChanged)
/*     */     {
/* 111 */       TriggerEventsManger.getInstance().triggerEvent(new PetFightDefenseTeamChanged(), new PetFightDefenseTeamChangedArg(this.roleId, this.teamNo), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int reason)
/*     */   {
/* 119 */     SPetFightSetPositionFail fail = new SPetFightSetPositionFail();
/* 120 */     fail.reason = reason;
/* 121 */     fail.team = this.teamNo;
/* 122 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightSetPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */