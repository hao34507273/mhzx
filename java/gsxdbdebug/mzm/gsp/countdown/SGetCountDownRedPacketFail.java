/*    */ package mzm.gsp.countdown;
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
/*    */ public class SGetCountDownRedPacketFail
/*    */   extends __SGetCountDownRedPacketFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606722;
/*    */   public static final int ROLE_HAS_GET_RED_PACKET = 1;
/*    */   public static final int ROLE_CANNOT_GET_RED_PACKET = 2;
/*    */   public static final int AWARD_FAIL = 3;
/*    */   public static final int NOT_IN_GET_RED_PACKET_TIME = 4;
/*    */   public int cfg_id;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606722;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetCountDownRedPacketFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetCountDownRedPacketFail(int _cfg_id_, int _res_)
/*    */   {
/* 42 */     this.cfg_id = _cfg_id_;
/* 43 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.cfg_id);
/* 52 */     _os_.marshal(this.res);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.cfg_id = _os_.unmarshal_int();
/* 58 */     this.res = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGetCountDownRedPacketFail)) {
/* 68 */       SGetCountDownRedPacketFail _o_ = (SGetCountDownRedPacketFail)_o1_;
/* 69 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 70 */       if (this.res != _o_.res) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.cfg_id;
/* 79 */     _h_ += this.res;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.cfg_id).append(",");
/* 87 */     _sb_.append(this.res).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetCountDownRedPacketFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.cfg_id - _o_.cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.res - _o_.res;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\SGetCountDownRedPacketFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */