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
/*    */ public class SFinishTaskRes
/*    */   extends __SFinishTaskRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610310;
/*    */   public int typeid;
/*    */   public int graphid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12610310;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFinishTaskRes() {}
/*    */   
/*    */ 
/*    */   public SFinishTaskRes(int _typeid_, int _graphid_)
/*    */   {
/* 35 */     this.typeid = _typeid_;
/* 36 */     this.graphid = _graphid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.typeid);
/* 45 */     _os_.marshal(this.graphid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.typeid = _os_.unmarshal_int();
/* 51 */     this.graphid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SFinishTaskRes)) {
/* 61 */       SFinishTaskRes _o_ = (SFinishTaskRes)_o1_;
/* 62 */       if (this.typeid != _o_.typeid) return false;
/* 63 */       if (this.graphid != _o_.graphid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.typeid;
/* 72 */     _h_ += this.graphid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.typeid).append(",");
/* 80 */     _sb_.append(this.graphid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFinishTaskRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.typeid - _o_.typeid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.graphid - _o_.graphid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\SFinishTaskRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */