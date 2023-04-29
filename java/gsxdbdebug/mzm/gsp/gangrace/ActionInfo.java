/*    */ package mzm.gsp.gangrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ActionInfo implements Marshal, Comparable<ActionInfo>
/*    */ {
/*    */   public int actioncode;
/*    */   public int movestep;
/*    */   
/*    */   public ActionInfo() {}
/*    */   
/*    */   public ActionInfo(int _actioncode_, int _movestep_)
/*    */   {
/* 16 */     this.actioncode = _actioncode_;
/* 17 */     this.movestep = _movestep_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.actioncode);
/* 26 */     _os_.marshal(this.movestep);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.actioncode = _os_.unmarshal_int();
/* 32 */     this.movestep = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ActionInfo)) {
/* 39 */       ActionInfo _o_ = (ActionInfo)_o1_;
/* 40 */       if (this.actioncode != _o_.actioncode) return false;
/* 41 */       if (this.movestep != _o_.movestep) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.actioncode;
/* 50 */     _h_ += this.movestep;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.actioncode).append(",");
/* 58 */     _sb_.append(this.movestep).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActionInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.actioncode - _o_.actioncode;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.movestep - _o_.movestep;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\ActionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */