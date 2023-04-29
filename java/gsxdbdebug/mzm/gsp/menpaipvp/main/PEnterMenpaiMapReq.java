/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MenpaiPVP;
/*    */ import xbean.MenpaiPVPScore;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Menpaipvpscore;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PEnterMenpaiMapReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int npc;
/*    */   
/*    */   public PEnterMenpaiMapReq(long roleid, int npc)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.npc = npc;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     if (!NpcInterface.checkNpcService(this.npc, 150200034, this.roleid)) {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     String userid = RoleInterface.getUserId(this.roleid);
/* 43 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 46 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, MenpaiPVPConfigManager.getInstance().getActivityID());
/*    */     
/* 48 */     if (!result.isCanJoin()) {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     MenpaiPVPScore xScore = Menpaipvpscore.select(Long.valueOf(this.roleid));
/* 54 */     if (xScore != null) {
/* 55 */       if (MenpaiPVPManager.reachMaxLoseTimes(xScore)) {
/* 56 */         MenpaiPVPManager.sendNormalResult(this.roleid, 1);
/* 57 */         return false;
/*    */       }
/* 59 */       if (MenpaiPVPManager.hasParticipated(xScore)) {
/* 60 */         MenpaiPVPManager.sendNormalResult(this.roleid, 2);
/* 61 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 66 */     if (!RoleStatusInterface.setStatus(this.roleid, 5, true)) {
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     Role role = RoleInterface.getRole(this.roleid, true);
/* 71 */     int menpai = role.getOccupationId();
/* 72 */     int mapid = MenpaiPVPConfigManager.getInstance().getMenpaiMap(menpai);
/* 73 */     if (mapid <= 0) {
/* 74 */       MenpaiPVPManager.logger.error("No menpai map, menpai=" + menpai);
/* 75 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 79 */     MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/*    */     
/* 81 */     Long worldid = (Long)xMenpaiPVP.getMenpai2world().get(Integer.valueOf(menpai));
/* 82 */     if (worldid == null) {
/* 83 */       worldid = Long.valueOf(MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(mapid) })));
/* 84 */       xMenpaiPVP.getMenpai2world().put(Integer.valueOf(menpai), worldid);
/*    */     }
/*    */     
/*    */ 
/* 88 */     MapInterface.forceTransferToScene(this.roleid, worldid.longValue(), mapid);
/*    */     
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PEnterMenpaiMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */