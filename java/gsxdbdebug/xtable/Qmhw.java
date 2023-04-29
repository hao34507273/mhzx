/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.QMHWActivity;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Qmhw
/*    */ {
/*    */   public static QMHWActivity get(Long key)
/*    */   {
/* 12 */     return (QMHWActivity)_Tables_.getInstance().qmhw.get(key);
/*    */   }
/*    */   
/*    */   public static QMHWActivity get(Long key, QMHWActivity value)
/*    */   {
/* 17 */     return (QMHWActivity)_Tables_.getInstance().qmhw.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, QMHWActivity value)
/*    */   {
/* 22 */     _Tables_.getInstance().qmhw.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().qmhw.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, QMHWActivity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().qmhw.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().qmhw.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, QMHWActivity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().qmhw.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, QMHWActivity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().qmhw;
/*    */   }
/*    */   
/*    */   public static QMHWActivity select(Long key)
/*    */   {
/* 52 */     (QMHWActivity)getTable().select(key, new TField()
/*    */     {
/*    */       public QMHWActivity get(QMHWActivity v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectWorldid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(QMHWActivity v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorldid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectFightids(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(QMHWActivity v)
/*    */       {
/* 78 */         return v.getFightidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectHandleresult(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(QMHWActivity v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getHandleresult());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Qmhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */