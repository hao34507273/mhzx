/*    */ package mzm.gsp.petmark.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PetMoveToDepotProcedure;
/*    */ import xbean.Role2PetMarkInfo;
/*    */ 
/*    */ public class POnPetMoveToDepot
/*    */   extends PetMoveToDepotProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(((PetEventArg)this.arg).roleId);
/* 14 */     Map<Long, Long> petid2petmarkid = xRole2PetMarkInfo.getPetid2petmarkid();
/* 15 */     Long equipedPetMarkId = (Long)petid2petmarkid.get(Long.valueOf(((PetEventArg)this.arg).petId));
/* 16 */     if (null == equipedPetMarkId)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 22 */     PetMarkManager.unequipPetMark(((PetEventArg)this.arg).roleId, equipedPetMarkId.longValue(), xRole2PetMarkInfo, PetMarkManager.UnequipPetMarkReason.PET_REMOVE);
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\POnPetMoveToDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */