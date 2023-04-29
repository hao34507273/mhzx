/*    */ package mzm.gsp.mourn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.mourn.main.PCMournReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMournReq
/*    */   extends __CMournReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613382;
/*    */   public int mournid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCMournReq(roleId, this.mournid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12613382;
/*    */   }
/*    */   
/*    */ 
/*    */   public CMournReq() {}
/*    */   
/*    */ 
/*    */   public CMournReq(int _mournid_)
/*    */   {
/* 41 */     this.mournid = _mournid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.mournid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mournid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CMournReq)) {
/* 64 */       CMournReq _o_ = (CMournReq)_o1_;
/* 65 */       if (this.mournid != _o_.mournid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.mournid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.mournid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMournReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.mournid - _o_.mournid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\CMournReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */