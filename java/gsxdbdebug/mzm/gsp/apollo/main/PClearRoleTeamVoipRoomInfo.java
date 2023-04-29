/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.apollo.SApolloExitVoipRoomRsp;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleVoipRoom;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2voip_room;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class PClearRoleTeamVoipRoomInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long teamid;
/*    */   private final long roomid;
/*    */   private final int memberid;
/*    */   private final boolean isSendProtocol;
/*    */   
/*    */   public PClearRoleTeamVoipRoomInfo(long roleid, long teamid, long roomid, int memberid, boolean isSendProtocol)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.teamid = teamid;
/* 27 */     this.roomid = roomid;
/* 28 */     this.memberid = memberid;
/* 29 */     this.isSendProtocol = isSendProtocol;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     String userid = RoleInterface.getUserId(this.roleid);
/* 37 */     lock(Lockeys.get(User.getTable(), userid));
/* 38 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 40 */     RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(this.roleid));
/* 41 */     if (xRoleVoipRoom == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     if ((xRoleVoipRoom.getVoip_room_type() != 1) || (xRoleVoipRoom.getOwner_id() != this.teamid))
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     Role2voip_room.remove(Long.valueOf(this.roleid));
/*    */     
/* 51 */     if (this.isSendProtocol)
/*    */     {
/* 53 */       SApolloExitVoipRoomRsp protocol = new SApolloExitVoipRoomRsp();
/* 54 */       protocol.retcode = 0;
/* 55 */       protocol.voip_room_type = 1;
/* 56 */       protocol.room_id = this.roomid;
/* 57 */       protocol.member_id = this.memberid;
/* 58 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     }
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PClearRoleTeamVoipRoomInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */