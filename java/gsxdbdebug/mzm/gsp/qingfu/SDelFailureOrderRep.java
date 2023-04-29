/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SDelFailureOrderRep
/*    */   extends __SDelFailureOrderRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588804;
/*    */   public int retcode;
/*    */   public Octets gameorderid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588804;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SDelFailureOrderRep()
/*    */   {
/* 34 */     this.gameorderid = new Octets();
/*    */   }
/*    */   
/*    */   public SDelFailureOrderRep(int _retcode_, Octets _gameorderid_) {
/* 38 */     this.retcode = _retcode_;
/* 39 */     this.gameorderid = _gameorderid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.retcode);
/* 48 */     _os_.marshal(this.gameorderid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.retcode = _os_.unmarshal_int();
/* 54 */     this.gameorderid = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SDelFailureOrderRep)) {
/* 64 */       SDelFailureOrderRep _o_ = (SDelFailureOrderRep)_o1_;
/* 65 */       if (this.retcode != _o_.retcode) return false;
/* 66 */       if (!this.gameorderid.equals(_o_.gameorderid)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.retcode;
/* 75 */     _h_ += this.gameorderid.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.retcode).append(",");
/* 83 */     _sb_.append("B").append(this.gameorderid.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SDelFailureOrderRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */