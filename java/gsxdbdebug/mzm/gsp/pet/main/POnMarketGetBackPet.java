/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.market.event.GetBackPetArg;
/*    */ import mzm.gsp.market.event.GetBackPetEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnMarketGetBackPet extends GetBackPetEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(((GetBackPetArg)this.arg).roleid, ((GetBackPetArg)this.arg).petId);
/* 14 */     String hostIp = GameServerInfoManager.getHostIP();
/* 15 */     String userId = RoleInterface.getUserId(((GetBackPetArg)this.arg).roleid);
/* 16 */     PetManager.addPetGetTlog(((GetBackPetArg)this.arg).roleid, hostIp, userId, ((GetBackPetArg)this.arg).petId, ((GetBackPetArg)this.arg).petCfgId, PetGetTLogEnum.MARKET_BACK, skillList.size());
/* 17 */     PetManager.addPetSkillChangeTlog(((GetBackPetArg)this.arg).roleid, hostIp, userId, ((GetBackPetArg)this.arg).petId, ((GetBackPetArg)this.arg).petCfgId, PetSkillChangeLogEnum.INIT, skillList);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnMarketGetBackPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */