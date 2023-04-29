/*    */ package xtable;
/*    */ 
/*    */ import xbean.AnswerWorldQuestionData;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2worldquestion
/*    */ {
/*    */   public static AnswerWorldQuestionData get(Long key)
/*    */   {
/* 12 */     return (AnswerWorldQuestionData)_Tables_.getInstance().role2worldquestion.get(key);
/*    */   }
/*    */   
/*    */   public static AnswerWorldQuestionData get(Long key, AnswerWorldQuestionData value)
/*    */   {
/* 17 */     return (AnswerWorldQuestionData)_Tables_.getInstance().role2worldquestion.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AnswerWorldQuestionData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2worldquestion.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2worldquestion.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AnswerWorldQuestionData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2worldquestion.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2worldquestion.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, AnswerWorldQuestionData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2worldquestion.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AnswerWorldQuestionData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2worldquestion;
/*    */   }
/*    */   
/*    */   public static AnswerWorldQuestionData select(Long key)
/*    */   {
/* 52 */     (AnswerWorldQuestionData)getTable().select(key, new TField()
/*    */     {
/*    */       public AnswerWorldQuestionData get(AnswerWorldQuestionData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectGetnbawardnum(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(AnswerWorldQuestionData v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getGetnbawardnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectUpdatetime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(AnswerWorldQuestionData v)
/*    */       {
/* 78 */         return Long.valueOf(v.getUpdatetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2worldquestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */