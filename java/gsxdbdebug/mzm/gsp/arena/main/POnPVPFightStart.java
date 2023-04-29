/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import xbean.ArenaTmp;
/*    */ 
/*    */ public class POnPVPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (!(((PVPFightStartArg)this.arg).context instanceof ArenaFightContext)) {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/* 17 */     xArenaTmp.getFights().add(Long.valueOf(((PVPFightStartArg)this.arg).fightid));
/*    */     
/*    */ 
/* 20 */     ArenaManager.broadcastMatchCountDownForce(((PVPFightStartArg)this.arg).getAllRoles());
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */