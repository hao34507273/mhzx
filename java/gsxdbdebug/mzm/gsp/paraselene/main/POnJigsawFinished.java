/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.paraselene.event.JigsawFinishArg;
/*    */ import mzm.gsp.paraselene.event.JigsawFinishProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJigsawFinished extends JigsawFinishProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if ((((JigsawFinishArg)this.arg).getContext() == null) || (!(((JigsawFinishArg)this.arg).getContext() instanceof ParaseleneJigsawContext)))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     ParaseleneJigsawContext jigsawContext = (ParaseleneJigsawContext)((JigsawFinishArg)this.arg).getContext();
/* 23 */     int layer = jigsawContext.getLayer();
/*    */     
/* 25 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId);
/*    */     
/* 27 */     if ((((JigsawFinishArg)this.arg).getAllRoleids() == null) || (((JigsawFinishArg)this.arg).getAllRoleids().size() == 0))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     Map<Long, String> roleidToUserid = new HashMap();
/* 33 */     List<Long> allRoles = ((JigsawFinishArg)this.arg).getAllRoleids();
/* 34 */     for (Long roleid : allRoles)
/*    */     {
/* 36 */       String userid = RoleInterface.getUserId(roleid.longValue());
/* 37 */       roleidToUserid.put(roleid, userid);
/*    */     }
/* 39 */     lock(User.getTable(), roleidToUserid.values());
/* 40 */     lock(xtable.Role2properties.getTable(), allRoles);
/*    */     
/* 42 */     ParaseleneManager.sendjigsawRes(((JigsawFinishArg)this.arg).getSucroleids(), ((JigsawFinishArg)this.arg).getFailedroleids(), ((JigsawFinishArg)this.arg).isIspassed());
/* 43 */     if (((JigsawFinishArg)this.arg).isIspassed())
/*    */     {
/*    */ 
/* 46 */       boolean hasFanPai = ParaseleneManager.offerAwardOnTaskEnd(roleidToUserid, ((JigsawFinishArg)this.arg).getAllRoleids(), ((JigsawFinishArg)this.arg).getAllRoleids(), layer, LogReason.PARASELENE_ACTIVITY_REWARD_ADD);
/*    */       
/* 48 */       ParaseleneManager.sendOnTaskSuccess(layer, ((JigsawFinishArg)this.arg).getAllRoleids());
/* 49 */       if (isActivityOpen)
/*    */       {
/* 51 */         if (!hasFanPai)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 57 */           ParaseleneManager.transferToNextLayer(((JigsawFinishArg)this.arg).getAllRoleids(), layer);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 62 */       ParaseleneManager.logActivityAndAddCount(roleidToUserid, ((JigsawFinishArg)this.arg).getAllRoleids());
/* 63 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 67 */     ParaseleneManager.sendOnTaskFailed(layer, ((JigsawFinishArg)this.arg).getAllRoleids());
/*    */     
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnJigsawFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */