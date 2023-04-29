/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.fabao.SSynFabaoInfo;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import xbean.Item;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleFabaoSysInfo xRoleFabaoSysInfo = xtable.Role2fabaosys.get((Long)this.arg);
/* 14 */     if (xRoleFabaoSysInfo == null) {
/* 15 */       return false;
/*    */     }
/* 17 */     SSynFabaoInfo synFabaoInfo = new SSynFabaoInfo();
/* 18 */     synFabaoInfo.disfabaotype = xRoleFabaoSysInfo.getDisfabaotype();
/*    */     
/* 20 */     for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/* 21 */       ItemInfo iteminfo = new ItemInfo();
/* 22 */       mzm.gsp.item.main.ItemInterface.fillInItemInfoBean(iteminfo, (Item)entry.getValue());
/* 23 */       synFabaoInfo.euqipfabao.put(entry.getKey(), iteminfo);
/*    */     }
/*    */     
/* 26 */     for (Map.Entry<Integer, xbean.LongJing> entry : xRoleFabaoSysInfo.getLongjingmap().entrySet()) {
/* 27 */       mzm.gsp.fabao.LongJingInfo longJingInfo = new mzm.gsp.fabao.LongJingInfo();
/* 28 */       for (Map.Entry<Integer, Item> itmeEntry : ((xbean.LongJing)entry.getValue()).getLongjingitems().entrySet()) {
/* 29 */         ItemInfo iteminfo = new ItemInfo();
/* 30 */         mzm.gsp.item.main.ItemInterface.fillInItemInfoBean(iteminfo, (Item)itmeEntry.getValue());
/* 31 */         longJingInfo.longjingitems.put(itmeEntry.getKey(), iteminfo);
/*    */       }
/* 33 */       synFabaoInfo.euqiplongjing.put(entry.getKey(), longJingInfo);
/*    */     }
/* 35 */     mzm.gsp.online.main.OnlineManager.getInstance().send(((Long)this.arg).longValue(), synFabaoInfo);
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */