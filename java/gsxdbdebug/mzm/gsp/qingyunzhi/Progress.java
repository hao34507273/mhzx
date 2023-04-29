/*    */ package mzm.gsp.qingyunzhi;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class Progress
/*    */   implements Marshal, Comparable<Progress>
/*    */ {
/*    */   public int chapter;
/*    */   public int section;
/*    */   
/*    */   public Progress() {}
/*    */   
/*    */   public Progress(int _chapter_, int _section_)
/*    */   {
/* 18 */     this.chapter = _chapter_;
/* 19 */     this.section = _section_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.chapter);
/* 28 */     _os_.marshal(this.section);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.chapter = _os_.unmarshal_int();
/* 34 */     this.section = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof Progress)) {
/* 41 */       Progress _o_ = (Progress)_o1_;
/* 42 */       if (this.chapter != _o_.chapter) return false;
/* 43 */       if (this.section != _o_.section) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.chapter;
/* 52 */     _h_ += this.section;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.chapter).append(",");
/* 60 */     _sb_.append(this.section).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Progress _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.chapter - _o_.chapter;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.section - _o_.section;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\Progress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */