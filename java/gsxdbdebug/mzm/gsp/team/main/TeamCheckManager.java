/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamCheckManager
/*     */ {
/*  18 */   private static Map<Integer, JoinTeamCheckHandler> teamCheckHandlers = new ConcurrentHashMap();
/*     */   
/*     */   public static Map<Integer, JoinTeamCheckHandler> getJoinTeamCheckHandlers()
/*     */   {
/*  22 */     return teamCheckHandlers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void registerTeamCheckImpl(int roleStatus, JoinTeamCheckHandler joinTeamCheckHandler)
/*     */   {
/*  34 */     if (teamCheckHandlers.containsKey(Integer.valueOf(roleStatus)))
/*     */     {
/*  36 */       GameServer.logger().error("加入队伍类已经被注册了，roleStatus = " + roleStatus + "；" + joinTeamCheckHandler.getClass().getName());
/*     */     }
/*     */     
/*  39 */     teamCheckHandlers.put(Integer.valueOf(roleStatus), joinTeamCheckHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean unRegisterTeamCheckImpl(int roleStatus)
/*     */   {
/*  50 */     if (!teamCheckHandlers.containsKey(Integer.valueOf(roleStatus)))
/*     */     {
/*  52 */       GameServer.logger().error("加入队伍类没有被注册，worldId = " + roleStatus);
/*  53 */       return true;
/*     */     }
/*  55 */     teamCheckHandlers.remove(Integer.valueOf(roleStatus));
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, JoinTeamCheckHandler> getRoleOwnHandlers(long roleId)
/*     */   {
/*  67 */     Map<Integer, JoinTeamCheckHandler> handlers = new HashMap();
/*  68 */     Set<Integer> roleStatus = RoleStatusInterface.getStatusSet(roleId);
/*  69 */     for (Iterator i$ = roleStatus.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/*     */       
/*  71 */       JoinTeamCheckHandler handler = (JoinTeamCheckHandler)teamCheckHandlers.get(Integer.valueOf(status));
/*  72 */       if (handler != null)
/*     */       {
/*     */ 
/*     */ 
/*  76 */         handlers.put(Integer.valueOf(status), handler); }
/*     */     }
/*  78 */     return handlers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canJoinTeam(long roleId, long leaderId, TeamInfo teamInfo, boolean needTF2Leader, JoinTeamType joinTeamType)
/*     */   {
/*  91 */     return (canJoinTeamNewGuy(roleId, teamInfo, needTF2Leader, joinTeamType)) && (canJoinTeamLeader(leaderId, roleId, teamInfo, needTF2Leader, joinTeamType));
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean canJoinTeamNewGuy(long roleId, TeamInfo teamInfo, boolean needTF2Leader, JoinTeamType joinTeamType)
/*     */   {
/*  97 */     Map<Integer, JoinTeamCheckHandler> handlers = getRoleOwnHandlers(roleId);
/*  98 */     if ((handlers == null) || (handlers.size() == 0))
/*     */     {
/* 100 */       return true;
/*     */     }
/*     */     
/* 103 */     Iterator<Map.Entry<Integer, JoinTeamCheckHandler>> it = handlers.entrySet().iterator();
/* 104 */     while (it.hasNext())
/*     */     {
/* 106 */       Map.Entry<Integer, JoinTeamCheckHandler> entry = (Map.Entry)it.next();
/* 107 */       int roleStatus = ((Integer)entry.getKey()).intValue();
/* 108 */       JoinTeamCheckHandler handler = (JoinTeamCheckHandler)entry.getValue();
/*     */       
/* 110 */       JoinTeamResult res_member = handler.canJoinTeam(teamInfo, roleId, -1L, -1L, needTF2Leader, joinTeamType);
/* 111 */       if (!res_member.isSucceed())
/*     */       {
/* 113 */         return TeamManager.joinWrongPro(roleId, teamInfo.getLeaderId(), res_member);
/*     */       }
/*     */     }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean canJoinTeamLeader(long leaderId, long roleId, TeamInfo teamInfo, boolean needTF2Leader, JoinTeamType joinTeamType)
/*     */   {
/* 123 */     Map<Integer, JoinTeamCheckHandler> handlers = getRoleOwnHandlers(leaderId);
/* 124 */     if ((handlers == null) || (handlers.size() == 0))
/*     */     {
/* 126 */       return true;
/*     */     }
/* 128 */     Iterator<Map.Entry<Integer, JoinTeamCheckHandler>> it = handlers.entrySet().iterator();
/* 129 */     while (it.hasNext())
/*     */     {
/* 131 */       Map.Entry<Integer, JoinTeamCheckHandler> entry = (Map.Entry)it.next();
/* 132 */       int roleStatus = ((Integer)entry.getKey()).intValue();
/* 133 */       JoinTeamCheckHandler handler = (JoinTeamCheckHandler)entry.getValue();
/*     */       
/* 135 */       JoinTeamResult res_member = handler.canJoinTeam(teamInfo, roleId, -1L, -1L, needTF2Leader, joinTeamType);
/* 136 */       if (!res_member.isSucceed())
/*     */       {
/* 138 */         return TeamManager.joinWrongPro(roleId, teamInfo.getLeaderId(), res_member);
/*     */       }
/*     */     }
/*     */     
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamCheckManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */