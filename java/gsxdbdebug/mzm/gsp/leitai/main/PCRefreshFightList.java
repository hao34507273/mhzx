/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.leitai.LeiTaiFightInfo;
/*    */ import mzm.gsp.leitai.SRefreshFightListRes;
/*    */ import mzm.gsp.leitai.confbean.SLeiTaiConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.LeiTaiFight;
/*    */ 
/*    */ public class PCRefreshFightList extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCRefreshFightList(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!MapInterface.isRoleInPkZone(SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID, this.roleid)) {
/* 27 */       LeiTaiManager.sendNormalResult(this.roleid, 3, new String[0]);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.LeiTaiBean xleiTaiBean = xtable.Leitai.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 32 */     java.util.Set<Map.Entry<Long, LeiTaiFight>> set = LeiTaiManager.getInstance().randomFight(xleiTaiBean, SLeiTaiConsts.getInstance().LEI_TAI_REFRESH_NUM);
/*    */     
/* 34 */     SRefreshFightListRes sRefreshFightListRes = new SRefreshFightListRes();
/* 35 */     for (Map.Entry<Long, LeiTaiFight> entry : set) {
/* 36 */       LeiTaiFightInfo leiTaiFightInfo = new LeiTaiFightInfo();
/*    */       
/* 38 */       Role activityRole = RoleInterface.getRole(((LeiTaiFight)entry.getValue()).getActiveroleid(), false);
/* 39 */       LeiTaiManager.fillinLeiTaiRoleInfo(activityRole, leiTaiFightInfo.activeroleinfo);
/* 40 */       leiTaiFightInfo.activeteamnum = ((LeiTaiFight)entry.getValue()).getActiveteamnum();
/*    */       
/*    */ 
/* 43 */       Role passiveRole = RoleInterface.getRole(((LeiTaiFight)entry.getValue()).getPassiveroleid(), false);
/* 44 */       LeiTaiManager.fillinLeiTaiRoleInfo(passiveRole, leiTaiFightInfo.passiveroleinfo);
/* 45 */       leiTaiFightInfo.passiveteamnum = ((LeiTaiFight)entry.getValue()).getPassiveteamnum();
/* 46 */       sRefreshFightListRes.leitaifightinfolist.add(leiTaiFightInfo);
/*    */     }
/* 48 */     OnlineManager.getInstance().send(this.roleid, sRefreshFightListRes);
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\PCRefreshFightList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */