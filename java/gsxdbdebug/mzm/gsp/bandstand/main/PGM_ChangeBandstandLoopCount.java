/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xtable.Role2bandstandsessionid;
/*    */ 
/*    */ public class PGM_ChangeBandstandLoopCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int loopCount;
/*    */   
/*    */   public PGM_ChangeBandstandLoopCount(long roleId, int loopCount)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.loopCount = loopCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     Long sessionId = Role2bandstandsessionid.get(Long.valueOf(this.roleId));
/* 21 */     if (null == sessionId)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有进行音乐台");
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     BandstandSession session = (BandstandSession)BandstandSession.getSession(sessionId.longValue());
/* 28 */     if (null == session)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有进行音乐台");
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     session.setLoopCount(this.loopCount);
/* 35 */     GmManager.getInstance().sendResultToGM(this.roleId, "修改成功");
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\PGM_ChangeBandstandLoopCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */