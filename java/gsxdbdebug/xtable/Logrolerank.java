/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LogRankData;
/*    */ import xbean.RecordData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Logrolerank
/*    */ {
/*    */   public static LogRankData get(Long key)
/*    */   {
/* 12 */     return (LogRankData)_Tables_.getInstance().logrolerank.get(key);
/*    */   }
/*    */   
/*    */   public static LogRankData get(Long key, LogRankData value)
/*    */   {
/* 17 */     return (LogRankData)_Tables_.getInstance().logrolerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LogRankData value)
/*    */   {
/* 22 */     _Tables_.getInstance().logrolerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().logrolerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LogRankData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().logrolerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().logrolerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LogRankData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().logrolerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LogRankData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().logrolerank;
/*    */   }
/*    */   
/*    */   public static LogRankData select(Long key)
/*    */   {
/* 52 */     (LogRankData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LogRankData get(LogRankData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RecordData> selectType2rankdata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RecordData> get(LogRankData v)
/*    */       {
/* 67 */         return v.getType2rankdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Logrolerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */