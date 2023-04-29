/*    */ package mzm.gsp.qiuqian;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qiuqian.main.PCQiuQian;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CQiuQianReq
/*    */   extends __CQiuQianReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610818;
/*    */   public int qiuqian_id;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCQiuQian(roleid, this.qiuqian_id, this.sessionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12610818;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CQiuQianReq() {}
/*    */   
/*    */ 
/*    */   public CQiuQianReq(int _qiuqian_id_, long _sessionid_)
/*    */   {
/* 41 */     this.qiuqian_id = _qiuqian_id_;
/* 42 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.qiuqian_id);
/* 51 */     _os_.marshal(this.sessionid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.qiuqian_id = _os_.unmarshal_int();
/* 57 */     this.sessionid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CQiuQianReq)) {
/* 67 */       CQiuQianReq _o_ = (CQiuQianReq)_o1_;
/* 68 */       if (this.qiuqian_id != _o_.qiuqian_id) return false;
/* 69 */       if (this.sessionid != _o_.sessionid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.qiuqian_id;
/* 78 */     _h_ += (int)this.sessionid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.qiuqian_id).append(",");
/* 86 */     _sb_.append(this.sessionid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CQiuQianReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.qiuqian_id - _o_.qiuqian_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\CQiuQianReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */