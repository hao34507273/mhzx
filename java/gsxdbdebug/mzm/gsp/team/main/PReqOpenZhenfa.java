/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*    */ import xbean.Team;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReqOpenZhenfa
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int openzhenfaid;
/*    */   
/*    */   public PReqOpenZhenfa(long roleid, int openzhenfaid)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.openzhenfaid = openzhenfaid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 34 */     ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type = checkTeamInfo();
/*    */     
/*    */ 
/* 37 */     if (!ZhenfaInterface.hasZhenfa(this.roleid, this.openzhenfaid))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     if (!PartnerInterface.changeDefaultPartnerLineUpZhenFaId(this.roleid, this.openzhenfaid, type))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     return true;
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
/* 59 */     Team xTeam = TeamManager.getXTeamByRoleid(this.roleid, false);
/*    */     
/* 61 */     if ((xTeam != null) && (TeamManager.isLeader(this.roleid, xTeam)))
/*    */     {
/* 63 */       TeamManager.synTeamZhenFaInfo(xTeam, this.openzhenfaid, ZhenfaInterface.getZhenfaLevel(this.roleid, this.openzhenfaid));
/* 64 */       return ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.TEAM;
/*    */     }
/* 66 */     return ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.PARTNER;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PReqOpenZhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */