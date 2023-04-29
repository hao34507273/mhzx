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
/*    */ public class SBroadcastChestAwardInfo
/*    */   extends __SBroadcastChestAwardInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12630020;
/*    */   public AwardWinnerInfo winner_info;
/*    */   public long orig_yuan_bao_count;
/*    */   public long yuan_bao_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12630020;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBroadcastChestAwardInfo()
/*    */   {
/* 35 */     this.winner_info = new AwardWinnerInfo();
/*    */   }
/*    */   
/*    */   public SBroadcastChestAwardInfo(AwardWinnerInfo _winner_info_, long _orig_yuan_bao_count_, long _yuan_bao_count_) {
/* 39 */     this.winner_info = _winner_info_;
/* 40 */     this.orig_yuan_bao_count = _orig_yuan_bao_count_;
/* 41 */     this.yuan_bao_count = _yuan_bao_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.winner_info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.winner_info);
/* 51 */     _os_.marshal(this.orig_yuan_bao_count);
/* 52 */     _os_.marshal(this.yuan_bao_count);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.winner_info.unmarshal(_os_);
/* 58 */     this.orig_yuan_bao_count = _os_.unmarshal_long();
/* 59 */     this.yuan_bao_count = _os_.unmarshal_long();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SBroadcastChestAwardInfo)) {
/* 69 */       SBroadcastChestAwardInfo _o_ = (SBroadcastChestAwardInfo)_o1_;
/* 70 */       if (!this.winner_info.equals(_o_.winner_info)) return false;
/* 71 */       if (this.orig_yuan_bao_count != _o_.orig_yuan_bao_count) return false;
/* 72 */       if (this.yuan_bao_count != _o_.yuan_bao_count) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.winner_info.hashCode();
/* 81 */     _h_ += (int)this.orig_yuan_bao_count;
/* 82 */     _h_ += (int)this.yuan_bao_count;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.winner_info).append(",");
/* 90 */     _sb_.append(this.orig_yuan_bao_count).append(",");
/* 91 */     _sb_.append(this.yuan_bao_count).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\SBroadcastChestAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */