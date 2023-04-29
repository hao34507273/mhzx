/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetSoulInitPropErrorRes;
/*     */ import mzm.gsp.pet.SPetSoulInitPropRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.petsoul.confbean.SPetSoulCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSoul;
/*     */ import xbean.PetSoulBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PCPetSoulInitPropReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final long petId;
/*     */   final int soulPos;
/*     */   final int propIndex;
/*     */   private static final int INIT_SOUL_LEVEL = 1;
/*     */   
/*     */   public PCPetSoulInitPropReq(long roleId, long petId, int soulPos, int propIndex)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.petId = petId;
/*  31 */     this.soulPos = soulPos;
/*  32 */     this.propIndex = propIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!PetManager.isPetSoulOpen(this.roleId)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1800, true)) {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  50 */     if (xPetBag == null) {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  55 */     if ((PetConstants.getInstance().PET_SOUL_OPEN_ROLE_LEVEL > 0) && (roleLevel < PetConstants.getInstance().PET_SOUL_OPEN_ROLE_LEVEL))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  60 */     if (xPet == null) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     SPetSoulCfg petSoulCfg = PetManager.getPetSoulCfg(this.soulPos, 1);
/*  65 */     if (petSoulCfg == null) {
/*  66 */       return false;
/*     */     }
/*  68 */     int maxPropIndex = PetManager.getMaxPropIndex(petSoulCfg);
/*  69 */     if ((maxPropIndex < this.propIndex) || (this.propIndex < 1)) {
/*  70 */       GameServer.logger().info(String.format("[petsoul]PCPetSoulInitPropReq.processImp@init pet soul with error propIndex|roleid=%d|soulPos=%d|propIndex=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.soulPos), Integer.valueOf(this.propIndex) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       sendError(1);
/*  76 */       return false;
/*     */     }
/*  78 */     Map<Integer, PetSoul> xSoulMap = xPet.getSoulbag().getSoulmap();
/*  79 */     PetSoul xPetSoul = (PetSoul)xSoulMap.get(Integer.valueOf(this.soulPos));
/*  80 */     if (xPetSoul != null) {
/*  81 */       PetManager.logInfo("[petsoul]PCPetSoulInitPropReq.processImp@pet soul had already been inited|roleid=%d|soulPos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.soulPos) });
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*  86 */     xPetSoul = xbean.Pod.newPetSoul();
/*  87 */     xSoulMap.put(Integer.valueOf(this.soulPos), xPetSoul);
/*  88 */     xPetSoul.setExp(0);
/*  89 */     xPetSoul.setLevel(1);
/*  90 */     xPetSoul.setPos(this.soulPos);
/*  91 */     xPetSoul.setPropindex(this.propIndex);
/*     */     
/*  93 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/*  94 */     pet.updateSoul();
/*  95 */     xPet.setIsbinded(1);
/*  96 */     pet.syncPetInfo();
/*     */     
/*  98 */     SPetSoulInitPropRes res = new SPetSoulInitPropRes(this.petId, this.soulPos, this.propIndex);
/*  99 */     OnlineManager.getInstance().send(this.roleId, res);
/* 100 */     GameServer.logger().info(String.format("PCPetSoulInitPropReq.processImp@pet soul init|roleid=%d|soulPos=%d|propIndex=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.soulPos), Integer.valueOf(this.propIndex) }));
/*     */     
/*     */ 
/* 103 */     PetManager.tLogPetSoulInit(this.roleId, this.petId, xPetSoul);
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int code) {
/* 108 */     SPetSoulInitPropErrorRes protocol = new SPetSoulInitPropErrorRes(code);
/* 109 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCPetSoulInitPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */