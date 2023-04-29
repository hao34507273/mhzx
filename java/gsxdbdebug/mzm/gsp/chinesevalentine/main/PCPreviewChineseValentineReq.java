/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chinesevalentine.SNotifyPreviewChineseValentine;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PCPreviewChineseValentineReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCPreviewChineseValentineReq(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     List<Long> roleIds = TeamInterface.getNormalRoleList(this.roleId);
/*    */     
/* 22 */     if (roleIds.size() == 0) {
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     if ((roleIds.size() <= 0) || (((Long)roleIds.get(0)).longValue() != this.roleId)) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 32 */       if (roleId != this.roleId)
/*    */       {
/*    */ 
/* 35 */         OnlineManager.getInstance().send(roleId, new SNotifyPreviewChineseValentine());
/*    */       }
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\PCPreviewChineseValentineReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */