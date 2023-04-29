/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.RoleGameStatus;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gamestatus
/*    */ {
/*    */   public static RoleGameStatus get(Long key)
/*    */   {
/* 12 */     return (RoleGameStatus)_Tables_.getInstance().gamestatus.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGameStatus get(Long key, RoleGameStatus value)
/*    */   {
/* 17 */     return (RoleGameStatus)_Tables_.getInstance().gamestatus.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGameStatus value)
/*    */   {
/* 22 */     _Tables_.getInstance().gamestatus.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gamestatus.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGameStatus value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gamestatus.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gamestatus.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGameStatus> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gamestatus.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGameStatus> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gamestatus;
/*    */   }
/*    */   
/*    */   public static RoleGameStatus select(Long key)
/*    */   {
/* 52 */     (RoleGameStatus)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleGameStatus get(RoleGameStatus v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectGamestatus(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(RoleGameStatus v)
/*    */       {
/* 67 */         return v.getGamestatusAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gamestatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */