/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.InteractionInvitationBanRecord;
/*    */ import xbean.InteractionInvitationBanRecords;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2interaction_invitation_ban_records
/*    */ {
/*    */   public static InteractionInvitationBanRecords get(Long key)
/*    */   {
/* 12 */     return (InteractionInvitationBanRecords)_Tables_.getInstance().role2interaction_invitation_ban_records.get(key);
/*    */   }
/*    */   
/*    */   public static InteractionInvitationBanRecords get(Long key, InteractionInvitationBanRecords value)
/*    */   {
/* 17 */     return (InteractionInvitationBanRecords)_Tables_.getInstance().role2interaction_invitation_ban_records.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, InteractionInvitationBanRecords value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2interaction_invitation_ban_records.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2interaction_invitation_ban_records.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, InteractionInvitationBanRecords value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2interaction_invitation_ban_records.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2interaction_invitation_ban_records.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, InteractionInvitationBanRecords> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2interaction_invitation_ban_records.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, InteractionInvitationBanRecords> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2interaction_invitation_ban_records;
/*    */   }
/*    */   
/*    */   public static InteractionInvitationBanRecords select(Long key)
/*    */   {
/* 52 */     (InteractionInvitationBanRecords)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public InteractionInvitationBanRecords get(InteractionInvitationBanRecords v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, InteractionInvitationBanRecord> selectRecords(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, InteractionInvitationBanRecord> get(InteractionInvitationBanRecords v)
/*    */       {
/* 67 */         return v.getRecordsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2interaction_invitation_ban_records.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */