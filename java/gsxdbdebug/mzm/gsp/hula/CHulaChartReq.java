/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.hula.main.PHulaChartReq;
/*    */ 
/*    */ 
/*    */ public class CHulaChartReq
/*    */   extends __CHulaChartReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608773;
/*    */   public int startpos;
/*    */   public int num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleid = Role.getRoleId(this);
/* 19 */     if (roleid < 0L)
/*    */     {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PHulaChartReq(roleid, this.startpos, this.num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12608773;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CHulaChartReq() {}
/*    */   
/*    */ 
/*    */   public CHulaChartReq(int _startpos_, int _num_)
/*    */   {
/* 41 */     this.startpos = _startpos_;
/* 42 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.startpos);
/* 51 */     _os_.marshal(this.num);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.startpos = _os_.unmarshal_int();
/* 57 */     this.num = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CHulaChartReq)) {
/* 67 */       CHulaChartReq _o_ = (CHulaChartReq)_o1_;
/* 68 */       if (this.startpos != _o_.startpos) return false;
/* 69 */       if (this.num != _o_.num) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.startpos;
/* 78 */     _h_ += this.num;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.startpos).append(",");
/* 86 */     _sb_.append(this.num).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CHulaChartReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.startpos - _o_.startpos;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.num - _o_.num;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\CHulaChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */