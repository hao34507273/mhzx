/*    */ package mzm.gsp.drawcarnival;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBroadcastYuanBaoChangeInfo
/*    */   extends __SBroadcastYuanBaoChangeInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12630023;
/*    */   public long award_pool_yuan_bao_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12630023;
/*    */   }
/*    */   
/*    */ 
/*    */   public SBroadcastYuanBaoChangeInfo() {}
/*    */   
/*    */ 
/*    */   public SBroadcastYuanBaoChangeInfo(long _award_pool_yuan_bao_count_)
/*    */   {
/* 36 */     this.award_pool_yuan_bao_count = _award_pool_yuan_bao_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.award_pool_yuan_bao_count);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.award_pool_yuan_bao_count = _os_.unmarshal_long();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SBroadcastYuanBaoChangeInfo)) {
/* 59 */       SBroadcastYuanBaoChangeInfo _o_ = (SBroadcastYuanBaoChangeInfo)_o1_;
/* 60 */       if (this.award_pool_yuan_bao_count != _o_.award_pool_yuan_bao_count) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += (int)this.award_pool_yuan_bao_count;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.award_pool_yuan_bao_count).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBroadcastYuanBaoChangeInfo _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = Long.signum(this.award_pool_yuan_bao_count - _o_.award_pool_yuan_bao_count);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\SBroadcastYuanBaoChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */