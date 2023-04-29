/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleVoipRoom;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2voip_room;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogoffVoipRoom
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 19 */     String userid = RoleInterface.getUserId(roleid);
/* 20 */     lock(Lockeys.get(User.getTable(), userid));
/* 21 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 23 */     RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(roleid));
/* 24 */     if (xRoleVoipRoom == null)
/*    */     {
/*    */ 
/* 27 */       StringBuilder sb = new StringBuilder();
/* 28 */       sb.append(String.format("[voiproom]POnRoleLogoffVoipRoom.processImp@role not in voip room|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 29 */       VoipRoomManager.logger.info(sb.toString());
/* 30 */       return false;
/*    */     }
/* 32 */     if (xRoleVoipRoom.getVoip_room_type() == 1)
/*    */     {
/* 34 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(xRoleVoipRoom.getOwner_id()), new PTryExitTeamVoipRoom(roleid, xRoleVoipRoom.getOwner_id()));
/*    */       
/* 36 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(xRoleVoipRoom.getOwner_id()), new PClearRoleTeamVoipRoomInfo(roleid, xRoleVoipRoom.getOwner_id(), 0L, 0, false));
/*    */       
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleLogoffVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */