/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.STransfomPetPlaceRes;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetMoveToDepot;
/*     */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetDepot;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.Role2petdepot;
/*     */ 
/*     */ public class PTransfomPetPlaceReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int target;
/*     */   
/*     */   public PTransfomPetPlaceReq(long roleId, long petId, int target)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.petId = petId;
/*  30 */     this.target = target;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if ((this.target == 1) && (PetFightInterface.isPetInDefenseTeam(this.roleId, this.petId, false)))
/*     */     {
/*  42 */       SPetNormalResult p = new SPetNormalResult();
/*  43 */       p.result = 300;
/*  44 */       OnlineManager.getInstance().sendAtOnce(this.roleId, p);
/*  45 */       PetManager.logDebug("PTransfomPetPlaceReq.processImp()@last pet in defense team|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  46 */       return false;
/*     */     }
/*  48 */     boolean isOpenChangeInFight = OpenInterface.getOpenStatus(157);
/*  49 */     if (mzm.gsp.fight.main.FightInterface.isInFight(this.roleId)) {
/*  50 */       if (isOpenChangeInFight)
/*     */       {
/*     */ 
/*  53 */         Role2PetBean role2PetBean = xtable.Role2petoutfightbean.get(Long.valueOf(this.roleId));
/*  54 */         role2PetBean.setAction(this);
/*  55 */         SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  56 */         sPetNormalResult.result = 19;
/*  57 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  58 */         return true;
/*     */       }
/*  60 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  61 */       sPetNormalResult.result = 200;
/*  62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  68 */     if (xPetBag == null) {
/*  69 */       PetManager.logDebug("PTransfomPetPlaceReq.processImp@PetBag is null|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  70 */       return false;
/*     */     }
/*  72 */     PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(this.roleId));
/*  73 */     if (xPetDepot == null) {
/*  74 */       PetManager.logDebug("PTransfomPetPlaceReq.processImp@PetDepot is null|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  75 */       return false;
/*     */     }
/*  77 */     if (this.target == 0) {
/*  78 */       Pet xPet = (Pet)xPetDepot.getPetmap().remove(Long.valueOf(this.petId));
/*  79 */       if (xPet == null) {
/*  80 */         PetManager.logDebug("PTransfomPetPlaceReq.processImp@depot move pet is null|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       if (xPetBag.getBagsize() == xPetBag.getPetmap().size()) {
/*  85 */         PetManager.logDebug("PTransfomPetPlaceReq.processImp@petbag is full!|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  86 */         return false;
/*     */       }
/*  88 */       xPetBag.getPetmap().put(Long.valueOf(this.petId), xPet);
/*  89 */       STransfomPetPlaceRes res = new STransfomPetPlaceRes();
/*  90 */       res.petid = this.petId;
/*  91 */       res.target = this.target;
/*  92 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */       
/*  94 */       PetManager.logInfo("PTransfomPetPlaceReq.processImp@pet move to bag|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*     */       
/*  96 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 100 */     if (xPetDepot.getPetmap().size() == xPetDepot.getDepotsize()) {
/* 101 */       PetManager.logDebug("PTransfomPetPlaceReq.processImp@depot is full!|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 102 */       return false;
/*     */     }
/* 104 */     Pet xPet = (Pet)xPetBag.getPetmap().remove(Long.valueOf(this.petId));
/* 105 */     if (xPet == null) {
/* 106 */       PetManager.logDebug("PTransfomPetPlaceReq.processImp@petbag move pet is null|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (xPetBag.getFightpet() == this.petId) {
/* 111 */       xPetBag.setFightpet(-1L);
/* 112 */       SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 113 */       petStateChange.petid = this.petId;
/* 114 */       petStateChange.state = 3;
/* 115 */       OnlineManager.getInstance().send(this.roleId, petStateChange);
/*     */     }
/* 117 */     if (xPetBag.getShowpet() == this.petId) {
/* 118 */       xPetBag.setShowpet(-1L);
/* 119 */       SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 120 */       petStateChange.petid = this.petId;
/* 121 */       petStateChange.state = 4;
/* 122 */       OnlineManager.getInstance().send(this.roleId, petStateChange);
/*     */       
/* 124 */       PlayerShowPetChange change = new PlayerShowPetChange();
/* 125 */       PetEventArg arg = new PetEventArg();
/* 126 */       arg.petId = this.petId;
/* 127 */       arg.roleId = this.roleId;
/* 128 */       TriggerEventsManger.getInstance().triggerEvent(change, arg);
/*     */     }
/*     */     
/* 131 */     xPetDepot.getPetmap().put(Long.valueOf(this.petId), xPet);
/* 132 */     STransfomPetPlaceRes res = new STransfomPetPlaceRes();
/* 133 */     res.petid = this.petId;
/* 134 */     res.target = this.target;
/* 135 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 137 */     PetMoveToDepot change = new PetMoveToDepot();
/* 138 */     PetEventArg arg = new PetEventArg();
/* 139 */     arg.petId = this.petId;
/* 140 */     arg.roleId = this.roleId;
/* 141 */     TriggerEventsManger.getInstance().triggerEvent(change, arg);
/*     */     
/* 143 */     PetManager.logInfo("PTransfomPetPlaceReq.processImp@pet move to depot|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 144 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PTransfomPetPlaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */