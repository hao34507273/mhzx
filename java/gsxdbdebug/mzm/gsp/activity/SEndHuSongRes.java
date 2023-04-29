/*    */ package mzm.gsp.activity;
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
/*    */ public class SEndHuSongRes
/*    */   extends __SEndHuSongRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587558;
/*    */   public static final int NORMAL = 1;
/*    */   public static final int GIVE_UP = 2;
/*    */   public int husongcfgid;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587558;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEndHuSongRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEndHuSongRes(int _husongcfgid_, int _ret_)
/*    */   {
/* 40 */     this.husongcfgid = _husongcfgid_;
/* 41 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.husongcfgid);
/* 50 */     _os_.marshal(this.ret);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.husongcfgid = _os_.unmarshal_int();
/* 56 */     this.ret = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SEndHuSongRes)) {
/* 66 */       SEndHuSongRes _o_ = (SEndHuSongRes)_o1_;
/* 67 */       if (this.husongcfgid != _o_.husongcfgid) return false;
/* 68 */       if (this.ret != _o_.ret) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.husongcfgid;
/* 77 */     _h_ += this.ret;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.husongcfgid).append(",");
/* 85 */     _sb_.append(this.ret).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEndHuSongRes _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.husongcfgid - _o_.husongcfgid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.ret - _o_.ret;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SEndHuSongRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */