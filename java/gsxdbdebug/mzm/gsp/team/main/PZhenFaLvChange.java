/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SReqChangeZhenfa;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PZhenFaLvChange extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int zhenfaId;
/*    */   
/*    */   public PZhenFaLvChange(long roleId, int zhenfaId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.zhenfaId = zhenfaId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 29 */     if (teamInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!teamInfo.isLeader(this.roleId))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/* 39 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 40 */     teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/* 41 */     if (teamInfo == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     if (!needNoticeAll(teamInfo, PartnerInterface.getRolePartnerDefaultZhenFaId(this.roleId)))
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     noticeTeamAll(this.zhenfaId, mzm.gsp.zhenfa.main.ZhenfaInterface.getZhenfaLevel(this.roleId, this.zhenfaId), teamInfo.getTeamMemberList());
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void noticeTeamAll(int zhenfaId, int lv, List<Long> members)
/*    */   {
/* 62 */     SReqChangeZhenfa sReqChangeZhenfa = new SReqChangeZhenfa();
/* 63 */     sReqChangeZhenfa.changedzhenfaid = zhenfaId;
/* 64 */     sReqChangeZhenfa.zhenfalevel = lv;
/* 65 */     OnlineManager.getInstance().sendMulti(sReqChangeZhenfa, members);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean needNoticeAll(TeamInfo teamInfo, int defaultId)
/*    */   {
/* 76 */     if (teamInfo == null)
/*    */     {
/* 78 */       return false;
/*    */     }
/* 80 */     if (!teamInfo.isLeader(this.roleId))
/*    */     {
/* 82 */       return false;
/*    */     }
/* 84 */     if (this.zhenfaId != defaultId)
/*    */     {
/* 86 */       return false;
/*    */     }
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PZhenFaLvChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */