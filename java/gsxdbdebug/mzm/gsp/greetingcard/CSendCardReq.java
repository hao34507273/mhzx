/*    */ package mzm.gsp.greetingcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.greetingcard.main.PSendCardReq;
/*    */ 
/*    */ 
/*    */ public class CSendCardReq
/*    */   extends __CSendCardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616449;
/*    */   public int item_key;
/*    */   public int channel;
/*    */   public GreetingCardData data;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PSendCardReq(roleId, this.item_key, this.channel, this.data));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12616449;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CSendCardReq()
/*    */   {
/* 36 */     this.data = new GreetingCardData();
/*    */   }
/*    */   
/*    */   public CSendCardReq(int _item_key_, int _channel_, GreetingCardData _data_) {
/* 40 */     this.item_key = _item_key_;
/* 41 */     this.channel = _channel_;
/* 42 */     this.data = _data_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.data._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.item_key);
/* 52 */     _os_.marshal(this.channel);
/* 53 */     _os_.marshal(this.data);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.item_key = _os_.unmarshal_int();
/* 59 */     this.channel = _os_.unmarshal_int();
/* 60 */     this.data.unmarshal(_os_);
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CSendCardReq)) {
/* 70 */       CSendCardReq _o_ = (CSendCardReq)_o1_;
/* 71 */       if (this.item_key != _o_.item_key) return false;
/* 72 */       if (this.channel != _o_.channel) return false;
/* 73 */       if (!this.data.equals(_o_.data)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.item_key;
/* 82 */     _h_ += this.channel;
/* 83 */     _h_ += this.data.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.item_key).append(",");
/* 91 */     _sb_.append(this.channel).append(",");
/* 92 */     _sb_.append(this.data).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\CSendCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */