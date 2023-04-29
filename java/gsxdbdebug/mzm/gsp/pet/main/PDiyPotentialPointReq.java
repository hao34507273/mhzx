/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PDiyPotentialPointReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   private final Map<Integer, Integer> propMap;
/*    */   
/*    */   public PDiyPotentialPointReq(long roleId, long petId, Map<Integer, Integer> propMap)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.petId = petId;
/* 23 */     this.propMap = propMap;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 34 */     if (xPetBag == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 38 */     if (xPet == null) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/*    */     
/* 44 */     int xPotentialPoint = xPet.getPotentialpoint();
/*    */     
/* 46 */     int levelPoint = xPet.getLevel() * PetManager.getPortentialPointPerLevel();
/*    */     
/* 48 */     int oldMp = pet.getFinalMaxMP();
/* 49 */     int oldHp = pet.getFinalMaxHP();
/* 50 */     int totalUsePoint = 0;
/*    */     
/* 52 */     Map<Integer, Integer> xPropMap = xPet.getBasicproperty();
/* 53 */     for (Map.Entry<Integer, Integer> propEntry : this.propMap.entrySet())
/*    */     {
/* 55 */       int propType = ((Integer)propEntry.getKey()).intValue();
/* 56 */       if (!PetManager.addPointTypeCheck(propType)) {
/* 57 */         PetManager.logDebug("PDiyPotentialPointReq.processImp@proptype not legal|roleid=%d|petid=%d|addponittype=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(propType) });
/* 58 */         return false;
/*    */       }
/* 60 */       int value = ((Integer)propEntry.getValue()).intValue();
/*    */       
/* 62 */       if ((value < 0) || (value > xPotentialPoint) || (value > levelPoint)) {
/* 63 */         PetManager.logDebug("PDiyPotentialPointReq.processImp@addpoint not legal|roleid=%d|petid=%d|addponitvalue=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(value) });
/* 64 */         return false;
/*    */       }
/* 66 */       totalUsePoint += value;
/*    */       
/* 68 */       Integer xPropValue = (Integer)xPropMap.get(Integer.valueOf(propType));
/* 69 */       if (xPropValue == null) {
/* 70 */         xPropValue = Integer.valueOf(0);
/*    */       }
/* 72 */       xPropMap.put(Integer.valueOf(propType), Integer.valueOf(xPropValue.intValue() + value));
/*    */     }
/*    */     
/* 75 */     if ((xPotentialPoint < totalUsePoint) || (totalUsePoint > levelPoint)) {
/* 76 */       PetManager.logDebug("PDiyPotentialPointReq.processImp@tialpoint not match totalusepoint|roleid=%d|xPotentialPoint=%d|totalUsePoint=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xPotentialPoint), Integer.valueOf(totalUsePoint), Long.valueOf(this.petId) });
/* 77 */       return false;
/*    */     }
/*    */     
/* 80 */     xPet.setPotentialpoint(xPotentialPoint - totalUsePoint);
/*    */     
/* 82 */     int changeMp = pet.getFinalMaxMP() - oldMp;
/* 83 */     int changeHp = pet.getFinalMaxHP() - oldHp;
/* 84 */     pet.setMP(pet.getMP() + changeMp);
/* 85 */     pet.setHP(pet.getHP() + changeHp);
/* 86 */     pet.syncPetInfo();
/*    */     
/* 88 */     String hostIp = GameServerInfoManager.getHostIP();
/* 89 */     String userId = RoleInterface.getUserId(this.roleId);
/* 90 */     PetManager.addPetPointChangeTlog(this.roleId, hostIp, userId, this.petId, xPet.getLevel(), PetPointChangeLogEnum.DIYADD_TYPE, xPropMap, xPet.getPotentialpoint());
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PDiyPotentialPointReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */