/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Team;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReqCloseZhenfa
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PReqCloseZhenfa(long roleid)
/*    */   {
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 31 */     ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type = checkTeamInfo();
/*    */     
/*    */ 
/* 34 */     if (!PartnerInterface.changeDefaultPartnerLineUpZhenFaId(this.roleid, 0, type))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   ChangePartnerZhenFaIdArg.ChangeZhenFaIdType checkTeamInfo()
/*    */   {
/* 50 */     Team xTeam = TeamManager.getXTeamByRoleid(this.roleid, false);
/*    */     
/* 52 */     if ((xTeam != null) && (TeamManager.isLeader(this.roleid, xTeam)))
/*    */     {
/* 54 */       TeamManager.synTeamZhenFaInfo(xTeam, 0, 0);
/* 55 */       return ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.TEAM;
/*    */     }
/* 57 */     return ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.PARTNER;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PReqCloseZhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */