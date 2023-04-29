/*    */ package mzm.gsp.grc;
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
/*    */ public class SGetBindRewardSuccess
/*    */   extends __SGetBindRewardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600376;
/*    */   public Octets open_id;
/*    */   public int reward_time;
/*    */   public int bind_type;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600376;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetBindRewardSuccess()
/*    */   {
/* 35 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public SGetBindRewardSuccess(Octets _open_id_, int _reward_time_, int _bind_type_) {
/* 39 */     this.open_id = _open_id_;
/* 40 */     this.reward_time = _reward_time_;
/* 41 */     this.bind_type = _bind_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.open_id);
/* 50 */     _os_.marshal(this.reward_time);
/* 51 */     _os_.marshal(this.bind_type);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.open_id = _os_.unmarshal_Octets();
/* 57 */     this.reward_time = _os_.unmarshal_int();
/* 58 */     this.bind_type = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGetBindRewardSuccess)) {
/* 68 */       SGetBindRewardSuccess _o_ = (SGetBindRewardSuccess)_o1_;
/* 69 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 70 */       if (this.reward_time != _o_.reward_time) return false;
/* 71 */       if (this.bind_type != _o_.bind_type) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.open_id.hashCode();
/* 80 */     _h_ += this.reward_time;
/* 81 */     _h_ += this.bind_type;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 89 */     _sb_.append(this.reward_time).append(",");
/* 90 */     _sb_.append(this.bind_type).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetBindRewardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */