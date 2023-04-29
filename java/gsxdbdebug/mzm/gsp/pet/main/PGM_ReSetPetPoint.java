/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_ReSetPetPoint extends LogicProcedure
/*    */ {
/*    */   private final long operatorId;
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   
/*    */   public PGM_ReSetPetPoint(long operatorId, long roleId, long petId)
/*    */   {
/* 15 */     this.operatorId = operatorId;
/* 16 */     this.roleId = roleId;
/* 17 */     this.petId = petId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     xbean.Pet xPet = PetInterface.getXPetById(this.roleId, this.petId, true);
/* 24 */     if (xPet == null) {
/* 25 */       String logStr = String.format("PGM_ReSetPetPoint.process@not have pet! |roleId=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 26 */       sendMessage(this.operatorId, logStr.toString());
/* 27 */       return false;
/*    */     }
/* 29 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/*    */     
/* 31 */     pet.resetPoint();
/* 32 */     pet.syncPetInfo();
/*    */     
/* 34 */     String logStr = String.format("重置宠物加点成功！ |roleId=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 35 */     sendMessage(this.operatorId, logStr.toString());
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr) {
/* 40 */     if (gmroleid == -1L) {
/* 41 */       GameServer.logger().info(messageStr);
/*    */     } else {
/* 43 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_ReSetPetPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */