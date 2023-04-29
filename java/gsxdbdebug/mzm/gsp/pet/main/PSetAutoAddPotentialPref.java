/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SAutoAddPotentialPrefRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PSetAutoAddPotentialPref
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   private final Map<Integer, Integer> propMap;
/*    */   
/*    */   public PSetAutoAddPotentialPref(long roleId, long petId, Map<Integer, Integer> propMap)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.petId = petId;
/* 24 */     this.propMap = propMap;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 35 */     if (xPetBag == null) {
/* 36 */       return false;
/*    */     }
/* 38 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 39 */     if (xPet == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     int totalAssignPoint = 0;
/* 43 */     for (Map.Entry<Integer, Integer> propEntry : this.propMap.entrySet())
/*    */     {
/* 45 */       int propType = ((Integer)propEntry.getKey()).intValue();
/* 46 */       if (!PetManager.addPointTypeCheck(propType)) {
/* 47 */         PetManager.logDebug("PSetAutoAddPotentialPref.processImp@proptype not legal|roleid=%d|petid=%d|addponittype=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(propType) });
/* 48 */         return false;
/*    */       }
/* 50 */       int value = ((Integer)propEntry.getValue()).intValue();
/*    */       
/* 52 */       if ((value < 0) || (value > PetManager.getInstance().getAutoAssignPointLimit())) {
/* 53 */         PetManager.logDebug("PSetAutoAddPotentialPref.processImp@addpoint not legal|roleid=%d|petid=%d|addponitvalue=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(value) });
/* 54 */         return false;
/*    */       }
/* 56 */       totalAssignPoint += value;
/*    */     }
/* 58 */     if (totalAssignPoint != PetManager.getInstance().getAutoAssignPointLimit()) {
/* 59 */       PetManager.logDebug("PSetAutoAddPotentialPref.processImp@pet set auto point totalassignpoint != 10|roleid=%d|totalAssignPoint=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(totalAssignPoint) });
/* 60 */       return false;
/*    */     }
/* 62 */     Map<Integer, Integer> xAssignMap = xPet.getAutospecialpointcase();
/* 63 */     xAssignMap.clear();
/* 64 */     int[] propTypeArr = { 25, 27, 26, 28, 29 };
/* 65 */     SAutoAddPotentialPrefRes res = new SAutoAddPotentialPrefRes();
/* 66 */     res.petid = this.petId;
/* 67 */     for (int propType : propTypeArr) {
/* 68 */       Integer value = (Integer)this.propMap.get(Integer.valueOf(propType));
/* 69 */       if (value == null) {
/* 70 */         value = Integer.valueOf(0);
/*    */       }
/* 72 */       xAssignMap.put(Integer.valueOf(propType), value);
/* 73 */       res.propmap.put(Integer.valueOf(propType), value);
/*    */     }
/* 75 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 77 */     PetOutFightObj outFightObj = new PetOutFightObj(this.roleId, xPet);
/* 78 */     xPet.setIsautospecialpoint(true);
/* 79 */     int oldMp = outFightObj.getFinalMaxMP();
/* 80 */     int oldHp = outFightObj.getFinalMaxHP();
/* 81 */     outFightObj.autoSpecialPoint();
/* 82 */     int changeMp = outFightObj.getFinalMaxMP() - oldMp;
/* 83 */     int changeHp = outFightObj.getFinalMaxHP() - oldHp;
/* 84 */     outFightObj.setHP(outFightObj.getHP() + changeHp);
/* 85 */     outFightObj.setMP(outFightObj.getMP() + changeMp);
/* 86 */     outFightObj.updateOutFightProperty();
/* 87 */     outFightObj.syncPetInfo();
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PSetAutoAddPotentialPref.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */