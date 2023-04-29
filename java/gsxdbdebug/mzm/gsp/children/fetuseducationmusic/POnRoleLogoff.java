/*    */ package mzm.gsp.children.fetuseducationmusic;
/*    */ 
/*    */ import mzm.gsp.children.confbean.FetusEducationMusicConsts;
/*    */ import mzm.gsp.musicgame.main.MusicGameInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     MusicGameInterface.stopMusicGame(roleid, FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID, true, false);
/* 18 */     StringBuilder sb = new StringBuilder();
/* 19 */     sb.append(String.format("[fetus_education_music]POnRoleLogoff.processImp@try pause fetus education music game on role logoff|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */     
/*    */ 
/* 22 */     FetusEducationMusicManager.logger.info(sb.toString());
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */