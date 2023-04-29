/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGiveAwrd
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int awardId;
/*    */   private final int modifyId;
/*    */   private final boolean activeGet;
/*    */   private final boolean isSend;
/*    */   private final AwardReason awardReason;
/*    */   
/*    */   public PGiveAwrd(long roleId, int awardId, boolean activeGet, boolean isSend, int modifileId, AwardReason awardReason)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.awardId = awardId;
/* 31 */     this.modifyId = modifileId;
/* 32 */     this.activeGet = activeGet;
/* 33 */     this.isSend = isSend;
/* 34 */     this.awardReason = awardReason;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 41 */     String userId = RoleInterface.getUserId(this.roleId);
/* 42 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 44 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 46 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 47 */     if (teamInfo == null)
/*    */     {
/* 49 */       AwardInterface.award(this.awardId, userId, this.roleId, this.modifyId, this.activeGet, this.isSend, this.awardReason);
/* 50 */       return true;
/*    */     }
/* 52 */     final List<Long> normalList = teamInfo.getTeamNormalList();
/* 53 */     if ((normalList == null) || (normalList.size() == 0))
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 65 */         String userId = RoleInterface.getUserId(PGiveAwrd.this.roleId);
/* 66 */         lock(Lockeys.get(User.getTable(), userId));
/*    */         
/* 68 */         AwardInterface.award(PGiveAwrd.this.awardId, userId, PGiveAwrd.this.roleId, PGiveAwrd.this.modifyId, normalList, normalList, PGiveAwrd.this.activeGet, PGiveAwrd.this.isSend, PGiveAwrd.this.awardReason);
/* 69 */         return true;
/*    */       }
/* 71 */     });
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGiveAwrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */