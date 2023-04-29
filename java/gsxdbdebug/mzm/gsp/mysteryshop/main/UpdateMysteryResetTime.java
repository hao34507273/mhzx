/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateMysteryResetTime
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int shopType;
/*    */   private final long cur;
/*    */   
/*    */   UpdateMysteryResetTime(int shopType, long cur)
/*    */   {
/* 20 */     this.shopType = shopType;
/* 21 */     this.cur = cur;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     MysteryShopManager.setMysteryShopResetTime(this.shopType, this.cur);
/* 28 */     for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */     {
/* 30 */       NoneRealTimeTaskManager.getInstance().addTask(new ResetMysteryShop(this.shopType, roleId.longValue(), this.cur));
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   private static class ResetMysteryShop
/*    */     extends LogicProcedure
/*    */   {
/*    */     final int shopType;
/*    */     final long roleid;
/*    */     final long time;
/*    */     
/*    */     ResetMysteryShop(int shopType, long roleid, long time)
/*    */     {
/* 44 */       this.shopType = shopType;
/* 45 */       this.roleid = roleid;
/* 46 */       this.time = time;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 53 */       if (!MysteryShopManager.isMysteryShopOpenForRole(this.roleid, this.shopType))
/*    */       {
/* 55 */         return false;
/*    */       }
/* 57 */       if (MysteryShopManager.refreshMysteryShopSys(this.roleid, this.shopType, this.time))
/*    */       {
/* 59 */         MysteryShopManager.synMysteryShopInfo(this.roleid, this.shopType);
/* 60 */         return true;
/*    */       }
/* 62 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\UpdateMysteryResetTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */