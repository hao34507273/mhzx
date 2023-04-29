/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ public class PvcFriend
/*    */   extends AbsPvcFight
/*    */ {
/*    */   public PvcFriend(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 20 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */   long getMrTargetRoleId()
/*    */   {
/* 26 */     return ranOneFriend(getRoleId());
/*    */   }
/*    */   
/*    */ 
/*    */   List<Long> getPassiveRoleIds()
/*    */   {
/* 32 */     List<Long> roleIds = new ArrayList();
/* 33 */     long friendRoleId = ranOneFriend(getRoleId());
/* 34 */     if (friendRoleId > 0L)
/*    */     {
/* 36 */       roleIds.add(Long.valueOf(friendRoleId));
/*    */     }
/* 38 */     return roleIds;
/*    */   }
/*    */   
/*    */ 
/*    */   long ranOneFriend(long roleId)
/*    */   {
/* 44 */     Map<Long, Integer> role2friendValue = FriendInterface.getAllFriendValue(roleId, false);
/* 45 */     if ((role2friendValue == null) || (role2friendValue.size() == 0))
/*    */     {
/* 47 */       return -1L;
/*    */     }
/* 49 */     int totalValue = 0;
/* 50 */     for (Iterator i$ = role2friendValue.values().iterator(); i$.hasNext();) { int value = ((Integer)i$.next()).intValue();
/*    */       
/* 52 */       totalValue += value;
/*    */     }
/* 54 */     if (totalValue == 0)
/*    */     {
/*    */ 
/* 57 */       List<Long> allFriends = new ArrayList(role2friendValue.keySet());
/* 58 */       List<Long> needFriends = new ArrayList();
/* 59 */       CommonUtils.regionRandom(allFriends, 1, needFriends);
/* 60 */       if (needFriends.size() != 1)
/*    */       {
/* 62 */         return -1L;
/*    */       }
/* 64 */       return ((Long)needFriends.get(0)).longValue();
/*    */     }
/* 66 */     int ran = Xdb.random().nextInt(totalValue);
/* 67 */     int tmpValue = 0;
/* 68 */     for (Map.Entry<Long, Integer> entry : role2friendValue.entrySet())
/*    */     {
/* 70 */       tmpValue += ((Integer)entry.getValue()).intValue();
/* 71 */       if (tmpValue > ran)
/*    */       {
/*    */ 
/*    */ 
/* 75 */         return ((Long)entry.getKey()).longValue();
/*    */       }
/*    */     }
/* 78 */     return -1L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PvcFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */