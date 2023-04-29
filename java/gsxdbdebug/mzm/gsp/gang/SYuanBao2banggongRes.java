/*    */ package mzm.gsp.gang;
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
/*    */ public class SYuanBao2banggongRes
/*    */   extends __SYuanBao2banggongRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590010;
/*    */   public int yuan_bao;
/*    */   public int yuan_bao_to_banggong_total;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590010;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SYuanBao2banggongRes() {}
/*    */   
/*    */ 
/*    */   public SYuanBao2banggongRes(int _yuan_bao_, int _yuan_bao_to_banggong_total_)
/*    */   {
/* 37 */     this.yuan_bao = _yuan_bao_;
/* 38 */     this.yuan_bao_to_banggong_total = _yuan_bao_to_banggong_total_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.yuan_bao);
/* 47 */     _os_.marshal(this.yuan_bao_to_banggong_total);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.yuan_bao = _os_.unmarshal_int();
/* 53 */     this.yuan_bao_to_banggong_total = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SYuanBao2banggongRes)) {
/* 63 */       SYuanBao2banggongRes _o_ = (SYuanBao2banggongRes)_o1_;
/* 64 */       if (this.yuan_bao != _o_.yuan_bao) return false;
/* 65 */       if (this.yuan_bao_to_banggong_total != _o_.yuan_bao_to_banggong_total) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.yuan_bao;
/* 74 */     _h_ += this.yuan_bao_to_banggong_total;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.yuan_bao).append(",");
/* 82 */     _sb_.append(this.yuan_bao_to_banggong_total).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SYuanBao2banggongRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.yuan_bao - _o_.yuan_bao;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.yuan_bao_to_banggong_total - _o_.yuan_bao_to_banggong_total;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SYuanBao2banggongRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */