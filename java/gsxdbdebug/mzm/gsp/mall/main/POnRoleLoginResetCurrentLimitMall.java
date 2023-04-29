/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginResetCurrentLimitMall
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 20 */     for (Map.Entry<Integer, CurrentLimitShopRelation> entry : MallManager.CURRENT_LIMIT_SHOP.entrySet())
/*    */     {
/* 22 */       int malltype = ((Integer)entry.getKey()).intValue();
/*    */       
/*    */ 
/* 25 */       if (MallManager.isCurrentLimitMallSwitchOpenForRole(roleid, malltype))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 31 */         MallManager.checkAndResetCurrentLimitMall(roleid, malltype);
/*    */       }
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\POnRoleLoginResetCurrentLimitMall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */