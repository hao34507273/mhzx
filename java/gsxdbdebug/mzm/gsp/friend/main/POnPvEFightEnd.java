/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ 
/*    */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (!((PVEFightEndArg)this.arg).isPlayerWin) {
/* 15 */       return false;
/*    */     }
/* 17 */     if (((PVEFightEndArg)this.arg).alivedRoles.size() <= 0) {
/* 18 */       return false;
/*    */     }
/* 20 */     List<Long> allRole = new ArrayList();
/* 21 */     allRole.addAll(((PVEFightEndArg)this.arg).alivedRoles);
/* 22 */     allRole.addAll(((PVEFightEndArg)this.arg).diedRoles);
/* 23 */     if (allRole.size() <= 1) {
/* 24 */       return false;
/*    */     }
/* 26 */     int friendValue = SFriendConsts.getInstance().valuePerbattle;
/* 27 */     xdb.Lockeys.lock(xtable.Role2friend.getTable(), allRole);
/* 28 */     for (int i = 0; i < allRole.size() - 1; i++) {
/* 29 */       for (int j = i + 1; j < allRole.size(); j++) {
/* 30 */         long role0 = ((Long)allRole.get(i)).longValue();
/* 31 */         long role1 = ((Long)allRole.get(j)).longValue();
/* 32 */         if (FriendInterface.isFriend(role0, role1, false)) {
/* 33 */           FriendInterface.addFriendValue(role0, role1, friendValue, 1);
/*    */         }
/*    */       }
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */