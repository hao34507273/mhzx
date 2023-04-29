/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.NotNotifyMarriage;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2notnotifymarriage
/*    */ {
/*    */   public static NotNotifyMarriage get(Long key)
/*    */   {
/* 12 */     return (NotNotifyMarriage)_Tables_.getInstance().role2notnotifymarriage.get(key);
/*    */   }
/*    */   
/*    */   public static NotNotifyMarriage get(Long key, NotNotifyMarriage value)
/*    */   {
/* 17 */     return (NotNotifyMarriage)_Tables_.getInstance().role2notnotifymarriage.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NotNotifyMarriage value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2notnotifymarriage.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2notnotifymarriage.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NotNotifyMarriage value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2notnotifymarriage.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2notnotifymarriage.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NotNotifyMarriage> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2notnotifymarriage.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NotNotifyMarriage> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2notnotifymarriage;
/*    */   }
/*    */   
/*    */   public static NotNotifyMarriage select(Long key)
/*    */   {
/* 52 */     (NotNotifyMarriage)getTable().select(key, new TField()
/*    */     {
/*    */       public NotNotifyMarriage get(NotNotifyMarriage v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectMarriageids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(NotNotifyMarriage v)
/*    */       {
/* 67 */         return v.getMarriageidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2notnotifymarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */