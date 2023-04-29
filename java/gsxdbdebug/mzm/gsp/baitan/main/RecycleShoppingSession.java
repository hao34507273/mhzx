/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.baitan.SSyncSellItemNotify;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.Item;
/*    */ import xbean.RoleGrid;
/*    */ import xbean.ShoppingInfo;
/*    */ import xbean.Shoppoingid2Sessionid;
/*    */ import xtable.Roleshoppinginfo;
/*    */ 
/*    */ public class RecycleShoppingSession extends Session
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public RecycleShoppingSession(long interval, long shoppingId, long roleId)
/*    */   {
/* 19 */     super(interval, shoppingId);
/* 20 */     this.roleid = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     new RecycleShoppingSessionPro(getOwerId(), this.roleid).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class RecycleShoppingSessionPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private long shoppingId;
/*    */     private long roleid;
/*    */     
/*    */     public RecycleShoppingSessionPro(long shoppingid, long roleId)
/*    */     {
/* 40 */       this.shoppingId = shoppingid;
/* 41 */       this.roleid = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       ShoppingInfo gridInfo = Roleshoppinginfo.select(Long.valueOf(this.shoppingId));
/* 48 */       if ((gridInfo == null) || (gridInfo.getRoleid() != this.roleid) || (gridInfo.getItem().getNumber() <= 0))
/*    */       {
/* 50 */         return false;
/*    */       }
/* 52 */       RoleGrid xRoleGrid = xtable.Role2grid.get(Long.valueOf(this.roleid));
/* 53 */       if ((xRoleGrid == null) || (!xRoleGrid.getNeedrecycleshoppingidsAsData().contains(Long.valueOf(this.shoppingId))))
/*    */       {
/* 55 */         return false;
/*    */       }
/* 57 */       long key = mzm.gsp.GameServerInfoManager.toGlobalId(gridInfo.getItem().getCfgid());
/* 58 */       xdb.Lockeys.lock(xtable.Item2prices.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(key) }));
/* 59 */       gridInfo = Roleshoppinginfo.get(Long.valueOf(this.shoppingId));
/* 60 */       if ((gridInfo == null) || (gridInfo.getRoleid() != this.roleid) || (gridInfo.getItem().getNumber() <= 0))
/*    */       {
/* 62 */         return false;
/*    */       }
/* 64 */       Item item = gridInfo.getItem();
/*    */       
/* 66 */       SSyncSellItemNotify sSyncSellItemNotify = new SSyncSellItemNotify();
/* 67 */       sSyncSellItemNotify.shoppingid = this.shoppingId;
/* 68 */       sSyncSellItemNotify.num = 0;
/* 69 */       sSyncSellItemNotify.sellnum = item.getNumber();
/* 70 */       OnlineManager.getInstance().send(this.roleid, sSyncSellItemNotify);
/*    */       
/* 72 */       item.setNumber(0);
/*    */       
/* 74 */       Shoppoingid2Sessionid shoppoingid2Sessionid = xtable.Role2shoppingsession.get(Long.valueOf(gridInfo.getRoleid()));
/* 75 */       if (shoppoingid2Sessionid != null)
/*    */       {
/* 77 */         shoppoingid2Sessionid.getShoppingid2sessionid().remove(Long.valueOf(this.shoppingId));
/*    */       }
/* 79 */       BaiTanManager.decItemGridnum(item.getCfgid());
/* 80 */       BaiTanManager.addItemSellMoney(item.getCfgid(), sSyncSellItemNotify.sellnum * gridInfo.getPrice(), sSyncSellItemNotify.sellnum);
/*    */       
/* 82 */       long channleId = ((Long)xRoleGrid.getShoppingid2channelid().get(Long.valueOf(this.shoppingId))).longValue();
/* 83 */       BaiTanManager.removeSCPI(item.getCfgid(), gridInfo.getPrice(), ((Long)xRoleGrid.getShoppingid2channelid().get(Long.valueOf(this.shoppingId))).longValue(), this.shoppingId);
/*    */       
/* 85 */       String logStr = String.format("[baitan]RecycleShoppingSessionPro.processImp@recycle role baitan item success|roleid=%d|itemid=%d|shoppingid=%d|channelid=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(item.getCfgid()), Long.valueOf(this.shoppingId), Long.valueOf(channleId), Integer.valueOf(gridInfo.getPrice()), Integer.valueOf(sSyncSellItemNotify.sellnum) });
/*    */       
/*    */ 
/*    */ 
/* 89 */       BaiTanManager.logger.info(logStr);
/* 90 */       BaiTanManager.tlogBaitanBuy(this.roleid, item.getCfgid(), sSyncSellItemNotify.sellnum, gridInfo.getPrice(), gridInfo.getRoleid());
/*    */       
/* 92 */       BaiTanManager.tlogBaitanBuyForIdip(0L, this.roleid, item.getCfgid(), sSyncSellItemNotify.sellnum, gridInfo.getPrice(), gridInfo.getItem().getUuidAsData(), this.shoppingId);
/*    */       
/*    */ 
/* 95 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\RecycleShoppingSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */