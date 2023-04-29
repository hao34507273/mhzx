/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xbean.PetDepot;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     xtable.Role2petoutfightbean.remove((Long)this.arg);
/*    */     
/* 14 */     Pet xPet = PetManager.getMaxPetScore(((Long)this.arg).longValue());
/* 15 */     if (xPet != null) {
/* 16 */       TLogManager.getInstance().addLog(((Long)this.arg).longValue(), "PetScore", PetManager.createTLog(new Object[] { mzm.gsp.GameServerInfoManager.getHostIP(), mzm.gsp.role.main.RoleInterface.getUserId(((Long)this.arg).longValue()), this.arg, Long.valueOf(xPet.getId()), Integer.valueOf(xPet.getTemplateid()), Integer.valueOf(xPet.getYaoli()) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 25 */     PetBag xPetBag = xtable.Role2petbag.get((Long)this.arg);
/* 26 */     if (xPetBag == null) {
/* 27 */       xPetBag = PetManager.getInstance().createPetBag(((Long)this.arg).longValue());
/*    */     }
/*    */     
/* 30 */     PetDepot xPetDepot = xtable.Role2petdepot.get((Long)this.arg);
/* 31 */     if (xPetDepot == null) {
/* 32 */       xPetDepot = PetManager.getInstance().createDepot(((Long)this.arg).longValue());
/*    */     }
/*    */     
/* 35 */     PetManager.checkPetPointError(((Long)this.arg).longValue(), xPetBag.getPetmap(), xPetDepot.getPetmap());
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */