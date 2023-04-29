/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.couple.SLeaveRideRes;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CoupleRide;
/*    */ import xtable.Coupleride;
/*    */ import xtable.Role2coupleride;
/*    */ 
/*    */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     int newMapcfg = ((MapTransferArg)this.arg).newMapCfgId;
/* 24 */     Iterator i$; if (!MapInterface.canFly(newMapcfg))
/*    */     {
/* 26 */       for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 28 */         NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 34 */             Long coupleId = Role2coupleride.select(Long.valueOf(roleid));
/* 35 */             if (coupleId != null)
/*    */             {
/* 37 */               CoupleRide xCoupleRide = Coupleride.select(coupleId);
/* 38 */               if (xCoupleRide == null)
/*    */               {
/* 40 */                 GameServer.logger().info(String.format("[CoupleRide]PCLeaveRideReq.processImp@已经结束双人飞行了|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */                 
/* 42 */                 return false;
/*    */               }
/* 44 */               long roleA = xCoupleRide.getRolea();
/* 45 */               long roleB = xCoupleRide.getRoleb();
/* 46 */               lock(Role2coupleride.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/* 47 */               if (Coupleride.select(coupleId) == null)
/*    */               {
/* 49 */                 return false;
/*    */               }
/* 51 */               RoleStatusInterface.unsetStatus(roleA, 25);
/* 52 */               RoleStatusInterface.unsetStatus(roleA, 2);
/* 53 */               RoleStatusInterface.unsetStatus(roleB, 25);
/* 54 */               RoleStatusInterface.unsetStatus(roleB, 2);
/*    */               
/* 56 */               Role2coupleride.remove(Long.valueOf(roleA));
/* 57 */               Role2coupleride.remove(Long.valueOf(roleB));
/* 58 */               Coupleride.remove(coupleId);
/* 59 */               SLeaveRideRes leaveRideRes = new SLeaveRideRes();
/* 60 */               OnlineManager.getInstance().send(roleA, leaveRideRes);
/* 61 */               OnlineManager.getInstance().send(roleB, leaveRideRes);
/*    */               
/* 63 */               TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.couple.event.DissolveCoupleRide(), new mzm.gsp.couple.event.DissolveCoupleRideArg(coupleId.longValue(), roleA, roleB));
/*    */             }
/*    */             
/* 66 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */