/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (GameServerInfoManager.isRoamServer()) {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     for (SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/* 21 */       GratefulDeliveryManager.removeFromAvailableRoleMap(cfg.activityId, ((Long)this.arg).longValue());
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */