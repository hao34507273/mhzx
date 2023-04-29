/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleChange;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolechangetable
/*    */ {
/*    */   public static RoleChange get(Long key)
/*    */   {
/* 12 */     return (RoleChange)_Tables_.getInstance().rolechangetable.get(key);
/*    */   }
/*    */   
/*    */   public static RoleChange get(Long key, RoleChange value)
/*    */   {
/* 17 */     return (RoleChange)_Tables_.getInstance().rolechangetable.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleChange value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolechangetable.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolechangetable.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleChange value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolechangetable.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolechangetable.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleChange> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolechangetable.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleChange> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolechangetable;
/*    */   }
/*    */   
/*    */   public static RoleChange select(Long key)
/*    */   {
/* 52 */     (RoleChange)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleChange get(RoleChange v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectChangeids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(RoleChange v)
/*    */       {
/* 67 */         return v.getChangeidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolechangetable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */