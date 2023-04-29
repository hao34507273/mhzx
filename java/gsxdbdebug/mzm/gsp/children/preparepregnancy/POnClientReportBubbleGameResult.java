/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*    */ import mzm.gsp.bubblegame.event.ClientReportBubbleGameResultArg;
/*    */ import mzm.gsp.bubblegame.event.ClientReportBubbleGameResultProcedure;
/*    */ import mzm.gsp.bubblegame.main.BubbleGameInterface;
/*    */ import mzm.gsp.children.confbean.PreparePregnancyConsts;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnClientReportBubbleGameResult
/*    */   extends ClientReportBubbleGameResultProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long roleid = ((ClientReportBubbleGameResultArg)this.arg).roleid;
/* 23 */     int gameid = ((ClientReportBubbleGameResultArg)this.arg).gameid;
/* 24 */     boolean isAnswerRight = ((ClientReportBubbleGameResultArg)this.arg).isAnswerRight;
/* 25 */     BubbleGameContext context = ((ClientReportBubbleGameResultArg)this.arg).context;
/*    */     
/* 27 */     if (gameid != PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID)
/*    */     {
/*    */ 
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     PreparePregnancyBubbleGameContext preparePregnancyBubbleGameContext = null;
/* 35 */     if ((context != null) && ((context instanceof PreparePregnancyBubbleGameContext)))
/*    */     {
/* 37 */       preparePregnancyBubbleGameContext = (PreparePregnancyBubbleGameContext)context;
/*    */     }
/* 39 */     if ((preparePregnancyBubbleGameContext == null) || (preparePregnancyBubbleGameContext.partnerid != MarriageInterface.getMarriedRoleid(roleid, false)) || (preparePregnancyBubbleGameContext.marriageid != MarriageInterface.getMarriedId(roleid, false)))
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     String userid = RoleInterface.getUserId(roleid);
/* 48 */     String partnerUserid = RoleInterface.getUserId(preparePregnancyBubbleGameContext.partnerid);
/*    */     
/* 50 */     lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*    */     
/* 52 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(preparePregnancyBubbleGameContext.partnerid) }));
/*    */     
/* 54 */     if (isAnswerRight)
/*    */     {
/* 56 */       ChildrenInterface.addPreparePregnantScore(roleid, preparePregnancyBubbleGameContext.partnerid, preparePregnancyBubbleGameContext.marriageid, BubbleGameInterface.getBubbleGameRightPoint(PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 62 */       ChildrenInterface.addPreparePregnantScore(roleid, preparePregnancyBubbleGameContext.partnerid, preparePregnancyBubbleGameContext.marriageid, BubbleGameInterface.getBubbleGameWrongPoint(PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 67 */     StringBuilder sb = new StringBuilder();
/* 68 */     sb.append(String.format("[prepare_pregnancy]POnClientReportBubbleGameResult.processImp@client report bubble game result process success|roleid=%d|gameid=%d|is_answer_right=%b|%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(gameid), Boolean.valueOf(isAnswerRight), preparePregnancyBubbleGameContext.toString() }));
/*    */     
/*    */ 
/* 71 */     PreparePregnancyManager.logger.info(sb.toString());
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\POnClientReportBubbleGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */