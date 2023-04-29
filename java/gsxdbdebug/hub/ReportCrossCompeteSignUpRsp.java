/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ReportCrossCompeteSignUpRsp
/*    */   implements Marshal
/*    */ {
/*    */   public static final int RESULT_MATCHING = 0;
/*    */   public static final int RESULT_SUCCESS = 1;
/*    */   public static final int RESULT_START_TIME_ERR = 2;
/*    */   public int result;
/*    */   public long start_mills;
/*    */   public ArrayList<CrossCompeteAgainst> againsts;
/*    */   public ArrayList<Long> miss_turn_factions;
/*    */   
/*    */   public ReportCrossCompeteSignUpRsp()
/*    */   {
/* 21 */     this.againsts = new ArrayList();
/* 22 */     this.miss_turn_factions = new ArrayList();
/*    */   }
/*    */   
/*    */   public ReportCrossCompeteSignUpRsp(int _result_, long _start_mills_, ArrayList<CrossCompeteAgainst> _againsts_, ArrayList<Long> _miss_turn_factions_) {
/* 26 */     this.result = _result_;
/* 27 */     this.start_mills = _start_mills_;
/* 28 */     this.againsts = _againsts_;
/* 29 */     this.miss_turn_factions = _miss_turn_factions_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     for (CrossCompeteAgainst _v_ : this.againsts)
/* 34 */       if (!_v_._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.result);
/* 40 */     _os_.marshal(this.start_mills);
/* 41 */     _os_.compact_uint32(this.againsts.size());
/* 42 */     for (CrossCompeteAgainst _v_ : this.againsts) {
/* 43 */       _os_.marshal(_v_);
/*    */     }
/* 45 */     _os_.compact_uint32(this.miss_turn_factions.size());
/* 46 */     for (Long _v_ : this.miss_turn_factions) {
/* 47 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.result = _os_.unmarshal_int();
/* 54 */     this.start_mills = _os_.unmarshal_long();
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       CrossCompeteAgainst _v_ = new CrossCompeteAgainst();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.againsts.add(_v_);
/*    */     }
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.miss_turn_factions.add(Long.valueOf(_v_));
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof ReportCrossCompeteSignUpRsp)) {
/* 71 */       ReportCrossCompeteSignUpRsp _o_ = (ReportCrossCompeteSignUpRsp)_o1_;
/* 72 */       if (this.result != _o_.result) return false;
/* 73 */       if (this.start_mills != _o_.start_mills) return false;
/* 74 */       if (!this.againsts.equals(_o_.againsts)) return false;
/* 75 */       if (!this.miss_turn_factions.equals(_o_.miss_turn_factions)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.result;
/* 84 */     _h_ += (int)this.start_mills;
/* 85 */     _h_ += this.againsts.hashCode();
/* 86 */     _h_ += this.miss_turn_factions.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.result).append(",");
/* 94 */     _sb_.append(this.start_mills).append(",");
/* 95 */     _sb_.append(this.againsts).append(",");
/* 96 */     _sb_.append(this.miss_turn_factions).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportCrossCompeteSignUpRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */