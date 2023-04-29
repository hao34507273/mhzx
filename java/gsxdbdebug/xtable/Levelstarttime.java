/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LevelStartTimeData;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Levelstarttime
/*    */ {
/*    */   public static LevelStartTimeData get(Long key)
/*    */   {
/* 12 */     return (LevelStartTimeData)_Tables_.getInstance().levelstarttime.get(key);
/*    */   }
/*    */   
/*    */   public static LevelStartTimeData get(Long key, LevelStartTimeData value)
/*    */   {
/* 17 */     return (LevelStartTimeData)_Tables_.getInstance().levelstarttime.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LevelStartTimeData value)
/*    */   {
/* 22 */     _Tables_.getInstance().levelstarttime.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().levelstarttime.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LevelStartTimeData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().levelstarttime.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().levelstarttime.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LevelStartTimeData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().levelstarttime.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LevelStartTimeData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().levelstarttime;
/*    */   }
/*    */   
/*    */   public static LevelStartTimeData select(Long key)
/*    */   {
/* 52 */     (LevelStartTimeData)getTable().select(key, new TField()
/*    */     {
/*    */       public LevelStartTimeData get(LevelStartTimeData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectServerlevel2starttime(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(LevelStartTimeData v)
/*    */       {
/* 67 */         return v.getServerlevel2starttimeAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Levelstarttime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */