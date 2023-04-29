/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleVoipRoom;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2voip_room;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLoginVoipRoom extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 18 */     String userid = RoleInterface.getUserId(roleid);
/* 19 */     lock(Lockeys.get(User.getTable(), userid));
/* 20 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 22 */     RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(roleid));
/* 23 */     if (xRoleVoipRoom == null)
/*    */     {
/*    */ 
/* 26 */       StringBuilder sb = new StringBuilder();
/* 27 */       sb.append(String.format("[voiproom]POnRoleLoginVoipRoom.processImp@role not in voip room|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 28 */       VoipRoomManager.logger.info(sb.toString());
/* 29 */       return false;
/*    */     }
/* 31 */     if (xRoleVoipRoom.getVoip_room_type() == 1)
/*    */     {
/* 33 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(xRoleVoipRoom.getOwner_id()), new POnRoleLoginTeamVoipRoom(roleid, xRoleVoipRoom.getOwner_id()));
/*    */       
/* 35 */       return true;
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleLoginVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */