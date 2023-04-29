/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class SBindFriendFailed
/*    */   extends __SBindFriendFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600373;
/*    */   public static final int ERROR_RECALL_NOT_LOSS = -1;
/*    */   public static final int ERROR_RECALL_BIND_EXPIRED = -2;
/*    */   public static final int ERROR_RECALL_BINDED = -3;
/*    */   public static final int ERROR_RECALL_BIND_FULL = -4;
/*    */   public static final int ERROR_RECALL_REDIS_LOCK_FAILED = -5;
/*    */   public static final int ERROR_RECALL_FRIEND_BIND_FULL = -6;
/*    */   public static final int ERROR_RECALL_NET = -7;
/*    */   public static final int ERROR_RECALL_NOT_FRIEND = -8;
/*    */   public static final int ERROR_RECALL_BIND_TOGETHER_FILLED = -9;
/*    */   public Octets open_id;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600373;
/*    */   }
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
/*    */ 
/*    */ 
/*    */   public SBindFriendFailed()
/*    */   {
/* 44 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public SBindFriendFailed(Octets _open_id_, int _retcode_) {
/* 48 */     this.open_id = _open_id_;
/* 49 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 57 */     _os_.marshal(this.open_id);
/* 58 */     _os_.marshal(this.retcode);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.open_id = _os_.unmarshal_Octets();
/* 64 */     this.retcode = _os_.unmarshal_int();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SBindFriendFailed)) {
/* 74 */       SBindFriendFailed _o_ = (SBindFriendFailed)_o1_;
/* 75 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 76 */       if (this.retcode != _o_.retcode) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.open_id.hashCode();
/* 85 */     _h_ += this.retcode;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 93 */     _sb_.append(this.retcode).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SBindFriendFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */