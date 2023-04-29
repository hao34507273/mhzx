/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*    */ import mzm.gsp.christmasstocking.SSynRoleStockingInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Role2ChristmasStockingInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PStockingOnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((Long)this.arg).longValue();
/* 18 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 19 */     if (null == userId)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/* 24 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*    */     
/*    */ 
/* 27 */     int activityId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/* 28 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/* 29 */     if ((!res.isCanJoin()) && (!res.isActivityNotOpen()) && (!res.isActivityJoinCountMax()))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     Role2ChristmasStockingInfo xRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(roleId);
/* 35 */     if (!ChristmasStockingManager.isActivityOpenOrNeedRetain())
/*    */     {
/*    */ 
/* 38 */       if (xRole2StockingInfo.getHangstockinghistoryinfos().size() > 0)
/*    */       {
/* 40 */         xRole2StockingInfo.getHangstockinghistoryinfos().clear();
/*    */       }
/* 42 */       return true;
/*    */     }
/*    */     
/* 45 */     SSynRoleStockingInfo proto = new SSynRoleStockingInfo();
/* 46 */     proto.total_hang_num = ChristmasStockingManager.getTotalHangNum(xRole2StockingInfo);
/* 47 */     OnlineManager.getInstance().send(roleId, proto);
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PStockingOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */