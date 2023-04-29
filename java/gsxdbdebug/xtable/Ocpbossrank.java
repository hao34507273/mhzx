/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.OcpBigBossRoleList;
/*    */ import xbean.RoleBossBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Ocpbossrank
/*    */ {
/*    */   public static OcpBigBossRoleList get(Long key)
/*    */   {
/* 12 */     return (OcpBigBossRoleList)_Tables_.getInstance().ocpbossrank.get(key);
/*    */   }
/*    */   
/*    */   public static OcpBigBossRoleList get(Long key, OcpBigBossRoleList value)
/*    */   {
/* 17 */     return (OcpBigBossRoleList)_Tables_.getInstance().ocpbossrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OcpBigBossRoleList value)
/*    */   {
/* 22 */     _Tables_.getInstance().ocpbossrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().ocpbossrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OcpBigBossRoleList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().ocpbossrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().ocpbossrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, OcpBigBossRoleList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().ocpbossrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OcpBigBossRoleList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().ocpbossrank;
/*    */   }
/*    */   
/*    */   public static OcpBigBossRoleList select(Long key)
/*    */   {
/* 52 */     (OcpBigBossRoleList)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public OcpBigBossRoleList get(OcpBigBossRoleList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleBossBean> selectRolelist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleBossBean> get(OcpBigBossRoleList v)
/*    */       {
/* 67 */         return v.getRolelistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Ocpbossrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */