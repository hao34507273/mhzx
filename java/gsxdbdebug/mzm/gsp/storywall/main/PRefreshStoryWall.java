/*    */ package mzm.gsp.storywall.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.SStoryWallCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.storywall.SStoryWallRefresh;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.StoryWall;
/*    */ import xtable.Storywall;
/*    */ 
/*    */ public class PRefreshStoryWall extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!OpenInterface.getOpenStatus(163)) {
/* 19 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 23 */     StoryWall xStoryWall = Storywall.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 24 */     if (xStoryWall == null) {
/* 25 */       xStoryWall = xbean.Pod.newStoryWall();
/* 26 */       Storywall.add(Long.valueOf(GameServerInfoManager.getLocalId()), xStoryWall);
/*    */     }
/*    */     
/* 29 */     long oldTime = xStoryWall.getStoryrefreshtime();
/* 30 */     long nowTime = DateTimeUtils.getCurrTimeInMillis();
/* 31 */     if (DateTimeUtils.isInSameWeek(oldTime, nowTime)) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     xStoryWall.getStoryids().clear();
/* 36 */     int maxIndex = xStoryWall.getMaxindex();
/* 37 */     for (int i = 0; i < StoryWallModule.MAX_STORY_COUNT; i++) {
/* 38 */       int storyid = 0;
/* 39 */       int curIndex = 0;
/* 40 */       for (SStoryWallCfg storyCfg : SStoryWallCfg.getAll().values()) {
/* 41 */         if ((storyCfg.index > maxIndex) && ((curIndex == 0) || (storyCfg.index < curIndex))) {
/* 42 */           storyid = storyCfg.id;
/* 43 */           curIndex = storyCfg.index;
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 48 */       if ((storyid == 0) || (curIndex == 0)) {
/* 49 */         storyid = 0;
/* 50 */         curIndex = 0;
/* 51 */         maxIndex = 0;
/* 52 */         for (SStoryWallCfg storyCfg : SStoryWallCfg.getAll().values()) {
/* 53 */           if ((storyCfg.index > maxIndex) && ((curIndex == 0) || (storyCfg.index < curIndex))) {
/* 54 */             storyid = storyCfg.id;
/* 55 */             curIndex = storyCfg.index;
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 60 */       if ((storyid == 0) || (curIndex == 0) || (xStoryWall.getStoryids().contains(Integer.valueOf(storyid)))) {
/*    */         break;
/*    */       }
/* 63 */       maxIndex = curIndex;
/* 64 */       xStoryWall.getStoryids().add(Integer.valueOf(storyid));
/*    */     }
/*    */     
/* 67 */     xStoryWall.setMaxindex(maxIndex);
/* 68 */     xStoryWall.setStoryrefreshtime(nowTime);
/*    */     
/* 70 */     if (oldTime > 0L) {
/* 71 */       OnlineManager.getInstance().sendAll(new SStoryWallRefresh());
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\main\PRefreshStoryWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */