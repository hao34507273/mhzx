/*    */ package mzm.gsp.teamplatform;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class LevelCfg
/*    */   implements Marshal, Comparable<LevelCfg>
/*    */ {
/*    */   public int levellow;
/*    */   public int levelhigh;
/*    */   
/*    */   public LevelCfg() {}
/*    */   
/*    */   public LevelCfg(int _levellow_, int _levelhigh_)
/*    */   {
/* 18 */     this.levellow = _levellow_;
/* 19 */     this.levelhigh = _levelhigh_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.levellow);
/* 28 */     _os_.marshal(this.levelhigh);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.levellow = _os_.unmarshal_int();
/* 34 */     this.levelhigh = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof LevelCfg)) {
/* 41 */       LevelCfg _o_ = (LevelCfg)_o1_;
/* 42 */       if (this.levellow != _o_.levellow) return false;
/* 43 */       if (this.levelhigh != _o_.levelhigh) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.levellow;
/* 52 */     _h_ += this.levelhigh;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.levellow).append(",");
/* 60 */     _sb_.append(this.levelhigh).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(LevelCfg _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.levellow - _o_.levellow;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.levelhigh - _o_.levelhigh;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\LevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */