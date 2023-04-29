/*    */ package mzm.gsp.constellation;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChooseCardNormalRes
/*    */   extends __SChooseCardNormalRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612105;
/*    */   public int constellation;
/*    */   public int index;
/*    */   public AwardBean award;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612105;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChooseCardNormalRes()
/*    */   {
/* 35 */     this.award = new AwardBean();
/*    */   }
/*    */   
/*    */   public SChooseCardNormalRes(int _constellation_, int _index_, AwardBean _award_) {
/* 39 */     this.constellation = _constellation_;
/* 40 */     this.index = _index_;
/* 41 */     this.award = _award_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.award._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.constellation);
/* 51 */     _os_.marshal(this.index);
/* 52 */     _os_.marshal(this.award);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.constellation = _os_.unmarshal_int();
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     this.award.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SChooseCardNormalRes)) {
/* 69 */       SChooseCardNormalRes _o_ = (SChooseCardNormalRes)_o1_;
/* 70 */       if (this.constellation != _o_.constellation) return false;
/* 71 */       if (this.index != _o_.index) return false;
/* 72 */       if (!this.award.equals(_o_.award)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.constellation;
/* 81 */     _h_ += this.index;
/* 82 */     _h_ += this.award.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.constellation).append(",");
/* 90 */     _sb_.append(this.index).append(",");
/* 91 */     _sb_.append(this.award).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\SChooseCardNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */