/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import grc.GrcBindFriendVitalityInfo;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GetBindVitalityInfoResponse implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<GrcBindFriendVitalityInfo> recall_bind_info;
/*    */   public ArrayList<GrcBindFriendVitalityInfo> back_bind_info;
/*    */   public ArrayList<grc.GrcRoleInfo> role_vitality_info;
/*    */   
/*    */   public GetBindVitalityInfoResponse()
/*    */   {
/* 15 */     this.recall_bind_info = new ArrayList();
/* 16 */     this.back_bind_info = new ArrayList();
/* 17 */     this.role_vitality_info = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 23 */     os.compact_uint32(this.recall_bind_info.size());
/* 24 */     for (GrcBindFriendVitalityInfo v : this.recall_bind_info)
/*    */     {
/* 26 */       os.marshal(v);
/*    */     }
/* 28 */     os.compact_uint32(this.back_bind_info.size());
/* 29 */     for (GrcBindFriendVitalityInfo v : this.back_bind_info)
/*    */     {
/* 31 */       os.marshal(v);
/*    */     }
/* 33 */     os.compact_uint32(this.role_vitality_info.size());
/* 34 */     for (grc.GrcRoleInfo v : this.role_vitality_info)
/*    */     {
/* 36 */       os.marshal(v);
/*    */     }
/* 38 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 44 */     for (int size = os.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 46 */       GrcBindFriendVitalityInfo v = new GrcBindFriendVitalityInfo();
/* 47 */       v.unmarshal(os);
/* 48 */       this.recall_bind_info.add(v);
/*    */     }
/* 50 */     for (int size = os.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       GrcBindFriendVitalityInfo v = new GrcBindFriendVitalityInfo();
/* 53 */       v.unmarshal(os);
/* 54 */       this.back_bind_info.add(v);
/*    */     }
/* 56 */     for (int size = os.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       grc.GrcRoleInfo v = new grc.GrcRoleInfo();
/* 59 */       v.unmarshal(os);
/* 60 */       this.role_vitality_info.add(v);
/*    */     }
/* 62 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GetBindVitalityInfoResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */