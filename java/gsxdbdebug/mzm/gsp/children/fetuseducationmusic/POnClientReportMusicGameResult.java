/*    */ package mzm.gsp.children.fetuseducationmusic;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.children.confbean.FetusEducationMusicConsts;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.musicgame.event.ClientReportMusicGameResultArg;
/*    */ import mzm.gsp.musicgame.event.ClientReportMusicGameResultProcedure;
/*    */ import mzm.gsp.musicgame.event.MusicGameContext;
/*    */ import mzm.gsp.musicgame.main.MusicGameInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnClientReportMusicGameResult
/*    */   extends ClientReportMusicGameResultProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long roleid = ((ClientReportMusicGameResultArg)this.arg).roleid;
/* 23 */     int gameid = ((ClientReportMusicGameResultArg)this.arg).gameid;
/* 24 */     boolean isAnswerRight = ((ClientReportMusicGameResultArg)this.arg).isAnswerRight;
/* 25 */     MusicGameContext context = ((ClientReportMusicGameResultArg)this.arg).context;
/*    */     
/* 27 */     if (gameid != FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID)
/*    */     {
/*    */ 
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     FetusEducationMusicGameContext fetusEducationMusicGameContext = null;
/* 35 */     if ((context != null) && ((context instanceof FetusEducationMusicGameContext)))
/*    */     {
/* 37 */       fetusEducationMusicGameContext = (FetusEducationMusicGameContext)context;
/*    */     }
/* 39 */     if ((fetusEducationMusicGameContext == null) || (fetusEducationMusicGameContext.partnerid != MarriageInterface.getMarriedRoleid(roleid, false)) || (fetusEducationMusicGameContext.marriageid != MarriageInterface.getMarriedId(roleid, false)))
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     String userid = RoleInterface.getUserId(roleid);
/* 48 */     String partnerUserid = RoleInterface.getUserId(fetusEducationMusicGameContext.partnerid);
/*    */     
/* 50 */     lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*    */     
/* 52 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(fetusEducationMusicGameContext.partnerid) }));
/*    */     
/*    */ 
/* 55 */     if (isAnswerRight)
/*    */     {
/* 57 */       ChildrenInterface.addGiveBirthScore(roleid, fetusEducationMusicGameContext.partnerid, fetusEducationMusicGameContext.marriageid, MusicGameInterface.getMusicGameRightPoint(FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 63 */       ChildrenInterface.addGiveBirthScore(roleid, fetusEducationMusicGameContext.partnerid, fetusEducationMusicGameContext.marriageid, MusicGameInterface.getMusicGameWrongPoint(FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 68 */     StringBuilder sb = new StringBuilder();
/* 69 */     sb.append(String.format("[fetus_education_music]POnClientReportMusicGameResult.processImp@client report music game result process success|roleid=%d|gameid=%d|is_answer_right=%b|%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(gameid), Boolean.valueOf(isAnswerRight), fetusEducationMusicGameContext }));
/*    */     
/*    */ 
/* 72 */     FetusEducationMusicManager.logger.info(sb.toString());
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\POnClientReportMusicGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */