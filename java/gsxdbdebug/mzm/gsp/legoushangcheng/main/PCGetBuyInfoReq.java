/*    */ package mzm.gsp.legoushangcheng.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LeGouShangChengInfo;
/*    */ import xtable.Role2legoushangchenginfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetBuyInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCGetBuyInfoReq(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(435))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1731, false))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!LeGouShangChengManager.checkRoleLevelAndServerTime(this.roleId))
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     LeGouShangChengInfo xLeGouShangChengInfo = Role2legoushangchenginfo.get(Long.valueOf(this.roleId));
/* 45 */     LeGouShangChengManager.synLeGouShangchengInfo(this.roleId, xLeGouShangChengInfo);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\main\PCGetBuyInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */