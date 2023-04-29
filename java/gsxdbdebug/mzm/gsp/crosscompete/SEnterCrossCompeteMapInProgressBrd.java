/*    */ package mzm.gsp.crosscompete;
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
/*    */ 
/*    */ public class SEnterCrossCompeteMapInProgressBrd
/*    */   extends __SEnterCrossCompeteMapInProgressBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616738;
/*    */   public Against against;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616738;
/*    */   }
/*    */   
/*    */ 
/*    */   public SEnterCrossCompeteMapInProgressBrd()
/*    */   {
/* 33 */     this.against = new Against();
/*    */   }
/*    */   
/*    */   public SEnterCrossCompeteMapInProgressBrd(Against _against_) {
/* 37 */     this.against = _against_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.against._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.against);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.against.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SEnterCrossCompeteMapInProgressBrd)) {
/* 61 */       SEnterCrossCompeteMapInProgressBrd _o_ = (SEnterCrossCompeteMapInProgressBrd)_o1_;
/* 62 */       if (!this.against.equals(_o_.against)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.against.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.against).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SEnterCrossCompeteMapInProgressBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */