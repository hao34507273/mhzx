/*    */ package mzm.gsp.skylantern;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.greetingcard.GreetingCardData;
/*    */ import mzm.gsp.skylantern.main.PCSendSkyLanternReq;
/*    */ 
/*    */ 
/*    */ public class CSendSkyLanternReq
/*    */   extends __CSendSkyLanternReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624129;
/*    */   public int activity_id;
/*    */   public int channel;
/*    */   public GreetingCardData data;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCSendSkyLanternReq(roleId, this.activity_id, this.channel, this.data));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12624129;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CSendSkyLanternReq()
/*    */   {
/* 41 */     this.data = new GreetingCardData();
/*    */   }
/*    */   
/*    */   public CSendSkyLanternReq(int _activity_id_, int _channel_, GreetingCardData _data_) {
/* 45 */     this.activity_id = _activity_id_;
/* 46 */     this.channel = _channel_;
/* 47 */     this.data = _data_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     if (!this.data._validator_()) return false;
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.activity_id);
/* 57 */     _os_.marshal(this.channel);
/* 58 */     _os_.marshal(this.data);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.activity_id = _os_.unmarshal_int();
/* 64 */     this.channel = _os_.unmarshal_int();
/* 65 */     this.data.unmarshal(_os_);
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CSendSkyLanternReq)) {
/* 75 */       CSendSkyLanternReq _o_ = (CSendSkyLanternReq)_o1_;
/* 76 */       if (this.activity_id != _o_.activity_id) return false;
/* 77 */       if (this.channel != _o_.channel) return false;
/* 78 */       if (!this.data.equals(_o_.data)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_id;
/* 87 */     _h_ += this.channel;
/* 88 */     _h_ += this.data.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_id).append(",");
/* 96 */     _sb_.append(this.channel).append(",");
/* 97 */     _sb_.append(this.data).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skylantern\CSendSkyLanternReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */