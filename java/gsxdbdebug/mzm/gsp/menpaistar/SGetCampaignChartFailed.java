/*    */ package mzm.gsp.menpaistar;
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
/*    */ public class SGetCampaignChartFailed
/*    */   extends __SGetCampaignChartFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612381;
/*    */   public static final int ERROR_NOT_CAMPAIGN = -1;
/*    */   public static final int ERROR_SWITH_OCCUPATION = -2;
/*    */   public long target_roleid;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612381;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetCampaignChartFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetCampaignChartFailed(long _target_roleid_, int _retcode_)
/*    */   {
/* 40 */     this.target_roleid = _target_roleid_;
/* 41 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.target_roleid);
/* 50 */     _os_.marshal(this.retcode);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.target_roleid = _os_.unmarshal_long();
/* 56 */     this.retcode = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SGetCampaignChartFailed)) {
/* 66 */       SGetCampaignChartFailed _o_ = (SGetCampaignChartFailed)_o1_;
/* 67 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 68 */       if (this.retcode != _o_.retcode) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.target_roleid;
/* 77 */     _h_ += this.retcode;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.target_roleid).append(",");
/* 85 */     _sb_.append(this.retcode).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetCampaignChartFailed _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.retcode - _o_.retcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SGetCampaignChartFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */