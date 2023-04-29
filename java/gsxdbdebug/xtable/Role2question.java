/*    */ package xtable;
/*    */ 
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.QuestionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2question
/*    */ {
/*    */   public static QuestionInfo get(Long key)
/*    */   {
/* 12 */     return (QuestionInfo)_Tables_.getInstance().role2question.get(key);
/*    */   }
/*    */   
/*    */   public static QuestionInfo get(Long key, QuestionInfo value)
/*    */   {
/* 17 */     return (QuestionInfo)_Tables_.getInstance().role2question.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, QuestionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2question.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2question.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, QuestionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2question.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2question.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, QuestionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2question.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, QuestionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2question;
/*    */   }
/*    */   
/*    */   public static QuestionInfo select(Long key)
/*    */   {
/* 52 */     (QuestionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public QuestionInfo get(QuestionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static EveryDayQuestionAnswerInfo selectEverydayinfo(Long key)
/*    */   {
/* 63 */     (EveryDayQuestionAnswerInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public EveryDayQuestionAnswerInfo get(QuestionInfo v)
/*    */       {
/* 67 */         return v.getEverydayinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2question.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */