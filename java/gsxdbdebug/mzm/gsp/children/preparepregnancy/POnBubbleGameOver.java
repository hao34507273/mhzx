/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.bubblegame.event.BubbleGameOverArg;
/*    */ import mzm.gsp.bubblegame.event.BubbleGameOverProcedure;
/*    */ import mzm.gsp.children.confbean.PreparePregnancyConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnBubbleGameOver extends BubbleGameOverProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((BubbleGameOverArg)this.arg).roleid;
/* 19 */     int gameid = ((BubbleGameOverArg)this.arg).gameid;
/* 20 */     long gameStartTimeStamp = ((BubbleGameOverArg)this.arg).gameStartTimeStamp;
/*    */     
/* 22 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 24 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 26 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 28 */     if (gameid != PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID)
/*    */     {
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (!DateTimeUtils.needDailyReset(gameStartTimeStamp, DateTimeUtils.getCurrTimeInMillis(), 0))
/*    */     {
/* 37 */       ActivityInterface.addActivityCount(userid, roleid, PreparePregnancyConsts.getInstance().ACTIVITY_CFG_ID);
/*    */     }
/*    */     
/* 40 */     StringBuilder sb = new StringBuilder();
/* 41 */     sb.append(String.format("[prepare_pregnancy]POnBubbleGameOver.processImp@bubble game over process success|roleid=%d|gameid=%d|game_start_timestamp=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(gameid), Long.valueOf(gameStartTimeStamp) }));
/*    */     
/*    */ 
/* 44 */     PreparePregnancyManager.logger.info(sb.toString());
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\POnBubbleGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */