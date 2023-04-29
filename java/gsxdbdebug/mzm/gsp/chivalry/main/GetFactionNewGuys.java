/*     */ package mzm.gsp.chivalry.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.teamplatform.match.TeamMatchInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetFactionNewGuys
/*     */ {
/*     */   private final List<Long> roleIds;
/*     */   private Map<Long, Set<Long>> role2NewGuys;
/*     */   private Map<Long, Integer> role2Lv;
/*     */   private Map<Long, Long> role2FactionId;
/*     */   
/*     */   public GetFactionNewGuys(List<Long> roleIds)
/*     */   {
/*  32 */     this.roleIds = roleIds;
/*  33 */     this.role2NewGuys = new HashMap();
/*  34 */     this.role2Lv = new HashMap();
/*  35 */     this.role2FactionId = new HashMap();
/*     */   }
/*     */   
/*     */   Map<Long, Set<Long>> getNewGuysDataInSameFaction()
/*     */   {
/*  40 */     for (int i = 0; i < this.roleIds.size(); i++)
/*     */     {
/*  42 */       long roleId = ((Long)this.roleIds.get(i)).longValue();
/*  43 */       int roleLv = getRoleLv(roleId);
/*  44 */       for (int j = i + 1; j < this.roleIds.size(); j++)
/*     */       {
/*  46 */         long tmpRoleId = ((Long)this.roleIds.get(j)).longValue();
/*  47 */         fillSingleNewGuyData(roleId, roleLv, tmpRoleId, getRoleLv(tmpRoleId));
/*     */       }
/*     */     }
/*  50 */     return this.role2NewGuys;
/*     */   }
/*     */   
/*     */   private int getRoleLv(long roleId)
/*     */   {
/*  55 */     Integer tmpRoleLv = (Integer)this.role2Lv.get(Long.valueOf(roleId));
/*  56 */     if (tmpRoleLv == null)
/*     */     {
/*  58 */       tmpRoleLv = Integer.valueOf(RoleInterface.getLevel(roleId));
/*  59 */       this.role2Lv.put(Long.valueOf(roleId), tmpRoleLv);
/*     */     }
/*  61 */     return tmpRoleLv.intValue();
/*     */   }
/*     */   
/*     */   private void fillSingleNewGuyData(long r1, int rLv1, long r2, int rLv2)
/*     */   {
/*  66 */     Pair<Long, Long> compareData = getSingleNewGuyData(r1, rLv1, r2, rLv2);
/*  67 */     if (compareData == null)
/*     */     {
/*  69 */       return;
/*     */     }
/*  71 */     Set<Long> newGuys = (Set)this.role2NewGuys.get(compareData.first);
/*  72 */     if (newGuys == null)
/*     */     {
/*  74 */       newGuys = new HashSet();
/*  75 */       this.role2NewGuys.put(compareData.first, newGuys);
/*     */     }
/*  77 */     newGuys.add(compareData.second);
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
/*     */ 
/*     */ 
/*     */   private Pair<Long, Long> getSingleNewGuyData(long roleId1, int roleLv1, long roleId2, int roleLv2)
/*     */   {
/*  92 */     if (!inSameFaction(roleId1, roleId2))
/*     */     {
/*  94 */       return null;
/*     */     }
/*  96 */     int interval = roleLv1 - roleLv2;
/*  97 */     if (Math.abs(interval) < TeamMatchInterface.getNewGuyLevelDiff())
/*     */     {
/*  99 */       return null;
/*     */     }
/* 101 */     if (interval > 0)
/*     */     {
/* 103 */       return new Pair(Long.valueOf(roleId1), Long.valueOf(roleId2));
/*     */     }
/*     */     
/*     */ 
/* 107 */     return new Pair(Long.valueOf(roleId2), Long.valueOf(roleId1));
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
/*     */ 
/*     */ 
/*     */   private boolean inSameFaction(long roleId1, long roleId2)
/*     */   {
/* 122 */     long factionId1 = getRoleFactionId(roleId1);
/* 123 */     long factionId2 = getRoleFactionId(roleId2);
/* 124 */     if ((factionId1 != factionId2) || (factionId1 == 0L))
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
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
/*     */   private long getRoleFactionId(long roleId)
/*     */   {
/* 141 */     Long factionId = (Long)this.role2FactionId.get(Long.valueOf(roleId));
/* 142 */     if (factionId == null)
/*     */     {
/* 144 */       factionId = Long.valueOf(GangInterface.getGangId(roleId));
/* 145 */       this.role2FactionId.put(Long.valueOf(roleId), factionId);
/*     */     }
/* 147 */     return factionId.longValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\GetFactionNewGuys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */