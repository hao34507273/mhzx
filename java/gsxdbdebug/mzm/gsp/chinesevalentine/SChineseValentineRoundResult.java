/*    */ package mzm.gsp.chinesevalentine;
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
/*    */ public class SChineseValentineRoundResult
/*    */   extends __SChineseValentineRoundResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622091;
/*    */   public static final int SUCCESS = 1;
/*    */   public static final int FAILED = 2;
/*    */   public int code;
/*    */   public int roundnumber;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12622091;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChineseValentineRoundResult()
/*    */   {
/* 37 */     this.roundnumber = 1;
/*    */   }
/*    */   
/*    */   public SChineseValentineRoundResult(int _code_, int _roundnumber_) {
/* 41 */     this.code = _code_;
/* 42 */     this.roundnumber = _roundnumber_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.code);
/* 51 */     _os_.marshal(this.roundnumber);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.code = _os_.unmarshal_int();
/* 57 */     this.roundnumber = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SChineseValentineRoundResult)) {
/* 67 */       SChineseValentineRoundResult _o_ = (SChineseValentineRoundResult)_o1_;
/* 68 */       if (this.code != _o_.code) return false;
/* 69 */       if (this.roundnumber != _o_.roundnumber) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.code;
/* 78 */     _h_ += this.roundnumber;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.code).append(",");
/* 86 */     _sb_.append(this.roundnumber).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChineseValentineRoundResult _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.code - _o_.code;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.roundnumber - _o_.roundnumber;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\SChineseValentineRoundResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */