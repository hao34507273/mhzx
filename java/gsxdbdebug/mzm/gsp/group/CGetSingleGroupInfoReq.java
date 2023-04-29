/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.group.main.PGetSingleGroupInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetSingleGroupInfoReq
/*    */   extends __CGetSingleGroupInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605213;
/*    */   public long groupid;
/*    */   public long info_version;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PGetSingleGroupInfoReq(roleid, this.groupid, this.info_version));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12605213;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetSingleGroupInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetSingleGroupInfoReq(long _groupid_, long _info_version_)
/*    */   {
/* 41 */     this.groupid = _groupid_;
/* 42 */     this.info_version = _info_version_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.groupid);
/* 51 */     _os_.marshal(this.info_version);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.groupid = _os_.unmarshal_long();
/* 57 */     this.info_version = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetSingleGroupInfoReq)) {
/* 67 */       CGetSingleGroupInfoReq _o_ = (CGetSingleGroupInfoReq)_o1_;
/* 68 */       if (this.groupid != _o_.groupid) return false;
/* 69 */       if (this.info_version != _o_.info_version) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.groupid;
/* 78 */     _h_ += (int)this.info_version;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.groupid).append(",");
/* 86 */     _sb_.append(this.info_version).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetSingleGroupInfoReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.info_version - _o_.info_version);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\CGetSingleGroupInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */