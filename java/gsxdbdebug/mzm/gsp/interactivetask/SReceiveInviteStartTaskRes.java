/*    */ package mzm.gsp.interactivetask;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SReceiveInviteStartTaskRes
/*    */   extends __SReceiveInviteStartTaskRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610313;
/*    */   public int typeid;
/*    */   public int graphid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12610313;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SReceiveInviteStartTaskRes() {}
/*    */   
/*    */ 
/*    */   public SReceiveInviteStartTaskRes(int _typeid_, int _graphid_)
/*    */   {
/* 37 */     this.typeid = _typeid_;
/* 38 */     this.graphid = _graphid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.typeid);
/* 47 */     _os_.marshal(this.graphid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.typeid = _os_.unmarshal_int();
/* 53 */     this.graphid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SReceiveInviteStartTaskRes)) {
/* 63 */       SReceiveInviteStartTaskRes _o_ = (SReceiveInviteStartTaskRes)_o1_;
/* 64 */       if (this.typeid != _o_.typeid) return false;
/* 65 */       if (this.graphid != _o_.graphid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.typeid;
/* 74 */     _h_ += this.graphid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.typeid).append(",");
/* 82 */     _sb_.append(this.graphid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SReceiveInviteStartTaskRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.typeid - _o_.typeid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.graphid - _o_.graphid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\SReceiveInviteStartTaskRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */