/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.watchmoon.SGetWatchCountRes;
/*    */ import mzm.gsp.watchmoon.WatchmoonState;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*    */ 
/*    */ 
/*    */ public class PGetWatchMoonCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final List<Long> roleList;
/*    */   private final long roleid;
/*    */   
/*    */   public PGetWatchMoonCount(ArrayList<Long> roleList, long roleid)
/*    */   {
/* 25 */     this.roleList = roleList;
/* 26 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     SGetWatchCountRes res = new SGetWatchCountRes();
/* 33 */     for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 35 */       String userId = RoleInterface.getUserId(r);
/* 36 */       WatchmoonState watchmoonState = new WatchmoonState();
/* 37 */       watchmoonState.count = ActivityInterface.getActivityCount(userId, r, SWatchmoonConsts.getInstance().ACTIVITY_ID, false);
/*    */       
/* 39 */       boolean result = RoleStatusInterface.checkCanSetStatus(r, 28, false);
/* 40 */       watchmoonState.canwatchmoon = ((byte)(result ? 1 : 0));
/* 41 */       res.roleid2state.put(Long.valueOf(r), watchmoonState);
/*    */     }
/* 43 */     OnlineManager.getInstance().send(this.roleid, res);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PGetWatchMoonCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */