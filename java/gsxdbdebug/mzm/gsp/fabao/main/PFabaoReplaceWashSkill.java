/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fabao.SFabaReplaceWashSkillErrorRes;
/*    */ import mzm.gsp.fabao.SFabaoReplaceWashSkillRes;
/*    */ import mzm.gsp.item.confbean.SFabaoItem;
/*    */ import mzm.gsp.item.main.FabaoItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.Item;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class PFabaoReplaceWashSkill extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int equiped;
/*    */   private final long fabaouuid;
/*    */   
/*    */   public PFabaoReplaceWashSkill(long roleid, int equiped, long fabaouuid)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.equiped = equiped;
/* 26 */     this.fabaouuid = fabaouuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*    */     {
/* 33 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/* 34 */       return false;
/*    */     }
/* 36 */     if (FabaoManager.checkInCross(this.roleid)) {
/* 37 */       sendErrorRes(3);
/* 38 */       return false;
/*    */     }
/* 40 */     boolean isEquiped = this.equiped == 1;
/*    */     
/* 42 */     FabaoItem fabaoItem = null;
/* 43 */     if (isEquiped) {
/* 44 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/* 45 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/* 46 */         Item xItem = (Item)entry.getValue();
/* 47 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/* 48 */           fabaoItem = new FabaoItem(xItem);
/* 49 */           break;
/*    */         }
/*    */       }
/*    */     } else {
/* 53 */       mzm.gsp.item.main.BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, 340600006, this.fabaouuid);
/* 54 */       if (!(basicItem instanceof FabaoItem)) {
/* 55 */         sendErrorRes(1);
/* 56 */         return false;
/*    */       }
/* 58 */       fabaoItem = (FabaoItem)basicItem;
/*    */     }
/*    */     
/* 61 */     if (fabaoItem == null) {
/* 62 */       sendErrorRes(1);
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     FabaoManager.checkWashSkillId(fabaoItem);
/* 67 */     int washSkillid = fabaoItem.getWashSkillId();
/* 68 */     if (washSkillid <= 0) {
/* 69 */       sendErrorRes(2);
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     fabaoItem.setWashSkillId(0);
/* 74 */     fabaoItem.setOwnSkillid(washSkillid);
/* 75 */     SFabaoReplaceWashSkillRes sFabaoReplaceWashSkillRes = new SFabaoReplaceWashSkillRes();
/* 76 */     sFabaoReplaceWashSkillRes.equiped = this.equiped;
/* 77 */     sFabaoReplaceWashSkillRes.fabaouuid = this.fabaouuid;
/* 78 */     sFabaoReplaceWashSkillRes.skillid = washSkillid;
/* 79 */     OnlineManager.getInstance().send(this.roleid, sFabaoReplaceWashSkillRes);
/*    */     
/* 81 */     if (isEquiped) {
/* 82 */       FabaoManager.onEquipFabaoChanged(this.roleid, fabaoItem, SFabaoItem.get(fabaoItem.getCfgId()));
/*    */     }
/* 84 */     FabaoManager.tlogFabaoWash(this.roleid, 2, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), 0, 0, washSkillid);
/*    */     
/* 86 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int error) {
/* 90 */     SFabaReplaceWashSkillErrorRes sFabaReplaceWashSkillErrorRes = new SFabaReplaceWashSkillErrorRes();
/* 91 */     sFabaReplaceWashSkillErrorRes.retcode = error;
/* 92 */     OnlineManager.getInstance().sendAtOnce(this.roleid, sFabaReplaceWashSkillErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoReplaceWashSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */