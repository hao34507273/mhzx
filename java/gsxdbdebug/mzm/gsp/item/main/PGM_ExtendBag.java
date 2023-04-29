/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SExtendBagRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGM_ExtendBag
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int bagid;
/*    */   private final long roleid;
/*    */   private final int number;
/*    */   
/*    */   public PGM_ExtendBag(long roleid, int bagid, int number)
/*    */   {
/* 17 */     this.bagid = bagid;
/* 18 */     this.roleid = roleid;
/* 19 */     this.number = number;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     RoleItemBag bag = null;
/* 25 */     if (this.number <= 0) {
/* 26 */       return false;
/*    */     }
/* 28 */     SExtendBagRes sExtendBagRes = new SExtendBagRes();
/* 29 */     if (this.bagid == 1) {
/* 30 */       bag = ItemManager.getBag(this.roleid, 340600000);
/* 31 */       bag.expandCapacity(this.number);
/* 32 */       sExtendBagRes.bagid = 340600000;
/* 33 */       sExtendBagRes.capcity = bag.getCapacity();
/* 34 */       OnlineManager.getInstance().send(this.roleid, sExtendBagRes);
/* 35 */       return true;
/*    */     }
/* 37 */     if (this.bagid == 2) {
/* 38 */       bag = ItemManager.getBag(this.roleid, 340600001);
/* 39 */       bag.expandCapacity(this.number);
/* 40 */       sExtendBagRes.bagid = 340600000;
/* 41 */       sExtendBagRes.capcity = bag.getCapacity();
/* 42 */       OnlineManager.getInstance().send(this.roleid, sExtendBagRes);
/* 43 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 54 */     bag = ItemManager.getBag(this.roleid, 340600000);
/* 55 */     bag.expandCapacity(this.number);
/* 56 */     bag = ItemManager.getBag(this.roleid, 340600001);
/* 57 */     bag.expandCapacity(this.number);
/*    */     
/*    */ 
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_ExtendBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */