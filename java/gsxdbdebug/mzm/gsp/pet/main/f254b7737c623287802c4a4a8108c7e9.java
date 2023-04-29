/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pet;
/*    */ import xbean.PetSkill;
/*    */ import xbean.Pod;
/*    */ 
/*    */ 
/*    */ public class f254b7737c623287802c4a4a8108c7e9
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int operatorId;
/*    */   private final int pos;
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   
/*    */   public f254b7737c623287802c4a4a8108c7e9(int operatorId, long roleId, long petId, int pos)
/*    */   {
/* 22 */     this.operatorId = operatorId;
/* 23 */     this.roleId = roleId;
/* 24 */     this.petId = petId;
/* 25 */     this.pos = pos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     Pet xPet = PetInterface.getXPetById(this.roleId, this.petId, true);
/* 32 */     if (xPet == null)
/*    */     {
/* 34 */       String logStr = String.format("PGM_ReSetPetPoint.process@not have pet! |roleId=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 35 */       sendMessage(this.operatorId, logStr.toString());
/* 36 */       return false;
/*    */     }
/* 38 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 39 */     PetSkill xPetSkill = Pod.newPetSkill();
/* 40 */     xPetSkill.setSkillid(this.operatorId);
/* 41 */     xPetSkill.setSkillfrom(this.pos);
/* 42 */     pet.getOccupationId1(this.operatorId);
/* 43 */     pet.syncPetInfo();
/*    */     
/* 45 */     String logStr = String.format("修改HP成功！ |roleId=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 46 */     sendMessage(this.operatorId, logStr.toString());
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr)
/*    */   {
/* 52 */     if (gmroleid == -1L) {
/* 53 */       GameServer.logger().info(messageStr);
/*    */     } else {
/* 55 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\f254b7737c623287802c4a4a8108c7e9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */