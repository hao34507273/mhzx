/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.bag.confbean.SBagCfg;
/*    */ import mzm.gsp.bag.confbean.SBagExpendCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SExpandPetDepotRes;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PetDepot;
/*    */ import xtable.Role2petdepot;
/*    */ 
/*    */ public class PExpandDepot extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int clientItemNum;
/*    */   private final long clientYuanBaoNum;
/*    */   
/*    */   public PExpandDepot(long roleId, int clientItemNum, long clientYuanBaoNum)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.clientItemNum = clientItemNum;
/* 28 */     this.clientYuanBaoNum = clientYuanBaoNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     String userid = RoleInterface.getUserId(this.roleId);
/*    */     
/* 40 */     if (this.clientYuanBaoNum != QingfuInterface.getBalance(userid, true)) {
/* 41 */       PetManager.logDebug("PExpandDepot.processImp@cyuanbao not match syuanbao|roleid=%d|clientYuanBaoNum=%d|serverYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.clientYuanBaoNum), Long.valueOf(QingfuInterface.getBalance(userid, false)) });
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SBagCfg sBagCfg = SBagCfg.get(340600004);
/* 46 */     int itemNum = ItemInterface.getItemNumberById(this.roleId, sBagCfg.expendItemId);
/* 47 */     if (itemNum != this.clientItemNum) {
/* 48 */       PetManager.logDebug("PExpandDepot.processImp@itemnum not match |roleid=%d|itemNum=%d|clientItemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemNum), Integer.valueOf(this.clientItemNum) });
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     PetDepot xDepot = Role2petdepot.get(Long.valueOf(this.roleId));
/* 53 */     if (xDepot == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     if (xDepot.getDepotsize() >= sBagCfg.maxcapacity) {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     int expandCount = (xDepot.getDepotsize() - sBagCfg.initcapacity) / sBagCfg.addCount + 1;
/* 61 */     SBagExpendCfg expandCfg = null;
/* 62 */     for (SBagExpendCfg cfg : SBagExpendCfg.getAll().values()) {
/* 63 */       if ((cfg.bagId == sBagCfg.id) && (cfg.expendCount == expandCount)) {
/* 64 */         expandCfg = cfg;
/* 65 */         break;
/*    */       }
/*    */     }
/* 68 */     if (expandCfg == null) {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     if (!PetManager.getInstance().removeItemAndYuanBao(userid, this.roleId, sBagCfg.expendItemId, expandCfg.itemCount, CostType.COST_BIND_FIRST_PET_EXPEND_DEPOT, new TLogArg(LogReason.PET_EXPEND_DEPOT_REM)))
/*    */     {
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     xDepot.setDepotsize(xDepot.getDepotsize() + sBagCfg.addCount);
/* 78 */     SExpandPetDepotRes res = new SExpandPetDepotRes();
/* 79 */     res.depotsize = xDepot.getDepotsize();
/* 80 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 82 */     PetManager.logInfo("PExpandDepot.processImp@expand pet depot success!|" + this.roleId + "|" + res.depotsize + "|" + sBagCfg.addCount, new Object[0]);
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PExpandDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */