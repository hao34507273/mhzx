/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Team
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().team.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().team.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(xbean.Team value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Team value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Team get(Long key)
/*     */   {
/*  46 */     return (xbean.Team)_Tables_.getInstance().team.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Team get(Long key, xbean.Team value)
/*     */   {
/*  51 */     return (xbean.Team)_Tables_.getInstance().team.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Team value)
/*     */   {
/*  56 */     _Tables_.getInstance().team.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Team value)
/*     */   {
/*  61 */     _Tables_.getInstance().team.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().team.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Team value)
/*     */   {
/*  71 */     return _Tables_.getInstance().team.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Team value)
/*     */   {
/*  76 */     return _Tables_.getInstance().team.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().team.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Team> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().team.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Team> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().team;
/*     */   }
/*     */   
/*     */   public static xbean.Team select(Long key)
/*     */   {
/*  96 */     (xbean.Team)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Team get(xbean.Team v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.TeamMember> selectMembers(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.TeamMember> get(xbean.Team v)
/*     */       {
/* 111 */         return v.getMembersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.TeamApplicant> selectApplicants(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.TeamApplicant> get(xbean.Team v)
/*     */       {
/* 122 */         return v.getApplicantsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.TeamDispositionMember> selectDisposition(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.TeamDispositionMember> get(xbean.Team v)
/*     */       {
/* 133 */         return v.getDispositionAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSameteamfightcount(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Team v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getSameteamfightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectZhenfaid(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Team v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getZhenfaid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIsfromplatform(Long key)
/*     */   {
/* 162 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(xbean.Team v)
/*     */       {
/* 166 */         return Boolean.valueOf(v.getIsfromplatform());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIschangeleadering(Long key)
/*     */   {
/* 173 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(xbean.Team v)
/*     */       {
/* 177 */         return Boolean.valueOf(v.getIschangeleadering());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */