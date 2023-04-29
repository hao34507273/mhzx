/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnPVEFightEndRole extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     FightContext fightContext = ((PVEFightEndArg)this.arg).context;
/* 16 */     if ((fightContext == null) || (!(fightContext instanceof CampaignFightContext)))
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     CampaignFightContext campaignFightContext = (CampaignFightContext)fightContext;
/* 22 */     int fightReason = campaignFightContext.getFightReson().value;
/* 23 */     if (fightReason != FightReason.MENPAI_STAR_CAMPAIGN_ROLE_FIGHT.value)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     long roleid = campaignFightContext.getRoleid();
/* 30 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 31 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 33 */     boolean win = ((PVEFightEndArg)this.arg).isPlayerWin;
/* 34 */     MenPaiStarManager.onCampaignFightEnd(roleid, win);
/*    */     
/* 36 */     GameServer.logger().info(String.format("[menpaistar]POnPVCFightEnd.processImp@handle success|roleid=%d|fight_reason=%d|win=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(fightReason), Boolean.valueOf(win) }));
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\POnPVEFightEndRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */