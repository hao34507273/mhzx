/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleVoipRoom;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2voip_room;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleEnterProtectVoipRoom extends PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     String userid = RoleInterface.getUserId(roleid);
/* 18 */     lock(Lockeys.get(User.getTable(), userid));
/* 19 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 21 */     RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(roleid));
/* 22 */     if (xRoleVoipRoom == null)
/*    */     {
/*    */ 
/* 25 */       StringBuilder sb = new StringBuilder();
/* 26 */       sb.append(String.format("[voiproom]POnRoleEnterProtectVoipRoom.processImp@role not in voip room|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 27 */       VoipRoomManager.logger.info(sb.toString());
/* 28 */       return false;
/*    */     }
/* 30 */     if (xRoleVoipRoom.getVoip_room_type() == 1)
/*    */     {
/* 32 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(xRoleVoipRoom.getOwner_id()), new POnRoleEnterProtectTeamVoipRoom(roleid, xRoleVoipRoom.getOwner_id()));
/*    */       
/* 34 */       return true;
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleEnterProtectVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */