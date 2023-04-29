/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.QYXTQuestionInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2qyxtquestion
/*     */ {
/*     */   public static QYXTQuestionInfo get(Long key)
/*     */   {
/*  12 */     return (QYXTQuestionInfo)_Tables_.getInstance().role2qyxtquestion.get(key);
/*     */   }
/*     */   
/*     */   public static QYXTQuestionInfo get(Long key, QYXTQuestionInfo value)
/*     */   {
/*  17 */     return (QYXTQuestionInfo)_Tables_.getInstance().role2qyxtquestion.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, QYXTQuestionInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2qyxtquestion.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2qyxtquestion.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, QYXTQuestionInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2qyxtquestion.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2qyxtquestion.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, QYXTQuestionInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2qyxtquestion.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, QYXTQuestionInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2qyxtquestion;
/*     */   }
/*     */   
/*     */   public static QYXTQuestionInfo select(Long key)
/*     */   {
/*  52 */     (QYXTQuestionInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public QYXTQuestionInfo get(QYXTQuestionInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRightnum(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(QYXTQuestionInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getRightnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectSeek_help_questions(Long key)
/*     */   {
/*  74 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(QYXTQuestionInfo v)
/*     */       {
/*  78 */         return v.getSeek_help_questionsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectCurrent_help_roleids(Long key)
/*     */   {
/*  85 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(QYXTQuestionInfo v)
/*     */       {
/*  89 */         return v.getCurrent_help_roleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Integer> selectQuestions(Long key)
/*     */   {
/*  96 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Integer> get(QYXTQuestionInfo v)
/*     */       {
/* 100 */         return v.getQuestionsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_force_answer_index(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(QYXTQuestionInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCurrent_force_answer_index());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2qyxtquestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */