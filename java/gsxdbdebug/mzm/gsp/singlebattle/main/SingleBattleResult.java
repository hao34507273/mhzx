/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleBattleResult
/*     */ {
/*     */   private final int _battleCfgId;
/*     */   private final long _battleId;
/*     */   private final int _winerCampId;
/*     */   private final Map<Integer, Long> _camp2mvp;
/*     */   private final Map<Long, Performance> _roleInfos;
/*     */   private final SingleBattleContext _context;
/*     */   private Set<Long> _escapedRoleIds;
/*     */   private Map<Integer, Set<Long>> _campId2RoleIds;
/*     */   
/*     */   public SingleBattleResult(int battleCfgId, long battleId, int winnerCampId, Map<Integer, Long> _camp2mvp, SingleBattleContext _context)
/*     */   {
/*  24 */     this._battleCfgId = battleCfgId;
/*  25 */     this._battleId = battleId;
/*  26 */     this._winerCampId = winnerCampId;
/*  27 */     this._camp2mvp = new HashMap();
/*  28 */     this._camp2mvp.putAll(_camp2mvp);
/*  29 */     this._roleInfos = new HashMap();
/*  30 */     this._context = _context;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getBattleCfgId()
/*     */   {
/*  36 */     return this._battleCfgId;
/*     */   }
/*     */   
/*     */   public long getBattleId()
/*     */   {
/*  41 */     return this._battleId;
/*     */   }
/*     */   
/*     */   public int getWinnerCampId()
/*     */   {
/*  46 */     return this._winerCampId;
/*     */   }
/*     */   
/*     */   public SingleBattleContext get_context()
/*     */   {
/*  51 */     return this._context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addRoleInfo(long roleId, int campId, int point)
/*     */   {
/*  63 */     this._roleInfos.put(Long.valueOf(roleId), new Performance(campId, point));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getCampMvp(int campId)
/*     */   {
/*  74 */     Long mvpLong = (Long)this._camp2mvp.get(Integer.valueOf(campId));
/*  75 */     return mvpLong == null ? -1L : mvpLong.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isMvp(long roleId)
/*     */   {
/*  87 */     return this._camp2mvp.values().contains(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRoleCampId(long roleId)
/*     */   {
/*  98 */     Performance p = (Performance)this._roleInfos.get(Long.valueOf(roleId));
/*  99 */     if (p == null)
/*     */     {
/* 101 */       return -1;
/*     */     }
/* 103 */     return p.getCampId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRolePoint(long roleId)
/*     */   {
/* 114 */     Performance p = (Performance)this._roleInfos.get(Long.valueOf(roleId));
/* 115 */     if (p == null)
/*     */     {
/* 117 */       return 0;
/*     */     }
/* 119 */     return p.getPoint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isWinner(long roleId)
/*     */   {
/* 130 */     return getRoleCampId(roleId) == getWinnerCampId();
/*     */   }
/*     */   
/*     */   class Performance
/*     */   {
/*     */     private final int campId;
/*     */     private final int point;
/*     */     
/*     */     Performance(int campId, int point)
/*     */     {
/* 140 */       this.campId = campId;
/* 141 */       this.point = point;
/*     */     }
/*     */     
/*     */     int getCampId()
/*     */     {
/* 146 */       return this.campId;
/*     */     }
/*     */     
/*     */     int getPoint()
/*     */     {
/* 151 */       return this.point;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */