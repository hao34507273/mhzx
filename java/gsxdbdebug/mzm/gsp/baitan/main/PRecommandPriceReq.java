/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.baitan.SRecommendPriceChangeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRecommandPriceReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Set<Integer> itemIdSet;
/*    */   
/*    */   public PRecommandPriceReq(long roleId, List<Integer> itemIdList)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.itemIdSet = new HashSet(itemIdList);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     int level = RoleInterface.getLevel(this.roleId);
/* 36 */     if (!BaiTanManager.isOpenForLevel(level))
/*    */     {
/* 38 */       String logStr = String.format("[baitan]PRecommandPriceReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*    */       
/* 40 */       BaiTanManager.logger.warn(logStr);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     SRecommendPriceChangeRes sSyncRecommandPriceChange = new SRecommendPriceChangeRes();
/* 45 */     for (Iterator i$ = this.itemIdSet.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*    */       
/* 47 */       int price = BaiTanManager.getItemRecommendPrice(id);
/*    */       
/* 49 */       if (price != -1)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 55 */         sSyncRecommandPriceChange.itemid2price.put(Integer.valueOf(id), Integer.valueOf(price));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 60 */     OnlineManager.getInstance().send(this.roleId, sSyncRecommandPriceChange);
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PRecommandPriceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */