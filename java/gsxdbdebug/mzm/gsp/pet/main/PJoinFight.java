/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.Role2petoutfightbean;
/*     */ 
/*     */ public class PJoinFight
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long petId;
/*     */   private final long roleId;
/*     */   
/*     */   public PJoinFight(long petId, long roleId)
/*     */   {
/*  28 */     this.petId = petId;
/*  29 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  42 */     if (xPetBag == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 532, true, true))
/*     */     {
/*  49 */       StringBuilder sBuilder = new StringBuilder();
/*  50 */       sBuilder.append("[pet]PJoinFight.processImp@join fight fail,status error");
/*  51 */       sBuilder.append("|role_id=").append(this.roleId);
/*  52 */       sBuilder.append("|pet_id=").append(this.petId);
/*     */       
/*  54 */       GameServer.logger().error(sBuilder.toString());
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long oldFightPet = xPetBag.getFightpet();
/*  59 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*     */     
/*     */ 
/*  62 */     if (FightInterface.isInFight(this.roleId))
/*     */     {
/*     */ 
/*  65 */       Role2PetBean role2PetBean = Role2petoutfightbean.get(Long.valueOf(this.roleId));
/*  66 */       role2PetBean.setAction(this);
/*  67 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  68 */       normalResult.result = 19;
/*  69 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  70 */       return true;
/*     */     }
/*     */     
/*  73 */     if (xPet == null)
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  78 */     if (petCfg == null)
/*     */     {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (petCfg.getCarrayLevel() > RoleInterface.getLevel(this.roleId))
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     if ((xPet.getLife() != -1) && (xPet.getLife() <= PetConstants.getInstance().PET_JOIN_FIGHT_MIN_LIFE))
/*     */     {
/*  89 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  90 */       normalResult.result = 2;
/*  91 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  92 */       return false;
/*     */     }
/*  94 */     xPetBag.setFightpet(this.petId);
/*     */     
/*  96 */     if (xPetBag.getPetmap().containsKey(Long.valueOf(oldFightPet)))
/*     */     {
/*  98 */       SSyncPetStateChange restProtocol = new SSyncPetStateChange();
/*  99 */       restProtocol.petid = oldFightPet;
/* 100 */       restProtocol.state = 3;
/* 101 */       OnlineManager.getInstance().send(this.roleId, restProtocol);
/*     */     }
/* 103 */     SSyncPetStateChange changeProtocol = new SSyncPetStateChange();
/* 104 */     changeProtocol.petid = this.petId;
/* 105 */     changeProtocol.state = 0;
/* 106 */     OnlineManager.getInstance().send(this.roleId, changeProtocol);
/* 107 */     PetInterface.setPetBindSync(this.roleId, xPet);
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PJoinFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */