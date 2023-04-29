/*    */ package mzm.gsp.partneryuanshen.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.partneryuanshen.SSyncPartnerYuanshenInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (PartnerYuanshenManager.isNotEnable())
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     syncPartnerYuanshenInfo();
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   private void syncPartnerYuanshenInfo()
/*    */   {
/* 25 */     Map<Integer, xbean.PartnerYuanshenPositionInfo> map = PartnerYuanshenManager.getPartnerYuanshenPositionInfoMap(((Long)this.arg).longValue(), false);
/*    */     
/* 27 */     if (map == null)
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     SSyncPartnerYuanshenInfo sSyncPartnerYuanshenInfo = new SSyncPartnerYuanshenInfo();
/* 32 */     for (Map.Entry<Integer, xbean.PartnerYuanshenPositionInfo> entry : map.entrySet())
/*    */     {
/* 34 */       mzm.gsp.partneryuanshen.PartnerYuanshenPositionInfo info = new mzm.gsp.partneryuanshen.PartnerYuanshenPositionInfo();
/* 35 */       info.attached_partner_id = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getAttached_partner_id();
/* 36 */       info.level = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getLevel();
/* 37 */       info.property = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getProperty_num();
/* 38 */       sSyncPartnerYuanshenInfo.position_info_map.put(entry.getKey(), info);
/*    */     }
/* 40 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncPartnerYuanshenInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */