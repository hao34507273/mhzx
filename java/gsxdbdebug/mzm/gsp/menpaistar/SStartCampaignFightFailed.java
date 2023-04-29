/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SStartCampaignFightFailed
/*    */   extends __SStartCampaignFightFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612355;
/*    */   public static final int ERROR_LEVEL = -1;
/*    */   public static final int ERROR_LEVEL_LESS_SERVER = -2;
/*    */   public static final int ERROR_FIGHT_NUM_LIMIT = -3;
/*    */   public static final int ERROR_SUCCESSED = -4;
/*    */   public static final int ERROR_IN_TEAM = -5;
/*    */   public static final int ERROR_CANNOT_JOIN_ACTIVITY = -6;
/*    */   public static final int ERROR_ACTIVITY_IN_AWARD = -7;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612355;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStartCampaignFightFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStartCampaignFightFailed(int _retcode_)
/*    */   {
/* 44 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.retcode);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SStartCampaignFightFailed)) {
/* 67 */       SStartCampaignFightFailed _o_ = (SStartCampaignFightFailed)_o1_;
/* 68 */       if (this.retcode != _o_.retcode) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.retcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.retcode).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SStartCampaignFightFailed _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.retcode - _o_.retcode;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SStartCampaignFightFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */