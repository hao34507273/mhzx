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
/*    */ public class SSendRecallFriendSuccess
/*    */   extends __SSendRecallFriendSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600358;
/*    */   public int zone_id;
/*    */   public long role_id;
/*    */   public Octets open_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600358;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSendRecallFriendSuccess()
/*    */   {
/* 35 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public SSendRecallFriendSuccess(int _zone_id_, long _role_id_, Octets _open_id_) {
/* 39 */     this.zone_id = _zone_id_;
/* 40 */     this.role_id = _role_id_;
/* 41 */     this.open_id = _open_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.zone_id);
/* 50 */     _os_.marshal(this.role_id);
/* 51 */     _os_.marshal(this.open_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.zone_id = _os_.unmarshal_int();
/* 57 */     this.role_id = _os_.unmarshal_long();
/* 58 */     this.open_id = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSendRecallFriendSuccess)) {
/* 68 */       SSendRecallFriendSuccess _o_ = (SSendRecallFriendSuccess)_o1_;
/* 69 */       if (this.zone_id != _o_.zone_id) return false;
/* 70 */       if (this.role_id != _o_.role_id) return false;
/* 71 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.zone_id;
/* 80 */     _h_ += (int)this.role_id;
/* 81 */     _h_ += this.open_id.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.zone_id).append(",");
/* 89 */     _sb_.append(this.role_id).append(",");
/* 90 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSendRecallFriendSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */