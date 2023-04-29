/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.FlowerPoint;
/*    */ import xtable.Role2flowerpoint;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginClearFlowerPoint
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long lastfreshtime = ItemGiveManager.getFlowerrefreshtime();
/* 16 */     FlowerPoint xFlowerPoint = Role2flowerpoint.get((Long)this.arg);
/* 17 */     if (xFlowerPoint == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     long cleartime = xFlowerPoint.getCleartime();
/* 22 */     if ((cleartime < lastfreshtime) || (!ItemGiveManager.isFlowerVersionRight(xFlowerPoint.getVersion())))
/*    */     {
/* 24 */       ItemGiveManager.clearFlowerPoint(((Long)this.arg).longValue(), xFlowerPoint, lastfreshtime);
/*    */     }
/*    */     else
/*    */     {
/* 28 */       int rank = GiveFlowerRankManager.getInstance().getRank(this.arg);
/* 29 */       if (rank == -1)
/*    */       {
/* 31 */         int giveFlowerPoint = xFlowerPoint.getGivepoint();
/* 32 */         RoleGiveFlowerChart roleGiveFlowerChart = new RoleGiveFlowerChart(((Long)this.arg).longValue(), giveFlowerPoint);
/* 33 */         GiveFlowerRankManager.getInstance().rank(roleGiveFlowerChart);
/*    */       }
/* 35 */       int r = ReceiveFlowerRankManager.getInstance().getRank(this.arg);
/* 36 */       if (r == -1)
/*    */       {
/* 38 */         int receiveFlowerPoint = xFlowerPoint.getReceivepoint();
/* 39 */         RoleReceiveFlowerChart roleReceiveFlowerChart = new RoleReceiveFlowerChart(((Long)this.arg).longValue(), receiveFlowerPoint);
/* 40 */         ReceiveFlowerRankManager.getInstance().rank(roleReceiveFlowerChart);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginClearFlowerPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */