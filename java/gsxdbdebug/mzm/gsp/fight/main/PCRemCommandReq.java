/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.SSynRemCommandRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PCRemCommandReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int fighterid;
/*    */   
/*    */   public PCRemCommandReq(long roleid, int fighterid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.fighterid = fighterid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 22 */     if (fight == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     Set<Long> lockRoles = fight.getLockRoles();
/* 26 */     lock(Basic.getTable(), lockRoles);
/* 27 */     FightGroupRole fightGroupRole = fight.getGroupRole(this.roleid);
/* 28 */     if (fightGroupRole == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     SSynRemCommandRes synRemCommandRes = new SSynRemCommandRes();
/* 32 */     synRemCommandRes.fighterid = this.fighterid;
/* 33 */     OnlineManager.getInstance().sendMulti(synRemCommandRes, fightGroupRole.fightTeam.getBroadcastRoles());
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCRemCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */