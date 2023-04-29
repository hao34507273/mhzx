/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.WorldGoal;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Worldgoals
/*     */ {
/*     */   public static WorldGoal get(Long key)
/*     */   {
/*  12 */     return (WorldGoal)_Tables_.getInstance().worldgoals.get(key);
/*     */   }
/*     */   
/*     */   public static WorldGoal get(Long key, WorldGoal value)
/*     */   {
/*  17 */     return (WorldGoal)_Tables_.getInstance().worldgoals.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, WorldGoal value)
/*     */   {
/*  22 */     _Tables_.getInstance().worldgoals.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().worldgoals.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, WorldGoal value)
/*     */   {
/*  32 */     return _Tables_.getInstance().worldgoals.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().worldgoals.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, WorldGoal> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().worldgoals.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, WorldGoal> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().worldgoals;
/*     */   }
/*     */   
/*     */   public static WorldGoal select(Long key)
/*     */   {
/*  52 */     (WorldGoal)getTable().select(key, new TField()
/*     */     {
/*     */       public WorldGoal get(WorldGoal v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.Section> selectSections(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.Section> get(WorldGoal v)
/*     */       {
/*  67 */         return v.getSectionsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_section_id(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(WorldGoal v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurrent_section_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectExtra_award_num(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(WorldGoal v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getExtra_award_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectExtra_award_num_timestamp(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(WorldGoal v)
/*     */       {
/* 100 */         return Long.valueOf(v.getExtra_award_num_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectCommit_roles(Long key)
/*     */   {
/* 107 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(WorldGoal v)
/*     */       {
/* 111 */         return v.getCommit_rolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorld_id(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(WorldGoal v)
/*     */       {
/* 122 */         return Long.valueOf(v.getWorld_id());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Worldgoals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */