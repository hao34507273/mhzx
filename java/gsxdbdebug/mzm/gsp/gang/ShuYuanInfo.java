/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ShuYuanInfo
/*    */   implements Marshal, Comparable<ShuYuanInfo>
/*    */ {
/*    */   public int level;
/*    */   public int levelupendtime;
/*    */   
/*    */   public ShuYuanInfo() {}
/*    */   
/*    */   public ShuYuanInfo(int _level_, int _levelupendtime_)
/*    */   {
/* 18 */     this.level = _level_;
/* 19 */     this.levelupendtime = _levelupendtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.level);
/* 28 */     _os_.marshal(this.levelupendtime);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.level = _os_.unmarshal_int();
/* 34 */     this.levelupendtime = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof ShuYuanInfo)) {
/* 41 */       ShuYuanInfo _o_ = (ShuYuanInfo)_o1_;
/* 42 */       if (this.level != _o_.level) return false;
/* 43 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.level;
/* 52 */     _h_ += this.levelupendtime;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.level).append(",");
/* 60 */     _sb_.append(this.levelupendtime).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ShuYuanInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.level - _o_.level;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.levelupendtime - _o_.levelupendtime;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\ShuYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */