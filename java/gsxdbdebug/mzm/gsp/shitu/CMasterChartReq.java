/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.shitu.main.PCMasterChartReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMasterChartReq
/*    */   extends __CMasterChartReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601603;
/*    */   public int startpos;
/*    */   public int endpos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCMasterChartReq(this.startpos, this.endpos, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12601603;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMasterChartReq() {}
/*    */   
/*    */ 
/*    */   public CMasterChartReq(int _startpos_, int _endpos_)
/*    */   {
/* 42 */     this.startpos = _startpos_;
/* 43 */     this.endpos = _endpos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.startpos);
/* 52 */     _os_.marshal(this.endpos);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.startpos = _os_.unmarshal_int();
/* 58 */     this.endpos = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CMasterChartReq)) {
/* 68 */       CMasterChartReq _o_ = (CMasterChartReq)_o1_;
/* 69 */       if (this.startpos != _o_.startpos) return false;
/* 70 */       if (this.endpos != _o_.endpos) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.startpos;
/* 79 */     _h_ += this.endpos;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.startpos).append(",");
/* 87 */     _sb_.append(this.endpos).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMasterChartReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.startpos - _o_.startpos;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.endpos - _o_.endpos;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CMasterChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */