/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.baitan.SSyncItemExpire;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.Item;
/*    */ import xbean.ShoppingInfo;
/*    */ import xbean.Shoppoingid2Sessionid;
/*    */ 
/*    */ public class ShoppingSession extends Session
/*    */ {
/*    */   private long shoppingId;
/*    */   
/*    */   public ShoppingSession(long interval, long shoppingId)
/*    */   {
/* 17 */     super(interval, shoppingId);
/* 18 */     this.shoppingId = shoppingId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     new ShoppingSessionPro(this.shoppingId).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class ShoppingSessionPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private long shoppingId;
/*    */     
/*    */     public ShoppingSessionPro(long shoppingid)
/*    */     {
/* 37 */       this.shoppingId = shoppingid;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 42 */       ShoppingInfo gridInfo = xtable.Roleshoppinginfo.select(Long.valueOf(this.shoppingId));
/* 43 */       if (gridInfo == null)
/*    */       {
/* 45 */         return false;
/*    */       }
/* 47 */       Map<Long, Long> shopMap = xtable.Role2grid.selectShoppingid2channelid(Long.valueOf(gridInfo.getRoleid()));
/* 48 */       if ((shopMap == null) || (shopMap.get(Long.valueOf(this.shoppingId)) == null))
/*    */       {
/* 50 */         return false;
/*    */       }
/* 52 */       Item item = gridInfo.getItem();
/*    */       
/* 54 */       SSyncItemExpire sSyncItemExpire = new SSyncItemExpire();
/* 55 */       sSyncItemExpire.shoppingid = this.shoppingId;
/* 56 */       OnlineManager.getInstance().send(gridInfo.getRoleid(), sSyncItemExpire);
/*    */       
/* 58 */       Shoppoingid2Sessionid shoppoingid2Sessionid = xtable.Role2shoppingsession.get(Long.valueOf(gridInfo.getRoleid()));
/* 59 */       if (shoppoingid2Sessionid != null)
/*    */       {
/* 61 */         shoppoingid2Sessionid.getShoppingid2sessionid().remove(Long.valueOf(this.shoppingId));
/*    */       }
/* 63 */       BaiTanManager.decItemGridnum(item.getCfgid());
/* 64 */       BaiTanManager.removeSCPI(item.getCfgid(), gridInfo.getPrice(), ((Long)shopMap.get(Long.valueOf(this.shoppingId))).longValue(), this.shoppingId);
/*    */       
/* 66 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\ShoppingSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */