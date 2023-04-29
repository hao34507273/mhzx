/*    */ package mzm.gsp.festival;
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
/*    */ public class SFestivalInfoRes
/*    */   extends __SFestivalInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600067;
/*    */   public static final int NOT_TAKE = 0;
/*    */   public static final int TAKED = 1;
/*    */   public int festivalawardid;
/*    */   public int awardstate;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600067;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFestivalInfoRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFestivalInfoRes(int _festivalawardid_, int _awardstate_)
/*    */   {
/* 40 */     this.festivalawardid = _festivalawardid_;
/* 41 */     this.awardstate = _awardstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.festivalawardid);
/* 50 */     _os_.marshal(this.awardstate);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.festivalawardid = _os_.unmarshal_int();
/* 56 */     this.awardstate = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SFestivalInfoRes)) {
/* 66 */       SFestivalInfoRes _o_ = (SFestivalInfoRes)_o1_;
/* 67 */       if (this.festivalawardid != _o_.festivalawardid) return false;
/* 68 */       if (this.awardstate != _o_.awardstate) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.festivalawardid;
/* 77 */     _h_ += this.awardstate;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.festivalawardid).append(",");
/* 85 */     _sb_.append(this.awardstate).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFestivalInfoRes _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.festivalawardid - _o_.festivalawardid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.awardstate - _o_.awardstate;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\SFestivalInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */