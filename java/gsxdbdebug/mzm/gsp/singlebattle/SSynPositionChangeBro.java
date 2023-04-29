/*    */ package mzm.gsp.singlebattle;
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
/*    */ public class SSynPositionChangeBro
/*    */   extends __SSynPositionChangeBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621583;
/*    */   public int positionid;
/*    */   public PositionData positiondata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621583;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynPositionChangeBro()
/*    */   {
/* 34 */     this.positiondata = new PositionData();
/*    */   }
/*    */   
/*    */   public SSynPositionChangeBro(int _positionid_, PositionData _positiondata_) {
/* 38 */     this.positionid = _positionid_;
/* 39 */     this.positiondata = _positiondata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.positiondata._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.positionid);
/* 49 */     _os_.marshal(this.positiondata);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.positionid = _os_.unmarshal_int();
/* 55 */     this.positiondata.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynPositionChangeBro)) {
/* 65 */       SSynPositionChangeBro _o_ = (SSynPositionChangeBro)_o1_;
/* 66 */       if (this.positionid != _o_.positionid) return false;
/* 67 */       if (!this.positiondata.equals(_o_.positiondata)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.positionid;
/* 76 */     _h_ += this.positiondata.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.positionid).append(",");
/* 84 */     _sb_.append(this.positiondata).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynPositionChangeBro _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.positionid - _o_.positionid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.positiondata.compareTo(_o_.positiondata);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynPositionChangeBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */