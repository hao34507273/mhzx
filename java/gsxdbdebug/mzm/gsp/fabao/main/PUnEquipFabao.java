/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fabao.SSynFaBaoChangeInfo;
/*    */ import mzm.gsp.fabao.SUnEquipFabaoErrorRes;
/*    */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*    */ import mzm.gsp.item.main.FabaoItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Item;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class PUnEquipFabao extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fabaotype;
/*    */   
/*    */   public PUnEquipFabao(long roleid, int fabaotype)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.fabaotype = fabaotype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 33 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*    */     {
/* 35 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/* 36 */       return false;
/*    */     }
/* 38 */     if (FabaoManager.checkInCross(this.roleid)) {
/* 39 */       sendErrorRes(2);
/* 40 */       return false;
/*    */     }
/* 42 */     RoleFabaoSysInfo xFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/* 43 */     Item xItem = (Item)xFabaoSysInfo.getFabaomap().remove(Integer.valueOf(this.fabaotype));
/* 44 */     if (xItem == null) {
/* 45 */       sendErrorRes(0);
/* 46 */       return false;
/*    */     }
/* 48 */     FabaoItem fabaoItem = new FabaoItem(xItem);
/* 49 */     boolean ret = ItemInterface.moveItemInBag(this.roleid, 340600006, fabaoItem);
/* 50 */     if (!ret) {
/* 51 */       sendErrorRes(1);
/* 52 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 56 */     SSynFaBaoChangeInfo synFaBaoChangeInfo = new SSynFaBaoChangeInfo();
/* 57 */     synFaBaoChangeInfo.fabaochangeinfo.removed.add(Integer.valueOf(this.fabaotype));
/* 58 */     OnlineManager.getInstance().send(this.roleid, synFaBaoChangeInfo);
/*    */     
/*    */ 
/* 61 */     if (this.fabaotype == xFabaoSysInfo.getDisfabaotype()) {
/* 62 */       int fabaoType = 0;
/* 63 */       int fabaoCfgid = 0;
/* 64 */       for (Map.Entry<Integer, Item> entry : xFabaoSysInfo.getFabaomap().entrySet()) {
/* 65 */         if (fabaoType == 0) {
/* 66 */           fabaoType = ((Integer)entry.getKey()).intValue();
/* 67 */           fabaoCfgid = ((Item)entry.getValue()).getCfgid();
/*    */         } else {
/* 69 */           int tempType = ((Integer)entry.getKey()).intValue();
/* 70 */           if (tempType < fabaoType) {
/* 71 */             fabaoType = tempType;
/* 72 */             fabaoCfgid = ((Item)entry.getValue()).getCfgid();
/*    */           }
/*    */         }
/*    */       }
/* 76 */       FabaoManager.onFaBaoDisplayChange(this.roleid, xFabaoSysInfo, fabaoCfgid, fabaoType);
/*    */     }
/* 78 */     Set<Integer> fabaotypes = new HashSet();
/* 79 */     fabaotypes.add(Integer.valueOf(this.fabaotype));
/* 80 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(this.roleid, fabaotypes);
/* 81 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/* 83 */     FabaoManager.tlogEquipFabao(this.roleid, 2, fabaoItem.getCfgId(), fabaoItem.getFirstUuid().longValue(), this.fabaotype);
/*    */     
/* 85 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int error) {
/* 89 */     SUnEquipFabaoErrorRes unEquipFabaoErrorRes = new SUnEquipFabaoErrorRes();
/* 90 */     unEquipFabaoErrorRes.errorcode = error;
/* 91 */     OnlineManager.getInstance().sendAtOnce(this.roleid, unEquipFabaoErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PUnEquipFabao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */