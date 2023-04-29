/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.GHubHelper;
/*     */ import hub.RoamRoleDataReq;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFail;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFailArg;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.scene.PositionWithExtraInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOutFightObj;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Location;
/*     */ import xbean.Properties;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ class PSendRoamRole extends LogicProcedure implements MapCallback<Map<Long, PositionWithExtraInfo>>
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final RoamContext context;
/*     */   
/*     */   PSendRoamRole(String userid, long roleid, RoamContext context)
/*     */   {
/*  33 */     this.userid = userid;
/*  34 */     this.roleid = roleid;
/*  35 */     this.context = context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     return onResult(null);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Map<Long, PositionWithExtraInfo> result)
/*     */   {
/*  57 */     boolean sendResult = false;
/*     */     try
/*     */     {
/*  60 */       if (result != null)
/*     */       {
/*  62 */         PositionWithExtraInfo pos = (PositionWithExtraInfo)result.get(Long.valueOf(this.roleid));
/*  63 */         if (pos != null)
/*     */         {
/*  65 */           savePosition(pos);
/*     */         }
/*     */       }
/*     */       
/*  69 */       sendResult = sendRoamRoleData();
/*     */     } catch (Exception e) {
/*     */       RoamRoleDataFail event;
/*     */       RoamRoleDataFailArg arg;
/*  73 */       GameServer.logger().error(String.format("[crossserver]PSendRoamRole.onResult@send roam role data error|userid=%s|roleid=%d", new Object[] { this.userid, Long.valueOf(this.roleid) }));
/*     */     }
/*     */     finally
/*     */     {
/*     */       RoamRoleDataFail event;
/*     */       RoamRoleDataFailArg arg;
/*  79 */       if (!sendResult)
/*     */       {
/*  81 */         RoamRoleDataFail event = new RoamRoleDataFail();
/*  82 */         RoamRoleDataFailArg arg = RoamRoleDataEventCreator.createRoamRoleDataFailArg(this.context);
/*  83 */         TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       }
/*     */     }
/*     */     
/*  87 */     return sendResult;
/*     */   }
/*     */   
/*     */ 
/*     */   private void savePosition(PositionWithExtraInfo pos)
/*     */   {
/*  93 */     Lockeys.lock(Lockeys.get(User.getTable(), this.userid));
/*     */     
/*  95 */     Properties xProperties = xtable.Role2properties.get(Long.valueOf(this.roleid));
/*  96 */     if (xProperties != null)
/*     */     {
/*  98 */       Location xLocation = xProperties.getLocation();
/*  99 */       xLocation.setSceneid(pos.getSceneId());
/* 100 */       xLocation.setX(pos.getX());
/* 101 */       xLocation.setY(pos.getY());
/* 102 */       xLocation.setZ(pos.getZ());
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean sendRoamRoleData() throws Exception
/*     */   {
/* 108 */     DataTransferReq req = new DataTransferReq();
/* 109 */     req.direction = 0;
/* 110 */     req.data_type = 2;
/* 111 */     req.src_id = GameServerInfoManager.getZoneidFromUserid(this.userid);
/* 112 */     req.dst_id = this.context.getRoamZoneid();
/* 113 */     RoamRoleDataReq roamRoleDataReq = new RoamRoleDataReq();
/* 114 */     roamRoleDataReq.userid.setString(this.userid, "UTF-8");
/* 115 */     roamRoleDataReq.roleid = this.roleid;
/* 116 */     roamRoleDataReq.roam_type = this.context.getRoamType().ordinal();
/* 117 */     roamRoleDataReq.roam_room_instanceid = this.context.getRoamRoomInstanceid();
/*     */     
/* 119 */     CrossServerManager.boxRoleXtableData(this.userid, this.roleid, roamRoleDataReq.xtables);
/*     */     
/*     */ 
/* 122 */     OctetsStream os = new OctetsStream();
/* 123 */     os.marshal(roamRoleDataReq);
/* 124 */     req.data = os;
/*     */     
/* 126 */     GameServer.logger().info(String.format("[crossserver]PSendRoamRole.sendRoamRoleData@dump role data size|userid=%s|roleid=%d|data_szie=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(os.size()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */     RoleOutFightObj roleOutFightObj = RoleInterface.getRoleOutFightObject(this.roleid);
/* 135 */     GameServer.logger().info(String.format("[crossserver]PSendRoamRole.sendRoamRoleData@dump role out fight obj info|userid=%s|%s", new Object[] { this.userid, roleOutFightObj.getSimpleInfo() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 140 */     RoamRoleDataTransferReqXidWrapper reqXidWrapper = new RoamRoleDataTransferReqXidWrapper(req, this.context);
/* 141 */     if (!GHubHelper.sendDataTransferReq(reqXidWrapper, false))
/*     */     {
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PSendRoamRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */