/*    */ package mzm.gsp.qmhw;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class QMHWAwardInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashSet<Integer> winawards;
/*    */   public HashSet<Integer> joinawards;
/*    */   
/*    */   public QMHWAwardInfo()
/*    */   {
/* 13 */     this.winawards = new HashSet();
/* 14 */     this.joinawards = new HashSet();
/*    */   }
/*    */   
/*    */   public QMHWAwardInfo(HashSet<Integer> _winawards_, HashSet<Integer> _joinawards_) {
/* 18 */     this.winawards = _winawards_;
/* 19 */     this.joinawards = _joinawards_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.compact_uint32(this.winawards.size());
/* 28 */     for (Integer _v_ : this.winawards) {
/* 29 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 31 */     _os_.compact_uint32(this.joinawards.size());
/* 32 */     for (Integer _v_ : this.joinawards) {
/* 33 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 41 */       int _v_ = _os_.unmarshal_int();
/* 42 */       this.winawards.add(Integer.valueOf(_v_));
/*    */     }
/* 44 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 46 */       int _v_ = _os_.unmarshal_int();
/* 47 */       this.joinawards.add(Integer.valueOf(_v_));
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof QMHWAwardInfo)) {
/* 55 */       QMHWAwardInfo _o_ = (QMHWAwardInfo)_o1_;
/* 56 */       if (!this.winawards.equals(_o_.winawards)) return false;
/* 57 */       if (!this.joinawards.equals(_o_.joinawards)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.winawards.hashCode();
/* 66 */     _h_ += this.joinawards.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.winawards).append(",");
/* 74 */     _sb_.append(this.joinawards).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\QMHWAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */