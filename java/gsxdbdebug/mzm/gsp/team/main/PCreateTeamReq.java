/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCreateTeamReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCreateTeamReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 237, true))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     return TeamManager.createTeam(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PCreateTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */