/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.ShiTuRoleInfoAndModelInfo;
/*    */ import mzm.gsp.shitu.SynApprenticeRecommendInfo;
/*    */ import mzm.gsp.shitu.confbean.SMasterRecommendConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MasterRecommendSession
/*    */   extends Session
/*    */ {
/*    */   private final Set<Long> recommendRoleIds;
/*    */   
/*    */   public MasterRecommendSession(long interval, long roleId, Set<Long> recommendRoleIds)
/*    */   {
/* 30 */     super(interval, roleId);
/* 31 */     this.recommendRoleIds = Collections.unmodifiableSet(recommendRoleIds);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 37 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 44 */         SynApprenticeRecommendInfo synApprenticeRecommendInfo = new SynApprenticeRecommendInfo();
/* 45 */         synApprenticeRecommendInfo.apprentice_recommend_info = ShiTuManager.setShiTuRoleInfoAndModelInfo(MasterRecommendSession.this.getOwerId(), new ShiTuRoleInfoAndModelInfo());
/*    */         
/* 47 */         OnlineManager.getInstance().sendMulti(synApprenticeRecommendInfo, MasterRecommendSession.this.recommendRoleIds);
/*    */         
/*    */ 
/* 50 */         if (RoleInterface.getLevel(MasterRecommendSession.this.getOwerId()) >= SMasterRecommendConsts.getInstance().APPRENTICE_MAX_LEVEL)
/*    */         {
/*    */ 
/* 53 */           ShiTuManager.triggerMasterRecommendEvent(MasterRecommendSession.this.getOwerId(), MasterRecommendSession.this.recommendRoleIds, false);
/*    */         }
/*    */         
/* 56 */         ShiTuTLogManager.tlogShiTuRecommend(MasterRecommendSession.this.getOwerId(), RoleInterface.getUserId(MasterRecommendSession.this.getOwerId()), MasterRecommendSession.this.recommendRoleIds, ShiTuRecommendEnum.TIMEOUT_RECOMMEND);
/*    */         
/* 58 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public Set<Long> getRecommendRoleIds()
/*    */   {
/* 65 */     return this.recommendRoleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\MasterRecommendSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */