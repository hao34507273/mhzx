/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.EquipFumoInfo;
/*    */ import mzm.gsp.item.SResEquipFumoInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FumoInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginCheckFumo
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     long currentTime = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 26 */     SResEquipFumoInfo resEquipFumoInfo = new SResEquipFumoInfo();
/* 27 */     List<EquipFumoInfo> fs1 = removeFumoEquips(340600001, currentTime);
/* 28 */     resEquipFumoInfo.fumoinolist.addAll(fs1);
/* 29 */     List<EquipFumoInfo> fs2 = removeFumoEquips(340600000, currentTime);
/* 30 */     resEquipFumoInfo.fumoinolist.addAll(fs2);
/*    */     
/* 32 */     List<Integer> res = ItemInterface.getOpenStorageids(((Long)this.arg).longValue(), true);
/* 33 */     for (Iterator i$ = res.iterator(); i$.hasNext();) { int storagebagid = ((Integer)i$.next()).intValue();
/* 34 */       List<EquipFumoInfo> fs = removeFumoEquips(storagebagid, currentTime);
/* 35 */       resEquipFumoInfo.fumoinolist.addAll(fs);
/*    */     }
/*    */     
/* 38 */     if (resEquipFumoInfo.fumoinolist.size() > 0) {
/* 39 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), resEquipFumoInfo);
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   private List<EquipFumoInfo> removeFumoEquips(int bagId, long currentTime) {
/* 46 */     List<EquipFumoInfo> fumoinolist = new ArrayList();
/*    */     
/* 48 */     List<EquipmentItem> equipmentItems = ItemInterface.getFumoTimeoutEquips(((Long)this.arg).longValue(), bagId, currentTime);
/* 49 */     List<FumoInfo> timeOuts = new ArrayList();
/* 50 */     for (EquipmentItem e : equipmentItems) {
/* 51 */       for (FumoInfo f : e.getFumoInfos()) {
/* 52 */         if (f.getTimeout() <= currentTime) {
/* 53 */           timeOuts.add(f);
/*    */           
/* 55 */           EquipFumoInfo fumoinfo = new EquipFumoInfo();
/* 56 */           fumoinfo.bagid = bagId;
/* 57 */           fumoinfo.uuid = e.getFirstUuid().longValue();
/* 58 */           fumoinfo.addvalue = 0;
/* 59 */           fumoinfo.expirationtime = 0L;
/* 60 */           fumoinfo.propertytype = f.getProtype();
/* 61 */           fumoinfo.itemid = e.getCfgId();
/* 62 */           fumoinolist.add(fumoinfo);
/*    */         }
/*    */       }
/* 65 */       e.getFumoInfos().removeAll(timeOuts);
/* 66 */       timeOuts.clear();
/*    */     }
/*    */     
/* 69 */     return fumoinolist;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginCheckFumo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */