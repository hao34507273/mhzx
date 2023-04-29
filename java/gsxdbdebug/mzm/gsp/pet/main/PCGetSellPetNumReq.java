/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.pet.SSyncPetShopCanSellNum;
/*    */ import mzm.gsp.pet.confbean.PetShopConstants;
/*    */ import xbean.PetShopBean;
/*    */ 
/*    */ public class PCGetSellPetNumReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCGetSellPetNumReq(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     PetShopBean xPetShopBean = xtable.Role2petshop.get(Long.valueOf(this.roleid));
/* 20 */     if (xPetShopBean == null) {
/* 21 */       xPetShopBean = xbean.Pod.newPetShopBean();
/* 22 */       xtable.Role2petshop.add(Long.valueOf(this.roleid), xPetShopBean);
/*    */     }
/*    */     
/* 25 */     long inNow = System.currentTimeMillis();
/* 26 */     long inTimestamp = PetManager.getBeginningOfDay(xPetShopBean.getTimestamp()) + 86400000L;
/* 27 */     if (inNow > inTimestamp) {
/* 28 */       xPetShopBean.setSellcount(0);
/* 29 */       xPetShopBean.setTimestamp(inNow);
/*    */     }
/*    */     
/* 32 */     SSyncPetShopCanSellNum sSyncPetShopCanSellNum = new SSyncPetShopCanSellNum();
/* 33 */     sSyncPetShopCanSellNum.cansellnum = (PetShopConstants.getInstance().SELL_PER_DAY_LIMIT - xPetShopBean.getSellcount());
/* 34 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, sSyncPetShopCanSellNum);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCGetSellPetNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */