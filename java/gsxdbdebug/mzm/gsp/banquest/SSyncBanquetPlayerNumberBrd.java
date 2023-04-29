/*    */ package mzm.gsp.banquest;
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
/*    */ public class SSyncBanquetPlayerNumberBrd
/*    */   extends __SSyncBanquetPlayerNumberBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605959;
/*    */   public long masterid;
/*    */   public int player_num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605959;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncBanquetPlayerNumberBrd() {}
/*    */   
/*    */ 
/*    */   public SSyncBanquetPlayerNumberBrd(long _masterid_, int _player_num_)
/*    */   {
/* 37 */     this.masterid = _masterid_;
/* 38 */     this.player_num = _player_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.masterid);
/* 47 */     _os_.marshal(this.player_num);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.masterid = _os_.unmarshal_long();
/* 53 */     this.player_num = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncBanquetPlayerNumberBrd)) {
/* 63 */       SSyncBanquetPlayerNumberBrd _o_ = (SSyncBanquetPlayerNumberBrd)_o1_;
/* 64 */       if (this.masterid != _o_.masterid) return false;
/* 65 */       if (this.player_num != _o_.player_num) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.masterid;
/* 74 */     _h_ += this.player_num;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.masterid).append(",");
/* 82 */     _sb_.append(this.player_num).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncBanquetPlayerNumberBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.masterid - _o_.masterid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.player_num - _o_.player_num;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\SSyncBanquetPlayerNumberBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */