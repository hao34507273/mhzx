/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import grc.GrcBindFriendVitalityInfo;
/*    */ import grc.GrcRoleInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BindFriendResponse
/*    */   implements Marshal
/*    */ {
/*    */   public long bindTime;
/*    */   public long roleid;
/*    */   public int zoneid;
/* 27 */   public GrcBindFriendVitalityInfo friendVitalityInfo = new GrcBindFriendVitalityInfo();
/*    */   
/* 29 */   public List<GrcRoleInfo> vitalityInfo = new ArrayList();
/*    */   
/*    */ 
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 34 */     os.marshal(this.bindTime);
/* 35 */     os.marshal(this.roleid);
/* 36 */     os.marshal(this.zoneid);
/* 37 */     os.marshal(this.friendVitalityInfo);
/*    */     
/* 39 */     os.compact_uint32(this.vitalityInfo.size());
/* 40 */     for (GrcRoleInfo v : this.vitalityInfo)
/*    */     {
/* 42 */       os.marshal(v);
/*    */     }
/* 44 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 50 */     this.bindTime = os.unmarshal_long();
/* 51 */     this.roleid = os.unmarshal_long();
/* 52 */     this.zoneid = os.unmarshal_int();
/* 53 */     this.friendVitalityInfo.unmarshal(os);
/*    */     
/* 55 */     for (int size = os.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 57 */       GrcRoleInfo v = new GrcRoleInfo();
/* 58 */       v.unmarshal(os);
/* 59 */       this.vitalityInfo.add(v);
/*    */     }
/* 61 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\BindFriendResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */