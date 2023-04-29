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
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     FightContext fightContext = ((PVEFightEndArg)this.arg).context;
/* 16 */     if ((fightContext == null) || (!(fightContext instanceof PVEFightContext)))
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     PVEFightContext pveFightContext = (PVEFightContext)fightContext;
/* 22 */     int fightReason = pveFightContext.getFightReson().value;
/* 23 */     if ((fightReason != FightReason.MENPAI_STAR_VOTE_FIGHT.value) && (fightReason != FightReason.MENPAI_STAR_CAMPAIGN_PVE_FIGHT.value))
/*    */     {
/*    */ 
/* 26 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 30 */     long roleid = pveFightContext.getRoleid();
/* 31 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 32 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 34 */     boolean win = ((PVEFightEndArg)this.arg).isPlayerWin;
/* 35 */     if (fightReason == FightReason.MENPAI_STAR_VOTE_FIGHT.value)
/*    */     {
/* 37 */       MenPaiStarManager.onVoteFightEnd(roleid, win);
/*    */     }
/*    */     else
/*    */     {
/* 41 */       MenPaiStarManager.onCampaignFightEnd(roleid, win);
/*    */     }
/*    */     
/* 44 */     GameServer.logger().info(String.format("[menpaistar]POnPVEFightEnd.processImp@handle success|roleid=%d|fight_reason=%d|win=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(fightReason), Boolean.valueOf(win) }));
/*    */     
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */