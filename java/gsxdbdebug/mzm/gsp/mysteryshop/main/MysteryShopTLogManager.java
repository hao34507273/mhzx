/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.MysteryGoodsInfo;
/*    */ import xbean.MysteryShopInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MysteryShopTLogManager
/*    */ {
/*    */   private static final String TLOG_MYSTERY_SHOP_REFRESH = "MysteryShopfreshLog";
/*    */   private static final String TLOG_MYSTERY_GOODS_BUY = "MysteryShopBuyGoodsLog";
/*    */   
/*    */   public static void tlogMysteryShopRefresh(long roleId, int shopType, int costType, int costNum, MysteryShopInfo mysteryShopInfo)
/*    */   {
/* 29 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 30 */     String userid = RoleInterface.getUserId(roleId);
/* 31 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 32 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/* 34 */     int refresh_times = mysteryShopInfo.getRefresh_times();
/* 35 */     StringBuffer sb = new StringBuffer();
/* 36 */     for (MysteryGoodsInfo goodsInfo : mysteryShopInfo.getGoods_list()) {
/* 37 */       sb.append("{");
/* 38 */       sb.append("goodsId=").append(goodsInfo.getGoods_id());
/* 39 */       sb.append(",sale=").append(goodsInfo.getSale());
/* 40 */       sb.append(",buyCount=").append(goodsInfo.getCount());
/* 41 */       sb.append("}");
/*    */     }
/*    */     
/* 44 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(serverLevel), Integer.valueOf(shopType), Integer.valueOf(costType), Integer.valueOf(costNum), Integer.valueOf(refresh_times), sb.toString() });
/*    */     
/* 46 */     TLogManager.getInstance().addLog(roleId, "MysteryShopfreshLog", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void tlogMysteryShopBuyGoods(long roleId, int shopType, int costType, int costNum, int buyCount, MysteryGoodsInfo goodsInfo)
/*    */   {
/* 58 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 59 */     String userid = RoleInterface.getUserId(roleId);
/* 60 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 61 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/* 63 */     StringBuffer sb = new StringBuffer();
/*    */     
/* 65 */     sb.append("{");
/* 66 */     sb.append("goodsId=").append(goodsInfo.getGoods_id());
/* 67 */     sb.append(",sale=").append(goodsInfo.getSale());
/* 68 */     sb.append(",buyCount=").append(goodsInfo.getCount());
/* 69 */     sb.append("}");
/*    */     
/*    */ 
/* 72 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(serverLevel), Integer.valueOf(shopType), Integer.valueOf(costType), Integer.valueOf(costNum), Integer.valueOf(buyCount), sb.toString() });
/*    */     
/*    */ 
/* 75 */     TLogManager.getInstance().addLog(roleId, "MysteryShopBuyGoodsLog", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\MysteryShopTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */