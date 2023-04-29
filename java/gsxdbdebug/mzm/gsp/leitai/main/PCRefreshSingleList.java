/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.leitai.LeiTaiRoleInfo;
/*    */ import mzm.gsp.leitai.SRefreshSingleListRes;
/*    */ import mzm.gsp.leitai.confbean.SLeiTaiConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class PCRefreshSingleList extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCRefreshSingleList(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!MapInterface.isRoleInPkZone(SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID, this.roleid)) {
/* 26 */       LeiTaiManager.sendNormalResult(this.roleid, 3, new String[0]);
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     xbean.LeiTaiBean xLeiTaiBean = xtable.Leitai.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */     
/* 32 */     Set<Long> singleids = LeiTaiManager.getInstance().randomSingle(SLeiTaiConsts.getInstance().LEI_TAI_REFRESH_NUM, this.roleid, xLeiTaiBean);
/*    */     
/* 34 */     SRefreshSingleListRes sRefreshSingleListRes = new SRefreshSingleListRes();
/* 35 */     for (Iterator i$ = singleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 36 */       LeiTaiRoleInfo leiTaiRoleInfo = new LeiTaiRoleInfo();
/*    */       
/* 38 */       mzm.gsp.role.main.Role role = RoleInterface.getRole(roleid, false);
/* 39 */       LeiTaiManager.fillinLeiTaiRoleInfo(role, leiTaiRoleInfo);
/* 40 */       sRefreshSingleListRes.leitairolelist.add(leiTaiRoleInfo);
/*    */     }
/* 42 */     OnlineManager.getInstance().send(this.roleid, sRefreshSingleListRes);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\PCRefreshSingleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */