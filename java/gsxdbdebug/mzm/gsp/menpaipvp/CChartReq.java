/*    */ package mzm.gsp.menpaipvp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.menpaipvp.main.PChartReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChartReq
/*    */   extends __CChartReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596233;
/*    */   public int menpai;
/*    */   public int page;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PChartReq(roleid, this.menpai, this.page));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12596233;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChartReq() {}
/*    */   
/*    */ 
/*    */   public CChartReq(int _menpai_, int _page_)
/*    */   {
/* 38 */     this.menpai = _menpai_;
/* 39 */     this.page = _page_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.menpai);
/* 48 */     _os_.marshal(this.page);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.menpai = _os_.unmarshal_int();
/* 54 */     this.page = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CChartReq)) {
/* 64 */       CChartReq _o_ = (CChartReq)_o1_;
/* 65 */       if (this.menpai != _o_.menpai) return false;
/* 66 */       if (this.page != _o_.page) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.menpai;
/* 75 */     _h_ += this.page;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.menpai).append(",");
/* 83 */     _sb_.append(this.page).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChartReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.menpai - _o_.menpai;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.page - _o_.page;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\CChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */