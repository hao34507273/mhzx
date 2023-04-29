/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Memorycompetition
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().memorycompetition.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().memorycompetition.getAutoKey(localid);
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
/*     */   public static Long insert(MemoryCompetitionInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, MemoryCompetitionInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static MemoryCompetitionInfo get(Long key)
/*     */   {
/*  46 */     return (MemoryCompetitionInfo)_Tables_.getInstance().memorycompetition.get(key);
/*     */   }
/*     */   
/*     */   public static MemoryCompetitionInfo get(Long key, MemoryCompetitionInfo value)
/*     */   {
/*  51 */     return (MemoryCompetitionInfo)_Tables_.getInstance().memorycompetition.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MemoryCompetitionInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().memorycompetition.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, MemoryCompetitionInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().memorycompetition.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().memorycompetition.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MemoryCompetitionInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().memorycompetition.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, MemoryCompetitionInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().memorycompetition.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().memorycompetition.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MemoryCompetitionInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().memorycompetition.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MemoryCompetitionInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().memorycompetition;
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectMapping(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(MemoryCompetitionInfo v)
/*     */       {
/* 100 */         return v.getMappingAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectRole_id_list(Long key)
/*     */   {
/* 107 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(MemoryCompetitionInfo v)
/*     */       {
/* 111 */         return v.getRole_id_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivity_cfg_id(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MemoryCompetitionInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getActivity_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMemory_competition_cfg_id(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MemoryCompetitionInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getMemory_competition_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_round_num(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MemoryCompetitionInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getCurrent_round_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_score(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MemoryCompetitionInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getCurrent_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIs_need_notify_after_every_question(Long key)
/*     */   {
/* 162 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(MemoryCompetitionInfo v)
/*     */       {
/* 166 */         return Boolean.valueOf(v.getIs_need_notify_after_every_question());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RolesMemoryQuestion> selectRoles_answered_question_map(Long key)
/*     */   {
/* 173 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.RolesMemoryQuestion> get(MemoryCompetitionInfo v)
/*     */       {
/* 177 */         return v.getRoles_answered_question_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectRoles_seek_help_times_map(Long key)
/*     */   {
/* 184 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(MemoryCompetitionInfo v)
/*     */       {
/* 188 */         return v.getRoles_seek_help_times_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Memorycompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */