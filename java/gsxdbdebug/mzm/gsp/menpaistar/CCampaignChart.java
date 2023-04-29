/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.menpaistar.main.PCCampaignChart;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCampaignChart
/*    */   extends __CCampaignChart__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612369;
/*    */   public int occupationid;
/*    */   public int page;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCCampaignChart(roleId, this.occupationid, this.page));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12612369;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCampaignChart() {}
/*    */   
/*    */ 
/*    */   public CCampaignChart(int _occupationid_, int _page_)
/*    */   {
/* 42 */     this.occupationid = _occupationid_;
/* 43 */     this.page = _page_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.occupationid);
/* 52 */     _os_.marshal(this.page);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.occupationid = _os_.unmarshal_int();
/* 58 */     this.page = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CCampaignChart)) {
/* 68 */       CCampaignChart _o_ = (CCampaignChart)_o1_;
/* 69 */       if (this.occupationid != _o_.occupationid) return false;
/* 70 */       if (this.page != _o_.page) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.occupationid;
/* 79 */     _h_ += this.page;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.occupationid).append(",");
/* 87 */     _sb_.append(this.page).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCampaignChart _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.occupationid - _o_.occupationid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.page - _o_.page;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CCampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */