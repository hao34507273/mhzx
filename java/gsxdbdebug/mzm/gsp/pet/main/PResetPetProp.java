/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.pet.confbean.PetConstants;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PResetPetProp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   private final int clientItemNum;
/*    */   private final long yuanBaoNum;
/*    */   
/*    */   public PResetPetProp(long roleId, long petId, int clientItemNum, long yuanBaoNum)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.petId = petId;
/* 28 */     this.clientItemNum = clientItemNum;
/* 29 */     this.yuanBaoNum = yuanBaoNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     String userid = RoleInterface.getUserId(this.roleId);
/*    */     
/* 41 */     if (QingfuInterface.getBalance(userid, true) != this.yuanBaoNum) {
/* 42 */       return false;
/*    */     }
/* 44 */     TLogArg remArg = new TLogArg(LogReason.PET_RESET_PROP_REM);
/*    */     
/* 46 */     if (!ItemInterface.removeItemsByType(this.roleId, 17, 1, remArg)) {
/* 47 */       int money = ItemInterface.getItemYuanBaoPrice(PetConstants.getInstance().PET_RESET_PROP_ITEM_ID);
/* 48 */       if ((money <= 0) || (QingfuInterface.costYuanbao(userid, this.roleId, money, CostType.COST_BIND_FIRST_PET_RESET_PROP, remArg) != CostResult.Success))
/*    */       {
/* 50 */         PetManager.logDebug("PResetPetProp.processImp@cost yuanbao error|roleid=%d|yuanbaonum=%d|money=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.yuanBaoNum), Integer.valueOf(money) });
/* 51 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 55 */     PetOutFightObj pet = PetInterface.getPetOutFightObjById(this.roleId, this.petId);
/* 56 */     pet.resetPoint();
/* 57 */     pet.syncPetInfo();
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PResetPetProp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */