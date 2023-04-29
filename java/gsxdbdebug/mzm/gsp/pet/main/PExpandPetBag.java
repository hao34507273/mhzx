/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.bag.confbean.SBagCfg;
/*    */ import mzm.gsp.bag.confbean.SBagExpendCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SExpandPetBagRes;
/*    */ import mzm.gsp.pet.event.ExtendPetBag;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PExpandPetBag extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int clientItemNum;
/*    */   private final long clientYuanBaoNum;
/*    */   
/*    */   public PExpandPetBag(long roleId, int clientItemNum, long clientYuanBaoNum)
/*    */   {
/* 32 */     this.roleId = roleId;
/* 33 */     this.clientItemNum = clientItemNum;
/* 34 */     this.clientYuanBaoNum = clientYuanBaoNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 531, true)) {
/* 45 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/* 46 */       GameServer.logger().error(String.format("[pet]PExpandPetBag.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*    */       
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     String userid = RoleInterface.getUserId(this.roleId);
/* 52 */     if (this.clientYuanBaoNum != QingfuInterface.getBalance(userid, true)) {
/* 53 */       PetManager.logDebug("PExpandPetBag.processImp@cyuanbao not match syuanbao|roleid=%d|clientYuanBaoNum=%d|serverYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.clientYuanBaoNum), Long.valueOf(QingfuInterface.getBalance(userid, false)) });
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     SBagCfg sBagCfg = SBagCfg.get(340600003);
/* 58 */     int itemNum = ItemInterface.getItemNumberById(this.roleId, sBagCfg.expendItemId);
/* 59 */     if (itemNum != this.clientItemNum) {
/* 60 */       PetManager.logDebug("PExpandPetBag.processImp@itemnum not match |roleid=%d|itemNum=%d|clientItemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemNum), Integer.valueOf(this.clientItemNum) });
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 65 */     if (xPetBag == null) {
/* 66 */       return false;
/*    */     }
/* 68 */     if (xPetBag.getBagsize() >= sBagCfg.maxcapacity) {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     int expandCount = (xPetBag.getBagsize() - sBagCfg.initcapacity) / sBagCfg.addCount + 1;
/* 73 */     SBagExpendCfg expandCfg = null;
/* 74 */     for (SBagExpendCfg cfg : SBagExpendCfg.getAll().values()) {
/* 75 */       if ((cfg.bagId == sBagCfg.id) && (cfg.expendCount == expandCount)) {
/* 76 */         expandCfg = cfg;
/* 77 */         break;
/*    */       }
/*    */     }
/* 80 */     if (expandCfg == null) {
/* 81 */       return false;
/*    */     }
/*    */     
/* 84 */     if (!PetManager.getInstance().removeItemAndYuanBao(userid, this.roleId, sBagCfg.expendItemId, expandCfg.itemCount, CostType.COST_BIND_FIRST_PET_EXPEND_BAG, new TLogArg(LogReason.PET_EXPEND_BAG_REM)))
/*    */     {
/* 86 */       return false;
/*    */     }
/*    */     
/* 89 */     xPetBag.setBagsize(xPetBag.getBagsize() + sBagCfg.addCount);
/* 90 */     SExpandPetBagRes res = new SExpandPetBagRes();
/* 91 */     res.bagsize = xPetBag.getBagsize();
/* 92 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 94 */     TriggerEventsManger.getInstance().triggerEvent(new ExtendPetBag(), Long.valueOf(this.roleId));
/*    */     
/* 96 */     PetManager.logInfo("PExpandPetBag.processImp@expand pet bag success!|" + this.roleId + "|" + res.bagsize + "|" + sBagCfg.addCount, new Object[0]);
/*    */     
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PExpandPetBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */