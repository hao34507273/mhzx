/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     for (Map.Entry<Integer, CSMysteryShopConstsCfg> entry : )
/*    */     {
/* 22 */       int shopType = ((Integer)entry.getKey()).intValue();
/*    */       
/*    */ 
/* 25 */       if (MysteryShopManager.isMysteryShopOpenForRole(((Long)this.arg).longValue(), shopType))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 30 */         long roleResetTime = MysteryShopManager.getRoleMysteryShopResetTime(((Long)this.arg).longValue(), shopType);
/* 31 */         long sysResetTime = MysteryShopManager.getMysteryShopResetTime(shopType);
/*    */         
/* 33 */         if ((sysResetTime <= 0L) || (roleResetTime <= 0L))
/*    */         {
/* 35 */           return false;
/*    */         }
/* 37 */         if (roleResetTime < sysResetTime)
/*    */         {
/* 39 */           return MysteryShopManager.refreshMysteryShopSys(((Long)this.arg).longValue(), shopType, sysResetTime); }
/*    */       }
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */