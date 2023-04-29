/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleSelectionProcessInfo
/*    */   implements Marshal, Comparable<CrossBattleSelectionProcessInfo>
/*    */ {
/*    */   public static final int BEGIN = 0;
/*    */   public static final int GEN_TOKEN_SUC = 1;
/*    */   public static final int TRANSFOR_DATA_SUC = 2;
/*    */   public static final int LOGIN = 3;
/*    */   public long roleid;
/*    */   public int process;
/*    */   
/*    */   public CrossBattleSelectionProcessInfo() {}
/*    */   
/*    */   public CrossBattleSelectionProcessInfo(long _roleid_, int _process_)
/*    */   {
/* 23 */     this.roleid = _roleid_;
/* 24 */     this.process = _process_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.process);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.roleid = _os_.unmarshal_long();
/* 39 */     this.process = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof CrossBattleSelectionProcessInfo)) {
/* 46 */       CrossBattleSelectionProcessInfo _o_ = (CrossBattleSelectionProcessInfo)_o1_;
/* 47 */       if (this.roleid != _o_.roleid) return false;
/* 48 */       if (this.process != _o_.process) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.roleid;
/* 57 */     _h_ += this.process;
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.roleid).append(",");
/* 65 */     _sb_.append(this.process).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CrossBattleSelectionProcessInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.process - _o_.process;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleSelectionProcessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */