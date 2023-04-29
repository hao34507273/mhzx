/*    */ package mzm.gsp.storywall.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.confbean.StoryWallConst;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.storywall.SStoryWallInfoRes;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.StoryInfo;
/*    */ import xbean.StoryWall;
/*    */ import xtable.Role2storyinfo;
/*    */ 
/*    */ public class PGetStoryWallInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetStoryWallInfoReq(long _roleid)
/*    */   {
/* 18 */     this.roleid = _roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if ((!OpenInterface.getOpenStatus(163)) || (OpenInterface.isBanPlay(this.roleid, 163)))
/*    */     {
/* 25 */       OpenInterface.sendBanPlayMsg(this.roleid, 163);
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(StoryWallConst.getInstance().activityid)) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     StoryInfo xStoryInfo = Role2storyinfo.select(Long.valueOf(this.roleid));
/* 34 */     if (xStoryInfo == null) {
/* 35 */       xStoryInfo = xbean.Pod.newStoryInfo();
/* 36 */       Role2storyinfo.add(Long.valueOf(this.roleid), xStoryInfo);
/*    */     }
/*    */     
/*    */ 
/* 40 */     StoryWall xStoryWall = xtable.Storywall.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 41 */     if (xStoryWall == null) {
/* 42 */       NoneRealTimeTaskManager.getInstance().addTask(new PRefreshStoryWall());
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     long refTime = xStoryWall.getStoryrefreshtime();
/* 47 */     long nowTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 48 */     if (!mzm.gsp.util.DateTimeUtils.isInSameWeek(refTime, nowTime)) {
/* 49 */       NoneRealTimeTaskManager.getInstance().addTask(new PRefreshStoryWall());
/*    */     }
/* 51 */     SStoryWallInfoRes res = new SStoryWallInfoRes();
/* 52 */     res.storyids.addAll(xStoryWall.getStoryids());
/* 53 */     if ((xStoryInfo != null) && (xStoryInfo.getStorytime() == refTime)) {
/* 54 */       res.readstoryids.addAll(xStoryInfo.getStoryids());
/*    */     }
/* 56 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\main\PGetStoryWallInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */