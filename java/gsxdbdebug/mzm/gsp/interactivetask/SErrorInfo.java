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
/*    */ public class SErrorInfo
/*    */   extends __SErrorInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610306;
/*    */   public static final int ROLE_OFF_LINE = 1;
/*    */   public static final int DOING_GRAPH = 2;
/*    */   public static final int GRAPH_DONE = 3;
/*    */   public static final int GIVE_BIRTH_DAILED = 4;
/*    */   public int errorcode;
/*    */   public int typeid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12610306;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SErrorInfo() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SErrorInfo(int _errorcode_, int _typeid_)
/*    */   {
/* 42 */     this.errorcode = _errorcode_;
/* 43 */     this.typeid = _typeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.errorcode);
/* 52 */     _os_.marshal(this.typeid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.errorcode = _os_.unmarshal_int();
/* 58 */     this.typeid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SErrorInfo)) {
/* 68 */       SErrorInfo _o_ = (SErrorInfo)_o1_;
/* 69 */       if (this.errorcode != _o_.errorcode) return false;
/* 70 */       if (this.typeid != _o_.typeid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.errorcode;
/* 79 */     _h_ += this.typeid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.errorcode).append(",");
/* 87 */     _sb_.append(this.typeid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SErrorInfo _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.errorcode - _o_.errorcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.typeid - _o_.typeid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\SErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */