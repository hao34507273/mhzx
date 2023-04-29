/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import xbean.Role2PetBean;
/*    */ 
/*    */ public class POnDeletePetOutFightBean extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long petId;
/*    */   
/*    */   public POnDeletePetOutFightBean(long roleId, long petId) {
/* 11 */     this.roleId = roleId;
/* 12 */     this.petId = petId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Role2PetBean xRole2Pet = xtable.Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 18 */     if (xRole2Pet == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     if (xRole2Pet.getBeanmap().remove(Long.valueOf(this.petId)) != null) {
/* 22 */       return true;
/*    */     }
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnDeletePetOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */