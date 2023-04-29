/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FloorFightRes;
/*    */ import xbean.GlobalFloorInfo;
/*    */ import xbean.GlobalSingleFloorInfo;
/*    */ 
/*    */ public class PClearGlobalData extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public PClearGlobalData(int activityId)
/*    */   {
/* 21 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     GlobalFloorInfo xGlobalFloorInfo = FloorManager.getGlobalFloorInfo(this.activityId, true);
/* 29 */     if (xGlobalFloorInfo == null)
/*    */     {
/* 31 */       GameServer.logger().error(String.format("[floor]PClearGlobalData.processImp@ no xGlobalFloorInfo!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */       
/* 33 */       return false;
/*    */     }
/* 35 */     Iterator<Map.Entry<Integer, GlobalSingleFloorInfo>> it = xGlobalFloorInfo.getFloor2info().entrySet().iterator();
/* 36 */     while (it.hasNext())
/*    */     {
/* 38 */       clearFirstBloodInfo((GlobalSingleFloorInfo)((Map.Entry)it.next()).getValue());
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void clearFirstBloodInfo(GlobalSingleFloorInfo xGlobalSingleFloorInfo)
/*    */   {
/* 50 */     FloorFightRes xFloorFightRes = xGlobalSingleFloorInfo.getFirstblood();
/*    */     
/* 52 */     FloorManager.removeRedio(xGlobalSingleFloorInfo, true);
/*    */     
/* 54 */     xFloorFightRes.setKilltime(0);
/* 55 */     xFloorFightRes.setRadioid(0L);
/* 56 */     xFloorFightRes.setUsedtime(0);
/* 57 */     xFloorFightRes.getNames().clear();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PClearGlobalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */