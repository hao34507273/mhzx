/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.item.main.LotteryManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LotteryResult;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCAwardFinish extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int mapItemCfgid;
/*    */   
/*    */   public PCAwardFinish(long roleid, int mapItemCfgid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.mapItemCfgid = mapItemCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!MapInterface.isMapItemExist(this.mapItemCfgid))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     int type = 6;
/*    */     
/* 33 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 34 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 36 */     boolean luckyBagRet = LotteryManager.awardToRole(userid, this.roleid, 6);
/* 37 */     if (!luckyBagRet)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     Map<Integer, Integer> items = LotteryManager.getItemMap(this.roleid, 6);
/*    */     
/* 44 */     LotteryResult xLotteryResult = LotteryManager.removeLottery(this.roleid, 6);
/* 45 */     if (xLotteryResult == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     LuckyBagManager.worldBroadcast(this.roleid, this.mapItemCfgid, items);
/*    */     
/* 52 */     GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award lucky bag success|roleid=%d|map_item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapItemCfgid) }));
/*    */     
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PCAwardFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */