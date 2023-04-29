/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chess.SNotifyPreviewChess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCPreviewChessReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCPreviewChessReq(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 22 */     List<Long> roleIds = TeamInterface.getNormalRoleList(this.roleId);
/*    */     
/* 24 */     if (roleIds.size() == 0)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 30 */       if (roleId != this.roleId)
/*    */       {
/*    */ 
/*    */ 
/* 34 */         OnlineManager.getInstance().send(roleId, new SNotifyPreviewChess());
/*    */       }
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PCPreviewChessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */