/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.sworn.SCreateSwornFailRes;
/*    */ import xbean.SwornBuilder;
/*    */ import xtable.Swornbuilder;
/*    */ 
/*    */ public class PRejectSwornNameReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long swornid;
/*    */   
/*    */   public PRejectSwornNameReq(long _roleid, long _swornid)
/*    */   {
/* 18 */     this.roleid = _roleid;
/* 19 */     this.swornid = _swornid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*    */     {
/* 26 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     String roleName = mzm.gsp.role.main.RoleInterface.getName(this.roleid);
/*    */     
/*    */ 
/* 34 */     SwornBuilder swornBuilder = Swornbuilder.get(Long.valueOf(this.swornid));
/* 35 */     if (swornBuilder == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!swornBuilder.getRoleids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     List<Long> roleids = new ArrayList();
/* 46 */     roleids.addAll(swornBuilder.getRoleids());
/*    */     
/* 48 */     if (!SwornManager.removeSwornBuilder(this.swornid)) {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     SCreateSwornFailRes res = new SCreateSwornFailRes(7, roleName, "");
/* 53 */     OnlineManager.getInstance().sendMultiAtOnce(res, roleids);
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PRejectSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */