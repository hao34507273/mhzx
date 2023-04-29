/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
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
/*    */ public class KeJuState
/*    */   implements Marshal, Comparable<KeJuState>
/*    */ {
/*    */   public static final int XIANGSHI = 1;
/*    */   public static final int HUISHI = 2;
/*    */   public static final int DIANSHI = 3;
/*    */   public static final int NOT_START = 4;
/*    */   public static final int START = 5;
/*    */   public static final int END = 6;
/*    */   public static final int CAN_NOT_ACCESS = 7;
/*    */   public int statetype;
/*    */   public int state;
/*    */   
/*    */   public KeJuState() {}
/*    */   
/*    */   public KeJuState(int _statetype_, int _state_)
/*    */   {
/* 32 */     this.statetype = _statetype_;
/* 33 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 41 */     _os_.marshal(this.statetype);
/* 42 */     _os_.marshal(this.state);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.statetype = _os_.unmarshal_int();
/* 48 */     this.state = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof KeJuState)) {
/* 55 */       KeJuState _o_ = (KeJuState)_o1_;
/* 56 */       if (this.statetype != _o_.statetype) return false;
/* 57 */       if (this.state != _o_.state) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.statetype;
/* 66 */     _h_ += this.state;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.statetype).append(",");
/* 74 */     _sb_.append(this.state).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(KeJuState _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.statetype - _o_.statetype;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.state - _o_.state;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\KeJuState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */