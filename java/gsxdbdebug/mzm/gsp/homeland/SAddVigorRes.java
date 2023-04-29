/*    */ package mzm.gsp.homeland;
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
/*    */ public class SAddVigorRes
/*    */   extends __SAddVigorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605474;
/*    */   public int addvigornum;
/*    */   public int dayrestorevigorcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605474;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddVigorRes() {}
/*    */   
/*    */ 
/*    */   public SAddVigorRes(int _addvigornum_, int _dayrestorevigorcount_)
/*    */   {
/* 35 */     this.addvigornum = _addvigornum_;
/* 36 */     this.dayrestorevigorcount = _dayrestorevigorcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.addvigornum);
/* 45 */     _os_.marshal(this.dayrestorevigorcount);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.addvigornum = _os_.unmarshal_int();
/* 51 */     this.dayrestorevigorcount = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SAddVigorRes)) {
/* 61 */       SAddVigorRes _o_ = (SAddVigorRes)_o1_;
/* 62 */       if (this.addvigornum != _o_.addvigornum) return false;
/* 63 */       if (this.dayrestorevigorcount != _o_.dayrestorevigorcount) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.addvigornum;
/* 72 */     _h_ += this.dayrestorevigorcount;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.addvigornum).append(",");
/* 80 */     _sb_.append(this.dayrestorevigorcount).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAddVigorRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.addvigornum - _o_.addvigornum;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.dayrestorevigorcount - _o_.dayrestorevigorcount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SAddVigorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */