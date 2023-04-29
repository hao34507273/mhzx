/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*    */ import xbean.MasterInfo;
/*    */ import xbean.ShiTuTimeInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ public class PGM_ChuShiAllApprentice extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ChuShiAllApprentice(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     role2ShiTuInfo xSelectShiTuInfo = Role2shitu.select(Long.valueOf(this.roleId));
/* 29 */     if (xSelectShiTuInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     List<Long> nowApprenticeList = xSelectShiTuInfo.getMasterinfo().getNow_apprentice_role_list();
/* 34 */     List<Long> roleList = new ArrayList(nowApprenticeList);
/* 35 */     roleList.add(Long.valueOf(this.roleId));
/* 36 */     List<String> userIdList = new ArrayList();
/* 37 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       userIdList.add(RoleInterface.getUserId(roleId));
/*    */     }
/* 41 */     lock(xtable.User.getTable(), userIdList);
/* 42 */     lock(xtable.Role2properties.getTable(), roleList);
/*    */     
/* 44 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(this.roleId));
/* 45 */     MasterInfo xMasterInfo = xRole2ShiTuInfo.getMasterinfo();
/* 46 */     for (Iterator i$ = xMasterInfo.getNow_apprentice_role_list().iterator(); i$.hasNext();) { long apprenticeRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 48 */       ShiTuTimeInfo xShiTuTimeInfo = (ShiTuTimeInfo)xMasterInfo.getApprentice_now().get(Long.valueOf(apprenticeRoleId));
/* 49 */       ShiTuTimeInfo xApprenticeShiTuTimeInfo = xbean.Pod.newShiTuTimeInfo();
/* 50 */       xApprenticeShiTuTimeInfo.setEndtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 51 */       xApprenticeShiTuTimeInfo.setStarttime(xShiTuTimeInfo.getStarttime());
/* 52 */       xMasterInfo.getApprentice_graduate().put(Long.valueOf(apprenticeRoleId), xApprenticeShiTuTimeInfo);
/* 53 */       xMasterInfo.getApprentice_role_list().add(Long.valueOf(apprenticeRoleId));
/*    */       
/* 55 */       role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(apprenticeRoleId));
/* 56 */       if (xApprenticeShiTuInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 60 */         mzm.gsp.shitu.SChuShiSuccess sChuShiSuccess = new mzm.gsp.shitu.SChuShiSuccess();
/* 61 */         sChuShiSuccess.apprenticeroleid = apprenticeRoleId;
/* 62 */         sChuShiSuccess.apprenticerolename = RoleInterface.getName(apprenticeRoleId);
/*    */         
/* 64 */         xApprenticeShiTuInfo.setGraduatetimes(xApprenticeShiTuInfo.getGraduatetimes() + 1);
/* 65 */         xApprenticeShiTuInfo.getApprenticeinfo().getTimeinfo().setEndtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */         
/* 67 */         mzm.gsp.title.main.TitleInterface.removeAppllation(apprenticeRoleId, ShiTuConsts.getInstance().apprenticeAppellationId);
/*    */         
/* 69 */         mzm.gsp.title.main.TitleInterface.addAppellation(apprenticeRoleId, ShiTuConsts.getInstance().chuShiAppellationId, java.util.Arrays.asList(new String[] { RoleInterface.getName(this.roleId) }));
/*    */         
/*    */ 
/* 72 */         OnlineManager.getInstance().sendMulti(sChuShiSuccess, java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(apprenticeRoleId) }));
/*    */       } }
/* 74 */     xMasterInfo.getNow_apprentice_role_list().clear();
/* 75 */     xMasterInfo.getApprentice_now().clear();
/*    */     
/* 77 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 78 */     messagetip.result = Integer.MAX_VALUE;
/* 79 */     messagetip.args.add(String.format("你的弟子已经全部出师了！!", new Object[0]));
/* 80 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*    */     
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PGM_ChuShiAllApprentice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */