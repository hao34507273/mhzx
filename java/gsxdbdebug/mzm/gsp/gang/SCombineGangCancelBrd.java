/*    */ package mzm.gsp.gang;
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
/*    */ public class SCombineGangCancelBrd
/*    */   extends __SCombineGangCancelBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589972;
/*    */   public long srcid;
/*    */   public long targetid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589972;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCombineGangCancelBrd() {}
/*    */   
/*    */ 
/*    */   public SCombineGangCancelBrd(long _srcid_, long _targetid_)
/*    */   {
/* 37 */     this.srcid = _srcid_;
/* 38 */     this.targetid = _targetid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.srcid);
/* 47 */     _os_.marshal(this.targetid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.srcid = _os_.unmarshal_long();
/* 53 */     this.targetid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SCombineGangCancelBrd)) {
/* 63 */       SCombineGangCancelBrd _o_ = (SCombineGangCancelBrd)_o1_;
/* 64 */       if (this.srcid != _o_.srcid) return false;
/* 65 */       if (this.targetid != _o_.targetid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.srcid;
/* 74 */     _h_ += (int)this.targetid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.srcid).append(",");
/* 82 */     _sb_.append(this.targetid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCombineGangCancelBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.srcid - _o_.srcid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SCombineGangCancelBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */