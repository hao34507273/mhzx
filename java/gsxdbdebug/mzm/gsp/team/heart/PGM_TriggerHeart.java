/*    */ package mzm.gsp.team.heart;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_TriggerHeart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_TriggerHeart(long roleId)
/*    */   {
/* 25 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!HeartManager.isHeartModuleOpen())
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, "心动关闭啦~");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 39 */     if (teamInfo == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     List<Long> normalIds = teamInfo.getTeamNormalList();
/* 44 */     if (normalIds.size() <= 1)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     long other = 0L;
/* 49 */     for (Iterator i$ = normalIds.iterator(); i$.hasNext();) { long tmpId = ((Long)i$.next()).longValue();
/*    */       
/* 51 */       if (tmpId != this.roleId)
/*    */       {
/*    */ 
/*    */ 
/* 55 */         other = tmpId; }
/*    */     }
/* 57 */     if (other <= 0L)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     HeartManager.sendBothSGetHeart(this.roleId, other);
/*    */     
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\heart\PGM_TriggerHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */