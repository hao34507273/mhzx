/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SGetTargetPetInfoRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class PGetTargetPetInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long petId;
/*    */   private long targetId;
/*    */   
/*    */   public PGetTargetPetInfoReq(long roleId, long petId, long targetId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.petId = petId;
/* 21 */     this.targetId = targetId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetId) }));
/*    */     
/* 29 */     PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(this.targetId, this.petId);
/* 30 */     if (petOutFightObj == null) {
/* 31 */       Pet pet = PetInterface.getDepotPetByPetId(this.roleId, this.petId, false);
/* 32 */       if (pet != null) {
/* 33 */         petOutFightObj = new PetOutFightObj(this.roleId, pet.xPet);
/*    */       } else {
/* 35 */         return false;
/*    */       }
/*    */     }
/* 38 */     SGetTargetPetInfoRes res = new SGetTargetPetInfoRes();
/* 39 */     petOutFightObj.fillPetInfo(res.petinfo);
/* 40 */     OnlineManager.getInstance().send(this.roleId, res);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGetTargetPetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */