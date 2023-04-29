/*    */ package mzm.gsp.fabaolingqi;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabaolingqi.main.PGetArtifactInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetArtifactInfoReq
/*    */   extends __CGetArtifactInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618258;
/*    */   public long role_id;
/*    */   public int class_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PGetArtifactInfo(roleId, this.role_id, this.class_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12618258;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetArtifactInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetArtifactInfoReq(long _role_id_, int _class_id_)
/*    */   {
/* 38 */     this.role_id = _role_id_;
/* 39 */     this.class_id = _class_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.role_id);
/* 48 */     _os_.marshal(this.class_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.role_id = _os_.unmarshal_long();
/* 54 */     this.class_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGetArtifactInfoReq)) {
/* 64 */       CGetArtifactInfoReq _o_ = (CGetArtifactInfoReq)_o1_;
/* 65 */       if (this.role_id != _o_.role_id) return false;
/* 66 */       if (this.class_id != _o_.class_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.role_id;
/* 75 */     _h_ += this.class_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.role_id).append(",");
/* 83 */     _sb_.append(this.class_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetArtifactInfoReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.class_id - _o_.class_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\CGetArtifactInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */