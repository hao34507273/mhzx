/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.MatchQueue;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Matchqueue
/*     */ {
/*     */   public static MatchQueue get(Long key)
/*     */   {
/*  12 */     return (MatchQueue)_Tables_.getInstance().matchqueue.get(key);
/*     */   }
/*     */   
/*     */   public static MatchQueue get(Long key, MatchQueue value)
/*     */   {
/*  17 */     return (MatchQueue)_Tables_.getInstance().matchqueue.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MatchQueue value)
/*     */   {
/*  22 */     _Tables_.getInstance().matchqueue.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().matchqueue.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MatchQueue value)
/*     */   {
/*  32 */     return _Tables_.getInstance().matchqueue.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().matchqueue.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MatchQueue> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().matchqueue.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MatchQueue> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().matchqueue;
/*     */   }
/*     */   
/*     */   public static MatchQueue select(Long key)
/*     */   {
/*  52 */     (MatchQueue)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public MatchQueue get(MatchQueue v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<xbean.MatchKey, xbean.TeamMatchQueue> selectTeamqueue(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<xbean.MatchKey, xbean.TeamMatchQueue> get(MatchQueue v)
/*     */       {
/*  67 */         return v.getTeamqueueAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<xbean.MatchKey, xbean.TeamMatchQueue> selectRolequeue(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<xbean.MatchKey, xbean.TeamMatchQueue> get(MatchQueue v)
/*     */       {
/*  78 */         return v.getRolequeueAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectRepeatteamids(Long key)
/*     */   {
/*  85 */     (Set)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Set<Long> get(MatchQueue v)
/*     */       {
/*  89 */         return v.getRepeatteamidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectRepeatleaderids(Long key)
/*     */   {
/*  96 */     (Set)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Set<Long> get(MatchQueue v)
/*     */       {
/* 100 */         return v.getRepeatleaderidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.MatchActivityCfg> selectRoleinfo(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.MatchActivityCfg> get(MatchQueue v)
/*     */       {
/* 111 */         return v.getRoleinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Matchqueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */