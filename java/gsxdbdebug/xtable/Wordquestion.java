/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.WordQuestionInfo;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Wordquestion
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().wordquestion.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().wordquestion.getAutoKey(localid);
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
/*     */   public static Long insert(WordQuestionInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, WordQuestionInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static WordQuestionInfo get(Long key)
/*     */   {
/*  46 */     return (WordQuestionInfo)_Tables_.getInstance().wordquestion.get(key);
/*     */   }
/*     */   
/*     */   public static WordQuestionInfo get(Long key, WordQuestionInfo value)
/*     */   {
/*  51 */     return (WordQuestionInfo)_Tables_.getInstance().wordquestion.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, WordQuestionInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().wordquestion.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, WordQuestionInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().wordquestion.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().wordquestion.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, WordQuestionInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().wordquestion.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, WordQuestionInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().wordquestion.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().wordquestion.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, WordQuestionInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().wordquestion.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, WordQuestionInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().wordquestion;
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RoleWordQuestionInfo> selectRolequestionmap(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.RoleWordQuestionInfo> get(WordQuestionInfo v)
/*     */       {
/* 100 */         return v.getRolequestionmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLevelcfgid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Integer get(WordQuestionInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getLevelcfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Wordquestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */