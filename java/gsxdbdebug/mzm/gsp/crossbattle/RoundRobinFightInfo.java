/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class RoundRobinFightInfo
/*    */   implements Marshal
/*    */ {
/*    */   public static final int STATE_NOT_START = 0;
/*    */   public static final int STATE_FIGHTING = 1;
/*    */   public static final int STATE_A_WIN = 2;
/*    */   public static final int STATE_B_WIN = 3;
/*    */   public static final int STATE_A_ABSTAIN = 4;
/*    */   public static final int STATE_B_ABSTAIN = 5;
/*    */   public static final int STATE_ALL_ABSTAIN = 6;
/*    */   public static final int STATE_EXCEPTION_END = 7;
/*    */   public CorpsBriefInfo corps_a_brief_info;
/*    */   public CorpsBriefInfo corps_b_brief_info;
/*    */   public int state;
/*    */   
/*    */   public RoundRobinFightInfo()
/*    */   {
/* 25 */     this.corps_a_brief_info = new CorpsBriefInfo();
/* 26 */     this.corps_b_brief_info = new CorpsBriefInfo();
/*    */   }
/*    */   
/*    */   public RoundRobinFightInfo(CorpsBriefInfo _corps_a_brief_info_, CorpsBriefInfo _corps_b_brief_info_, int _state_) {
/* 30 */     this.corps_a_brief_info = _corps_a_brief_info_;
/* 31 */     this.corps_b_brief_info = _corps_b_brief_info_;
/* 32 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 36 */     if (!this.corps_a_brief_info._validator_()) return false;
/* 37 */     if (!this.corps_b_brief_info._validator_()) return false;
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.corps_a_brief_info);
/* 43 */     _os_.marshal(this.corps_b_brief_info);
/* 44 */     _os_.marshal(this.state);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.corps_a_brief_info.unmarshal(_os_);
/* 50 */     this.corps_b_brief_info.unmarshal(_os_);
/* 51 */     this.state = _os_.unmarshal_int();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof RoundRobinFightInfo)) {
/* 58 */       RoundRobinFightInfo _o_ = (RoundRobinFightInfo)_o1_;
/* 59 */       if (!this.corps_a_brief_info.equals(_o_.corps_a_brief_info)) return false;
/* 60 */       if (!this.corps_b_brief_info.equals(_o_.corps_b_brief_info)) return false;
/* 61 */       if (this.state != _o_.state) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.corps_a_brief_info.hashCode();
/* 70 */     _h_ += this.corps_b_brief_info.hashCode();
/* 71 */     _h_ += this.state;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.corps_a_brief_info).append(",");
/* 79 */     _sb_.append(this.corps_b_brief_info).append(",");
/* 80 */     _sb_.append(this.state).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\RoundRobinFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */