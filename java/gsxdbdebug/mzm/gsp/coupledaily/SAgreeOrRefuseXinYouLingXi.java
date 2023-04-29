/*    */ package mzm.gsp.coupledaily;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAgreeOrRefuseXinYouLingXi
/*    */   extends __SAgreeOrRefuseXinYouLingXi__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602382;
/*    */   public int operator;
/*    */   public long memberroleid;
/*    */   public String memberrolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602382;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAgreeOrRefuseXinYouLingXi()
/*    */   {
/* 35 */     this.memberrolename = "";
/*    */   }
/*    */   
/*    */   public SAgreeOrRefuseXinYouLingXi(int _operator_, long _memberroleid_, String _memberrolename_) {
/* 39 */     this.operator = _operator_;
/* 40 */     this.memberroleid = _memberroleid_;
/* 41 */     this.memberrolename = _memberrolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.operator);
/* 50 */     _os_.marshal(this.memberroleid);
/* 51 */     _os_.marshal(this.memberrolename, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.operator = _os_.unmarshal_int();
/* 57 */     this.memberroleid = _os_.unmarshal_long();
/* 58 */     this.memberrolename = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SAgreeOrRefuseXinYouLingXi)) {
/* 68 */       SAgreeOrRefuseXinYouLingXi _o_ = (SAgreeOrRefuseXinYouLingXi)_o1_;
/* 69 */       if (this.operator != _o_.operator) return false;
/* 70 */       if (this.memberroleid != _o_.memberroleid) return false;
/* 71 */       if (!this.memberrolename.equals(_o_.memberrolename)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.operator;
/* 80 */     _h_ += (int)this.memberroleid;
/* 81 */     _h_ += this.memberrolename.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.operator).append(",");
/* 89 */     _sb_.append(this.memberroleid).append(",");
/* 90 */     _sb_.append("T").append(this.memberrolename.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\SAgreeOrRefuseXinYouLingXi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */