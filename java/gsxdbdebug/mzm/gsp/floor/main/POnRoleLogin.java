/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.floor.SSynRoleActivtyInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.RoleSingleFloorInfo;
/*    */ import xtable.Role2flooractivity;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     xbean.RoleFloorActivityInfo xRoleFloorActivityInfo = Role2flooractivity.get((Long)this.arg);
/* 22 */     if (xRoleFloorActivityInfo == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     SSynRoleActivtyInfo syn = new SSynRoleActivtyInfo();
/* 27 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> entry : xRoleFloorActivityInfo.getActivityinfo().entrySet())
/*    */     {
/* 29 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 30 */       if (ActivityInterface.isActivityOpen(activityId))
/*    */       {
/*    */ 
/*    */ 
/* 34 */         mzm.gsp.floor.RoleFloorActivityInfo fRoleFloorActivityInfo = new mzm.gsp.floor.RoleFloorActivityInfo();
/* 35 */         fillActivityInfo(fRoleFloorActivityInfo, (xbean.RoleFloorInfo)entry.getValue());
/* 36 */         syn.activityinfos.put(Integer.valueOf(activityId), fRoleFloorActivityInfo);
/*    */       } }
/* 38 */     if (syn.activityinfos.size() == 0)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), syn);
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   private void fillActivityInfo(mzm.gsp.floor.RoleFloorActivityInfo fRoleFloorActivityInfo, xbean.RoleFloorInfo xRoleFloorInfo)
/*    */   {
/* 48 */     List<Integer> finishFloors = new ArrayList(xRoleFloorInfo.getFloor2info().keySet());
/* 49 */     Collections.sort(finishFloors);
/* 50 */     for (Iterator i$ = finishFloors.iterator(); i$.hasNext();) { int floor = ((Integer)i$.next()).intValue();
/*    */       
/* 52 */       RoleSingleFloorInfo xRoleSingleFloorInfo = (RoleSingleFloorInfo)xRoleFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 53 */       if (xRoleSingleFloorInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 57 */         mzm.gsp.floor.RoleFloorInfo pFloorInfo = new mzm.gsp.floor.RoleFloorInfo();
/* 58 */         pFloorInfo.floor = floor;
/* 59 */         pFloorInfo.usedtime = xRoleSingleFloorInfo.getUsedtime();
/* 60 */         fRoleFloorActivityInfo.finishfloor.add(pFloorInfo);
/*    */       } }
/* 62 */     fRoleFloorActivityInfo.historyfinishfloors.addAll(xRoleFloorInfo.getHistoryfloors());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */