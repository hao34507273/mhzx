/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGM_AddTeamChivalry
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int gainType;
/*    */   
/*    */   public PGM_AddTeamChivalry(long roleId, int gainType)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.gainType = gainType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     List<Long> members = TeamInterface.getNormalRoleList(this.roleId);
/* 28 */     if ((members == null) || (members.size() <= 1))
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, "添加侠义值失败！队伍正常状态玩家个数小于2个");
/* 31 */       return false;
/*    */     }
/* 33 */     int addValue = 0;
/* 34 */     switch (this.gainType)
/*    */     {
/*    */     case 8: 
/* 37 */       addValue = ChivalryConsts.getInstance().SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY;
/* 38 */       break;
/*    */     case 7: 
/* 40 */       addValue = ChivalryConsts.getInstance().ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY;
/* 41 */       break;
/*    */     default: 
/* 43 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("添加侠义值失败！不支持的侠义值类型:%d", new Object[] { Integer.valueOf(this.gainType) }));
/* 44 */       return false;
/*    */     }
/* 46 */     ChivalryManager.addFactionNewGuyTypeChivalry(members, this.gainType, addValue, new TLogArg(LogReason.GM_ADD));
/* 47 */     GmManager.getInstance().sendResultToGM(this.roleId, "操作完成!");
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\PGM_AddTeamChivalry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */