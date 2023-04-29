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
/*    */ public class SUnlockMountsSuccess
/*    */   extends __SUnlockMountsSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606216;
/*    */   public long mounts_id;
/*    */   public MountsInfo unlock_mounts_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606216;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnlockMountsSuccess()
/*    */   {
/* 34 */     this.unlock_mounts_info = new MountsInfo();
/*    */   }
/*    */   
/*    */   public SUnlockMountsSuccess(long _mounts_id_, MountsInfo _unlock_mounts_info_) {
/* 38 */     this.mounts_id = _mounts_id_;
/* 39 */     this.unlock_mounts_info = _unlock_mounts_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.unlock_mounts_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mounts_id);
/* 49 */     _os_.marshal(this.unlock_mounts_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mounts_id = _os_.unmarshal_long();
/* 55 */     this.unlock_mounts_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SUnlockMountsSuccess)) {
/* 65 */       SUnlockMountsSuccess _o_ = (SUnlockMountsSuccess)_o1_;
/* 66 */       if (this.mounts_id != _o_.mounts_id) return false;
/* 67 */       if (!this.unlock_mounts_info.equals(_o_.unlock_mounts_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.mounts_id;
/* 76 */     _h_ += this.unlock_mounts_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.mounts_id).append(",");
/* 84 */     _sb_.append(this.unlock_mounts_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SUnlockMountsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */