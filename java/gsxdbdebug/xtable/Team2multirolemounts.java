/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MultiRoleMounts;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Team2multirolemounts
/*    */ {
/*    */   public static MultiRoleMounts get(Long key)
/*    */   {
/* 12 */     return (MultiRoleMounts)_Tables_.getInstance().team2multirolemounts.get(key);
/*    */   }
/*    */   
/*    */   public static MultiRoleMounts get(Long key, MultiRoleMounts value)
/*    */   {
/* 17 */     return (MultiRoleMounts)_Tables_.getInstance().team2multirolemounts.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MultiRoleMounts value)
/*    */   {
/* 22 */     _Tables_.getInstance().team2multirolemounts.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().team2multirolemounts.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MultiRoleMounts value)
/*    */   {
/* 32 */     return _Tables_.getInstance().team2multirolemounts.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().team2multirolemounts.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MultiRoleMounts> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().team2multirolemounts.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiRoleMounts> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().team2multirolemounts;
/*    */   }
/*    */   
/*    */   public static MultiRoleMounts select(Long key)
/*    */   {
/* 52 */     (MultiRoleMounts)getTable().select(key, new TField()
/*    */     {
/*    */       public MultiRoleMounts get(MultiRoleMounts v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMounts_cfg_id(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MultiRoleMounts v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMounts_cfg_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRole_ids(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(MultiRoleMounts v)
/*    */       {
/* 78 */         return v.getRole_idsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Team2multirolemounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */