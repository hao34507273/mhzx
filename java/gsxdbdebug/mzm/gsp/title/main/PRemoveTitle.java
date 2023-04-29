/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.TitleAppellation;
/*    */ 
/*    */ class PRemoveTitle extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int titleId;
/*    */   
/*    */   public PRemoveTitle(long roleId, int titleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.titleId = titleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     TitleAppellation xTitleAppellation = xtable.Role2titleappellation.get(Long.valueOf(this.roleId));
/* 21 */     if (xTitleAppellation == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     boolean findTitle = TitleManager.rmTitleFromDB(xTitleAppellation, this.titleId);
/* 25 */     if (!findTitle) {
/* 26 */       GameServer.logger().warn(String.format("[title]PRemoveTitle.processImp@ not own title!|roleId=%d|titleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.titleId) }));
/*    */       
/*    */ 
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     TitleManager.rmTitleNotice(this.roleId, this.titleId);
/*    */     
/* 34 */     xbean.TitleSessionInfo xInfo = xtable.Role2titlesession.get(Long.valueOf(this.roleId));
/* 35 */     if (xInfo != null)
/*    */     {
/* 37 */       TitleManager.rmTitleSession(this.titleId, xInfo);
/*    */     }
/*    */     
/* 40 */     if (xTitleAppellation.getActivetitle() == this.titleId) {
/* 41 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PChangeTitleOrAppellationReq(this.roleId, 0, 1));
/*    */     }
/* 43 */     GameServer.logger().info(String.format("[title]PRemoveTitle.processImp@ rm title!|roleId=%d|titleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.titleId) }));
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PRemoveTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */