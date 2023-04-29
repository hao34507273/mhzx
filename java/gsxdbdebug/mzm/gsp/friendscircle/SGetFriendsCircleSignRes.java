/*    */ package mzm.gsp.friendscircle;
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
/*    */ public class SGetFriendsCircleSignRes
/*    */   extends __SGetFriendsCircleSignRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625425;
/*    */   public long timestamp;
/*    */   public Octets sign;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625425;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetFriendsCircleSignRes()
/*    */   {
/* 34 */     this.sign = new Octets();
/*    */   }
/*    */   
/*    */   public SGetFriendsCircleSignRes(long _timestamp_, Octets _sign_) {
/* 38 */     this.timestamp = _timestamp_;
/* 39 */     this.sign = _sign_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.timestamp);
/* 48 */     _os_.marshal(this.sign);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.timestamp = _os_.unmarshal_long();
/* 54 */     this.sign = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SGetFriendsCircleSignRes)) {
/* 64 */       SGetFriendsCircleSignRes _o_ = (SGetFriendsCircleSignRes)_o1_;
/* 65 */       if (this.timestamp != _o_.timestamp) return false;
/* 66 */       if (!this.sign.equals(_o_.sign)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.timestamp;
/* 75 */     _h_ += this.sign.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.timestamp).append(",");
/* 83 */     _sb_.append("B").append(this.sign.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SGetFriendsCircleSignRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */