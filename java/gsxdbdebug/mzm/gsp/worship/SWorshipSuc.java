/*    */ package mzm.gsp.worship;
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
/*    */ public class SWorshipSuc
/*    */   extends __SWorshipSuc__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612615;
/*    */   public int worshipid;
/*    */   public int goldnum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612615;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SWorshipSuc() {}
/*    */   
/*    */ 
/*    */   public SWorshipSuc(int _worshipid_, int _goldnum_)
/*    */   {
/* 37 */     this.worshipid = _worshipid_;
/* 38 */     this.goldnum = _goldnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.worshipid);
/* 47 */     _os_.marshal(this.goldnum);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.worshipid = _os_.unmarshal_int();
/* 53 */     this.goldnum = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SWorshipSuc)) {
/* 63 */       SWorshipSuc _o_ = (SWorshipSuc)_o1_;
/* 64 */       if (this.worshipid != _o_.worshipid) return false;
/* 65 */       if (this.goldnum != _o_.goldnum) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.worshipid;
/* 74 */     _h_ += this.goldnum;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.worshipid).append(",");
/* 82 */     _sb_.append(this.goldnum).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SWorshipSuc _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.worshipid - _o_.worshipid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.goldnum - _o_.goldnum;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\SWorshipSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */