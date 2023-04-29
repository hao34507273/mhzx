/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.WorldQuestionBean;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Worldquestion
/*     */ {
/*     */   public static WorldQuestionBean get(Long key)
/*     */   {
/*  12 */     return (WorldQuestionBean)_Tables_.getInstance().worldquestion.get(key);
/*     */   }
/*     */   
/*     */   public static WorldQuestionBean get(Long key, WorldQuestionBean value)
/*     */   {
/*  17 */     return (WorldQuestionBean)_Tables_.getInstance().worldquestion.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, WorldQuestionBean value)
/*     */   {
/*  22 */     _Tables_.getInstance().worldquestion.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().worldquestion.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, WorldQuestionBean value)
/*     */   {
/*  32 */     return _Tables_.getInstance().worldquestion.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().worldquestion.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, WorldQuestionBean> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().worldquestion.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, WorldQuestionBean> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().worldquestion;
/*     */   }
/*     */   
/*     */   public static WorldQuestionBean select(Long key)
/*     */   {
/*  52 */     (WorldQuestionBean)getTable().select(key, new TField()
/*     */     {
/*     */       public WorldQuestionBean get(WorldQuestionBean v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.WAwardBean> selectRoleawarddata(Long key)
/*     */   {
/*  63 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.WAwardBean> get(WorldQuestionBean v)
/*     */       {
/*  67 */         return v.getRoleawarddataAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectGoing(Long key)
/*     */   {
/*  74 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(WorldQuestionBean v)
/*     */       {
/*  78 */         return Boolean.valueOf(v.getGoing());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLasttime(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(WorldQuestionBean v)
/*     */       {
/*  89 */         return Long.valueOf(v.getLasttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNexttime(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(WorldQuestionBean v)
/*     */       {
/* 100 */         return Long.valueOf(v.getNexttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectQuestionid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(WorldQuestionBean v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getQuestionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectOldquestionids(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(WorldQuestionBean v)
/*     */       {
/* 122 */         return v.getOldquestionidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Worldquestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */