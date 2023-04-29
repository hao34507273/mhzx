/*    */ package mzm.gsp.grow;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FunctionOpenInfo
/*    */   implements Marshal, Comparable<FunctionOpenInfo>
/*    */ {
/*    */   public static final int ST_ON_GOING = 1;
/*    */   public static final int ST_FINISHED = 2;
/*    */   public static final int ST_HAND_UP = 3;
/*    */   public int targetid;
/*    */   public int targetstate;
/*    */   
/*    */   public FunctionOpenInfo() {}
/*    */   
/*    */   public FunctionOpenInfo(int _targetid_, int _targetstate_)
/*    */   {
/* 22 */     this.targetid = _targetid_;
/* 23 */     this.targetstate = _targetstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.targetid);
/* 32 */     _os_.marshal(this.targetstate);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.targetid = _os_.unmarshal_int();
/* 38 */     this.targetstate = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FunctionOpenInfo)) {
/* 45 */       FunctionOpenInfo _o_ = (FunctionOpenInfo)_o1_;
/* 46 */       if (this.targetid != _o_.targetid) return false;
/* 47 */       if (this.targetstate != _o_.targetstate) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.targetid;
/* 56 */     _h_ += this.targetstate;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.targetid).append(",");
/* 64 */     _sb_.append(this.targetstate).append(",");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FunctionOpenInfo _o_) {
/* 70 */     if (_o_ == this) return 0;
/* 71 */     int _c_ = 0;
/* 72 */     _c_ = this.targetid - _o_.targetid;
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     _c_ = this.targetstate - _o_.targetstate;
/* 75 */     if (0 != _c_) return _c_;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\FunctionOpenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */