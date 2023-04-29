/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.market.SQueryPubOrSellNumberRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PQueryPubOrSellNumberReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private Set<Integer> subids;
/*    */   private final int pubOrSell;
/*    */   
/*    */   public PQueryPubOrSellNumberReq(long roleid, Set<Integer> subids, int pubOrSell)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.subids = subids;
/* 19 */     this.pubOrSell = pubOrSell;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleid))
/*    */     {
/* 27 */       String logStr = String.format("[market]PQueryPubOrSellNumberReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 29 */       MarketManager.logger.info(logStr);
/* 30 */       return false;
/*    */     }
/* 32 */     SQueryPubOrSellNumberRes res = new SQueryPubOrSellNumberRes();
/* 33 */     res.puborsell = this.pubOrSell;
/* 34 */     Iterator i$; Iterator i$; if (this.pubOrSell == 0)
/*    */     {
/* 36 */       for (i$ = this.subids.iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*    */         
/* 38 */         if (MarketManager.isLevelSift(subid))
/*    */         {
/* 40 */           res.subid2num.put(Integer.valueOf(subid), Integer.valueOf(LevelSiftRankManager.getPubSize(subid)));
/*    */         }
/*    */         else
/*    */         {
/* 44 */           res.subid2num.put(Integer.valueOf(subid), Integer.valueOf(PriceRankManager.getPubSize(subid)));
/*    */         }
/*    */         
/*    */       }
/*    */       
/*    */     }
/*    */     else {
/* 51 */       for (i$ = this.subids.iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*    */         
/* 53 */         if (MarketManager.isLevelSift(subid))
/*    */         {
/* 55 */           res.subid2num.put(Integer.valueOf(subid), Integer.valueOf(LevelSiftRankManager.getSellSize(subid)));
/*    */         }
/*    */         else
/*    */         {
/* 59 */           res.subid2num.put(Integer.valueOf(subid), Integer.valueOf(PriceRankManager.getSellSize(subid)));
/*    */         }
/*    */       }
/*    */     }
/* 63 */     OnlineManager.getInstance().send(this.roleid, res);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryPubOrSellNumberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */