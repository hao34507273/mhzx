/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.group.main.PGetRoleGroupInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleGroupInfoReq
/*    */   extends __CGetRoleGroupInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605191;
/*    */   public HashMap<Long, Long> groupid2info_version;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PGetRoleGroupInfoReq(roleid, this.groupid2info_version));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12605191;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRoleGroupInfoReq()
/*    */   {
/* 37 */     this.groupid2info_version = new HashMap();
/*    */   }
/*    */   
/*    */   public CGetRoleGroupInfoReq(HashMap<Long, Long> _groupid2info_version_) {
/* 41 */     this.groupid2info_version = _groupid2info_version_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.groupid2info_version.size());
/* 50 */     for (Map.Entry<Long, Long> _e_ : this.groupid2info_version.entrySet()) {
/* 51 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 52 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.groupid2info_version.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof CGetRoleGroupInfoReq)) {
/* 74 */       CGetRoleGroupInfoReq _o_ = (CGetRoleGroupInfoReq)_o1_;
/* 75 */       if (!this.groupid2info_version.equals(_o_.groupid2info_version)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.groupid2info_version.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.groupid2info_version).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\CGetRoleGroupInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */