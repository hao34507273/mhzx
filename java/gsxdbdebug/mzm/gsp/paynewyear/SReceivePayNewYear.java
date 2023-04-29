/*    */ package mzm.gsp.paynewyear;
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
/*    */ public class SReceivePayNewYear
/*    */   extends __SReceivePayNewYear__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609026;
/*    */   public long role_id;
/*    */   public Octets role_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609026;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SReceivePayNewYear()
/*    */   {
/* 34 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public SReceivePayNewYear(long _role_id_, Octets _role_name_) {
/* 38 */     this.role_id = _role_id_;
/* 39 */     this.role_name = _role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.role_id);
/* 48 */     _os_.marshal(this.role_name);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.role_id = _os_.unmarshal_long();
/* 54 */     this.role_name = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SReceivePayNewYear)) {
/* 64 */       SReceivePayNewYear _o_ = (SReceivePayNewYear)_o1_;
/* 65 */       if (this.role_id != _o_.role_id) return false;
/* 66 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.role_id;
/* 75 */     _h_ += this.role_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.role_id).append(",");
/* 83 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paynewyear\SReceivePayNewYear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */