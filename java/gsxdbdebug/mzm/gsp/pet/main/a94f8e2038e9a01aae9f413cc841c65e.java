/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xbean.PetSkill;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a94f8e2038e9a01aae9f413cc841c65e
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int pos;
/*    */   private final int id;
/*    */   
/*    */   public a94f8e2038e9a01aae9f413cc841c65e(long roleId, int pos, int id)
/*    */   {
/* 39 */     this.roleId = roleId;
/* 40 */     this.pos = pos;
/* 41 */     this.id = id;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 47 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 48 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(xPetBag.getFightpet()));
/* 49 */     PetSkill xPetSkill = Pod.newPetSkill();
/* 50 */     xPetSkill.setSkillid(this.id);
/* 51 */     xPetSkill.setSkillfrom(this.pos);
/* 52 */     xPet.getSkilllist().add(xPetSkill);
/* 53 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 54 */     pet.updatePassiveSkill();
/* 55 */     pet.updateSoul();
/* 56 */     pet.syncPetInfo();
/* 57 */     GmManager.getInstance().sendResultToGM(this.roleId, "宠物增加技能成功");
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\a94f8e2038e9a01aae9f413cc841c65e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */