/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.auction.confbean.OrigAuctionItemCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AucItemInfo;
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
/*    */ 
/*    */ public class AuctionItemBeforeBidEndSession
/*    */   extends Session
/*    */ {
/*    */   final int activityId;
/*    */   final int turnIndex;
/*    */   final int auctionItemCfgId;
/*    */   
/*    */   public AuctionItemBeforeBidEndSession(long interval, long roleId, int activityId, int turnIndex, int auctionItemCfgId)
/*    */   {
/* 36 */     super(interval, roleId);
/* 37 */     this.activityId = activityId;
/* 38 */     this.turnIndex = turnIndex;
/* 39 */     this.auctionItemCfgId = auctionItemCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 45 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityId), new PAuctionItemBeforeBidEnd());
/*    */   }
/*    */   
/*    */   class PAuctionItemBeforeBidEnd extends LogicProcedure
/*    */   {
/*    */     PAuctionItemBeforeBidEnd() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 54 */       if (!OpenInterface.getOpenStatus(534))
/*    */       {
/* 56 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 60 */       AucItemInfo xAucItemInfo = AuctionManager.getAucItemInfo(AuctionItemBeforeBidEndSession.this.activityId, AuctionItemBeforeBidEndSession.this.turnIndex, AuctionItemBeforeBidEndSession.this.auctionItemCfgId, true);
/* 61 */       if (xAucItemInfo == null)
/*    */       {
/* 63 */         return false;
/*    */       }
/* 65 */       OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(xAucItemInfo.getItemcfgid());
/* 66 */       if (auctionItemCfg == null)
/*    */       {
/* 68 */         return false;
/*    */       }
/*    */       
/* 71 */       AuctionManager.sendBulletinInfo(auctionItemCfg.itemCfgId, 49);
/*    */       
/*    */ 
/* 74 */       Session session = new AuctionItemBidEndSession(TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()), AuctionItemBeforeBidEndSession.this.auctionItemCfgId, AuctionItemBeforeBidEndSession.this.activityId, AuctionItemBeforeBidEndSession.this.turnIndex, AuctionItemBeforeBidEndSession.this.auctionItemCfgId);
/*    */       
/*    */ 
/* 77 */       xAucItemInfo.setBidendsessionid(session.getSessionId());
/*    */       
/* 79 */       GameServer.logger().info(String.format("[auction]AuctionItemBeforeBidEndSession.PAuctionItemBeforeBidEnd.processImp@ time out|activityId=%d|turnId=%d|auctionItemCfgId=%d|currentTimeStamp=%s", new Object[] { Integer.valueOf(AuctionItemBeforeBidEndSession.this.activityId), Integer.valueOf(AuctionItemBeforeBidEndSession.this.turnIndex), Integer.valueOf(AuctionItemBeforeBidEndSession.this.auctionItemCfgId), DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(DateTimeUtils.getCurrTimeInMillis())) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 84 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionItemBeforeBidEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */