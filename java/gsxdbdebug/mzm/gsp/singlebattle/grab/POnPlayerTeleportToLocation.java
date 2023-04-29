/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.map.event.PlayerTeleportToLocationArg;
/*    */ import mzm.gsp.map.event.PlayerTeleportToLocationProcedure;
/*    */ 
/*    */ public class POnPlayerTeleportToLocation extends PlayerTeleportToLocationProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     for (Iterator i$ = ((PlayerTeleportToLocationArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 13 */       new PStopGrab(roleId, 2).execute();
/*    */     }
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\POnPlayerTeleportToLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */