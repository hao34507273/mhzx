/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*    */ import mzm.gsp.item.SUseMarriageSugerItem;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.confbean.SMarriageSugerItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCUseMarriageSugerItem extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long uuid;
/*    */   
/*    */   public PCUseMarriageSugerItem(long roleid, long uuid)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 31 */       String logStr = String.format("[item]PCUseMarriageSugerItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 32 */       ItemManager.logger.info(logStr);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     String userid = RoleInterface.getUserId(this.roleid);
/* 37 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 39 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 40 */     if (item == null) {
/* 41 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 42 */       return false;
/*    */     }
/* 44 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/* 45 */     if ((itemCfg == null) || (itemCfg.type != 74)) {
/* 46 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 47 */       return false;
/*    */     }
/* 49 */     SMarriageSugerItem marriageSugerItem = SMarriageSugerItem.get(itemCfg.id);
/* 50 */     if (marriageSugerItem == null) {
/* 51 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     int count = ItemInterface.getItemUseCount(this.roleid, marriageSugerItem.id);
/* 56 */     if (count >= marriageSugerItem.useCount) {
/* 57 */       ItemManager.sendWrongInfo(this.roleid, 103, new String[] { String.valueOf(item.getCfgId()), String.valueOf(marriageSugerItem.useCount) });
/*    */       
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_MARRIAGE_SUGER_REM);
/* 63 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 64 */     if (ret) {
/* 65 */       ItemManager.addItemUseCount(this.roleid, marriageSugerItem.id, 1);
/* 66 */       AwardPoolResultData awardPoolResultData = mzm.gsp.awardpool.main.AwardPoolInterface.getAwardPoolData(marriageSugerItem.awardpoolTypeid, this.roleid, RoleInterface.getLevel(this.roleid));
/*    */       
/* 68 */       if (awardPoolResultData == null) {
/* 69 */         return false;
/*    */       }
/* 71 */       TLogArg awardLogArg = new TLogArg(LogReason.ITEM_USE_MARRIAGE_SUGER_ADD);
/* 72 */       ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, awardPoolResultData.getItemMap(), false, awardLogArg);
/*    */       
/* 74 */       boolean isBagFull = itemOperateResult.isBagFull();
/* 75 */       if ((itemOperateResult.success()) || (isBagFull)) {
/* 76 */         SUseMarriageSugerItem useMarriageSugerItem = new SUseMarriageSugerItem();
/* 77 */         if (isBagFull) {
/* 78 */           useMarriageSugerItem.isbagfull = 1;
/*    */         } else {
/* 80 */           useMarriageSugerItem.isbagfull = 0;
/*    */         }
/* 82 */         useMarriageSugerItem.item2count.putAll(awardPoolResultData.getItemMap());
/* 83 */         OnlineManager.getInstance().send(this.roleid, useMarriageSugerItem);
/* 84 */         ret = true;
/*    */       } else {
/* 86 */         ret = false;
/*    */       }
/*    */     }
/* 89 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseMarriageSugerItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */