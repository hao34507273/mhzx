/*    */ package mzm.gsp.qingyunzhi;
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
/*    */ public class SQingYunZhi
/*    */   extends __SQingYunZhi__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590337;
/*    */   public int chapternum;
/*    */   public int nodenum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590337;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQingYunZhi() {}
/*    */   
/*    */ 
/*    */   public SQingYunZhi(int _chapternum_, int _nodenum_)
/*    */   {
/* 37 */     this.chapternum = _chapternum_;
/* 38 */     this.nodenum = _nodenum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.chapternum);
/* 47 */     _os_.marshal(this.nodenum);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.chapternum = _os_.unmarshal_int();
/* 53 */     this.nodenum = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SQingYunZhi)) {
/* 63 */       SQingYunZhi _o_ = (SQingYunZhi)_o1_;
/* 64 */       if (this.chapternum != _o_.chapternum) return false;
/* 65 */       if (this.nodenum != _o_.nodenum) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.chapternum;
/* 74 */     _h_ += this.nodenum;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.chapternum).append(",");
/* 82 */     _sb_.append(this.nodenum).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SQingYunZhi _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.chapternum - _o_.chapternum;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.nodenum - _o_.nodenum;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\SQingYunZhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */