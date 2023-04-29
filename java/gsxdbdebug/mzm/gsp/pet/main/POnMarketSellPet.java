/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.market.event.SellPetArg;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerDeletePet;
/*    */ 
/*    */ public class POnMarketSellPet extends mzm.gsp.market.event.SellPetEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 13 */     PetEventArg deleteArg = new PetEventArg();
/* 14 */     deleteArg.petId = ((SellPetArg)this.arg).petId;
/* 15 */     deleteArg.roleId = ((SellPetArg)this.arg).roleid;
/* 16 */     deleteArg.enventType = PetDeleteTLogEnum.MARKET_SELL.value;
/* 17 */     TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, deleteArg);
/*    */     
/*    */ 
/* 20 */     PetManager.addPetDeleteTlog(((SellPetArg)this.arg).roleid, ((SellPetArg)this.arg).petId, ((SellPetArg)this.arg).petCfgId, PetDeleteTLogEnum.MARKET_SELL);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnMarketSellPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */