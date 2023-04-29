/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import xbean.PrisonInfo;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ public class POnRoleEscape extends mzm.gsp.fight.event.RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if ((((RoleEscapeArg)this.arg).fightReason == FightReason.JAIL_BREAK_FIGHT_PVE.value) && ((((RoleEscapeArg)this.arg).fightContext instanceof JailBreakPVEFightContext)))
/*    */     {
/* 14 */       Role2prisoninfo.get(Long.valueOf(((RoleEscapeArg)this.arg).roleid)).setJailaction(1);
/* 15 */       return true;
/*    */     }
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */