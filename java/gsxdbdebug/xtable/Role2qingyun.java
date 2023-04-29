/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.HelpData;
/*    */ import xbean.QingData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2qingyun
/*    */ {
/*    */   public static QingData get(Long key)
/*    */   {
/* 12 */     return (QingData)_Tables_.getInstance().role2qingyun.get(key);
/*    */   }
/*    */   
/*    */   public static QingData get(Long key, QingData value)
/*    */   {
/* 17 */     return (QingData)_Tables_.getInstance().role2qingyun.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, QingData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2qingyun.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2qingyun.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, QingData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2qingyun.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2qingyun.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, QingData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2qingyun.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, QingData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2qingyun;
/*    */   }
/*    */   
/*    */   public static QingData select(Long key)
/*    */   {
/* 52 */     (QingData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public QingData get(QingData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.Progress> selectType2progress(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.Progress> get(QingData v)
/*    */       {
/* 67 */         return v.getType2progressAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, HelpData> selectType2helpdata(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, HelpData> get(QingData v)
/*    */       {
/* 78 */         return v.getType2helpdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2qingyun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */