/*    */ package mzm.gsp.greetingcard;
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
/*    */ public class SSendCardBroadcast
/*    */   extends __SSendCardBroadcast__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616450;
/*    */   public int channel;
/*    */   public GreetingCardData data;
/*    */   public SenderData senderdata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616450;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSendCardBroadcast()
/*    */   {
/* 35 */     this.data = new GreetingCardData();
/* 36 */     this.senderdata = new SenderData();
/*    */   }
/*    */   
/*    */   public SSendCardBroadcast(int _channel_, GreetingCardData _data_, SenderData _senderdata_) {
/* 40 */     this.channel = _channel_;
/* 41 */     this.data = _data_;
/* 42 */     this.senderdata = _senderdata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.data._validator_()) return false;
/* 47 */     if (!this.senderdata._validator_()) return false;
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.channel);
/* 53 */     _os_.marshal(this.data);
/* 54 */     _os_.marshal(this.senderdata);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.channel = _os_.unmarshal_int();
/* 60 */     this.data.unmarshal(_os_);
/* 61 */     this.senderdata.unmarshal(_os_);
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSendCardBroadcast)) {
/* 71 */       SSendCardBroadcast _o_ = (SSendCardBroadcast)_o1_;
/* 72 */       if (this.channel != _o_.channel) return false;
/* 73 */       if (!this.data.equals(_o_.data)) return false;
/* 74 */       if (!this.senderdata.equals(_o_.senderdata)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.channel;
/* 83 */     _h_ += this.data.hashCode();
/* 84 */     _h_ += this.senderdata.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.channel).append(",");
/* 92 */     _sb_.append(this.data).append(",");
/* 93 */     _sb_.append(this.senderdata).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\SSendCardBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */