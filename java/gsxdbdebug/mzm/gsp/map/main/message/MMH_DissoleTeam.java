/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.SMapTeamDissole;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.team.MapTeamData;
/*     */ import mzm.gsp.map.main.team.MapTeamManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_DissoleTeam
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long teamid;
/*     */   private final List<Long> members;
/*     */   private final Map<Long, Integer> nowFlyingRoles;
/*     */   private final Map<Long, Boolean> nowOnlineRoles;
/*     */   
/*     */   public MMH_DissoleTeam(long teamid, List<Long> members, Map<Long, Integer> nowFlyingRoles, Map<Long, Boolean> nowOnlineRoles)
/*     */   {
/*  27 */     this.teamid = teamid;
/*  28 */     this.members = members;
/*  29 */     this.nowFlyingRoles = nowFlyingRoles;
/*  30 */     this.nowOnlineRoles = nowOnlineRoles;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  36 */     MapTeamData data = MapTeamManager.getInstance().getTeamById(this.teamid);
/*  37 */     if (data == null)
/*     */     {
/*  39 */       GameServer.logger().info(String.format("[map]MMH_DissoleTeam.doProcess@team is not exist|teamid=%d", new Object[] { Long.valueOf(this.teamid) }));
/*  40 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  45 */       long leaderid = data.getLeaderId();
/*  46 */       MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(leaderid);
/*  47 */       if (leader == null)
/*     */       {
/*     */ 
/*  50 */         GameServer.logger().error(String.format("[map]MMH_DissoleTeam.doProcess@team leader is null|roleid=%d|teamid=%d", new Object[] { Long.valueOf(leaderid), Long.valueOf(this.teamid) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  56 */         SMapTeamDissole dissole = new SMapTeamDissole();
/*  57 */         dissole.teamid = this.teamid;
/*  58 */         leader.broadcastProtocolIncludeSelf(dissole);
/*     */       }
/*     */       
/*  61 */       for (Long roleId : this.members)
/*     */       {
/*  63 */         MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId.longValue());
/*  64 */         if (role != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  69 */           role.setTeamId(-1L);
/*  70 */           role.tryShowFollower();
/*     */           
/*  72 */           role.setXunLuoState(false);
/*  73 */           Integer flySpeed = (Integer)this.nowFlyingRoles.get(roleId);
/*  74 */           if ((flySpeed != null) && (flySpeed.intValue() > 0))
/*     */           {
/*  76 */             role.setFlySpeed(flySpeed.intValue());
/*     */           }
/*     */           else
/*     */           {
/*  80 */             role.setFlySpeed(0);
/*     */           }
/*     */           
/*  83 */           MapTeamData.adjustTeamMemberPos(leader, role);
/*     */         } }
/*  85 */       data.setValid(false);
/*     */       
/*     */ 
/*  88 */       for (Map.Entry<Long, Boolean> entry : this.nowOnlineRoles.entrySet())
/*     */       {
/*  90 */         if (!((Boolean)entry.getValue()).booleanValue())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  95 */           MapRole role = MapObjectInstanceManager.getInstance().getMapRole(((Long)entry.getKey()).longValue());
/*  96 */           if (role != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 101 */             role.destroy();
/*     */           }
/*     */         }
/*     */       }
/*     */     } finally {
/* 106 */       MapTeamManager.getInstance().releaseTeam(this.teamid);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DissoleTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */