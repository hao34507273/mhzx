/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.shitu.SGetChuShiApprenticeSuccess;
/*    */ import mzm.gsp.shitu.ShiTuRoleInfo;
/*    */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MasterInfo;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ 
/*    */ public class PCGetChuShiApprenticeInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long masterRoleId;
/*    */   private final int startPos;
/*    */   
/*    */   public PCGetChuShiApprenticeInfo(long masterRoleId, int startPos)
/*    */   {
/* 24 */     this.masterRoleId = masterRoleId;
/* 25 */     this.startPos = startPos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (this.startPos < 0)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     if (!RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1717, true))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!ShiTuManager.isShiTuSwitchOpen(this.masterRoleId, "PCGetChuShiApprenticeInfo.processImp"))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (this.startPos < 0)
/*    */     {
/* 49 */       GameServer.logger().error(String.format("[shitu]PCGetChuShiApprenticeInfo.processImp@page num <= 0|master_role_id=%d|start_pos=%d", new Object[] { Long.valueOf(this.masterRoleId), Integer.valueOf(this.startPos) }));
/*    */       
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     MasterInfo xMasterInfo = Role2shitu.selectMasterinfo(Long.valueOf(this.masterRoleId));
/*    */     
/* 57 */     if (xMasterInfo == null)
/*    */     {
/* 59 */       GameServer.logger().error(String.format("[shitu]PCGetChuShiApprenticeInfo.processImp@shi tu info is null|master_role_id=%d|start_pos=%d", new Object[] { Long.valueOf(this.masterRoleId), Integer.valueOf(this.startPos) }));
/*    */       
/*    */ 
/*    */ 
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     List<Long> graduateRoleIdList = xMasterInfo.getApprentice_role_list();
/*    */     
/* 68 */     int nowGraduateSize = graduateRoleIdList.size();
/*    */     
/*    */ 
/* 71 */     int endPos = this.startPos + ShiTuConsts.getInstance().graduateApprenticePageSize;
/*    */     
/* 73 */     SGetChuShiApprenticeSuccess sGetChuShiApprentice = new SGetChuShiApprenticeSuccess();
/* 74 */     List<ShiTuRoleInfo> apprenticeList = sGetChuShiApprentice.chushiapprenticelistinfo;
/*    */     
/*    */ 
/* 77 */     for (int index = this.startPos; (index <= endPos - 1) && (index < nowGraduateSize); index++)
/*    */     {
/*    */ 
/* 80 */       long roleId = ((Long)graduateRoleIdList.get(index)).longValue();
/* 81 */       apprenticeList.add(ShiTuManager.setShiTuRoleInfo(roleId, new ShiTuRoleInfo()));
/*    */     }
/* 83 */     OnlineManager.getInstance().send(this.masterRoleId, sGetChuShiApprentice);
/*    */     
/* 85 */     GameServer.logger().info(String.format("[shitu]PCGetChuShiApprenticeInfo.processImp@handle get apprentice info success|master_role_id=%d|begin_num=%d", new Object[] { Long.valueOf(this.masterRoleId), Integer.valueOf(this.startPos) }));
/*    */     
/*    */ 
/*    */ 
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCGetChuShiApprenticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */