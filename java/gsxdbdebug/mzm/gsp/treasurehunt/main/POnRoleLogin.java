/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.treasurehunt.SSyncTreasureHuntInfo;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg;
/*    */ import xbean.Role2TreasureHuntWorldInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = xtable.Role2treasurehuntworld.get((Long)this.arg);
/* 14 */     if (xRole2TreasureHuntWorldInfo == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     int chapterId = xRole2TreasureHuntWorldInfo.getChapter_cfg_id();
/*    */     
/* 21 */     STreasureHuntChapterCfg sTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(chapterId);
/* 22 */     if (sTreasureHuntChapterCfg == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     TreasureHuntSceneSession treasureHuntSceneSession = (TreasureHuntSceneSession)mzm.gsp.timer.main.Session.getSession(xRole2TreasureHuntWorldInfo.getSession_id());
/* 28 */     if (treasureHuntSceneSession == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     SSyncTreasureHuntInfo sSyncTreasureHuntInfo = new SSyncTreasureHuntInfo();
/* 33 */     sSyncTreasureHuntInfo.activity_cfg_id = treasureHuntSceneSession.getActivityCfgId();
/* 34 */     sSyncTreasureHuntInfo.left_seconds = (treasureHuntSceneSession.getLeftMillis() / 1000);
/* 35 */     sSyncTreasureHuntInfo.process = xRole2TreasureHuntWorldInfo.getProcess();
/* 36 */     sSyncTreasureHuntInfo.total = sTreasureHuntChapterCfg.map_item_num;
/* 37 */     sSyncTreasureHuntInfo.chapter_cfg_id = sTreasureHuntChapterCfg.id;
/*    */     
/* 39 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncTreasureHuntInfo);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */