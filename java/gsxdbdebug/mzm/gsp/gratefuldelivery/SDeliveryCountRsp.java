/*    */ package mzm.gsp.gratefuldelivery;
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
/*    */ public class SDeliveryCountRsp
/*    */   extends __SDeliveryCountRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615691;
/*    */   public int delivery_count;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12615691;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SDeliveryCountRsp() {}
/*    */   
/*    */ 
/*    */   public SDeliveryCountRsp(int _delivery_count_, int _activity_id_)
/*    */   {
/* 35 */     this.delivery_count = _delivery_count_;
/* 36 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.delivery_count);
/* 45 */     _os_.marshal(this.activity_id);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.delivery_count = _os_.unmarshal_int();
/* 51 */     this.activity_id = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SDeliveryCountRsp)) {
/* 61 */       SDeliveryCountRsp _o_ = (SDeliveryCountRsp)_o1_;
/* 62 */       if (this.delivery_count != _o_.delivery_count) return false;
/* 63 */       if (this.activity_id != _o_.activity_id) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.delivery_count;
/* 72 */     _h_ += this.activity_id;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.delivery_count).append(",");
/* 80 */     _sb_.append(this.activity_id).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SDeliveryCountRsp _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.delivery_count - _o_.delivery_count;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.activity_id - _o_.activity_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SDeliveryCountRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */