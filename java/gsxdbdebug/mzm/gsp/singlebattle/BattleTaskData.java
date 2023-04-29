/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class BattleTaskData implements Marshal, Comparable<BattleTaskData>
/*    */ {
/*    */   public int param;
/*    */   
/*    */   public BattleTaskData() {}
/*    */   
/*    */   public BattleTaskData(int _param_)
/*    */   {
/* 15 */     this.param = _param_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     _os_.marshal(this.param);
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     this.param = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof BattleTaskData)) {
/* 35 */       BattleTaskData _o_ = (BattleTaskData)_o1_;
/* 36 */       if (this.param != _o_.param) return false;
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     _h_ += this.param;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(this.param).append(",");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BattleTaskData _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     _c_ = this.param - _o_.param;
/* 60 */     if (0 != _c_) return _c_;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\BattleTaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */