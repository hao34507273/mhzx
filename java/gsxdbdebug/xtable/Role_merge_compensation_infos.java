/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.RoleMergeCompensationInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_merge_compensation_infos
/*    */ {
/*    */   public static RoleMergeCompensationInfo get(Long key)
/*    */   {
/* 12 */     return (RoleMergeCompensationInfo)_Tables_.getInstance().role_merge_compensation_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleMergeCompensationInfo get(Long key, RoleMergeCompensationInfo value)
/*    */   {
/* 17 */     return (RoleMergeCompensationInfo)_Tables_.getInstance().role_merge_compensation_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleMergeCompensationInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_merge_compensation_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_merge_compensation_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleMergeCompensationInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_merge_compensation_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_merge_compensation_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleMergeCompensationInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_merge_compensation_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleMergeCompensationInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_merge_compensation_infos;
/*    */   }
/*    */   
/*    */   public static RoleMergeCompensationInfo select(Long key)
/*    */   {
/* 52 */     (RoleMergeCompensationInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleMergeCompensationInfo get(RoleMergeCompensationInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectHave_got_compensation_merge_system_timestamps(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(RoleMergeCompensationInfo v)
/*    */       {
/* 67 */         return v.getHave_got_compensation_merge_system_timestampsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_merge_compensation_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */