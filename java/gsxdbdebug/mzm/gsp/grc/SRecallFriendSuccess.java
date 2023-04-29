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
/*    */ public class SRecallFriendSuccess
/*    */   extends __SRecallFriendSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600369;
/*    */   public int zone_id;
/*    */   public long role_id;
/*    */   public Octets open_id;
/*    */   public int invite_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600369;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRecallFriendSuccess()
/*    */   {
/* 36 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public SRecallFriendSuccess(int _zone_id_, long _role_id_, Octets _open_id_, int _invite_time_) {
/* 40 */     this.zone_id = _zone_id_;
/* 41 */     this.role_id = _role_id_;
/* 42 */     this.open_id = _open_id_;
/* 43 */     this.invite_time = _invite_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.zone_id);
/* 52 */     _os_.marshal(this.role_id);
/* 53 */     _os_.marshal(this.open_id);
/* 54 */     _os_.marshal(this.invite_time);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.zone_id = _os_.unmarshal_int();
/* 60 */     this.role_id = _os_.unmarshal_long();
/* 61 */     this.open_id = _os_.unmarshal_Octets();
/* 62 */     this.invite_time = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SRecallFriendSuccess)) {
/* 72 */       SRecallFriendSuccess _o_ = (SRecallFriendSuccess)_o1_;
/* 73 */       if (this.zone_id != _o_.zone_id) return false;
/* 74 */       if (this.role_id != _o_.role_id) return false;
/* 75 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 76 */       if (this.invite_time != _o_.invite_time) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.zone_id;
/* 85 */     _h_ += (int)this.role_id;
/* 86 */     _h_ += this.open_id.hashCode();
/* 87 */     _h_ += this.invite_time;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.zone_id).append(",");
/* 95 */     _sb_.append(this.role_id).append(",");
/* 96 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 97 */     _sb_.append(this.invite_time).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SRecallFriendSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */