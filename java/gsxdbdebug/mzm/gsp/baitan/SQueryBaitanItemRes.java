/*    */ package mzm.gsp.baitan;
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
/*    */ public class SQueryBaitanItemRes
/*    */   extends __SQueryBaitanItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584993;
/*    */   public PageInfo pageresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584993;
/*    */   }
/*    */   
/*    */ 
/*    */   public SQueryBaitanItemRes()
/*    */   {
/* 31 */     this.pageresult = new PageInfo();
/*    */   }
/*    */   
/*    */   public SQueryBaitanItemRes(PageInfo _pageresult_) {
/* 35 */     this.pageresult = _pageresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.pageresult._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.pageresult);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.pageresult.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SQueryBaitanItemRes)) {
/* 59 */       SQueryBaitanItemRes _o_ = (SQueryBaitanItemRes)_o1_;
/* 60 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.pageresult.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.pageresult).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SQueryBaitanItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */