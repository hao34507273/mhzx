/*    */ package mzm.gsp.mounts;
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
/*    */ public class SMountsCostItemRankUpSuccess
/*    */   extends __SMountsCostItemRankUpSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606243;
/*    */   public long mounts_id;
/*    */   public MountsInfo rank_up_mounts_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606243;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMountsCostItemRankUpSuccess()
/*    */   {
/* 34 */     this.rank_up_mounts_info = new MountsInfo();
/*    */   }
/*    */   
/*    */   public SMountsCostItemRankUpSuccess(long _mounts_id_, MountsInfo _rank_up_mounts_info_) {
/* 38 */     this.mounts_id = _mounts_id_;
/* 39 */     this.rank_up_mounts_info = _rank_up_mounts_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.rank_up_mounts_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mounts_id);
/* 49 */     _os_.marshal(this.rank_up_mounts_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mounts_id = _os_.unmarshal_long();
/* 55 */     this.rank_up_mounts_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMountsCostItemRankUpSuccess)) {
/* 65 */       SMountsCostItemRankUpSuccess _o_ = (SMountsCostItemRankUpSuccess)_o1_;
/* 66 */       if (this.mounts_id != _o_.mounts_id) return false;
/* 67 */       if (!this.rank_up_mounts_info.equals(_o_.rank_up_mounts_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.mounts_id;
/* 76 */     _h_ += this.rank_up_mounts_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.mounts_id).append(",");
/* 84 */     _sb_.append(this.rank_up_mounts_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsCostItemRankUpSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */