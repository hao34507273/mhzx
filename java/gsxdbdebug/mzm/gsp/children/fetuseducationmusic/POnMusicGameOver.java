/*    */ package mzm.gsp.children.fetuseducationmusic;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.children.confbean.FetusEducationMusicConsts;
/*    */ import mzm.gsp.musicgame.event.MusicGameOverArg;
/*    */ import mzm.gsp.musicgame.event.MusicGameOverProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMusicGameOver extends MusicGameOverProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((MusicGameOverArg)this.arg).roleid;
/* 19 */     int gameid = ((MusicGameOverArg)this.arg).gameid;
/* 20 */     long gameStartTimeStamp = ((MusicGameOverArg)this.arg).gameStartTimeStamp;
/*    */     
/* 22 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 24 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 26 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 28 */     if (gameid != FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID)
/*    */     {
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (!DateTimeUtils.needDailyReset(gameStartTimeStamp, DateTimeUtils.getCurrTimeInMillis(), 0))
/*    */     {
/* 37 */       ActivityInterface.addActivityCount(userid, roleid, FetusEducationMusicConsts.getInstance().ACTIVITY_CFG_ID);
/*    */     }
/*    */     
/* 40 */     StringBuilder sb = new StringBuilder();
/* 41 */     sb.append(String.format("[fetus_education_music]POnClientReportMusicGameResult.processImp@music game over process success|roleid=%d|gameid=%d|game_start_timestamp=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(gameid), Long.valueOf(gameStartTimeStamp) }));
/*    */     
/*    */ 
/* 44 */     FetusEducationMusicManager.logger.info(sb.toString());
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\POnMusicGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */