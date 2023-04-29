/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import xbean.RoleVoipRoom;
/*    */ 
/*    */ public class VoipRoomManager
/*    */ {
/*  7 */   static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("voiproom");
/*    */   
/*  9 */   static int EXIT_VOIP_ROOM_TRY_TIMES = 3;
/* 10 */   static int EXIT_VOIP_ROOM_TIMEOUT = 20;
/* 11 */   static int CLOSE_VOIP_ROOM_TRY_TIMES = 3;
/* 12 */   static int CLOSE_VOIP_ROOM_TIMEOUT = 20;
/* 13 */   static int VOIP_ROOM_PROTECT_TIME_IN_SECOND = 300;
/*    */   
/* 15 */   static boolean IS_DEBUG_MODE = false;
/*    */   
/*    */   static void init()
/*    */   {
/* 19 */     if (System.getProperty("com.zulong.mhzx.voip_debug_mode") != null)
/*    */     {
/* 21 */       IS_DEBUG_MODE = true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleInVoipRoom(long roleid)
/*    */   {
/* 33 */     return xtable.Role2voip_room.get(Long.valueOf(roleid)) != null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleInThisVoipRoom(long roleid, int voipRoomType, long ownerid)
/*    */   {
/* 47 */     RoleVoipRoom xRoleVoipRoom = xtable.Role2voip_room.get(Long.valueOf(roleid));
/* 48 */     if (xRoleVoipRoom == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     if ((xRoleVoipRoom.getVoip_room_type() != voipRoomType) || (xRoleVoipRoom.getOwner_id() != ownerid))
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleInOtherVoipRoom(long roleid, int voipRoomType, long ownerid)
/*    */   {
/* 70 */     RoleVoipRoom xRoleVoipRoom = xtable.Role2voip_room.get(Long.valueOf(roleid));
/* 71 */     if ((xRoleVoipRoom != null) && ((xRoleVoipRoom.getVoip_room_type() != voipRoomType) || (xRoleVoipRoom.getOwner_id() != ownerid)))
/*    */     {
/*    */ 
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\VoipRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */