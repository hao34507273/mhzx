/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.pet.main.PetBag;
/*    */ import mzm.gsp.pet.main.PetFightTeam;
/*    */ import mzm.gsp.pet.main.PetFightTeam.Position;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pet;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PGM_FPetFight extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long activeRoleId;
/*    */   private final long targetRoleId;
/*    */   
/*    */   public PGM_FPetFight(long activeRoleId, long targetRoleId)
/*    */   {
/* 22 */     this.activeRoleId = activeRoleId;
/* 23 */     this.targetRoleId = targetRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     Set<Long> allRoles = new java.util.HashSet();
/* 30 */     allRoles.add(Long.valueOf(this.activeRoleId));
/* 31 */     allRoles.add(Long.valueOf(this.targetRoleId));
/*    */     
/* 33 */     lock(Basic.getTable(), allRoles);
/*    */     
/* 35 */     FightInterface.PetFightInfo activePetFightInfo = getPetFightInfo(this.activeRoleId);
/* 36 */     if (activePetFightInfo == null) {
/* 37 */       return false;
/*    */     }
/* 39 */     FightInterface.PetFightInfo passivePetCloneFightInfo = getPetFightInfo(this.targetRoleId);
/* 40 */     if (passivePetCloneFightInfo == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     FightContext context = new FPetTestFightContext();
/*    */     
/* 45 */     FightInterface.startPetCVCFight(activePetFightInfo, passivePetCloneFightInfo, context, 1, FightReason.GM);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   private FightInterface.PetFightInfo getPetFightInfo(long roleId) {
/* 51 */     PetBag bag = PetInterface.getPetBag(roleId, true);
/* 52 */     if (bag == null) {
/* 53 */       GameServer.logger().error(String.format("[pet]PGM_FPetFight.getPetFightInfo@petbag is null|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 55 */       return null;
/*    */     }
/* 57 */     Map<Long, Pet> allPets = bag.getAllPets();
/* 58 */     if (allPets.size() <= 0) {
/* 59 */       return null;
/*    */     }
/* 61 */     Set<Map.Entry<Long, Pet>> allPetsEntrySet = allPets.entrySet();
/* 62 */     FightInterface.PetFightInfo fightInfo = new FightInterface.PetFightInfo();
/* 63 */     fightInfo.roleId = roleId;
/* 64 */     fightInfo.zhenfaInfo = new PetFightTeam(0, 0);
/* 65 */     int count = 0;
/* 66 */     int posStartIndex = 9;
/* 67 */     for (Map.Entry<Long, Pet> entry : allPetsEntrySet) {
/* 68 */       count++;
/*    */       
/* 70 */       if (count > 5) {
/*    */         break;
/*    */       }
/* 73 */       Pet xPet = (Pet)entry.getValue();
/* 74 */       int petFightSkillId = 0;
/* 75 */       int posIndex = posStartIndex--;
/* 76 */       PetFightTeam.Position posInfo = new PetFightTeam.Position(xPet.getId(), 0, posIndex);
/* 77 */       fightInfo.zhenfaInfo.positions.put(Integer.valueOf(posIndex), posInfo);
/*    */     }
/*    */     
/* 80 */     return fightInfo;
/*    */   }
/*    */   
/*    */   public final class FPetTestFightContext implements FightContext {
/*    */     public FPetTestFightContext() {}
/*    */     
/*    */     public boolean isRecordEnable() {
/* 87 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_FPetFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */