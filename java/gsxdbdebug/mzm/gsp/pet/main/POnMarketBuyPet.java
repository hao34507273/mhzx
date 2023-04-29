/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.market.event.BuyPetArg;
/*    */ import mzm.gsp.market.event.BuyPetEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnMarketBuyPet extends BuyPetEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(((BuyPetArg)this.arg).roleid, ((BuyPetArg)this.arg).petId);
/* 14 */     String hostIp = GameServerInfoManager.getHostIP();
/* 15 */     String userId = RoleInterface.getUserId(((BuyPetArg)this.arg).roleid);
/* 16 */     PetManager.addPetGetTlog(((BuyPetArg)this.arg).roleid, hostIp, userId, ((BuyPetArg)this.arg).petId, ((BuyPetArg)this.arg).petCfgId, PetGetTLogEnum.MARKET_BUY, skillList.size());
/* 17 */     PetManager.addPetSkillChangeTlog(((BuyPetArg)this.arg).roleid, hostIp, userId, ((BuyPetArg)this.arg).petId, ((BuyPetArg)this.arg).petCfgId, PetSkillChangeLogEnum.INIT, skillList);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnMarketBuyPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */