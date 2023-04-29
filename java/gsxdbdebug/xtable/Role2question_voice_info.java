/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.QuestionVoiceBean;
/*    */ import xbean.QuestionVoiceInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2question_voice_info
/*    */ {
/*    */   public static QuestionVoiceInfo get(Long key)
/*    */   {
/* 12 */     return (QuestionVoiceInfo)_Tables_.getInstance().role2question_voice_info.get(key);
/*    */   }
/*    */   
/*    */   public static QuestionVoiceInfo get(Long key, QuestionVoiceInfo value)
/*    */   {
/* 17 */     return (QuestionVoiceInfo)_Tables_.getInstance().role2question_voice_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, QuestionVoiceInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2question_voice_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2question_voice_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, QuestionVoiceInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2question_voice_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2question_voice_info.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, QuestionVoiceInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2question_voice_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, QuestionVoiceInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2question_voice_info;
/*    */   }
/*    */   
/*    */   public static QuestionVoiceInfo select(Long key)
/*    */   {
/* 52 */     (QuestionVoiceInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public QuestionVoiceInfo get(QuestionVoiceInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, QuestionVoiceBean> selectActivity2question_voice(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, QuestionVoiceBean> get(QuestionVoiceInfo v)
/*    */       {
/* 67 */         return v.getActivity2question_voiceAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2question_voice_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */