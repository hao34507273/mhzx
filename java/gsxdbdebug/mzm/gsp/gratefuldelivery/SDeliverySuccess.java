/*    */ package mzm.gsp.gratefuldelivery;
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
/*    */ public class SDeliverySuccess
/*    */   extends __SDeliverySuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615695;
/*    */   public long target_id;
/*    */   public Octets target_name;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615695;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SDeliverySuccess()
/*    */   {
/* 35 */     this.target_name = new Octets();
/*    */   }
/*    */   
/*    */   public SDeliverySuccess(long _target_id_, Octets _target_name_, int _activity_id_) {
/* 39 */     this.target_id = _target_id_;
/* 40 */     this.target_name = _target_name_;
/* 41 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.target_id);
/* 50 */     _os_.marshal(this.target_name);
/* 51 */     _os_.marshal(this.activity_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.target_id = _os_.unmarshal_long();
/* 57 */     this.target_name = _os_.unmarshal_Octets();
/* 58 */     this.activity_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SDeliverySuccess)) {
/* 68 */       SDeliverySuccess _o_ = (SDeliverySuccess)_o1_;
/* 69 */       if (this.target_id != _o_.target_id) return false;
/* 70 */       if (!this.target_name.equals(_o_.target_name)) return false;
/* 71 */       if (this.activity_id != _o_.activity_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.target_id;
/* 80 */     _h_ += this.target_name.hashCode();
/* 81 */     _h_ += this.activity_id;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.target_id).append(",");
/* 89 */     _sb_.append("B").append(this.target_name.size()).append(",");
/* 90 */     _sb_.append(this.activity_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SDeliverySuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */