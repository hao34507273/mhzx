/*    */ package mzm.gsp.wing;
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
/*    */ public class SOpenNewWingRes
/*    */   extends __SOpenNewWingRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596484;
/*    */   public int curindex;
/*    */   public int openindex;
/*    */   public WingInfo newwinginfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596484;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SOpenNewWingRes()
/*    */   {
/* 33 */     this.newwinginfo = new WingInfo();
/*    */   }
/*    */   
/*    */   public SOpenNewWingRes(int _curindex_, int _openindex_, WingInfo _newwinginfo_) {
/* 37 */     this.curindex = _curindex_;
/* 38 */     this.openindex = _openindex_;
/* 39 */     this.newwinginfo = _newwinginfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.newwinginfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.curindex);
/* 49 */     _os_.marshal(this.openindex);
/* 50 */     _os_.marshal(this.newwinginfo);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.curindex = _os_.unmarshal_int();
/* 56 */     this.openindex = _os_.unmarshal_int();
/* 57 */     this.newwinginfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SOpenNewWingRes)) {
/* 67 */       SOpenNewWingRes _o_ = (SOpenNewWingRes)_o1_;
/* 68 */       if (this.curindex != _o_.curindex) return false;
/* 69 */       if (this.openindex != _o_.openindex) return false;
/* 70 */       if (!this.newwinginfo.equals(_o_.newwinginfo)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.curindex;
/* 79 */     _h_ += this.openindex;
/* 80 */     _h_ += this.newwinginfo.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.curindex).append(",");
/* 88 */     _sb_.append(this.openindex).append(",");
/* 89 */     _sb_.append(this.newwinginfo).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SOpenNewWingRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */