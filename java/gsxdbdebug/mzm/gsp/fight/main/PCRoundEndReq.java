/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PCRoundEndReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCRoundEndReq(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 18 */     if (fight == null) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     Set<Long> lockRoles = fight.getLockRoles();
/* 23 */     lock(Basic.getTable(), lockRoles);
/* 24 */     fight.onRoleRoundEnd(this.roleid);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCRoundEndReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */